package com.example.jc.tarea2.Presenters;

import android.content.Context;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.jc.tarea2.Interactors.GitInteractorImpl;
import com.example.jc.tarea2.Interfaces.GitInteractor;
import com.example.jc.tarea2.Interfaces.GitListPresenter;
import com.example.jc.tarea2.Interfaces.MainPresenter;
import com.example.jc.tarea2.Models.Git;
import com.example.jc.tarea2.MySingleton;
import com.example.jc.tarea2.Views.GitList;

import java.util.ArrayList;

/**
 * Created by Jc on 01-11-2016.
 */

public class GitListPresenterImpl implements GitListPresenter {

    GitInteractor gitInteractor;
    GitList view;
    Context context;
    public GitListPresenterImpl(GitList view, Context context){
        this.context = context;
        this.view = view;
        this.gitInteractor = new GitInteractorImpl(context);
    }

    @Override
    public void getList(String user){
        String json_url = "https://api.github.com/users/"+user+"/repos";
        gitInteractor.getList(view, json_url);
    }



}
