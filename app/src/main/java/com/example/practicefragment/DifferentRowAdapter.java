package com.example.practicefragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.practicefragment.models.LevelEvent;
import com.example.practicefragment.screens.LevelActivity;

import java.util.List;

import static com.example.practicefragment.models.LevelEvent.HEADER_TYPE;
import static com.example.practicefragment.models.LevelEvent.ITEM_TYPE;

public class DifferentRowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<LevelEvent> _list;
    private Context context;

    public DifferentRowAdapter(List<LevelEvent> list, Context ct) {
        this._list = list;
        this.context = ct;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        switch (viewType) {
            case HEADER_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header, parent, false);
                return new CityViewHolder(view);
            case ITEM_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_images, parent, false);
                return new EventViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        LevelEvent object = _list.get(position);
        if (object != null) {
            switch (object.get_type()) {
                case HEADER_TYPE:
                    ((CityViewHolder) holder)._titleHeader.setText(object.get_header());
                    break;
                case ITEM_TYPE:
                    ((EventViewHolder) holder).mTitle.setText(object.get_name());
                    ((EventViewHolder) holder).mDescription.setText(object.get_description());
                    ((EventViewHolder)holder).linearLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(context, LevelActivity.class);
                            intent.putExtra("nameLevel", object.get_name());
                            intent.putExtra( "description", object.get_description());
                            context.startActivity(intent);
                        }
                    });
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        if (_list == null)
            return 0;
        return _list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (_list != null) {
            LevelEvent object = _list.get(position);
            if (object != null) {
                return object.get_type();
            }
        }
        return 0;
    }

    public static class CityViewHolder extends RecyclerView.ViewHolder {
        private TextView _titleHeader;

        public CityViewHolder(View itemView) {
            super(itemView);
            _titleHeader = (TextView) itemView.findViewById(R.id.headerTextView);
        }
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mDescription;
        LinearLayout linearLayout;

        public EventViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.titleTextView);
            mDescription = (TextView) itemView.findViewById(R.id.descriptionTextView);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.mainLinearLayuot);
        }
    }
}