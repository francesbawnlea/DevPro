package com.sineadmartin.sineadpiano01;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    //private fields for the class
    private SharedPreferences sharedPrefs;

    String KEY;
    String firstName, lastName, email, password;
    



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
}
