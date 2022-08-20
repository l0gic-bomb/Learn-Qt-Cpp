package com.example.practicefragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.practicefragment.utility.ContentReaderJson;

import java.net.URI;

public class LevelActivity extends AppCompatActivity {

    TextView tvNameLevel;
    String nameLevel;

    CardView contents;
    TextView[] general;
    TextView[] definitions;
    TextView[] code;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        tvNameLevel = findViewById(R.id.nameLevel);
        contents = findViewById(R.id.contents);

        getData();
        setData();

        
    }

    private void getData() {
        if (getIntent().hasExtra("nameLevel") && getIntent().hasExtra("typeLevel")
        && getIntent().hasExtra("idLevel")) {
            nameLevel = getIntent().getStringExtra("nameLevel");
            String path = "levels/ru/" + getIntent().getStringExtra("typeLevel").toLowerCase()
                    + "/" + getIntent().getStringExtra("idLevel").toLowerCase() + ".json";
            ContentReaderJson.getReaderJson().getDataAboutLevel(path, this);
        } else {
            Toast.makeText(this, R.string.no_level_data, Toast.LENGTH_SHORT).show();
        }
    }

    private void setData()
    {
        tvNameLevel.setText(nameLevel);
    }

}
