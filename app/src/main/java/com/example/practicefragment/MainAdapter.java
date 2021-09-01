package com.example.practicefragment;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practicefragment.models.LevelEvent;

import java.util.List;

import static com.example.practicefragment.models.LevelEvent.HEADER_TYPE;
import static com.example.practicefragment.models.LevelEvent.ITEM_TYPE;


public class MainAdapter extends RecyclerView.Adapter {

    private List _levelsData;

//    private final int ITEM_HEADER = 0;
//    private final int ITEM_IMAGE  = 1;

//    String _names[], _descs[];
//    int _images[];
//    Context context;
//    String _header; // Название заголовка

    public MainAdapter(List list) {
        this._levelsData = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        switch (viewType) {
            case HEADER_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header, parent, false);
                return new HeaderViewHolder(view);
            case ITEM_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_images, parent, false);
                return new HeaderViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        LevelEvent object = (LevelEvent) _levelsData.get(position);
        if (object != null) {
            switch (object.get_type()) {
                case HEADER_TYPE:
                    ((HeaderViewHolder)holder)._header.setText(object.get_header());
                    break;
                case ITEM_TYPE:
                    for (int i = 0; i < object.get_descs().length; ++i) {
                        ((ItemViewHolder) holder)._name.setText(object.get_nameLevels()[i]);
                        ((ItemViewHolder) holder)._desc.setText(object.get_descs()[i]);
                        ((ItemViewHolder) holder)._image.setImageResource(object.get_images()[i]);
                    }
                    break;
            }
        }

    }

    @Override
    public int getItemCount() {
        if (_levelsData == null)
            return 0;
        return _levelsData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (_levelsData != null) {
            LevelEvent object = (LevelEvent)_levelsData.get(position);
            if (object != null) {
                return object.get_type();
            }
        }
        return 0;
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        private TextView _header;


        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            _header = (TextView)itemView.findViewById(R.id.titleTextView);
        }
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView _name, _desc;
        private ImageView _image;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            _name = (TextView)itemView.findViewById(R.id.name_level);
            _desc = (TextView)itemView.findViewById(R.id.description);
            _image = (ImageView)itemView.findViewById(R.id.iv_image);
        }
    }


//
//    @NonNull
//    @Override
//    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View view = inflater.inflate(R.layout.item_images, parent, false);
//        return new ItemViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//
//    }

//    @Override
//    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
//        holder.name.setText(_names[position]);
//        holder.desc.setText(_descs[position]);
//        holder.image.setImageResource(_images[position]);
//    }


//    @Override
//    public int getItemViewType(int position) {
//        if (position == 0)
//            return ITEM_HEADER;
//        else
//            return ITEM_IMAGE;
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return _names.length;
//    }
//
//    // !!! Holder для Header-а
//    public class HeaderViewHolder extends  RecyclerView.ViewHolder {
//
//        TextView header;
//
//        public HeaderViewHolder(@NonNull View itemView) {
//            super(itemView);
//            header = itemView.findViewById(R.id.header);
//        }
//    }
//
//    public class ItemViewHolder extends RecyclerView.ViewHolder {
//
//        TextView name, desc;
//        ImageView image;
//
//        public ItemViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            name  = itemView.findViewById(R.id.name_level);
//            desc  = itemView.findViewById(R.id.description);
//            image = itemView.findViewById(R.id.iv_image);
//        }
//    }
}
