package com.example.androidsharedpref;
//https://www.tutorialspoint.com/android/android_shared_preferences.htm
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.androidsharedpref.SharedPref.*;

public class MainActivity extends AppCompatActivity {
    EditText ed1, ed2, ed3;
    TextView tv1, tv2, tv3;
    Button btn1;
    public static final String MyPreferences = "MyPrefs";
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";

    SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=findViewById(R.id.editText);
        ed2=findViewById(R.id.editText2);
        ed3=findViewById(R.id.editText3);

        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);

        btn1=findViewById(R.id.button);
        sharedPref = new SharedPref(this.getApplicationContext());
        showInfoInputText();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = ed1.getText().toString();
                String ph = ed2.getText().toString();
                String e = ed3.getText().toString();

                // Save into SharedPredfrences
                saveInfoSharedPref(n, ph, e);

                Toast.makeText(MainActivity.this, "Thanks!", Toast.LENGTH_LONG).show();

                showInfo();
            }
        });
    }

    private void showInfoInputText() {
        ArrayList<String> info = sharedPref.readInfoSharedPref();
        String nSharePref = info.get(0);
        String phSharePref = info.get(1);
        String eSharePref = info.get(2);
        ed1.setText(nSharePref);
        ed2.setText(phSharePref);
        ed3.setText(eSharePref);
    }

    private void showInfo() {
        ArrayList<String> info = sharedPref.readInfoSharedPref();
        String nSharePref = info.get(0);
        String phSharePref = info.get(1);
        String eSharePref = info.get(2);
        tv1.setText(nSharePref);
        tv2.setText(phSharePref);
        tv3.setText(eSharePref);
    }
}