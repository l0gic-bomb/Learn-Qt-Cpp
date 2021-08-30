package com.example.practicefragment;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_HEADER = 2;


    ItemViewHolder _holders[];
    String _levels[], _desc[];
    int _images[];
    Context _context;

    public MainAdapter(Context context,  String levels[], String desc[], int images) {
        _context = context;
        fillHolder(levels, desc, images);
    }

//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(_context);
//        View view = inflater.inflate(R.layout.items, parent, false);
//        return new MyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        if (position == 0) {
//
//        } else {
//            holder
//        }
//    }

//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        if (position == 0) {
//            holder.tv_desc.setVisibility(holder.itemView.GONE);
//            holder.tv_name.setVisibility(holder.itemView.GONE);
//        }else {
//
//            holder.tv_name.setText(_holders[position].get_name());
//            holder.tv_desc.setText(_holders[position].get_desc());
//            holder.images.setImageResource(_holders[position].get_image());
//            holder.tv_programmer.setVisibility(holder.itemView.GONE);
//        }
//    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(_context);
        View view = inflater.inflate(R.layout.items, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final int itemType = getItemViewType(position);

        if (itemType == TYPE_HEADER) {
            // HeaderHolder will be here
        } else if (itemType == TYPE_ITEM){
            ItemViewHolder itemView = (ItemViewHolder)holder;
            itemView.tv_name.setText(_levels[position]);
            itemView.tv_desc.setText(_desc[position]);
            itemView.image.setImageResource(_images[position]);

        }
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? TYPE_HEADER : TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return _levels.length;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        String _levels[], _descs[];

        public void set_levels(String[] _levels) {
            this._levels = _levels;
        }

        public void set_descs(String[] _descs) {
            this._descs = _descs;
        }

        public void set_images(int[] _images) {
//            this._images[] = _images[];
        }

        int _images;

        public String[] get_levels() {
            return _levels;
        }

        public String[] get_descs() {
            return _descs;
        }

        public int get_images() {
            return _images;
        }

        TextView tv_name, tv_desc;
        ImageView image;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.name_level);
            tv_desc = itemView.findViewById(R.id.description);
            image   = itemView.findViewById(R.id.iv_image);
        }


    }


    public void fillHolder(String names[], String descs[], int images[]) {
        for (int i = 0; i < names.length; ++i) {
            _holders[i].set_levels(names);
            _holders[i].set_descs(descs);
            _holders[i].set_images(images);
        }
    }
}
