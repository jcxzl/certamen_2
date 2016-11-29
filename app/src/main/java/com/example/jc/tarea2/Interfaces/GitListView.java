package com.example.jc.tarea2.Interfaces;

import com.example.jc.tarea2.Models.Git;

import java.util.ArrayList;

/**
 * Created by Jc on 01-11-2016.
 */

public interface GitListView {
    void showData(ArrayList<Git> arrayList);
    void showWebView(String url);
}
