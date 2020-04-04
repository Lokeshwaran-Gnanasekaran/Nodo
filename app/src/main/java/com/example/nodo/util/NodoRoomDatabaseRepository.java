package com.example.nodo.util;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.nodo.data.nodo;
import com.example.nodo.data.nodoRoomDatabase;
import com.example.nodo.model.Nodo;

import java.util.List;

public class NodoRoomDatabaseRepository {

    private nodo nododao;
    private LiveData<List<Nodo>> allnodos;

    public NodoRoomDatabaseRepository(Application application) {
        nodoRoomDatabase db=nodoRoomDatabase.getDatabase(application);
        nododao=db.nodo();
        allnodos=nododao.getAll();
    }
    public LiveData<List<Nodo>> getAll(){
        return allnodos;
    }

    public void insert(Nodo nodo1){
        new AsyncInsert(nododao).execute(nodo1);
    }

    private class AsyncInsert extends AsyncTask<Nodo, Void, Void> {
        private nodo asyncdao;
        public AsyncInsert(nodo dao) {
            asyncdao=dao;
        }

        @Override
        protected Void doInBackground(Nodo... nodos) {
            asyncdao.insert(nodos[0]);
            return null;

        }
    }
}
