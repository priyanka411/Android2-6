package com.example.androidprojectgroup_26.UI;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.example.androidprojectgroup_26.Adapters.RattingAdapters;
import com.example.androidprojectgroup_26.Database.DatabaseHandler;
import com.example.androidprojectgroup_26.Objects.Ratting;
import com.example.androidprojectgroup_26.Session.MyApplication;
import com.example.androidprojectgroup_26.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectedFoodCenterVendor extends AppCompatActivity {

    ImageView Logo;
    MyApplication myApplication;
    RecyclerView rv;
    List<Ratting> rattings;

    DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_food_center_vendor);


        getSupportActionBar().setTitle("Vendor");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        databaseHandler = new DatabaseHandler(this);
        rv = findViewById(R.id.recViewMain);
        Logo = findViewById(R.id.FoodCenterLogo);
        myApplication = (MyApplication) getApplicationContext();
        Logo.setImageResource(myApplication.getSelectedFoodCenterImage());

        findViewById(R.id.ViewGraph).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), GraphView.class));

            }
        });

        rattings = new ArrayList<>();
        rattings = databaseHandler.getAllrattings(Integer.parseInt(myApplication.getSelectedFoodCenterID()));
        Collections.reverse(rattings);
        rv.setLayoutManager(new GridLayoutManager(SelectedFoodCenterVendor.this, 1));
        rv.setAdapter(new RattingAdapters(SelectedFoodCenterVendor.this, rattings));


    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onResume() {
        rattings = databaseHandler.getAllrattings(Integer.parseInt(myApplication.getSelectedFoodCenterID()));

        super.onResume();
    }
}
