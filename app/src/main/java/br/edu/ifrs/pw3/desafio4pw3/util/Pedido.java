package br.edu.ifrs.pw3.desafio4pw3.util;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private String item;
    private String cliente;
    private String data;
    private String endereco;
    private String enderecoLinha2;
    private String cidade;
    private String cep;


    private int quantidade;

    public Pedido() {
    }

    public Pedido(String item, String cliente, String data, String endereco, String enderecoLinha2, String cidade, String cep, int quantidade) {
        this.item = item;
        this.cliente = cliente;
        this.data = data;
        this.endereco = endereco;
        this.enderecoLinha2 = enderecoLinha2;
        this.cidade = cidade;
        this.cep = cep;
        this.quantidade = quantidade;
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

    public String getEnderecoLinha2() {
        return enderecoLinha2;
    }

    public void setEnderecoLinha2(String enderecoLinha2) {
        this.enderecoLinha2 = enderecoLinha2;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "item='" + item + '\'' +
                ", cliente='" + cliente + '\'' +
                ", data='" + data + '\'' +
                ", endereco='" + endereco + '\'' +
                ", enderecoLinha2='" + enderecoLinha2 + '\'' +
                ", cidade='" + cidade + '\'' +
                ", cep='" + cep + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
    public static List<Pedido> inicializaLista(){
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(new Pedido("Botijão 13kg", "Alexandre da Silva", "15/11/2022","Rua Gal. Vasco Alves 508", "apto 501", "Porto Alegre", "9200006", 1));
        pedidos.add(new Pedido("Botijão 45kg", "Michele da Silva", "12/11/2022","Rua Cel Vicente 508", "apto 501", "Porto Alegre", "9200006", 2));
        pedidos.add(new Pedido("Botijão 08kg", "Mario da Silva", "10/11/2022","Rua Voluntarios da Patria 508", "apto 501", "Porto Alegre", "9200006", 3));
          return pedidos;
    }

}
