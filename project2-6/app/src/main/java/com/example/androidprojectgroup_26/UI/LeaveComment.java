package com.example.androidprojectgroup_26.UI;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.androidprojectgroup_2_6.Database.DatabaseHandler;
import com.example.androidprojectgroup_2_6.Objects.Ratting;
import com.example.androidprojectgroup_2_6.R;
import com.example.androidprojectgroup_2_6.Session.MyApplication;

import java.util.Calendar;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class LeaveComment extends AppCompatActivity {


    MaterialRatingBar materialRatingBar;
    EditText Message;
    MyApplication myApplication;
    DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_comment);

        databaseHandler = new DatabaseHandler(this);


        getSupportActionBar().setTitle("Leave Comment");
        myApplication = (MyApplication) getApplicationContext();


        materialRatingBar = findViewById(R.id.Ratting);
        Message = findViewById(R.id.Message);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        findViewById(R.id.LeaveComment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (Message.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter Your Comments", Toast.LENGTH_LONG).show();
                    return;
                }
                Ratting ratting = new Ratting();
                ratting.setDate(String.valueOf(Calendar.getInstance().getTimeInMillis()));
                ratting.setFoodCenterID(myApplication.getSelectedFoodCenterID());
                ratting.setMessage(Message.getText().toString());
                ratting.setUserEmail(myApplication.getUser().getEmail());
                ratting.setUserName(myApplication.getUser().getName());
                ratting.setStars(Integer.parseInt(String.valueOf(materialRatingBar.getRating()).split("\\.")[0]));
                databaseHandler.addRatting(ratting);
                finish();
                startActivity(new Intent(getApplicationContext(), Thanku.class));
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
