package com.example.semana9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder> {
    private List<String> nombres;
    private List<String> numeros;

    public ContactoAdapter(List<String> nombres, List<String> numeros) {
        this.nombres = nombres;
        this.numeros = numeros;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_contacto, parent, false);
        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        String nombre = nombres.get(position);
        String numero = numeros.get(position);
        View view = holder.itemView;
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView tvName = view.findViewById(R.id.textViewName);
        TextView tvNumero = view.findViewById(R.id.textViewNumero);
        Button btnLlamar = view.findViewById(R.id.btnLlamar); // Agrega el botón "Llamar"

        tvName.setText(nombre);
        tvNumero.setText(numero);
        Picasso.get().load("https://i.imgur.com/DvpvklR.png").into(imageView);

        btnLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarLlamada(numero); // Realiza la llamada al número correspondiente
            }
        });
    }

    @Override
    public int getItemCount() {
        return nombres.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder {
        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    private void realizarLlamada(String numero) {
        // Agrega el código para realizar la llamada al número indicado
        // ...
    }
}
