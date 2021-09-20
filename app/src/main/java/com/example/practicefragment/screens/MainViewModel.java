package com.example.practicefragment.screens;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.practicefragment.App;
import com.example.practicefragment.entity.Levels;

import java.util.List;

public class MainViewModel extends ViewModel {
    private LiveData<List<Levels>> levelsLiveData = App.getInstance().getLevelsDao().getAllLiveData();

    public LiveData<List<Levels>> getLevelsLiveData() {
        return levelsLiveData;
    }
}
