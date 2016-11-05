package com.example.jc.tarea2.Interfaces;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.example.jc.tarea2.Models.Git;

import java.util.ArrayList;


/**
 * Created by Jc on 01-11-2016.
 */

public interface GitListPresenter {
    public ArrayList<Git> getList(String user);
}
