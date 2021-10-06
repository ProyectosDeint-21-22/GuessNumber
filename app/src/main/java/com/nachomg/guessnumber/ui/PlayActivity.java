package com.nachomg.guessnumber.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nachomg.guessnumber.R;
import com.nachomg.guessnumber.data.Number;
import com.nachomg.guessnumber.databinding.ActivityConfigBinding;
import com.nachomg.guessnumber.databinding.ActivityPlayBinding;

public class PlayActivity extends AppCompatActivity {

    private ActivityPlayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        binding = ActivityPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        //Accion boton Check/Comprobar.
        binding.btPlayCheck.setOnClickListener(view -> {
            checkNumber();
        });

        //Accion boton Delete/Borrar.
        binding.btPlayDelete.setOnClickListener(view -> {
            deleteNumber();
        });
    }

    /**
     * Método que borra el numero y intenta que el usuario lo intente de nuevo.
     */
    private void deleteNumber() {
    }

    /**
     * Método que comprueba el número introducido por el usuario.
     */
    private void checkNumber() {
        Intent intent= getIntent();
        //Se recoge solo el jugador y el NIntentos.
        Number number= (Number) intent.getSerializableExtra("number");
        //Creamos un bundle de nuevo
        Bundle bundle= new Bundle();
        //Añado en la clase number el numero para añadirlo en el bundle que lo pasará de nuevo en el Intent.
        number.setNumero(Integer.parseInt(binding.etPlayNumero.getText().toString()));
        bundle.putSerializable("numberPlay",number);

        intent= new Intent(this,EndPlayActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }


}