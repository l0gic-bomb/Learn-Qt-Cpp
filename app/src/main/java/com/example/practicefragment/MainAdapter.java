package com.example.practicefragment;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ItemViewHolder> {

    String _names[], _descs[];
    int _images[];
    Context context;

    public MainAdapter(Context ct, String names[], String desc[], int images[]) {
        context = ct;
        _names  = names;
        _descs  = desc;
        _images = images;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.items, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.name.setText(_names[position]);
        holder.desc.setText(_descs[position]);
        holder.image.setImageResource(_images[position]);
    }

    @Override
    public int getItemCount() {
        return _names.length;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView name, desc;
        ImageView image;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            name  = itemView.findViewById(R.id.name_level);
            desc  = itemView.findViewById(R.id.description);
            image = itemView.findViewById(R.id.iv_image);
        }
    }
}
