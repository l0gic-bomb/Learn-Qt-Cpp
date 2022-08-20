package com.example.practicefragment.utility;

import android.content.Context;

import com.example.practicefragment.models.LevelEvent;
import com.example.practicefragment.models.RecyclerDataModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class ContentReaderJson {

    private static ContentReaderJson readerJson;
    private JSONObject object;
    private RecyclerDataModel.typeModel typeModel;


    //! singelton
    public static ContentReaderJson getReaderJson()
    {
        if (readerJson == null) {
            readerJson = new ContentReaderJson();
        }
        return readerJson;
    }

    //! get all data from file about all levels
    public boolean getDataAboutLevels(String path, Context context)
    {
        if (path.isEmpty())
            return false;

        setTypeModel(path);

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

    private void setTypeModel(String path)
    {
        // TODO if more than two type of levels
        typeModel = (path.contains("cpp")) ? RecyclerDataModel.typeModel.CPP_MODEL :
                RecyclerDataModel.typeModel.QT_MODEL;
    }

    public boolean getDataAboutLevel(String path, Context context)
    {
        // TODO localization system

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
    public RecyclerDataModel getGeneralDataLevels() throws JSONException {
        if (object == null)
            return null;

        RecyclerDataModel model = new RecyclerDataModel();
        getTmpModel("JUNIOR", model);
        getTmpModel("MIDDLE", model);
        getTmpModel("SENIOR", model);

        return model;
    }

    private void getTmpModel(String level, RecyclerDataModel model) throws JSONException
    {
        JSONArray data = object.getJSONArray(level);

        String[] names = new String[data.length()];
        String[] descs = new String[data.length()];
        String[] ids   = new String[data.length()];

        for (int i = 0; i < data.length(); ++i) {
            JSONObject tmpJsonObj = data.getJSONObject(i);
            names[i] = tmpJsonObj.getString("header");
            descs[i] = tmpJsonObj.getString("desc");
            ids[i]   = tmpJsonObj.getString("id");
        }

        int position = model.getSize();
        model.setListData(level, names, descs, ids);
        model.setType(getType(level), position);
    }

    private LevelEvent.Levels getType(String level)
    {
        LevelEvent.Levels result;
        switch (level)
        {
            case "JUNIOR" :
                result = LevelEvent.Levels.JUNIOR;
                break;
            case "MIDDLE" :
                result = LevelEvent.Levels.MIDDLE;
                break;
            case "SENIOR" :
                result = LevelEvent.Levels.SENIOR;
                break;
            default:
                return LevelEvent.Levels.EMPTY;
        }
        return result;
    }

    private String getType(int level)
    {
        String result;
        switch (level)
        {
            case 0:
                result = "JUNIOR";
                break;
            case 1:
                result = "MIDDLE";
                break;
            case 2:
                result = "SENIOR";
                break;
            default:
                return "";
        }
        return result;
    }
}
