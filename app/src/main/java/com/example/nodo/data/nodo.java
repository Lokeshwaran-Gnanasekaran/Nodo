package com.example.nodo.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.nodo.model.Nodo;

import java.util.List;

@Dao
public interface nodo {
    @Insert
    void insert(Nodo nodo);
    @Query("DELETE FROM nodo_table WHERE id= :id")
    void deleteOne(int id);
    @Query("DELETE FROM nodo_table")
    void deleteAll();
    @Query("UPDATE nodo_table SET nodo_col= :text WHERE id= :id")
    int updateOne(int id,String text);
    @Query("SELECT * FROM nodo_table")
    LiveData<List<Nodo>> getAll();



}
