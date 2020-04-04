package com.example.nodo.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.nodo.util.NodoRoomDatabaseRepository;

import java.util.List;

public class nodoViewModel extends AndroidViewModel {



    private NodoRoomDatabaseRepository repos;
    LiveData<List<Nodo>> allnodos;
    public nodoViewModel(@NonNull Application application) {
        super(application);
        repos=new NodoRoomDatabaseRepository(application);
        allnodos=repos.getAll();
    }
    LiveData<List<Nodo>> getAll(){
        return allnodos;
    }
    public void insert(Nodo n){
        repos.insert(n);
    }
}
