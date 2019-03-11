package com.example.androidprojectgroup_2_6;
import android.support.constraint.ConstraintLayout;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class Activity2register extends AppCompatActivity {
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_register);
        submit=(Button)findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thanks();

            }
        });}
    //        Intent ini=getIntent();
    public void thanks()
    {
        Intent in=new Intent(this,Activity2thanks.class);
        startActivity(in);

    }
}





