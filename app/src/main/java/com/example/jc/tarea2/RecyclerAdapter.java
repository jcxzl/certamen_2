package com.example.jc.tarea2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jc.tarea2.Interfaces.GitListView;
import com.example.jc.tarea2.Models.Git;
import com.example.jc.tarea2.Views.GitList;

import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.startActivity;
import static android.support.v4.content.ContextCompat.createDeviceProtectedStorageContext;
import static android.support.v4.content.ContextCompat.startActivities;

/**
 * Created by Jc on 03-11-2016.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    ArrayList<Git> arrayList = new ArrayList<>();
    GitListView gitListView;

    public RecyclerAdapter(ArrayList<Git> arrayList, GitListView gitListView){
        this.arrayList = arrayList;
        this.gitListView = gitListView;
    }

    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.nombre.setText(arrayList.get(position).getNombre());
        holder.descripcion.setText(arrayList.get(position).getDescripcion());
        holder.actualizacion.setText(arrayList.get(position).getActualizacion());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gitListView.showWebView(arrayList.get(position).getUrl());
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nombre, descripcion, actualizacion;
        Button button;
        LinearLayout linear;

        public MyViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView)itemView.findViewById(R.id.nombre);
            descripcion = (TextView)itemView.findViewById(R.id.descripcion);
            actualizacion = (TextView)itemView.findViewById(R.id.actualizacion);
            button = (Button) itemView.findViewById(R.id.button2);
            linear = (LinearLayout)itemView.findViewById(R.id.linear);
        }
    }

}
