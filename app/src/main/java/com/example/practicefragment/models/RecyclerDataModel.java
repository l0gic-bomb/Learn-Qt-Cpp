package com.example.practicefragment.models;

import java.util.ArrayList;
import java.util.List;

/*!
  \brief   Модель для уровней и хедеров
  Модель предназначена только для отображения уроков и
*/

public class RecyclerDataModel {

    public enum typeModel
    {
        CPP_MODEL,
        QT_MODEL
    }

    private List<LevelEvent> _listData;
    private typeModel model;


    public List<LevelEvent> getData() {
        return _listData;
    }

    public RecyclerDataModel() {
        _listData = new ArrayList<>();
    }

    public void setListData (String _nameLevel, String[] _levels, String[] _descs) {
        // insert header
        _listData.add(new LevelEvent(_nameLevel, null, null, LevelEvent.HEADER_TYPE));
        // insert lessons
        for (int i = 0; i < _levels.length; ++i)
            _listData.add(new LevelEvent(null, _levels[i], _descs[i], LevelEvent.ITEM_TYPE));
    }

    public void setType (int typeLevel, int position)
    {
        for (int i = position; i < _listData.size(); ++position)
        {
            if (_listData.get(i).get_type() == LevelEvent.HEADER_TYPE)
                continue;
            _listData.get(i).set_type(typeLevel);
        }
    }

    public int getSize()
    {
        if (_listData.isEmpty())
            return 0;
        return _listData.size();
    }

    public void setModel(typeModel model)
    {
        this.model = model;
    }

    public typeModel getModel()
    {
        return model;
    }
}
