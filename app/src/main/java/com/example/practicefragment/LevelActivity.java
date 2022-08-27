package com.example.practicefragment;

import static com.example.practicefragment.utility.ContentReaderJson.getReaderJson;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practicefragment.adapters.LevelsAdapter;
import com.example.practicefragment.adapters.TheoryContentAdapter;
import com.example.practicefragment.models.ContentsRecyclerView;
import com.example.practicefragment.models.RecyclerDataModel;
import com.example.practicefragment.utility.ContentReaderJson;

import org.json.JSONException;

import java.net.URI;

public class LevelActivity extends AppCompatActivity {

    TextView tvNameLevel;
    String nameLevel;

    TextView[] general;
    TextView[] definitions;
    TextView[] code;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        tvNameLevel = findViewById(R.id.nameLevel);

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

       /* ContentsRecyclerView recyclerDataModel = new ContentsRecyclerView();
        recyclerDataModel.setListData(getReaderJson().jsonArrayToStringArray("Contents"));
        if (recyclerDataModel.isEmpty())
        {
            Log.e("error-json", String.valueOf(R.string.json_error));
        }

        TheoryContentAdapter adapter = new TheoryContentAdapter(recyclerDataModel.getContentData(), this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_contents);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);*/

    }

    @Override
    protected void onStart() {
        super.onStart();

        ContentsRecyclerView recyclerDataModel = new ContentsRecyclerView();
        try {
            recyclerDataModel.setListData(getReaderJson().jsonArrayToStringArray("Contents"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (recyclerDataModel.isEmpty())
        {
            Log.e("error-json", String.valueOf(R.string.json_error));
        }

        TheoryContentAdapter adapter = new TheoryContentAdapter(recyclerDataModel.getContentData(), this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_contents);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }

}
