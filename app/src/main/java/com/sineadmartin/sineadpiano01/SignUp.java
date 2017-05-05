package com.sineadmartin.sineadpiano01;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    private SharedPreferences sharedPrefs;
    String KEY;
    String firstName, lastName, email, password;
    String json;
    String token;

    EditText editFirstName, editLastName, editEmail, editPassword, editConformPassword;
    Button submit;

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference dbRef = db.getReference("STH");// what goes in here as reference???

    ////////Firebase firebase; not working, do i need to create a class called Firebase?????

    private volatile boolean gotKey = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //Get the views

        editFirstName = (EditText) findViewById(R.id.editfirstName);
        editLastName = (EditText) findViewById(R.id.editLastName);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editPassword = (EditText) findViewById(R.id.editPassword);
        editConformPassword = (EditText) findViewById(R.id.editConfirmPassword);


    }
}
