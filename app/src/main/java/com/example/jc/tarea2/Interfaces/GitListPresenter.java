package com.example.jc.tarea2.Interfaces;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.example.jc.tarea2.Models.Git;
import com.example.jc.tarea2.Views.GitList;

import java.util.ArrayList;


/**
 * Created by Jc on 01-11-2016.
 */

public interface GitListPresenter {
    void getList(String user);
}
