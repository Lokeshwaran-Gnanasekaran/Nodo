package com.example.nodo.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nodo.R;
import com.example.nodo.model.Nodo;

import java.util.List;

public class NodoListAdapter extends RecyclerView.Adapter<NodoListAdapter.ViewHolder> {

    private LayoutInflater inflater;
    public List<Nodo> nodoList;

    public NodoListAdapter(Context context) {
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.recyclerview_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(nodoList!=null){
            Nodo current=nodoList.get(position);
            holder.text.setText(current.getNodo());
        }
        else {
            holder.text.setText("no todo ");
        }
    }
    void setNodo(List<Nodo> nodos){
        nodoList=nodos;
    }

    @Override
    public int getItemCount() {
        return nodoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.textview);
        }
    }
}
