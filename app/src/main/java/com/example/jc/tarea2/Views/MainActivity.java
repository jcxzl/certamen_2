package com.example.jc.tarea2.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.jc.tarea2.Interfaces.MainPresenter;
import com.example.jc.tarea2.Interfaces.MainView;
import com.example.jc.tarea2.Presenters.MainPresenterImpl;
import com.example.jc.tarea2.R;

public class MainActivity extends AppCompatActivity implements MainView{

    private EditText user;
    private ProgressBar progressbar;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        user = (EditText) findViewById(R.id.editText);
        progressbar = (ProgressBar) findViewById(R.id.progressBar);

        presenter = new MainPresenterImpl(this, MainActivity.this);
    }

    @Override
    public void showProgress() {
        progressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressbar.setVisibility(View.GONE);
    }

    @Override
    public void setError() {
        user.setError("Campo Obligatorio");
    }

    @Override
    public void toGit(String user) {
        Intent i = new Intent(MainActivity.this,GitList.class);
        i.putExtra("user", user);
        startActivity(i);

    }

    public void search(View v){
        presenter.searchUser(user.getText().toString());
    }
}
