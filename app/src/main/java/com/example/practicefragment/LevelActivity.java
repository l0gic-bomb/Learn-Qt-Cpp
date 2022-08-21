package com.example.practicefragment;

import static com.example.practicefragment.utility.ContentReaderJson.getReaderJson;

import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.practicefragment.models.ContentsRecyclerView;
import com.example.practicefragment.models.RecyclerDataModel;
import com.example.practicefragment.utility.ContentReaderJson;

import org.json.JSONException;

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

        getDataFromJson();
        try {
            setData();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getDataFromJson() {
        if (getIntent().hasExtra("nameLevel") && getIntent().hasExtra("typeLevel")
        && getIntent().hasExtra("idLevel")) {
            nameLevel = getIntent().getStringExtra("nameLevel");
            String path = "levels/ru/" + getReaderJson().getTypeModel().toString() +
                    "/" + getIntent().getStringExtra("typeLevel").toLowerCase()
                    + "/" + getIntent().getStringExtra("idLevel").toLowerCase() + ".json";
            ContentReaderJson.getReaderJson().getDataAboutLevel(path, this);
        } else {
            Toast.makeText(this, R.string.no_level_data, Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() throws JSONException {
        tvNameLevel.setText(nameLevel);

        ContentsRecyclerView recyclerDataModel = new ContentsRecyclerView();
        recyclerDataModel.setListData(getReaderJson().jsonArrayToStringArray("Contents"));
        int tmp = 100;
    }

}
