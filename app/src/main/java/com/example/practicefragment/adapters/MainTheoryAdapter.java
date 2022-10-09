package com.example.practicefragment.adapters;

import static com.example.practicefragment.models.MainTheory.TYPE_TEXT;
import static com.example.practicefragment.models.MainTheory.TYPE_DEF;
import static com.example.practicefragment.models.MainTheory.TYPE_CODE;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practicefragment.LevelActivity;
import com.example.practicefragment.R;
import com.example.practicefragment.models.LevelEvent;
import com.example.practicefragment.models.MainTheory;
import com.example.practicefragment.models.MainTheoryRecyclerView;

import java.util.List;

public class MainTheoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    List<MainTheory> theories;
    Context context;

    public MainTheoryAdapter(List<MainTheory> theories, Context ct) {
        this.theories = theories;
        this.context = ct;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case TYPE_TEXT:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text, parent, false);
                return new MainTheoryAdapter.TextViewHolder(view);
            case TYPE_DEF:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_definition, parent, false);
                return new LevelsAdapter.EventViewHolder(view);
            case TYPE_CODE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_code, parent, false);
                return new LevelsAdapter.EventViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MainTheory theory = theories.get(position);
        if (theory != null) {
            switch (theory.getType()) {
                case text:
                    ((TextViewHolder) holder).text.setText(theory.getTextTheory());
                    break;
                /*case code:
                    ((CodeViewHolder) holder).codeView.setText(theory.getTextTheory());
                    break;
                case definition:
                    // TODO
                    break;*/
            }
        }
    }

    @Override
    public int getItemCount() {
        if (theories.isEmpty())
            return 0;
        return theories.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (theories != null) {
            MainTheory object = theories.get(position);
            if (object != null) {
                return object.getType().ordinal();
            }
        }
        return 0;
    }


    // holders levelActivtiy
    // class for text
    public static class TextViewHolder extends RecyclerView.ViewHolder {
        public TextView text;

        public TextViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.textTextView);
        }
    }

    // class for definition
    public static class DefinitionViewHolder extends RecyclerView.ViewHolder {
        private TextView definition;
        private TextView addBtnDef;

        public DefinitionViewHolder(View itemView) {
            super(itemView);
            definition = (TextView) itemView.findViewById(R.id.defTextView);
            addBtnDef = (TextView) itemView.findViewById(R.id.addDefButton);
        }

    }

    // class for code
    public static class CodeViewHolder extends RecyclerView.ViewHolder {
        private final TextView codeView;

        public CodeViewHolder(View itemView) {
            super(itemView);
            codeView = (TextView) itemView.findViewById(R.id.codeTextView);
        }
    }

}
