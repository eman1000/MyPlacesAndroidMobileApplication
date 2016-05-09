package com.example.emmancipatemusemwa.c77172238myplacesapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onButtonClick(View v){

        if (v.getId() == R.id.Blogin){

            EditText a = (EditText) findViewById(R.id.TFusername);
            String str = a.getText().toString();
            EditText b = (EditText) findViewById(R.id.TFpassword);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);
            if (pass.equals(password))
            {


                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                i.putExtra("Username", str);
                startActivity(i);

            }

            else {

                //pop up message

                Toast temp = Toast.makeText(LoginActivity.this, "Username and Password Don't Match", Toast.LENGTH_SHORT);
                temp.show();
            }



        }

        if (v.getId() == R.id.Bsignup){

            Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(i);

        }
    }

}
