package com.example.practicefragment.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.practicefragment.data.LevelsDao;
import com.example.practicefragment.entity.Levels;

@Database(entities = {Levels.class}, version = 2, exportSchema = true)
public abstract class AppDatabase extends RoomDatabase {
    public abstract LevelsDao levelsDao();

}
