package com.example.practicefragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

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

}