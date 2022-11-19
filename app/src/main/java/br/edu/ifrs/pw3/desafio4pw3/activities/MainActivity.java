package br.edu.ifrs.pw3.desafio4pw3.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import br.edu.ifrs.pw3.desafio4pw3.R;
import br.edu.ifrs.pw3.desafio4pw3.util.Cliente;
import br.edu.ifrs.pw3.desafio4pw3.util.Pedido;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private AppBarConfiguration mAppBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_comprarFragment, R.id.nav_listarFragment)
                .setOpenableLayout(drawer)
                .build();
        Log.d("CLIENTE", Cliente.nome);
        Log.d("CLIENTE", Cliente.email);
        Log.d("CLIENTE", Cliente.cpf);
        Log.d("CLIENTE", Cliente.endereco);
        Log.d("CLIENTE", Cliente.enderecoLinha2);
        Log.d("CLIENTE", Cliente.cidade);
        Log.d("CLIENTE", Cliente.cep);
        if(Cliente.primeiroLogin) Log.d("CLIENTE", "TRUE");
        else Log.d("CLIENTE", "FALSE");


        if(Cliente.endereco.isEmpty()){
            primeiroLogin();

        }
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


    }

    private void primeiroLogin() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Primeiro Login");
        //define a mensagem
        builder.setMessage("Desja adicionar o seu endereco?")
                .setPositiveButton(R.string.sim, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        enterEnderecoFragment(findViewById(R.id.nav_host_fragment));
                    }
                })
                .setNegativeButton(R.string.maistarde, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Snackbar snackbar = Snackbar
                                .make(findViewById(android.R.id.content), "Sem Problemas!\nVocê poderá adicionar no momento da compra", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                });
        // Create the AlertDialog object and return it
        builder.create().show();
    }

    private void enterEnderecoFragment(View view) {
        Navigation.findNavController(view).navigate(R.id.action_Home_to_EnderecoFragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Sobre o App");
                //define a mensagem
                String msg = "Aplicativo construido para a discplina de Programacao Web 3 do IFRS - POA";
                builder.setMessage(msg)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Snackbar snackbar = Snackbar
                                .make(findViewById(android.R.id.content), "Obrigado por utilizar o app", Snackbar.LENGTH_LONG);
                        snackbar.show();
                            }
                        });
                // Create the AlertDialog object and return it
                builder.create().show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}