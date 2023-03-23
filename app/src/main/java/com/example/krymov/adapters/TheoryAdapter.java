package com.example.krymov.adapters;


import static com.example.krymov.models.theory.Theory.TYPE_HEADER;
import static com.example.krymov.models.theory.Theory.TYPE_TEXT;
import static com.example.krymov.models.theory.Theory.TYPE_DEF;
import static com.example.krymov.models.theory.Theory.TYPE_CODE;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.krymov.R;
import com.example.krymov.models.theory.Theory;
import com.example.krymov.views.CodeView;
import com.example.krymov.views.Language;
import com.example.krymov.views.Theme;

import java.util.List;

public class TheoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Theory> theories;
    Context context;

    public TheoryAdapter(List<Theory> theories, Context ct) {
        this.theories = theories;
        this.context = ct;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case TYPE_HEADER:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_content, parent, false);
                return new TheoryAdapter.HeaderViewHolder(view);
            case TYPE_TEXT:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text, parent, false);
                return new TheoryAdapter.TextViewHolder(view);
            case TYPE_DEF:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_definition, parent, false);
                return new TheoryAdapter.DefinitionViewHolder(view);
            case TYPE_CODE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_code, parent, false);
                return new TheoryAdapter.CodeViewHolder(view, context);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Theory theory = theories.get(position);
        if (theory != null) {
            switch (theory.getTypeTheory()) {
                case text:
                    ((TheoryAdapter.TextViewHolder) holder).text.setText(theory.getTheory());
                    break;
                case header:
                    ((TheoryAdapter.HeaderViewHolder) holder).headerView.setText(theory.getTheory());
                    break;
                case definition:
                    ((TheoryAdapter.DefinitionViewHolder) holder).definition.setText(theory.getTheory());
                    break;
                case code :
                    ((TheoryAdapter.CodeViewHolder) holder).codeView.setCode((theory.getTheory()));
                    ((TheoryAdapter.CodeViewHolder) holder).initCode();
                    break;
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
            Theory theory = theories.get(position);
            if (theory != null) {
                return theory.getTypeTheory().ordinal();
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
            // TODO нужно смотреть добавлено ли определение уже в словарь
            addBtnDef.setText("Добавить определение в словарь");
        }

    }

    // class for code
    public static class CodeViewHolder extends RecyclerView.ViewHolder {
        private final CodeView codeView;

        final String CPP_CODE = "#include<iostream>;\n" +
                "\n" +
                "int main()\n" +
                "{\n" +
                "   cout << \"hello world!\" << std::endl; \n" +
                "   return 0;\n" +
                "}\n";
        public CodeViewHolder(View itemView, Context ct) {
            super(itemView);
            codeView = itemView.findViewById(R.id.code_view);
            codeView.setOnHighlightListener((CodeView.OnHighlightListener) ct)
                    .setOnHighlightListener((CodeView.OnHighlightListener)ct);
        }

        public void initCode()
        {
            codeView.setTheme(Theme.SOLARIZED_LIGHT)
                    .setLanguage(Language.CPP)
                    .setWrapLine(true)
                    .setFontSize(14)
                    .setZoomEnabled(true)
                    .setShowLineNumber(true)
                    .setStartLineNumber(1)
                    .apply();
        }
    }

    // class for code
    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        private final TextView headerView;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            headerView = (TextView) itemView.findViewById(R.id.contentTextView);
        }
    }
}
