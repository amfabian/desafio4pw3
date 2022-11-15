package br.edu.ifrs.pw3.desafio4pw3.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import br.edu.ifrs.pw3.desafio4pw3.R;
import br.edu.ifrs.pw3.desafio4pw3.adapter.PedidoAdapter;
import br.edu.ifrs.pw3.desafio4pw3.util.Pedido;


public class ListarFragment extends Fragment {
    RecyclerView recyclerView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_listar, container, false);

        recyclerView = getActivity().findViewById(R.id.FragmentListarRecyclerView);
        //configurar o adapter - que formata que o layout de cada item do recycler
        PedidoAdapter pedidoAdapter = new PedidoAdapter(Pedido.inicializaLista());
        Log.d("PRODUTOS", Pedido.inicializaLista().toString());
        Log.d("PRODUTOS", String.valueOf(R.id.FragmentListarRecyclerView));
        recyclerView.setAdapter(pedidoAdapter);
        //linha de código usada para otimizar o recycler
        recyclerView.setHasFixedSize(true);
        //configurar o gerenciador de layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        //definindo o layout do recycler
        recyclerView.setLayoutManager(layoutManager);










             //   Navigation.findNavController(view).navigate(R.id.action_listarFragment_to_editarFragment);

        return root;
    }
}