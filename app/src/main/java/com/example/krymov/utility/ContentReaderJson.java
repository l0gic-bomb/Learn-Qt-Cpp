package com.example.krymov.utility;

import android.content.Context;

import com.example.krymov.models.LevelEvent;
import com.example.krymov.models.RecyclerDataModel;
import com.example.krymov.models.theory.CodeTheoryCreator;
import com.example.krymov.models.theory.DefenitionTheoryCreator;
import com.example.krymov.models.theory.HeaderTheoryCreator;
import com.example.krymov.models.theory.TextTheoryCreator;
import com.example.krymov.models.theory.Theory;
import com.example.krymov.models.theory.TheoryCreator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

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

        InputStream is = null;
        try {
            String json;
            is = context.getAssets().open(path);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            object = null;
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
        typeModel = (path.contains("cpp")) ? RecyclerDataModel.typeModel.cpp :
                RecyclerDataModel.typeModel.qt;
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
            object = null;
            object = new JSONObject(json);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return false;
        }

        if (object == null)
            return false;

        return true;
    }

    // TODO
    // Использовать для считывания данных из JSON один метод

    //! get DataModel for every levels by key
    public RecyclerDataModel getGeneralDataLevels() throws JSONException {
        if (object == null)
            return null;

        RecyclerDataModel model = new RecyclerDataModel();
        setDataModel("JUNIOR", model);
        setDataModel("MIDDLE", model);
        setDataModel("SENIOR", model);

        return model;
    }

    private void setDataModel(String level, RecyclerDataModel model) throws JSONException
    {
        JSONArray data = object.getJSONArray(level);

        String[] names = new String[data.length()];
        String[] descs = new String[data.length()];
        String[] ids   = new String[data.length()];

        for (int i = 0; i < data.length(); ++i) {
            JSONObject tmpJsonObj = data.getJSONObject(i);
            // TODO ключи можно взять из самой JSON. Этот метод становится не нужен???
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


    public ArrayList<Theory> arrayTheoryByString(String nameArray) throws JSONException {
        JSONArray array = object.getJSONArray(nameArray);
        ArrayList<Theory> results = new ArrayList<Theory>();

        CodeTheoryCreator codeTheoryCreator = new CodeTheoryCreator();
        DefenitionTheoryCreator defenitionTheoryCreator = new DefenitionTheoryCreator();
        HeaderTheoryCreator headerTheoryCreator = new HeaderTheoryCreator();
        TextTheoryCreator textTheoryCreator = new TextTheoryCreator();

        for (int i = 0; i < array.length(); ++i) {
            JSONObject jsonObject = array.getJSONObject(i);
            Iterator<String> iterStr = jsonObject.keys();
            while (iterStr.hasNext())
            {
                String key = iterStr.next();
                Theory.typeTheory type = TheoryCreator.defineTypeTheory(key);
                Theory theory;
                if (type == Theory.typeTheory.code)
                    theory = codeTheoryCreator.createTheory(jsonObject.getString(key), type.toString());
                else if (type == Theory.typeTheory.header)
                    theory = headerTheoryCreator.createTheory(jsonObject.getString(key), type.toString());
                else if (type == Theory.typeTheory.text)
                    theory = textTheoryCreator.createTheory(jsonObject.getString(key), type.toString());
                else
                    theory = defenitionTheoryCreator.createTheory(jsonObject.getString(key), type.toString());
                results.add(theory);
            }
        }
        return results;
    }

    public RecyclerDataModel.typeModel getTypeModel() {
        return typeModel;
    }

}
