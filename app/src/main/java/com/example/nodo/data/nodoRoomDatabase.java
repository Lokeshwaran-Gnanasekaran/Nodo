package com.example.nodo.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.nodo.model.Nodo;

@Database(entities = {Nodo.class},version = 1)
public abstract class nodoRoomDatabase extends RoomDatabase {

public static volatile nodoRoomDatabase INSTANCE;
    public abstract nodo nodo();

    public static nodoRoomDatabase getDatabase(final Context context){
        if(INSTANCE==null){
            synchronized (nodoRoomDatabase.class){
                if (INSTANCE==null){
                     INSTANCE= Room.databaseBuilder(context.getApplicationContext(),nodoRoomDatabase.class,"nodo_database").build();
                }
            }
        }
        return INSTANCE;
    }


}
