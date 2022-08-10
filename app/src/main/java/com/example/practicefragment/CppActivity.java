package com.example.practicefragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.practicefragment.models.RecyclerDataModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Класс для работы с уровнями С++,
 * представляет из себя переход между уровнями
 * снизу navigationBar для перехода между окнами приложения
 */

public class CppActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpp);

        // Задаем NavigationBar
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.cpp_id);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.cpp_id:
                        return true;
                    case R.id.qt_id:
                        startActivity(new Intent(getApplicationContext(), QtActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.profile_id:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
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
        //AssetManager am = CppActivity.this.getAssets();
        FileInputStream file = null;
        try {
            file = new FileInputStream("src/main/assets/cpp.json");
            BufferedReader reader = new BufferedReader(file, file.);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /* TO DO
        1. Make to ContentReaderJson
        2. Save to List<LevelEvent>
         JSONObject object = new JSONObject();
        object.put("name", "mkyong.com");
        object.put("age", new Integer(100));

        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        object.put("messages", list);

        try{
            FileWriter file = new FileWriter("test.json");
            file.write(object.toJSONString());
            file.flush();
            file.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }


        //============================================

        // остановить перед чтением файла
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("test.json"));

            JSONObject jsonObject = (JSONObject) obj;

            String name = (String) jsonObject.get("name");
            System.out.println(name);

            long age = (Long) jsonObject.get("age");
            System.out.println(age);

            // loop array
            JSONArray msg = (JSONArray) jsonObject.get("messages");
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
         */


        RecyclerDataModel recyclerDataModel = new RecyclerDataModel();

        _nameLevel = "JUNIOR";
        _names = getResources().getStringArray(R.array.name_level_junior);
        _descs = getResources().getStringArray(R.array.junior_description);
        recyclerDataModel.setListData(_nameLevel, _names, _descs);

        _nameLevel = "MIDDLE";
        _names = getResources().getStringArray(R.array.name_level_middle);
        _descs = getResources().getStringArray(R.array.middle_description);
        recyclerDataModel.setListData(_nameLevel, _names, _descs);

        _nameLevel = "SENIOR";
        _names = getResources().getStringArray(R.array.name_level_senior);
        _descs = getResources().getStringArray(R.array.senior_description);
        recyclerDataModel.setListData(_nameLevel, _names, _descs);

        DifferentRowAdapter adapter = new DifferentRowAdapter(recyclerDataModel.getData(), this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_cpp);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }

}