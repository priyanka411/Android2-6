package com.example.androidprojectgroup_2_6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity2thanks extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2thanks);
        Button submit = (Button) findViewById(R.id.submit);
        EditText et = (EditText) findViewById(R.id.commentset);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go();
            }
        });
    }
        public void go()
        {
            Intent in=new Intent(this, Activity1_2.class);
            startActivity(in);

        }
    }
