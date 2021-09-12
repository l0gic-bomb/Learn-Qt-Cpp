package com.example.practicefragment.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity
public class LevelsEntity {

    @PrimaryKey (autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "name_level")
    public String name_level;

    public LevelsEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LevelsEntity)) return false;
        LevelsEntity that = (LevelsEntity) o;
        return uid == that.uid &&
                prog_level_id == that.prog_level_id &&
                done == that.done &&
                name_level.equals(that.name_level) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, name_level, prog_level_id, description, done);
    }

    @ColumnInfo (name = "prog_level_id")
    public int prog_level_id;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo (name = "done")
    public boolean done;
}
