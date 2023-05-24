package com.example.semana9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText puntos1;
    EditText puntos2;
    EditText ganador;
    Button jugadores;
    Button resert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         jugadores = findViewById(R.id.btnJugadores);
         puntos1 = findViewById(R.id.puntos1);
         puntos2 = findViewById(R.id.puntos2);
         puntos2 = findViewById(R.id.puntos2);
         ganador = findViewById(R.id.ganador);
         resert = findViewById(R.id.btnReset);


        jugadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = jugadores.getText().toString();
                if (text.equals("Jugador 1")) {
                    Random random = new Random();
                    int numeroAleatorio1 = random.nextInt(10) + 1;

                    puntos1.setText(String.valueOf(numeroAleatorio1));
                    jugadores.setText("Jugador 2");

                    String puntos2Text = puntos2.getText().toString();
                    int numeroAleatorio2 = 0;

                    if (!puntos2Text.isEmpty()) {
                        numeroAleatorio2 = Integer.parseInt(puntos2Text);
                    }

                    // Comparar los números aleatorios
                    if (numeroAleatorio1 > numeroAleatorio2) {
                        // Jugador 1 gana
                        ganador.setText("¡Jugador 1 es el ganador!");
                    } else if (numeroAleatorio1 < numeroAleatorio2) {
                        // Jugador 2 gana
                        ganador.setText("¡Jugador 2 es el ganador!");
                    } else {
                        // Empate
                        ganador.setText("Empate");
                    }
                } else if (text.equals("Jugador 2")) {
                    Random random2 = new Random();
                    int numeroAleatorio2 = random2.nextInt(10) + 1;

                    puntos2.setText(String.valueOf(numeroAleatorio2));
                    jugadores.setText("Jugador 1");

                    String puntos1Text = puntos1.getText().toString();
                    int numeroAleatorio1 = 0;

                    if (!puntos1Text.isEmpty()) {
                        numeroAleatorio1 = Integer.parseInt(puntos1Text);
                    }

                    // Comparar los números aleatorios
                    if (numeroAleatorio1 > numeroAleatorio2) {
                        // Jugador 1 gana
                        ganador.setText("¡Jugador 1 es el ganador!");
                    } else if (numeroAleatorio1 < numeroAleatorio2) {
                        // Jugador 2 gana
                        ganador.setText("¡Jugador 2 es el ganador!");
                    } else {
                        // Empate
                        ganador.setText("Empate");
                    }

                    // Desactivar el botón jugadores después de generar al jugador 2
                    jugadores.setEnabled(false);
                }
            }
        });

        resert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Restablecer los valores
               // puntos1.setText("");
             // jugadores.setText("Jugador 1");
               // ganador.setText("");

                // Habilitar el botón jugadores
                //jugadores.setEnabled(true);

                Intent intent = new Intent(getApplicationContext(),ContactoActivity.class);
                startActivity(intent);
            }
        });

    }
}

