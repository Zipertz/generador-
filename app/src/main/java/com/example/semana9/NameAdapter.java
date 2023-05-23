package com.example.semana9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class NameAdapter extends RecyclerView.Adapter {


    private List<String> items;
    public NameAdapter(List<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_name, parent, false);
        NameViewHolder viewHolder = new NameViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    String item = items.get(position);
        View view = holder.itemView;
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView tvName = view.findViewById(R.id.textViewName);

        tvName.setText(item);
        Picasso.get().load("https://i.imgur.com/DvpvklR.png").into(imageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class NameViewHolder extends RecyclerView.ViewHolder {

        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
