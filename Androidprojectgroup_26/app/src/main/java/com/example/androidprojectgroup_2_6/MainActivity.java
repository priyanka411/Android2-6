package com.example.androidprojectgroup_2_6;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
 Button b,b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test();
            }
        });
        b1=(Button)findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test();
            }
        });

        b2=(Button)findViewById(R.id.button3);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test1();
            }
        });
        b3=(Button)findViewById(R.id.button4);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test2();
            }
        });
        b4=(Button)findViewById(R.id.button5);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test3();
            }
        });

    }
            public void test(){

                Intent i=new Intent(this, Activity2.class);
                startActivity(i);
              }

    public void test1(){

        Intent i=new Intent(this, Activity1.class);
        startActivity(i);
    }
    public void test2(){

        Intent i=new Intent(this, Activity1.class);
        startActivity(i);
    }
    public void test3(){

        Intent i=new Intent(this, Activity1.class);
        startActivity(i);
    }
}

