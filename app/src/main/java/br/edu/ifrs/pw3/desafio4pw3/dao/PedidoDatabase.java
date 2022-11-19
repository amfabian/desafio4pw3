package br.edu.ifrs.pw3.desafio4pw3.dao;



import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import br.edu.ifrs.pw3.desafio4pw3.util.Pedido;


@Database(entities = {Pedido.class}, version = 1)
public abstract class PedidoDatabase extends RoomDatabase {

    private static PedidoDatabase pedidoDatabase;

    public abstract PedidoDAO createPedidoDAO();

    public static PedidoDatabase getInstance(Context context) {
        if(pedidoDatabase == null) {
            pedidoDatabase = Room.databaseBuilder(context.getApplicationContext(), PedidoDatabase.class, "pedido_db")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return pedidoDatabase;
    }
}