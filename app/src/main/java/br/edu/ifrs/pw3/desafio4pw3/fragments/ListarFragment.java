package br.edu.ifrs.pw3.desafio4pw3.fragments;

import android.os.AsyncTask;
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

import java.util.List;

import br.edu.ifrs.pw3.desafio4pw3.R;
import br.edu.ifrs.pw3.desafio4pw3.adapter.PedidoAdapter;
import br.edu.ifrs.pw3.desafio4pw3.dao.PedidoDAO;
import br.edu.ifrs.pw3.desafio4pw3.dao.PedidoDatabase;
import br.edu.ifrs.pw3.desafio4pw3.util.Pedido;


public class ListarFragment extends Fragment {
    RecyclerView recyclerView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_listar, container, false);
        recyclerView = root.findViewById(R.id.FragmentListarRecyclerView);

        //configurar o adapter - que formata que o layout de cada item do recycler
        new AsyncTask<Void,Void, List<Pedido>>() {
            @Override
            protected List<Pedido> doInBackground(Void... voids) {
                PedidoDAO tarefaDAO = PedidoDatabase.getInstance(getContext()).createPedidoDAO();
                return tarefaDAO.getAllPedidos();
            }

            @Override
            protected void onPostExecute(List<Pedido> pedidos) {
                super.onPostExecute(pedidos);
                inicializaRecycler(pedidos);
            }

        }.execute();


               //   Navigation.findNavController(view).navigate(R.id.action_listarFragment_to_editarFragment);

        return root;
    }
    private void inicializaRecycler(List<Pedido> pedidos){
        PedidoAdapter pedidoAdapter = new PedidoAdapter(pedidos);//new MyAdapter(Pessoa.inicializaLista());
        recyclerView.setAdapter(pedidoAdapter);
        //linha de código usada para otimizar o recycler
        recyclerView.setHasFixedSize(true);

        //configurar o gerenciador de layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        //definindo o layout do recycler
        recyclerView.setLayoutManager(layoutManager);


    }
}