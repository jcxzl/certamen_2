package com.example.jc.tarea2.Interactors;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.jc.tarea2.Models.Git;
import com.example.jc.tarea2.Interfaces.GitInteractor;
import com.example.jc.tarea2.MySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Jc on 04-11-2016.
 */

public class GitInteractorImpl implements GitInteractor{

    Context context;
    ArrayList<Git> arrayList = new ArrayList<>();

    public GitInteractorImpl (Context context){
        this.context = context;
    }

    @Override
    public ArrayList<Git> getArrayList(JSONObject jsonObject, ArrayList<Git> array) {
        if(array == null){
            array = new ArrayList<Git>();
        }
        try {
            array.add(new Git(jsonObject.getString("name"), jsonObject.getString("description"), jsonObject.getString("updated_at"), jsonObject.getString("html_url")));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return array;
    }

    @Override
    public void setArrayList(ArrayList<Git> List) {
        this.arrayList = List;
        Toast.makeText(context, "Se han encontrado " + String.valueOf(List.size()) + " repositorios" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public ArrayList<Git> getList(String json_url) {
        JsonArrayRequest jsonArrayRequest;
        jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, json_url , (String)null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        ArrayList<Git> arrayList1 = null;
                        int count = 0;
                        while (count<response.length()){
                            try {
                                JSONObject jsonObject = response.getJSONObject(count);
                                arrayList1 = getArrayList(jsonObject, arrayList);
                                count++;
                            } catch (JSONException e) {
                                Toast.makeText(context, "error", Toast.LENGTH_SHORT).show();
                            }
                        }

                        setArrayList(arrayList1);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "usuario no encontrado", Toast.LENGTH_SHORT).show();
                arrayList.clear();

            }
        }
        );

        MySingleton.getInstance(context).addToRequestque(jsonArrayRequest);
        return  arrayList;
    }


}
