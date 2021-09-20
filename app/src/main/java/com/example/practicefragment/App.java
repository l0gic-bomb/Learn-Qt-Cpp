package com.example.practicefragment;

import android.app.Application;

import androidx.room.Room;

import com.example.practicefragment.data.LevelsDao;
import com.example.practicefragment.db.AppDatabase;

public class App extends Application {

    private AppDatabase database;
    private LevelsDao levelsDao;

    private static App instance;

    public static App getInstance() {
        return instance;
    }

    // Вызывается до момента взаимодействия пользователя с activtiy
    // При любом старте приложения
    @Override
    public void onCreate() {
        super.onCreate();

        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "learnqtcppdb.db")
                .createFromAsset("D:/Git/Learn-Qt-Cpp/app/src/main//java/com/example/database/learnqtcppdb.db")
                .build();

        if (!database.isOpen()) {
            System.out.println("ERROR OPENED FILE");
        }

        levelsDao = database.levelsDao();
    }


    public AppDatabase getDatabase() {
        return database;
    }

    public void setDatabase(AppDatabase database) {
        this.database = database;
    }

    public LevelsDao getLevelsDao() {
        return levelsDao;
    }

    public void setLevelsDao(LevelsDao levelsDao) {
        this.levelsDao = levelsDao;
    }
}
