package com.example.practicefragment.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity
public class Levels implements Parcelable {

    @PrimaryKey (autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "name_level")
    public String name_level;

    @ColumnInfo (name = "prog_level_id")
    public int prog_level_id;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo (name = "done")
    public boolean done;

    public Levels() {
    }

    protected Levels(Parcel in) {
        uid = in.readInt();
        name_level = in.readString();
        prog_level_id = in.readInt();
        description = in.readString();
        done = in.readByte() != 0;
    }

    public static final Creator<Levels> CREATOR = new Creator<Levels>() {
        @Override
        public Levels createFromParcel(Parcel in) {
            return new Levels(in);
        }

        @Override
        public Levels[] newArray(int size) {
            return new Levels[size];
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Levels)) return false;
        Levels that = (Levels) o;
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



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(uid);
        dest.writeString(name_level);
        dest.writeInt(prog_level_id);
        dest.writeString(description);
        dest.writeByte((byte) (done ? 1 : 0));
    }
}
