package com.example.krymov;

import static com.example.krymov.utility.ContentReaderJson.getReaderJson;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.krymov.adapters.TheoryAdapter;
import com.example.krymov.models.TheoryRecyclerView;
import com.example.krymov.utility.ContentReaderJson;

import org.json.JSONException;

public class LevelActivity extends AppCompatActivity {

    TextView tvNameLevel;

    String currentLevel;
    // For saving contents
    String [] contents;

    TextView[] general;
    TextView[] definitions;
    TextView[] code;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory);

        tvNameLevel = findViewById(R.id.nameLevel);

        getDataFromJson();
    }

    private void getDataFromJson() {
        if (getIntent().hasExtra("nameLevel") && getIntent().hasExtra("typeLevel")
        && getIntent().hasExtra("idLevel")) {
            tvNameLevel.setText(getIntent().getStringExtra("nameLevel"));

            currentLevel = getIntent().getStringExtra("typeLevel").toLowerCase();
            String path = "levels/ru/" + getReaderJson().getTypeModel().toString() +
                    "/" + getIntent().getStringExtra("typeLevel").toLowerCase()
                    + "/" + getIntent().getStringExtra("idLevel").toLowerCase() + ".json";
            ContentReaderJson.getReaderJson().getDataAboutLevel(path, this);
        } else {
            Toast.makeText(this, R.string.no_level_data, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        init();

    }

    private void init()
    {
        TheoryRecyclerView theoryRecyclerView = new TheoryRecyclerView();
        try {
            theoryRecyclerView.setListData(getReaderJson().arrayTheoryByString("Theory"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (theoryRecyclerView.isEmpty())
        {
            Log.e("error-json", String.valueOf(R.string.json_error));
        }

        TheoryAdapter theoryAdapter = new TheoryAdapter(theoryRecyclerView.getTheories(), this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_theory);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(theoryAdapter);
    }



}
