package com.example.androidsharedpref;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

public class SharedPref {
    public static SharedPreferences sharedPref;
    private static final String MYSHAREDPRED = "MySharedPref";
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";

    public SharedPref(Context context) {
        sharedPref = context.getSharedPreferences(MYSHAREDPRED, Context.MODE_PRIVATE);
    }

    public static void saveInfoSharedPref(String n, String ph, String e){
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString(Name, n);
        editor.putString(Phone, ph);
        editor.putString(Email, e);

        editor.commit();
    }

    public static ArrayList<String> readInfoSharedPref(){
        ArrayList<String> data = new ArrayList<String>();
        String nSharePref = sharedPref.getString(Name, "");
        String phSharePref = sharedPref.getString(Phone, "");
        String eSharePref = sharedPref.getString(Email, "");
        data.add(nSharePref);
        data.add(phSharePref);
        data.add(eSharePref);
        return data;
    }
}
