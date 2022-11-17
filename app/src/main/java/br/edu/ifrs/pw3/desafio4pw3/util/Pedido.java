package br.edu.ifrs.pw3.desafio4pw3.util;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String item;
    private String cliente;
    private String data;
    private String endereco;
    private String enderecoComplemento;
    private String enderecoCidade;


    private int quantidade;

    public Pedido() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEnderecoComplemento() {
        return enderecoComplemento;
    }

    public void setEnderecoComplemento(String enderecoComplemento) {
        this.enderecoComplemento = enderecoComplemento;
    }

    public String getEnderecoCidade() {
        return enderecoCidade;
    }

    public void setEnderecoCidade(String enderecoCidade) {
        this.enderecoCidade = enderecoCidade;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", cliente='" + cliente + '\'' +
                ", data='" + data + '\'' +
                ", endereco='" + endereco + '\'' +
                ", enderecoComplemento='" + enderecoComplemento + '\'' +
                ", enderecoCidade='" + enderecoCidade + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
/*  public static List<Pedido> inicializaLista(){
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(new Pedido("Botijão 13kg", "Alexandre da Silva", "15/11/2022","Rua Gal. Vasco Alves 508", "apto 501", "Porto Alegre", "9200006", 1));
        pedidos.add(new Pedido("Botijão 45kg", "Michele da Silva", "12/11/2022","Rua Cel Vicente 508", "apto 501", "Porto Alegre", "9200006", 2));
        pedidos.add(new Pedido("Botijão 08kg", "Mario da Silva", "10/11/2022","Rua Voluntarios da Patria 508", "apto 501", "Porto Alegre", "9200006", 3));
          return pedidos;
    }
*/
}
