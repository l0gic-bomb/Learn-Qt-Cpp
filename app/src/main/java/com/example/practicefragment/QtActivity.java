package com.example.practicefragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;

import com.example.practicefragment.models.RecyclerDataModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * Класс для работы с уровнями Qt,
 * представляет из себя переход между уровнями
 * снизу navigationBar для перехода между уровнями С++ и Qt
 */

public class QtActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_qt);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.qt);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.cpp:
                        startActivity(new Intent(getApplicationContext(), CppActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.qt:
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

        String _nameLevel;
        String _names[], _descs[];


        RecyclerDataModel recyclerDataModel = new RecyclerDataModel();

        _nameLevel = "JUNIOR";
        _names = getResources().getStringArray(R.array.qt_name_level_junior);
        _descs = getResources().getStringArray(R.array.qt_junior_description);
        recyclerDataModel.setListData(_nameLevel, _names, _descs);

        _nameLevel = "MIDDLE";
        _names = getResources().getStringArray(R.array.qt_name_level_middle);
        _descs = getResources().getStringArray(R.array.qt_middle_description);
        recyclerDataModel.setListData(_nameLevel, _names, _descs);

        _nameLevel = "SENIOR";
        _names = getResources().getStringArray(R.array.qt_name_level_senior);
        _descs = getResources().getStringArray(R.array.qt_senior_description);
        recyclerDataModel.setListData(_nameLevel, _names, _descs);


        DifferentRowAdapter adapter = new DifferentRowAdapter(recyclerDataModel.getData(), this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_cpp);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }

}