package com.example.practicefragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CppActivity extends AppCompatActivity {
    RecyclerView recyclerView;

//    ItemViewHolder _holders[];
    String names[], descs[];
    int images[] = {R.drawable.c_plus_plus, R.drawable.c_sharp, R.drawable.java,
            R.drawable.javascript, R.drawable.kotlin, R.drawable.python, R.drawable.ruby,
    R.drawable.swift, R.drawable.typescript, R.drawable.visualstudio};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpp);


        fillHolder(getResources().getStringArray(R.array.programming_languages), getResources().getStringArray(R.array.description), images);

        recyclerView = findViewById(R.id.recycler_view_cpp);

        // Задаем адаптер
//        MainAdapter mainAdapter = new MainAdapter(this, /*_holders*/);
//        recyclerView.setAdapter(mainAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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

    public void fillHolder(String names[], String descs[], int images[]) {
        for (int i = 0; i < names.length; ++i) {
//            _holders[i].set_name(names[i]);
//            _holders[i].set_desc(descs[i]);
//            _holders[i].set_image(images[i]);
        }
    }
}