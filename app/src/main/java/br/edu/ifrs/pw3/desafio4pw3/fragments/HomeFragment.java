package br.edu.ifrs.pw3.desafio4pw3.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.google.android.material.snackbar.Snackbar;

import br.edu.ifrs.pw3.desafio4pw3.R;


public class HomeFragment extends Fragment {
    private Integer quantidade1 = 1;
    private TextView txtQuantidade1;
    private TextView txtQuantidade2;
    private TextView txtQuantidade3;
    private ImageButton buttonSub1;
    private ImageButton buttonAdd1;
    private AppCompatButton buttonCompra1;
    private Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        txtQuantidade1 = root.findViewById(R.id.textViewQuantidade1);
        txtQuantidade1.setText(quantidade1.toString());

        buttonAdd1 = root.findViewById(R.id.buttonAdd1);
        buttonAdd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quantidade1 < 9) {
                    quantidade1++;
                    Snackbar snackbar = Snackbar
                            .make(getActivity().findViewById(android.R.id.content), "Adicionado um botijão a compra", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    txtQuantidade1.setText(quantidade1.toString());





                } else {
                    Snackbar snackbar = Snackbar
                            .make(getActivity().findViewById(android.R.id.content), "Não é possível comprar mais do que 09 botijões, por favor não insista.", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });
        buttonSub1 = root.findViewById(R.id.buttonSub1);
        buttonSub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quantidade1 > 1) {
                    quantidade1--;
                    Snackbar snackbar = Snackbar
                            .make(getActivity().findViewById(android.R.id.content), "Retirado um botijão da compra", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    txtQuantidade1.setText(quantidade1.toString());
                } else {
                    Snackbar snackbar = Snackbar
                            .make(getActivity().findViewById(android.R.id.content), "Não é possível comprar menos do que 1 botijão, por favor não insista.", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });

        buttonCompra1 = root.findViewById(R.id.buttonCompra);
        buttonCompra1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar
                        .make(getActivity().findViewById(android.R.id.content), "Comprar pressionado BUNDLE", Snackbar.LENGTH_LONG);
                snackbar.show();

                Bundle bundle = new Bundle();
                bundle.putInt("pedidoQuantidade", quantidade1);
                if(quantidade1 >= 2) bundle.putString("pedidoItem", "Botijões de 13kg");
                    else bundle.putString("pedidoItem", "Botijão de 13kg");
                Log.d("testBundle", "ok");
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_nav_comprarFragment, bundle);
            }
        });
        return root;
    }

}