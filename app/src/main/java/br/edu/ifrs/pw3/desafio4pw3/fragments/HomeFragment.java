package br.edu.ifrs.pw3.desafio4pw3.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import br.edu.ifrs.pw3.desafio4pw3.R;


public class HomeFragment extends Fragment {
    private Integer quantidade1 = 1;
    private TextView txtQuantidade1;
    private TextView txtQuantidade2;
    private TextView txtQuantidade3;
    private ImageButton buttonSub1;
    private ImageButton buttonAdd1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        txtQuantidade1 = root.findViewById(R.id.textViewQuantidade1);
        txtQuantidade1.setText(quantidade1.toString());

        buttonAdd1 = root.findViewById(R.id.buttonAdd1);
        buttonAdd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quantidade1 < 9) quantidade1++;
                txtQuantidade1.setText(quantidade1.toString());
            }
        });
        buttonSub1 = root.findViewById(R.id.buttonSub1);
        buttonSub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quantidade1 > 1) quantidade1--;
                txtQuantidade1.setText(quantidade1.toString());
            }
        });



        return root;
    }

}