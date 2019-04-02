package com.example.androidprojectgroup_26.UI;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidprojectgroup_26.Database.DatabaseHandler;
import com.example.androidprojectgroup_26.Session.MyApplication;
import com.example.androidprojectgroup_2_6.R;

public class Register extends AppCompatActivity {


    EditText Email, Password, Name, CPassword;
    DatabaseHandler databaseHandler;
    MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        databaseHandler = new DatabaseHandler(this);
        getSupportActionBar().setTitle("Register");
        myApplication = (MyApplication) getApplicationContext();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);
        Name = findViewById(R.id.Name);
        CPassword = findViewById(R.id.CPassword);


        findViewById(R.id.Register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (Name.getText().toString().equals("")) {
                    Name.setError("Email Required");
                    return;
                }
                if (Email.getText().toString().equals("")) {
                    Email.setError("Email Required");
                    return;
                }
                if (!isEmailValid(Email.getText().toString())) {
                    Email.setError("Invalid Email");
                    return;
                }
                if (Password.getText().toString().equals("")) {
                    Password.setError("Password Required");
                    return;
                }

                if (!CPassword.getText().toString().equals(Password.getText().toString())) {
                    CPassword.setError("Password Not Match");
                    return;
                }

                for (com.example.androidprojectgroup_2_6.Objects.user user : databaseHandler.getAllusers()) {
                    if (Email.getText().toString().equals(user.getEmail())) {
                        Toast.makeText(getApplicationContext(), "Email Already Exist", Toast.LENGTH_LONG).show();
                        Email.setError("Email Already Exist");
                        return;
                    }
                }
                user user = new user();
                user.setPassword(Password.getText().toString());
                user.setEmail(Email.getText().toString());
                user.setName(Name.getText().toString());
                databaseHandler.addUser(user);

                for (user user1 : databaseHandler.getAllusers()) {
                    if (Email.getText().toString().equals(user1.getEmail()) && Password.getText().toString().equals(user1.getPassword())) {
                        finish();
                        myApplication.setUser(user1);
                        startActivity(new Intent(getApplicationContext(), LeaveComment.class));
                        return;
                    }
                }

            }
        });
    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    @Override
    protected void onResume() {
        if (myApplication.getUser() != null) {
            finish();
        }
        super.onResume();
    }
}