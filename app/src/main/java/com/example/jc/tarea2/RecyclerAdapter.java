package com.example.jc.tarea2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jc.tarea2.Models.Git;

import java.util.ArrayList;

/**
 * Created by Jc on 03-11-2016.
 */

        public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

            ArrayList<Git> arrayList = new ArrayList<>();

            public RecyclerAdapter(ArrayList<Git> arrayList){
                this.arrayList = arrayList;
            }

            @Override
            public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
                return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.nombre.setText(arrayList.get(position).getNombre());
        holder.descripcion.setText(arrayList.get(position).getDescripcion());
        holder.actualizacion.setText(arrayList.get(position).getActualizacion());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nombre, descripcion, actualizacion;

        public MyViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView)itemView.findViewById(R.id.nombre);
            descripcion = (TextView)itemView.findViewById(R.id.descripcion);
            actualizacion = (TextView)itemView.findViewById(R.id.actualizacion);
        }
    }
}
