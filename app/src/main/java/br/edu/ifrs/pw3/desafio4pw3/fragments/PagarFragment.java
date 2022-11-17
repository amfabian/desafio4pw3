package br.edu.ifrs.pw3.desafio4pw3.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.google.android.material.snackbar.Snackbar;

import br.edu.ifrs.pw3.desafio4pw3.R;

public class PagarFragment extends Fragment {

    private AppCompatButton pagarPIX;
    private AppCompatButton pagarCC;
    private AppCompatButton pagarRS;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_pagar, container, false);
        pagarPIX = root.findViewById(R.id.buttonPIX);
        pagarCC = root.findViewById(R.id.buttonCC);
        pagarRS = root.findViewById(R.id.buttonRS);

        pagarPIX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView image = new ImageView(root.getContext());
                image.setImageResource(R.drawable.pix_cobrar);
                AlertDialog.Builder builder =
                        new AlertDialog.Builder(root.getContext()).
                                setMessage("Pague com PIX").
                                setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        Navigation.findNavController(view).navigate(R.id.action_PagarFragment_to_AcompanharPedido);
                                    }
                                }).
                                setView(image);
                builder.create().show();


            }});
        pagarCC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar
                        .make(getActivity().findViewById(android.R.id.content), "CC", Snackbar.LENGTH_LONG);
                snackbar.show();
                Navigation.findNavController(view).navigate(R.id.action_PagarFragment_to_PagarCCFragment);
            }});
        pagarRS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(root.getContext());
                builder.setTitle("Pagamento com Dinheiro");
                //define a mensagem
                builder.setMessage("O Pagamento será feito no momento da entrega")
                        .setPositiveButton(R.string.sim, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Navigation.findNavController(view).navigate(R.id.action_PagarFragment_to_AcompanharPedido);
                            }
                        });
                // Create the AlertDialog object and return it
                builder.create().show();
            }});



        return root;
    }

}
