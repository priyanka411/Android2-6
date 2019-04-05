package com.example.androidprojectgroup_26.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidprojectgroup_2_6.Database.DatabaseHandler;
import com.example.androidprojectgroup_2_6.Objects.user;
import com.example.androidprojectgroup_2_6.R;
import com.example.androidprojectgroup_2_6.Session.MyApplication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lib.kingja.switchbutton.SwitchMultiButton;

public class Login extends AppCompatActivity {


    Boolean Vender = false;
    EditText Email, Password;
    DatabaseHandler databaseHandler;
    MyApplication myApplication;

    String[] Emails = {"chcikfila@gmail.com", "mooyah@gmail.com", "einsteinbagels@gmail.com", "zen@gmail.com"};
    String[] Passwords = {"chickfila", "mooyah", "einsteinbagels", "zen"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        myApplication = (MyApplication) getApplicationContext();
        databaseHandler = new DatabaseHandler(this);

        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);


        getSupportActionBar().setTitle("Login");
        findViewById(R.id.Regsiter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });

        findViewById(R.id.Login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


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

                if (Vender) {
                    user user = new user();
                    user.setName("Vendor");
                    if (Emails[Integer.parseInt(myApplication.getSelectedFoodCenterID())].equals(Email.getText().toString().toLowerCase().trim()) && Passwords[Integer.parseInt(myApplication.getSelectedFoodCenterID())].equals(Password.getText().toString().toLowerCase().trim())) {
                        finish();
                        startActivity(new Intent(getApplicationContext(), SelectedFoodCenterVendor.class));
                        return;

                    } else {
                        Toast.makeText(getApplicationContext(), "User not Exist", Toast.LENGTH_LONG).show();
                    }

                    return;
                }


                for (user user : databaseHandler.getAllusers()) {
                    if (Email.getText().toString().equals(user.getEmail()) && Password.getText().toString().equals(user.getPassword())) {
                        finish();
                        myApplication.setUser(user);
                        startActivity(new Intent(getApplicationContext(), LeaveComment.class));
                        return;
                    }
                }

                Toast.makeText(getApplicationContext(), "User not Exist", Toast.LENGTH_LONG).show();


            }
        });


        SwitchMultiButton mSwitchMultiButton = (SwitchMultiButton) findViewById(R.id.userselectedion);
        mSwitchMultiButton.setOnSwitchListener(new SwitchMultiButton.OnSwitchListener() {
            @Override
            public void onSwitch(int position, String tabText) {

                if (position == 1) {
                    Vender = true;
                } else {
                    Vender = false;
                }

            }
        });
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
