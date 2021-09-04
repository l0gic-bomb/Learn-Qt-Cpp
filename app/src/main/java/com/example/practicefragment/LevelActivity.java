package com.example.practicefragment;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LevelActivity extends AppCompatActivity {

    TextView _name, _description;

    String _strName, _strDesc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        _name = findViewById(R.id.nameLevel);
        _description = findViewById(R.id.description);
    }

    private void getData() {
        if (getIntent().hasExtra("nameLevel") && getIntent().hasExtra("description")) {
            _name.setText(getIntent().getStringExtra("nameLevel"));
            _description.setText(getIntent().getStringExtra("description"));
        } else {
            Toast.makeText(this, "NoData", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {

    }

}