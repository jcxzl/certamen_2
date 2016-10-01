package com.example.jc.certamen2;

import android.accessibilityservice.GestureDescription;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.Date;

/**
 * Created by Jc on 30-09-2016.
 */

public class repo {
    public String name;
    public String description;
    public String date;
    public String url;

    public repo(JSONObject objetoJSON){
        name = objetoJSON.getString("NAME");
        description = objetoJSON.getString("DESCRIPTION");
        date = objetoJSON.getString("UPDATED_AD");
        url = objetoJSON.getString("HTML_URL");
    }
}
