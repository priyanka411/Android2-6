package com.example.androidprojectgroup_2_6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Activity2 extends AppCompatActivity {
    Button reg;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        reg=(Button)findViewById(R.id.register);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register1();
            }
        });

        login=(Button)findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity3();
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
