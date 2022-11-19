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

        // Monta os textos a serem exibidos
        Pedido p = listaPedidos.get(position);

        //Modelo msg: Pedido do dia 24/12/2022
        String msg;
        msg = "Pedido do dia ";
        msg += p.getData();

        //Modelo Item: 3 Botijões de 13kg da Butano Gás
        String item;
        item = p.getQuantidade().toString();
        item += " ";
        item += p.getItem();
        item += " da Butano Gás";

        //Modelo Cliente: Recebido por Alexandre Fabian
        String cliente;
        cliente = "Recebidos por ";
        cliente += p.getCliente();

        //Modelo Endereco: Rua Cel. Vicente apto 500
        String endereco;
        endereco = p.getEndereco();
        endereco += " ";
        endereco += p.getEnderecoComplemento();


        //exibe os itens no Recycler
        myViewHolder.pedido.setText(msg);
        myViewHolder.item_quantidade.setText(item);
        myViewHolder.cliente.setText(cliente);
        myViewHolder.cidade.setText(p.getEnderecoCidade());
        myViewHolder.endereco.setText(endereco);

    }

    @Override
    public int getItemCount() {
        return listaPedidos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        //dados do pedido que serão exibidos no recycler
        TextView pedido;
        TextView cliente;
        TextView cidade;
        TextView item_quantidade;
        TextView endereco;

        public MyViewHolder(View itemView){
            super(itemView);
            //passa uma referência para os componentes que estão na interface
            pedido = itemView.findViewById(R.id.textViewAdapterPedido);
            cliente = itemView.findViewById(R.id.textViewAdapterCliente);
            item_quantidade = itemView.findViewById(R.id.textViewAdapterItemQuantidade);
            cidade = itemView.findViewById(R.id.textViewAdapterCidade);
            endereco = itemView.findViewById(R.id.textViewAdapterEndereco);
        }
    }
}
