package br.edu.ifrs.pw3.desafio4pw3.fragments;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

import br.edu.ifrs.pw3.desafio4pw3.R;
import br.edu.ifrs.pw3.desafio4pw3.dao.PedidoDAO;
import br.edu.ifrs.pw3.desafio4pw3.dao.PedidoDatabase;
import br.edu.ifrs.pw3.desafio4pw3.util.Cliente;
import br.edu.ifrs.pw3.desafio4pw3.util.Pedido;

public class AcompanharFragment extends Fragment {

    private TextView txtAcompEndereco;
    private TextView textViewCliente;
    private TextView textViewPagamento;
    private String pagamento;
    private String mensagem;
    private String mensagem2;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_acompanhar, container, false);
        context = getContext();



        Bundle bundle = getArguments();
        Pedido pedido = new Pedido();
        pedido.setCliente(bundle.getString("pedidoCliente", "Default BUNDLE ERROR"));
        pedido.setItem(bundle.getString("pedidoItem", "Default BUNDLE ERROR"));
        pedido.setEndereco(bundle.getString("pedidoEndereco", "Default BUNDLE ERROR"));
        pedido.setEnderecoComplemento(bundle.getString("pedidoEnderecoComplemento", "Default BUNDLE ERROR"));
        pedido.setEnderecoCidade(bundle.getString("pedidoEnderecoCidade", "Default BUNDLE ERROR"));
        pedido.setQuantidade(bundle.getInt("pedidoQuantidade", -1));
        pedido.setData(bundle.getString("pedidoData", "Default BUNDLE ERROR"));
        Log.d("ACOMPANHAMENTO", pedido.toString());




        new AsyncTask<Void,Integer, Integer>() {
                    @Override
                    protected Integer doInBackground(Void... voids) {
                        PedidoDAO pessoaDao = PedidoDatabase.getInstance(context).createPedidoDAO();
                        pessoaDao.insert(pedido);
                        return pedido.getId();
                    }

                    @Override
                    protected void onPostExecute(Integer id) {
                        if(id==null)
                            Snackbar.make(getView(), "Erro ao finalizar o pedido", Snackbar.LENGTH_LONG).show();
                        else {
                            Snackbar.make(getView(), "Feito o pedido de "+ pedido.getQuantidade() + " de " + pedido.getItem(), Snackbar.LENGTH_LONG).show();

                                  }
                    }
                }.execute();

        txtAcompEndereco = root.findViewById(R.id.textViewEndereco);
        mensagem = "O endereco de entrega será ";
        mensagem+= pedido.getEndereco();
        mensagem+= " ";
        mensagem+= pedido.getEnderecoComplemento();
        txtAcompEndereco.setText(mensagem);

        textViewCliente = root.findViewById(R.id.textViewCliente);
        mensagem2 = "O nosso entregador irá procurar por ";
        mensagem2+= pedido.getCliente();
        mensagem2+= " para realizar a entrega";
        textViewCliente.setText(mensagem2);

        pagamento = bundle.getString("pedidoPagamento", "Default BUNDLE ERROR");
        textViewPagamento = root.findViewById(R.id.textViewPag);

        if(pagamento.equals("Dinheiro")) {
            Integer valor = bundle.getInt("pedidoValor", -1);
            pagamento = "Você escolheu pagar em dinheiro.\n";
            pagamento +="O valor será R$ ";
            pagamento += valor.toString();
            pagamento += ",00\n";
            pagamento += "Não esqueca de conferir o seu troco.";
        } else {
            String pag_aux = "Você pagou com ";
            pag_aux += pagamento;
            pag_aux += ".\nNão aceite cobrancas no momento da entrega.";
            pagamento = pag_aux;
        }
        textViewPagamento.setText(pagamento);


        return root;
    }
}
