package com.nachomg.guessnumber.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.nachomg.guessnumber.R;
import com.nachomg.guessnumber.data.Number;
import com.nachomg.guessnumber.databinding.ActivityConfigBinding;
import com.nachomg.guessnumber.databinding.ActivityPlayBinding;

import java.util.Random;

/*
Activity que comprobrá el valor del numero comparandolo con otro random que generará el juego.
Si el numero del jugador es menor o mayor que el numero del juego, se le indicará al usuario.
Si el numero del jugador es igual que el numero del juego, se le felicitará en la Activity EndPlayActivity.
Si el jugador supera el numero de intentos seleccionado antes en la activity ConfigActivity, lo dirigirá a EndPlayActivity,
indicandole que ha superado el numero de intentos.
 */
public class PlayActivity extends AppCompatActivity {

    private ActivityPlayBinding binding;
    int contadorNIntentos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        binding = ActivityPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
     * Método que borra el numero y el mensaje e intenta que el usuario lo intente de nuevo.
     */
    private void deleteNumber() {
        binding.etPlayNumero.setText("");
        binding.tvPlayMessage.setText("");
    }

    /**
     * Método que comprueba el número introducido por el usuario, si es mayor, menor o igual que el número propuesto.
     */
    private void checkNumber() {
        Intent intent= getIntent();
        //Se recoge solo el jugador y el NIntentos.
        Number number= (Number) intent.getSerializableExtra("number");

        //Comprobación del número;
        Random rnd = new Random();
        int numero= rnd.nextInt(101);
        int numeroPropuesto;

        //Si el campo numero, introducido por el usuario está vacio le envia al usuario información y sale del método checkNumber.
        if(binding.etPlayNumero.getText().toString().isEmpty()){
            binding.tvPlayMessage.setText(number.getJugador()+ " el número no puede estar vacío.");
            return;
        }
        else{
            numeroPropuesto= Integer.parseInt(binding.etPlayNumero.getText().toString());
        }

        //Si el contador es mayor que el número de intentos que el usuario ha indicado, se sale.
        if(contadorNIntentos < number.getnIntentos()){
            //Comparamos si el numero propuesto por el jugador es el numero Random que queremos acertar.
            if(numeroPropuesto<numero){
                binding.tvPlayMessage.setText(number.getJugador()+" el número es mayor.");
            }
            if(numeroPropuesto>numero){
                binding.tvPlayMessage.setText(number.getJugador()+ " el número es menor.");
            }
            if(numeroPropuesto==numero){
                //Creamos un bundle de nuevo
                Bundle bundle= new Bundle();
                //Añado en la clase number el numero para añadirlo en el bundle que lo pasará de nuevo en el Intent.
                number.setNumero(numeroPropuesto);
                number.setMensaje(number.getJugador()+" has acertado el número "+ number.getNumero()+ " en " + number.getnIntentos() + " intentos.");
                bundle.putSerializable("numberPlay",number);

                intent= new Intent(this,EndPlayActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
            contadorNIntentos++;
        }
        //Si supera el número de Intentos.
        else{
            Bundle bundle= new Bundle();
            //Añado en la clase number el numero para añadirlo en el bundle que lo pasará de nuevo en el Intent.
            number.setNumero(numeroPropuesto);
            number.setMensaje(number.getJugador()+" no has acertado el número "+ number.getNumero()+ " en " + number.getnIntentos() + " intentos.");
            bundle.putSerializable("numberPlay",number);

            intent= new Intent(this,EndPlayActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);

        }
    }



}