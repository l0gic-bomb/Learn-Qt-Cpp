package com.example.practicefragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.practicefragment.models.LevelEvent;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CppActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    String _names[], _descs[];
    int _images[] = {R.drawable.c_plus_plus, R.drawable.c_sharp, R.drawable.java,
            R.drawable.javascript, R.drawable.kotlin, R.drawable.python, R.drawable.ruby,
    R.drawable.swift, R.drawable.typescript, R.drawable.visualstudio};
    List _list;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpp);


        // Временный тип для холдера Header
        final String junior = "Junior";
        final String middle = "Middle";
        final String senior = "Senior";

        _names = getResources().getStringArray(R.array.programming_languages);
        _descs = getResources().getStringArray(R.array.description);

        _list = new ArrayList<>();

        _list.add(new LevelEvent(null, null, null, junior, LevelEvent.HEADER_TYPE));
        _list.add(new LevelEvent(_names, _descs, _images, null, LevelEvent.ITEM_TYPE));


        // Задаем адаптер


        // Задаем NavigationBar
//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setSelectedItemId(R.id.cpp);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.cpp:
//                        return true;
//                    case R.id.qt:
//                        startActivity(new Intent(getApplicationContext(), QtActivity.class));
//                        overridePendingTransition(0, 0);
//                        return true;
//                }
//                return false;
//            }
//        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        _names = getResources().getStringArray(R.array.programming_languages);
        _descs = getResources().getStringArray(R.array.description);

        _list = new ArrayList<>();

        _list.add(new LevelEvent(null, null, null, "Junior", LevelEvent.HEADER_TYPE));
        _list.add(new LevelEvent(_names, _descs, _images, null, LevelEvent.ITEM_TYPE));

        MainAdapter mainAdapter = new MainAdapter(_list);

        recyclerView = findViewById(R.id.recycler_view_cpp);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);
        recyclerView.setAdapter(mainAdapter);


    }
}