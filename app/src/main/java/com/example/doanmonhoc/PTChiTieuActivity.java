package com.example.doanmonhoc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PTChiTieuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptchi_tieu);

        BarChart barChart = findViewById(R.id.barChart);

        ArrayList<BarEntry> visitors = new ArrayList<>();
        visitors.add(new BarEntry(1,200));
        visitors.add(new BarEntry(2,300));
        visitors.add(new BarEntry(3,100));
        visitors.add(new BarEntry(4,500));
        visitors.add(new BarEntry(5,200));
        visitors.add(new BarEntry(6,100));
        visitors.add(new BarEntry(7,300));
        visitors.add(new BarEntry(8,500));
        visitors.add(new BarEntry(9,200));
        visitors.add(new BarEntry(10,200));
        visitors.add(new BarEntry(11,600));
        visitors.add(new BarEntry(12,200));


        BarDataSet barDataSet = new BarDataSet(visitors,"Visitors");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(10f);

        BarData barData = new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Báo cáo Chi Tiêu");
        barChart.animate();
    }
}