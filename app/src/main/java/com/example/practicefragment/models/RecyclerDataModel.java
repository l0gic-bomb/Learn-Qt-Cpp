package com.example.practicefragment.models;

import java.util.ArrayList;
import java.util.List;

/*!
  \brief   Модель для уровней и хедеров
  Модель предназначена только для отображения уроков и
*/

public class RecyclerDataModel {

    private List<LevelEvent> _listData;

    public List<LevelEvent> getData() {
        return _listData;
    }

    public RecyclerDataModel() {
        _listData = new ArrayList<>();
    }

    public void setListData (String _nameLevel, String _levels[], String _descs[]) {
        // insert header
        _listData.add(new LevelEvent(_nameLevel, null, null, LevelEvent.HEADER_TYPE));
        // insert lessons
        for (int i = 0; i < _levels.length; ++i)
            _listData.add(new LevelEvent(null, _levels[i], _descs[i], LevelEvent.ITEM_TYPE));
    }
}
