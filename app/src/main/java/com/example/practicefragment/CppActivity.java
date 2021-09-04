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

import com.example.practicefragment.models.DummyData;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class CppActivity extends AppCompatActivity {
    RecyclerView recyclerView;


    int _images[] = {R.drawable.c_plus_plus, R.drawable.c_sharp, R.drawable.java,
            R.drawable.javascript, R.drawable.kotlin, R.drawable.python, R.drawable.ruby,
    R.drawable.swift, R.drawable.typescript, R.drawable.visualstudio};
    List _list;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpp);

        // Задаем NavigationBar
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.cpp);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.cpp:
                        return true;
                    case R.id.qt:
                        startActivity(new Intent(getApplicationContext(), QtActivity.class));
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

        String _names[], _descs[];
        String _nameLevel;

        DummyData dummyData = new DummyData();

        _nameLevel = "JUNIOR";
        _names = getResources().getStringArray(R.array.name_level_junior);
        _descs = getResources().getStringArray(R.array.junior_description);
        dummyData.setListData(_nameLevel, _names, _descs);

        _nameLevel = "MIDDLE";
        _names = getResources().getStringArray(R.array.name_level_middle);
        _descs = getResources().getStringArray(R.array.middle_description);
        dummyData.setListData(_nameLevel, _names, _descs);

        _nameLevel = "SENIOR";
        _names = getResources().getStringArray(R.array.name_level_senior);
        _descs = getResources().getStringArray(R.array.senior_description);
        dummyData.setListData(_nameLevel, _names, _descs);


        DifferentRowAdapter adapter = new DifferentRowAdapter(dummyData.getData(), this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_cpp);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }
}