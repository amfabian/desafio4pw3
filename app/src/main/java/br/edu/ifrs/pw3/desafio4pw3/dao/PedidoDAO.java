package br.edu.ifrs.pw3.desafio4pw3.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.edu.ifrs.pw3.desafio4pw3.util.Pedido;
import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface PedidoDAO {

    @Query("SELECT * FROM Pedido")
    public List<Pedido> getAllPedidos();

    @Query("SELECT * FROM Pedido WHERE cliente = :name")
    public List<Pedido> getPedidoByName(String name);

    @Insert(onConflict = REPLACE)
    public void insert(Pedido pedido);

    @Update
    public void update(Pedido pedido);

    @Delete
    public void delete(Pedido pedido);

}