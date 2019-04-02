package com.example.androidprojectgroup_26.UI;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AbsListView;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListAdapter;
        import android.widget.Toast;

        import com.example.androidprojectgroup_26.R;
        import com.example.androidprojectgroup_26.Session.MyApplication;
        import com.betterspinner.library.material.MaterialBetterSpinner;

public class MainActivity extends AppCompatActivity {


    String[] FoodCentersNames = {"Chic-Fil-A", "Mooyah", "Einstein's bagels", "Zen"};
    int[] FoodCentersImages = {R.drawable.chic, R.drawable.mooyah, R.drawable.einstein, R.drawable.zen};
    MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myApplication = (MyApplication) getApplicationContext();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, FoodCentersNames);
        MaterialBetterSpinner materialDesignSpinner = (MaterialBetterSpinner)
                findViewById(R.id.android_material_design_spinner);
        materialDesignSpinner.setAdapter(arrayAdapter);
        materialDesignSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                myApplication.setSelectedFoodCenterID(position + "");
                myApplication.setSelectedFoodCenterImage(FoodCentersImages[position]);
                myApplication.setSelectedFoodCenterName(FoodCentersNames[position]);
                startActivity(new Intent(getApplicationContext(), SelectedFoodCenter.class));

            }
        });


        if (myApplication.getUser() == null) {
            findViewById(R.id.Logout).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.Logout).setVisibility(View.VISIBLE);
        }
        findViewById(R.id.Logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myApplication.setUser(null);
                findViewById(R.id.Logout).setVisibility(View.INVISIBLE);
            }
        });


    }

    @Override
    protected void onResume() {
        if (myApplication.getUser() == null) {
            findViewById(R.id.Logout).setVisibility(View.INVISIBLE);
        } else {

            findViewById(R.id.Logout).setVisibility(View.VISIBLE);
        }
        super.onResume();
    }
}
