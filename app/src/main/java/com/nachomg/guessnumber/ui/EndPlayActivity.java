package com.nachomg.guessnumber.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nachomg.guessnumber.data.Number;
import com.nachomg.guessnumber.databinding.ActivityEndPlayBinding;
import com.nachomg.guessnumber.databinding.ActivityPlayBinding;

/**
 * Activity que muestra al usuario si ha acertado el numero o no.
 */
public class EndPlayActivity extends AppCompatActivity {

    ActivityEndPlayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEndPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent= getIntent();
        Number number= (Number) intent.getSerializableExtra("numberPlay");



        // Muestra al usuario el mensaje de final de juego, diciendole si ha acertado o no.
        binding.tvEndPlayMessage.setText(number.getMensaje());


    }
}