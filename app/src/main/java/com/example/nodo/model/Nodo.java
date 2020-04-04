package com.example.nodo.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "nodo_table")
public class Nodo {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "nodo_col")
    @NonNull
    private String nodo;

    public Nodo(@NonNull String nodo) {
        this.nodo = nodo;
    }

    public String getNodo() {
        return nodo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNodo(@NonNull String nodo) {
        this.nodo = nodo;
    }
}
