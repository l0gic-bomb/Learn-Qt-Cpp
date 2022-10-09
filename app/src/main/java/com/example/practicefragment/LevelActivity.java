package com.example.practicefragment;

import static com.example.practicefragment.utility.ContentReaderJson.getReaderJson;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practicefragment.adapters.LevelsAdapter;
import com.example.practicefragment.adapters.MainTheoryAdapter;
import com.example.practicefragment.adapters.TheoryContentAdapter;
import com.example.practicefragment.models.ContentsRecyclerView;
import com.example.practicefragment.models.LevelEvent;
import com.example.practicefragment.models.MainTheoryRecyclerView;
import com.example.practicefragment.models.RecyclerDataModel;
import com.example.practicefragment.utility.ContentReaderJson;

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
        setContentView(R.layout.activity_level);

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
        initAbout();
        initMainTheory();

    }

    private void initAbout()
    {
        ContentsRecyclerView recyclerDataModel = new ContentsRecyclerView();
        try {
            String[] namesField = {"name"};
            recyclerDataModel.setListData(getReaderJson().jsonArrayToStringArray("Contents", namesField));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (recyclerDataModel.isEmpty())
        {
            Log.e("error-json", String.valueOf(R.string.json_error));
        }

        TheoryContentAdapter theoryAdapter = new TheoryContentAdapter(recyclerDataModel.getContentData(), this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_contents);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(theoryAdapter);
    }

    private void initMainTheory()
    {
        MainTheoryRecyclerView recyclerDataModel = new MainTheoryRecyclerView();
        try {
            recyclerDataModel.setListData(getReaderJson().jsonArrayToStringArray("Theory"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (recyclerDataModel.isEmpty())
        {
            Log.e("error-json", String.valueOf(R.string.json_error));
        }

        MainTheoryAdapter theoryAdapter = new MainTheoryAdapter(recyclerDataModel.getTheories(), this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_theory);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(theoryAdapter);
    }

}
