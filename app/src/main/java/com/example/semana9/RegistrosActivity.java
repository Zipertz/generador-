package com.example.semana9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrosActivity extends AppCompatActivity {
    private EditText etNombre;
    private EditText etNumero;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros);

        etNombre = findViewById(R.id.etNombre);
        etNumero = findViewById(R.id.etNumero);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString();
                String numero = etNumero.getText().toString();
                String imagenUrl = ""; // Agrega aquí la URL de la imagen si tienes un campo para ingresarla

                Intent resultIntent = new Intent();
                resultIntent.putExtra("nombre", nombre);
                resultIntent.putExtra("numero", numero);
                resultIntent.putExtra("imagenUrl", imagenUrl);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
