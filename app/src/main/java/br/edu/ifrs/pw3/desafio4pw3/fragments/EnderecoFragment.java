package br.edu.ifrs.pw3.desafio4pw3.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import br.edu.ifrs.pw3.desafio4pw3.R;
import br.edu.ifrs.pw3.desafio4pw3.util.Cliente;

public class EnderecoFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_endereco, container, false);
        Log.d("CLIENTE", "PASSOU");
        TextInputEditText textNome = root.findViewById(R.id.txtEndFragmentNome);
        TextInputEditText textEnderecoLinha1 = root.findViewById(R.id.txtEndFragmentEndereco);
        TextInputEditText textEnderecoLinha2 = root.findViewById(R.id.txtEndFragmentEnderecoLinha2);
        TextInputEditText textCidade = root.findViewById(R.id.txtEndFragmentCidade);

        Cliente.nome = Objects.requireNonNull(textNome.getText()).toString();
        Cliente.endereco = Objects.requireNonNull(textEnderecoLinha1.getText()).toString();
        Cliente.enderecoLinha2 = Objects.requireNonNull(textEnderecoLinha2.getText()).toString();
        Cliente.cidade = textCidade.getText().toString();

        Button btnEndCadastrar = root.findViewById(R.id.btnEndFragmentCadastrar);
        btnEndCadastrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Cliente.nome = textNome.getText().toString();
                Cliente.endereco = textEnderecoLinha1.getText().toString();
                Cliente.enderecoLinha2 = textEnderecoLinha2.getText().toString();
                Cliente.cidade = textCidade.getText().toString();
                Cliente.primeiroLogin = false;

                Navigation.findNavController(view).navigate(R.id.action_EnderecoFragment_to_Home);
            }
        });


        return root;
    }
}