package com.example.androidprojectgroup_26.UI;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.GridLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.example.androidprojectgroup_26.Adapters.RattingAdapters;
        import com.example.androidprojectgroup_26.Database.DatabaseHandler;
        import com.example.androidprojectgroup_26.Objects.Ratting;
        import com.example.androidprojectgroup_26.R;
        import com.example.androidprojectgroup_26.Session.MyApplication;

        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.List;

public class SelectedFoodCenter extends AppCompatActivity {

    TextView FoodCenterName;
    ImageView Logo;
    MyApplication myApplication;
    RecyclerView rv;
    List<Ratting> rattings;

    DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_food_center);
        rv = findViewById(R.id.recViewMain);

        Logo = findViewById(R.id.FoodCenterLogo);
        myApplication = (MyApplication) getApplicationContext();
        Logo.setImageResource(myApplication.getSelectedFoodCenterImage());
        FoodCenterName = findViewById(R.id.FoodCenterName);
        FoodCenterName.setText(myApplication.getSelectedFoodCenterName());


        databaseHandler = new DatabaseHandler(this);
        findViewById(R.id.LeaveComment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (myApplication.getUser() == null) {
                    startActivity(new Intent(getApplicationContext(), Login.class));
                } else {
                    startActivity(new Intent(getApplicationContext(), LeaveComment
                            .class));
                }

            }
        });

        findViewById(R.id.Logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myApplication.setUser(null);
                findViewById(R.id.Logout).setVisibility(View.INVISIBLE);
            }
        });

        findViewById(R.id.Home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        rattings = databaseHandler.getAllrattings(Integer.parseInt(myApplication.getSelectedFoodCenterID()));
        Collections.reverse(rattings);
        rv.setLayoutManager(new GridLayoutManager(SelectedFoodCenter.this, 1));
        rv.setAdapter(new RattingAdapters(SelectedFoodCenter.this, rattings));


    }

    @Override
    protected void onResume() {

        rattings = databaseHandler.getAllrattings(Integer.parseInt(myApplication.getSelectedFoodCenterID()));

        super.onResume();
    }
}
