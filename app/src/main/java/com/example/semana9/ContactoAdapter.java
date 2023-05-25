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
    private List<String> imagenes; // Agrega la lista de IDs de imágenes
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(String numero);
    }

    public ContactoAdapter(List<String> nombres, List<String> numeros, List<String> imagenes) {
        this.nombres = nombres;
        this.numeros = numeros;
        this.imagenes = imagenes; // Inicializa la lista de IDs de imágenes
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
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
        String imagenUrl = imagenes.get(position);// Obtén el ID de la imagen correspondiente
        View view = holder.itemView;
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView tvName = view.findViewById(R.id.textViewName);
        TextView tvNumero = view.findViewById(R.id.textViewNumero);
        Button btnLlamar = view.findViewById(R.id.btnLlamar); // Agrega el botón "Llamar"

        tvName.setText(nombre);
        tvNumero.setText(numero);
        Picasso.get().load(imagenUrl).into(imageView); // Carga la imagen correspondiente utilizando Picasso

        btnLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(numero);
                }
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
}
