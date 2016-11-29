package com.example.jc.tarea2.Interfaces;

import com.example.jc.tarea2.Models.Git;
import com.example.jc.tarea2.Views.GitList;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Jc on 04-11-2016.
 */

public interface GitInteractor {
    public ArrayList<Git> getArrayList(JSONObject jsonObject, ArrayList<Git> array);

    public void setArrayList(ArrayList<Git> List);

    public void getList(GitList view, String json_url);
}
