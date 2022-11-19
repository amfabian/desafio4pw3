package br.edu.ifrs.pw3.desafio4pw3.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrs.pw3.desafio4pw3.R;
import br.edu.ifrs.pw3.desafio4pw3.util.Pedido;

public class PedidoAdapter extends RecyclerView.Adapter<PedidoAdapter.MyViewHolder>  {
    List<Pedido> listaPedidos = new ArrayList<>();

    public PedidoAdapter(List<Pedido> pedidos) {this.listaPedidos = pedidos;}

    @NonNull
    @Override
    public PedidoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        //chamado para criar as visualizações - somente as primeiras que aparecem para o usuário
        //convertendo o XML em uma visualização
        //cria um objeto do tipo view
        View itemList = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_card, viewGroup, false);
        //retorna o itemList que é passado para o construtor da MyViewHolder
        return new MyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull PedidoAdapter.MyViewHolder myViewHolder, int position) {
        //exibe os itens no Recycler
        Pedido p = listaPedidos.get(position);
        myViewHolder.item.setText(p.getItem());
        myViewHolder.cliente.setText(p.getCliente());
        myViewHolder.quantidade.setText(p.getQuantidade().toString());
        myViewHolder.data.setText(p.getData());
        myViewHolder.endereco.setText(p.getEndereco());

    }

    @Override
    public int getItemCount() {
        return listaPedidos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        //dados do pedido que serão exibidos no recycler
        TextView item;
        TextView cliente;
        TextView data;
        TextView quantidade;
        TextView endereco;

        public MyViewHolder(View itemView){
            super(itemView);
            //passa uma referência para os componentes que estão na interface
            item = itemView.findViewById(R.id.textViewAdapterItem);
            cliente = itemView.findViewById(R.id.textViewAdapterCliente);
            quantidade = itemView.findViewById(R.id.textViewAdapterQuantidade);
            data = itemView.findViewById(R.id.textViewAdapterData);
            endereco = itemView.findViewById(R.id.textViewAdapterEndereco);
        }
    }
}
