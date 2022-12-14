package com.example.krymov;

import static com.example.krymov.utility.ContentReaderJson.getReaderJson;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.krymov.adapters.LevelsAdapter;
import com.example.krymov.models.RecyclerDataModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONException;


/**
 * Класс для работы с уровнями С++,
 * представляет из себя переход между уровнями
 * снизу navigationBar для перехода между окнами приложения
 */

public class CppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpp);

        // Задаем NavigationBar
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.cpp_id);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.cpp_id:
                        return true;
                    case R.id.qt_id:
                        startActivity(new Intent(getApplicationContext(), QtActivity.class));
                        overridePendingTransition(0, 0);
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

        /**
         * RecyclerView состоит следующим образом
         *  название уровня 1
         *  1. уровень
         *  ...
         *  n. уровень
         *  название уровня 2
         *  ...
         */

        if (!getReaderJson().getDataAboutLevels("windows/cpp.json", this))
        {
            Log.e("error-json", String.valueOf(R.string.json_error));
        }

        RecyclerDataModel recyclerDataModel = new RecyclerDataModel();
        try {
            recyclerDataModel = getReaderJson().getGeneralDataLevels();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        recyclerDataModel.setModel(RecyclerDataModel.typeModel.cpp);

        LevelsAdapter adapter = new LevelsAdapter(recyclerDataModel.getData(), this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_cpp);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }

}