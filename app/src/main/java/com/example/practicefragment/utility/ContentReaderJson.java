package com.example.practicefragment.utility;

import android.content.Context;

import com.example.practicefragment.models.RecyclerDataModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ContentReaderJson {
    private static ContentReaderJson readerJson;
    private JSONObject object;

    //! singelton
    public static ContentReaderJson getReaderJson()
    {
        if (readerJson == null) {
            readerJson = new ContentReaderJson();
        }
        return readerJson;
    }

    //! get all data from file
    public boolean getDataFromFile(String path, Context context)
    {
        if (path.isEmpty())
            return false;

        object = null;
        InputStream is = null;
        try {
            String json = new String();
            is = context.getAssets().open(path);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            object = new JSONObject(json);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return false;
        }

        if (object == null)
            return false;

        return true;
    }


    //! get DataModel for every levels by key
    public RecyclerDataModel getGeneralDataLevels(String key)
    {
        if (object != null)
            return null;

        return new RecyclerDataModel();
    }




}
