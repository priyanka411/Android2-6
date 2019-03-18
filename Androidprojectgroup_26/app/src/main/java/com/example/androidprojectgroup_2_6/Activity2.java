package com.example.androidprojectgroup_2_6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    Button reg;
    Button login;
    EditText e1, e2;
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        reg=(Button)findViewById(R.id.register);
        db=new DataBaseHelper(this);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        login=(Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=e1.getText().toString();
                String password=e2.getText().toString();
                Boolean chkemail=db.emailpassword(email, password);
                if(chkemail==true){

                    Toast.makeText(getApplicationContext(), "successfully login ", Toast.LENGTH_SHORT).show();
                Activity3();}
                else {
                    Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();
                }                 

            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register1();
            }
        });
    }
    public void register1 () {

        Intent in = new Intent(this, Activity2register.class);
        startActivity(in);


    }

    public void Activity3(){

        Intent in2=new Intent(this, Activity2thanks.class);
        startActivity(in2);
    }
}
