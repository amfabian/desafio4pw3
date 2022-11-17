package br.edu.ifrs.pw3.desafio4pw3.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import br.edu.ifrs.pw3.desafio4pw3.R;
import br.edu.ifrs.pw3.desafio4pw3.util.Cliente;

public class AcompanharFragment extends Fragment {

    private TextView txtAcompEndereco;
    private String mensagem;
    private String mensagem2;
    private TextView textViewCliente;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_acompanhar, container, false);
        txtAcompEndereco = root.findViewById(R.id.textViewEndereco);
        textViewCliente = root.findViewById(R.id.textViewCliente);
        mensagem = "O endereco de entrega será ";
        mensagem+= Cliente.endereco;
        txtAcompEndereco.setText(mensagem);
        mensagem2 = "O nosso entregador irá procurar por ";
        mensagem2+= Cliente.nome;
        textViewCliente.setText(mensagem2);



        return root;
    }
}
