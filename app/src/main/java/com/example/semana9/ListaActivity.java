package com.example.semana9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        NameAdapter adapter = new NameAdapter(data());

        RecyclerView rvLista = findViewById(R.id.rvListaSimple);
        rvLista.setLayoutManager(new LinearLayoutManager(this));
        rvLista.setAdapter(adapter);


    }
    private List<String> data(){
        List<String> names = new ArrayList<>();
        names.add("Luis");
        names.add("Pepe");
        names.add("jose");
        names.add("jhordan");
        return names;
    }


}