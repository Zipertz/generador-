package com.example.semana9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.semana9.ContactoAdapter;

import java.util.ArrayList;

public class ContactoActivity extends AppCompatActivity implements ContactoAdapter.OnItemClickListener {
    private ArrayList<String> nombres = new ArrayList<>();
    private ArrayList<String> numeros = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        llenarContactos();
        ContactoAdapter adapter = new ContactoAdapter(nombres, numeros);
        adapter.setOnItemClickListener(this);

        RecyclerView rvLista = findViewById(R.id.rvListaContacto);
        rvLista.setLayoutManager(new LinearLayoutManager(this));
        rvLista.setAdapter(adapter);
    }

    public void agregarContacto(String nombre, String numero) {
        nombres.add(nombre);
        numeros.add(numero);
    }

    public void llenarContactos() {
        agregarContacto("jose", "976532154");
        agregarContacto("Carlos", "976246813");
        agregarContacto("Pepe", "9764456431");
        agregarContacto("jhordab", "976124564");
    }

    @Override
    public void onItemClick(String numero) {
        realizarLlamada(numero);
    }

    private void realizarLlamada(String numero) {
        if (checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + numero));
            startActivity(intent);
        } else {
            // Solicitar permiso para realizar la llamada
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1);
        }
    }
}
