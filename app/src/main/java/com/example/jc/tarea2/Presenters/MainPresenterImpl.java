package com.example.jc.tarea2.Presenters;

import android.content.Context;

import com.example.jc.tarea2.Interactors.MainInteractorImpl;
import com.example.jc.tarea2.Interfaces.MainInteractor;
import com.example.jc.tarea2.Interfaces.MainPresenter;
import com.example.jc.tarea2.Interfaces.MainView;

/**
 * Created by Jc on 01-11-2016.
 */

public class MainPresenterImpl implements MainPresenter{

    private MainView view;
    private MainInteractor interactor;
    private Context context;

    public MainPresenterImpl(MainView view, Context context){
        this.view = view;
        this.context = context;
        this.interactor = new MainInteractorImpl();

    }

    @Override
    public void searchUser(String user) {
        if(user != null) {
            if (view != null) {
                view.showProgress();
                successful(user);
            }
        }else{
            usernameError();
        }
    }



    @Override
    public void usernameError() {
        if(view != null) {
            view.hideProgress();
            view.setError();
        }
    }

    @Override
    public void successful(String user) {
        if(view != null) {
            view.hideProgress();
            view.toGit(user);
        }
    }
}
