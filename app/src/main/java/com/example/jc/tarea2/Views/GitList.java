package com.example.jc.tarea2.Views;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.example.jc.tarea2.Interfaces.GitListPresenter;
import com.example.jc.tarea2.Models.Git;
import com.example.jc.tarea2.Interactors.GitInteractorImpl;
import com.example.jc.tarea2.Interfaces.GitInteractor;
import com.example.jc.tarea2.Interfaces.GitListView;
import com.example.jc.tarea2.Interfaces.MainPresenter;
import com.example.jc.tarea2.Presenters.GitListPresenterImpl;
import com.example.jc.tarea2.R;
import com.example.jc.tarea2.RecyclerAdapter;

import java.util.ArrayList;

public class GitList extends AppCompatActivity implements GitListView {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Git> arrayList = new ArrayList<>();
    ArrayList<Git> arrayTest = new ArrayList<>();
    String user;
    MainPresenter presenter;

    LinearLayout linear;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_list);
        user = getIntent().getStringExtra("user");

        linear = (LinearLayout)findViewById(R.id.linear);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        //recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        GitListPresenter gitListPresenter = new GitListPresenterImpl(this, GitList.this);
        arrayList = gitListPresenter.getList(user);
        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);
        ArrayList arra = new ArrayList<Git>();
        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);
    }

    public  void seter(ArrayList<Git> arrayList){
        this.arrayList = arrayList;
    }

    public void getBack(){
        startActivity(new Intent(GitList.this, MainActivity.class));
    }
}
