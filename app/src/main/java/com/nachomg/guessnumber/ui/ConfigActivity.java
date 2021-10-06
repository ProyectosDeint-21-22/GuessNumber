package com.nachomg.guessnumber.ui;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import com.nachomg.guessnumber.R;
import com.nachomg.guessnumber.data.Number;
import com.nachomg.guessnumber.databinding.ActivityConfigBinding;;

import android.view.Menu;
import android.view.MenuItem;

public class ConfigActivity extends AppCompatActivity {
    private ActivityConfigBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityConfigBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        //Accion Botón btConfig
        binding.btConfig.setOnClickListener(view -> {
            sendPlayNumber();
        });
    }

    /**
     * Método que implementa la acción del boton btConfig, enviará informacion a la Activity PlayActivity.
     */
    private void sendPlayNumber() {
        Bundle bundle= new Bundle();

        //Todo Cambiar el bundle y que recoja los objetos de la clase Number.
        Number number= new Number(binding.etConfigJugador.getText().toString(),Integer.parseInt(binding.etConfigNIntentos.getText().toString()));
        bundle.putSerializable("number",number);

        Intent intent= new Intent(this, PlayActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    //region Metodos del AppBar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //endregion
}