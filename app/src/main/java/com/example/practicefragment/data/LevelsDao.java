package com.example.practicefragment.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;


import com.example.practicefragment.entity.Levels;

import java.util.List;

@Dao
public interface LevelsDao {

    @Query("SELECT * FROM levels")
    List<Levels> getAll();

    @Query("SELECT * FROM levels")
    LiveData<List<Levels>> getAllLiveData();

}
