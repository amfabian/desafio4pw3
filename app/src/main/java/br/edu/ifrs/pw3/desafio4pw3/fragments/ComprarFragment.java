package br.edu.ifrs.pw3.desafio4pw3.fragments;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
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
    private TextInputEditText txtItem;
    private TextInputEditText txtQuantidade;
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
        //txtItem = root.findViewById(R.id.txtItemCad);
        //qtd = Integer.valueOf(root.findViewById(R.id.txtQtdCad));
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

                new AsyncTask<Void,Integer, Integer>() {
                    @Override
                    protected Integer doInBackground(Void... voids) {
                        PedidoDAO pessoaDao = PedidoDatabase.getInstance(context).createPedidoDAO();
                        Pedido pedido = new Pedido();
                        pedido.setCliente(txtCliente.getText().toString());
                        pedido.setEndereco(txtEndereco.getText().toString());
                        pedido.setEnderecoComplemento(txtEnderecoComplemento.getText().toString());
                        pedido.setEnderecoCidade(txtEnderecoCidade.getText().toString());
                        pedido.setItem("Botijao exemplo");
                        pedido.setQuantidade(1);
                        pedido.setData("17/11/2022");

                        pessoaDao.insert(pedido);
                        return pedido.getId();
                    }

                    @Override
                    protected void onPostExecute(Integer id) {
                        if(id==null)
                            Snackbar.make(view, "Erro ao finalizar o pedido", Snackbar.LENGTH_LONG).show();
                        else {
                            Snackbar.make(view, "Feito o pedido de "+ qtd + "botijão(ões)", Snackbar.LENGTH_LONG).show();
                            Navigation.findNavController(view).navigate(R.id.action_nav_comprarFragment_to_nav_home);        }
                    }
                }.execute();
            }
        }); return root;
    }
}