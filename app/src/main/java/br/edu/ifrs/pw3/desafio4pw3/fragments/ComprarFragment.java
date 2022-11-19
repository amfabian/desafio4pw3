package br.edu.ifrs.pw3.desafio4pw3.fragments;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

import br.edu.ifrs.pw3.desafio4pw3.R;
import br.edu.ifrs.pw3.desafio4pw3.dao.PedidoDAO;
import br.edu.ifrs.pw3.desafio4pw3.dao.PedidoDatabase;
import br.edu.ifrs.pw3.desafio4pw3.util.Cliente;
import br.edu.ifrs.pw3.desafio4pw3.util.Pedido;


public class ComprarFragment extends Fragment {

    private TextInputEditText txtCliente;
    private TextInputEditText txtEndereco;
    private TextInputEditText txtEnderecoComplemento;
    private TextInputEditText txtEnderecoCidade;
    private String item;
    private Integer qtd;
    private Button btnFinalizarPedido;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_comprar, container, false);
        context = getContext();



        txtCliente = root.findViewById(R.id.txtClienteCad);
        txtEndereco = root.findViewById(R.id.txtEnderecoCad);
        txtEnderecoComplemento = root.findViewById(R.id.txtEnderecoComplementoCad);
        txtEnderecoCidade = root.findViewById(R.id.txtEnderecoCidadeCad);

        Bundle bundle = getArguments();
        item = bundle.getString("pedidoItem", "Default");
        Log.d("testBundle", item);
        qtd = bundle.getInt("pedidoQuantidade", -111);
        Log.d("testBundle", qtd.toString());


        if(Cliente.endereco.isEmpty()) {
            Snackbar snackbar = Snackbar
                    .make(getActivity().findViewById(android.R.id.content), "ENDERECO VAZIO", Snackbar.LENGTH_LONG);
            snackbar.show();
        } else {
            Snackbar snackbar = Snackbar
                    .make(getActivity().findViewById(android.R.id.content), "ENDERECO PREENCHIDO", Snackbar.LENGTH_LONG);
            snackbar.show();
            txtCliente.setText(Cliente.nome);
            txtEndereco.setText(Cliente.endereco);
            txtEnderecoComplemento.setText(Cliente.enderecoLinha2);
            txtEnderecoCidade.setText(Cliente.cidade);
        }

        btnFinalizarPedido = root.findViewById(R.id.btnFinalizarPedido);
        btnFinalizarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navegarParaPagamento(view, bundle);
            }
        }); return root;
    }

    private void navegarParaPagamento(View view, Bundle bundle) {
        bundle.putString("pedidoCliente", txtCliente.getText().toString());
        bundle.putString("pedidoEndereco", txtEndereco.getText().toString());
        bundle.putString("pedidoEnderecoComplemento", txtEnderecoComplemento.getText().toString());
        bundle.putString("pedidoEnderecoCidade", txtEnderecoCidade.getText().toString());
        bundle.putString("pedidoData", obterData());
        Navigation.findNavController(view).navigate(R.id.action_nav_comprarFragment_to_PagarFragment, bundle);
    }

    private String obterData() {
        String data;
        Integer data_aux;




        Calendar c = Calendar.getInstance();
        data_aux = c.get(Calendar.DAY_OF_MONTH);
        data = data_aux.toString();
        data += "/";

        data_aux = c.get(Calendar.MONTH);
        data_aux++;
        data += data_aux.toString();
        data += "/";

        data_aux = c.get(Calendar.YEAR);
        data += data_aux.toString();
        Log.d("testBundle", c.getTime().toString());
        Log.d("testBundle", data);

        return data;
    }
}