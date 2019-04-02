package com.example.androidprojectgroup_26.UI;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.androidprojectgroup_26.Database.DatabaseHandler;
import com.example.androidprojectgroup_26.Objects.Ratting;
import com.example.androidprojectgroup_26.R;
import com.example.androidprojectgroup_26.Session.MyApplication;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.view.LineChartView;

public class GraphView extends AppCompatActivity {

    LineChartView lineChartView;
    MyApplication myApplication;
    DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_view);

        myApplication = (MyApplication) getApplicationContext();
        getSupportActionBar().setTitle("Graph");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        lineChartView = findViewById(R.id.chart);
        databaseHandler = new DatabaseHandler(this);
        List<PointValue> values = new ArrayList<>();

        List<Ratting> rattings = databaseHandler.getAllrattings(Integer.parseInt(myApplication.getSelectedFoodCenterID()));
        for (int i = 0; i < rattings.size(); i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(Long.valueOf(rattings.get(i).getDate()));
            values.add(new PointValue(i, rattings.get(i).getStars()).setLabel(DateFormat.getDateTimeInstance().format(calendar.getTime())));

        }
        Line line = new Line(values).setColor(Color.BLUE).setHasPoints(true);
        line.setHasLabels(true);
        List<Line> lines = new ArrayList<Line>();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);

        lineChartView.setLineChartData(data);
        lineChartView.invalidate();

    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
