package com.example.practicefragment.models;

import java.util.ArrayList;
import java.util.List;

public class RecyclerDataModel {

    private List<LevelEvent> _listData;

    public List<LevelEvent> getData() {

        return _listData;
    }

    public RecyclerDataModel() {
        _listData = new ArrayList<>();
    }

    public void setListData (String _nameLevel, String _levels[], String _descs[]) {
        _listData.add(new LevelEvent(_nameLevel, null, null, LevelEvent.HEADER_TYPE));
        for (int i = 0; i < _levels.length; ++i)
            _listData.add(new LevelEvent(null, _levels[i], _descs[i], LevelEvent.ITEM_TYPE));
    }

}
