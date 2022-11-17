package br.edu.ifrs.pw3.desafio4pw3.fragments;

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

import br.edu.ifrs.pw3.desafio4pw3.R;

public class PagarCartaoCreditoFragment extends Fragment {
    private Button btnPagarCC;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_pagar_cartao_credito, container, false);
        btnPagarCC = root.findViewById(R.id.btnFragmentPagarCC);
        btnPagarCC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar
                        .make(getActivity().findViewById(android.R.id.content), "Pago com Cartão de Crédito", Snackbar.LENGTH_LONG);
                snackbar.show();
                Navigation.findNavController(view).navigate(R.id.action_PagarCCFragment_to_AcompanharPedido);
            }});


        return root;
    }
}
