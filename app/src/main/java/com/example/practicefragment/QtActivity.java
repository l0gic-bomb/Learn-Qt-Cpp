package com.example.practicefragment;

import static com.example.practicefragment.utility.ContentReaderJson.getReaderJson;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.practicefragment.models.RecyclerDataModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONException;

public class QtActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qt);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.qt_id);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.cpp_id:
                        startActivity(new Intent(getApplicationContext(), CppActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.qt_id:
                        return true;
                    case R.id.profile_id:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (!getReaderJson().getDataFromFile("windows/qt.json", this))
        {
            Log.e("error-json", String.valueOf(R.string.json_error));
        }

        RecyclerDataModel recyclerDataModel = new RecyclerDataModel();
        try {
            recyclerDataModel = getReaderJson().getGeneralDataLevels();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        DifferentRowAdapter adapter = new DifferentRowAdapter(recyclerDataModel.getData(), this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_cpp);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }
}