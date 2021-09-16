package com.example.practicefragment.db;

import androidx.room.Database;

import com.example.practicefragment.data.LevelsDao;
import com.example.practicefragment.entity.Levels;

@Database(entities = {Levels.class}, version = 1, exportSchema = false)
public abstract class AppDatabase {
    public abstract LevelsDao levelsDao();

}
