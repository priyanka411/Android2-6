package com.example.androidprojectgroup_2_6;
import android.support.constraint.ConstraintLayout;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;


public class Activity2register extends AppCompatActivity {
    Button submit;
    EditText e1, e2, e3;
    DataBaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_register);
        db=new DataBaseHelper(this);
        e1=(EditText)findViewById(R.id.email);
        e2=(EditText)findViewById(R.id.password);
        e3=(EditText)findViewById(R.id.confirmpassword);

        submit=(Button)findViewById(R.id.submit);
       final RadioButton user=(RadioButton)findViewById(R.id.userrb);
        final RadioButton vendor=(RadioButton)findViewById(R.id.Vendorrb);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                if(s1.equals("")||s2.equals("")||s3.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "fields are empty", Toast.LENGTH_SHORT ).show();
                }
                else {
                    if(s2.equals(s3)){
                        Boolean chkemail=db.chkmail(s1);
                        if(chkemail==true){
                            Boolean insert=db.insert(s1,s2);
                            if(insert==true){
                                Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Email already exist", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"password do not match", Toast.LENGTH_SHORT).show();
                    }
                }

//                if(vendor.isChecked()) {
//                    thanks();
//                }
//                else  if(user.isChecked()){
//                    comment();
//                }
            }
        });

    }
//    public void comment()
//    {
//        Intent in=new Intent(this,Activity2thanks.class);
//        startActivity(in);
//    }
//    public void thanks()
//    {
//        Intent in=new Intent(this,Activity3.class);
//        startActivity(in);
//    }
}





