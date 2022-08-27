package com.example.practicefragment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practicefragment.R;
import com.example.practicefragment.models.ContentsTheory;

public class TheoryContentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    String[] contents;
    Context context;

    public TheoryContentAdapter(String[] strings, Context context)
    {
        contents = strings;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_content, parent, false);
        return new TheoryContentAdapter.ContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ContentsTheory contentsTheory = new ContentsTheory(contents[position]);
        if (contentsTheory != null)
        {
            ((ContentViewHolder) holder).content.setText(contentsTheory.getNameContent());
        }

    }

    @Override
    public int getItemCount() {
        if (contents.length == 0)
            return 0;
        return contents.length;
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        public TextView content;
        LinearLayout linearLayout;

        public ContentViewHolder(View itemView) {
            super(itemView);
            content = (TextView) itemView.findViewById(R.id.contentTextView);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.mainLinearLayuot);
        }

    }
}
