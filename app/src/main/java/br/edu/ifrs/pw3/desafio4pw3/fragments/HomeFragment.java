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
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import br.edu.ifrs.pw3.desafio4pw3.R;
import br.edu.ifrs.pw3.desafio4pw3.util.GlideApp;


public class HomeFragment extends Fragment {
    private ImageView imgBotijao13;
    private ImageView imgBotijao08;
    private ImageView imgBotijao45;

    private Integer quantidade1 = 1;
    private Integer quantidade2 = 1;
    private Integer quantidade3 = 1;
    private TextView txtQuantidade1;
    private TextView txtQuantidade2;
    private TextView txtQuantidade3;
    private ImageButton buttonSub1;
    private ImageButton buttonAdd1;

    private ImageButton buttonAdd2;
    private ImageButton buttonSub2;
    private ImageButton buttonAdd3;
    private ImageButton buttonSub3;
    private AppCompatButton buttonCompra1;
    private AppCompatButton buttonCompra2;
    private AppCompatButton buttonCompra3;
    private Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        imgBotijao13 = root.findViewById(R.id.imageView1);
        StorageReference storageReference = FirebaseStorage.getInstance().getReference();
        StorageReference imagens = storageReference.child("produtos/"+"butanoGas13.jpeg");
        GlideApp.with(getActivity())
                .load(imagens)
                .into(imgBotijao13);
        imgBotijao45 = root.findViewById(R.id.imageView2);
        imagens = storageReference.child("produtos/"+"butanoGas45.jpeg");
        GlideApp.with(getActivity())
                .load(imagens)
                .into(imgBotijao45);
        imgBotijao08 = root.findViewById(R.id.imageView3);
        imagens = storageReference.child("produtos/"+"butanoGas08.jpeg");
        GlideApp.with(getActivity())
                .load(imagens)
                .into(imgBotijao08);



        txtQuantidade1 = root.findViewById(R.id.textViewQuantidade1);
        txtQuantidade1.setText(quantidade1.toString());
        buttonAdd1 = root.findViewById(R.id.buttonAdd1);
        buttonAdd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantidade1 = adicionar(quantidade1);
                txtQuantidade1.setText(quantidade1.toString());
            }
        });
        buttonSub1 = root.findViewById(R.id.buttonSub1);
        buttonSub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantidade1 = subtrair(quantidade1);
                txtQuantidade1.setText(quantidade1.toString());
            }
        });

        buttonCompra1 = root.findViewById(R.id.buttonCompra);
        buttonCompra1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprar(view, quantidade1, 115);
            }
        });

        txtQuantidade2 = root.findViewById(R.id.textViewQuantidade2);
        txtQuantidade2.setText(quantidade2.toString());

        buttonAdd2 = root.findViewById(R.id.buttonAdd2);
        buttonAdd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantidade2 = adicionar(quantidade2);
                txtQuantidade2.setText(quantidade2.toString());
            }
        });
        buttonSub2 = root.findViewById(R.id.buttonSub2);
        buttonSub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantidade2 = subtrair(quantidade2);
                txtQuantidade2.setText(quantidade2.toString());
            }
        });

        buttonCompra2 = root.findViewById(R.id.buttonCompra2);
        buttonCompra2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprar(view, quantidade2, 350);
            }
        });

        txtQuantidade3 = root.findViewById(R.id.textViewQuantidade3);
        txtQuantidade3.setText(quantidade3.toString());

        buttonAdd3 = root.findViewById(R.id.buttonAdd3);
        buttonAdd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantidade3 = adicionar(quantidade3);
                txtQuantidade3.setText(quantidade3.toString());
            }
        });
        buttonSub3 = root.findViewById(R.id.buttonSub3);
        buttonSub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantidade3 = subtrair(quantidade3);
                txtQuantidade3.setText(quantidade3.toString());
            }
        });

        buttonCompra3 = root.findViewById(R.id.buttonCompra3);
        buttonCompra3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                comprar(view, quantidade3, 75);
            }
        });


        return root;
    }

    private void comprar(View view, int qtd, int valor) {
        Snackbar snackbar = Snackbar
                .make(getActivity().findViewById(android.R.id.content), "Comprar pressionado", Snackbar.LENGTH_LONG);
        snackbar.show();

        Bundle bundle = new Bundle();
        bundle.putInt("pedidoQuantidade", qtd);
        bundle.putInt("pedidoValor", valor*qtd);
        ;
        bundle.putString("pedidoItem", obterTipo(valor, qtd));
        Log.d("testBundle", "ok");
        Navigation.findNavController(view).navigate(R.id.action_nav_home_to_nav_comprarFragment, bundle);
    }

    private String obterTipo(int valor, int qtd) {
        String msg = "";
        switch (valor) {

            case 75:
                if(qtd == 1) msg = "Botijão de 08kg";
                else msg = "Botijões de 08kg";
                break;
            case 115:
                if(qtd == 1) msg = "Botijão de 13kg";
                else msg = "Botijões de 13kg";
                break;
            case 350:
                if(qtd == 1) msg = "Botijão de 45kg";
                else msg = "Botijões de 45kg";
                break;
            default:
                msg = "";
        }
        return msg;
    }

    private Integer subtrair(Integer qtd) {
        if(qtd > 1) {
            qtd--;
            Snackbar snackbar = Snackbar
                    .make(getActivity().findViewById(android.R.id.content), "Retirado um botijão da compra", Snackbar.LENGTH_LONG);
            snackbar.show();
        } else {
            Snackbar snackbar = Snackbar
                    .make(getActivity().findViewById(android.R.id.content), "Não é possível comprar menos do que 1 botijão, por favor não insista.", Snackbar.LENGTH_LONG);
            snackbar.show();
        }
        Log.d("HOME", qtd.toString());

        return qtd;
    }

    private Integer adicionar(Integer qtd) {
        if(qtd < 9) {
            qtd++;
            Snackbar snackbar = Snackbar
                    .make(getActivity().findViewById(android.R.id.content), "Adicionado um botijão a compra", Snackbar.LENGTH_LONG);
            snackbar.show();
        } else {
            Snackbar snackbar = Snackbar
                    .make(getActivity().findViewById(android.R.id.content), "Não é possível comprar mais do que 09 botijões, por favor não insista.", Snackbar.LENGTH_LONG);
            snackbar.show();
        }
        Log.d("HOME", qtd.toString());
        txtQuantidade1.setText(qtd.toString());
        return qtd;
    }

}