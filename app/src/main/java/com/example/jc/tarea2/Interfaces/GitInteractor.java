package com.example.jc.tarea2.Interfaces;

import com.example.jc.tarea2.Models.Git;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Jc on 04-11-2016.
 */

public interface GitInteractor {
    public ArrayList<Git> getArrayList(JSONObject jsonObject, ArrayList<Git> array);

    public void setArrayList(ArrayList<Git> List);

    public ArrayList<Git> getList(String json_url);
}
