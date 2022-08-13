package com.example.practicefragment;

import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LevelActivity extends AppCompatActivity {

    TextView tvNameLevel;
    String nameLevel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        tvNameLevel = findViewById(R.id.nameLevel);

        getData();
        setData();
    }

    private void getData() {
        if (getIntent().hasExtra("nameLevel")) {
            nameLevel = getIntent().getStringExtra("nameLevel");
        } else {
            Toast.makeText(this, R.string.no_level_data, Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {
        tvNameLevel.setText(nameLevel);
    }

}
