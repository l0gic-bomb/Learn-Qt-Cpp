package com.example.practicefragment;


import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public final class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<Item> items;

    public ItemAdapter (List<Item> items) {
        this.items = items;
    }

    // Загрузка строчки (одтельный слой)
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerView.ViewHolder(
                LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items, parent, false)
        )
        {};
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView name = holder.itemView.findViewById(R.id.name);
        name.setText(String.format("%s. %s", position, this.items.get(position).getName()));
    }

    // Сколько всего элементов в коллекции
    @Override
    public int getItemCount() {
        return this.items.size();
    }
}
