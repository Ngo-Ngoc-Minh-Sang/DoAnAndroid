package com.example.doanmonhoc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PTTaiChinhActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pttai_chinh);

        PieChart pieChart = findViewById(R.id.pieChart);

        ArrayList<PieEntry> visitors = new ArrayList<>();
        visitors.add(new PieEntry(1000,"2017"));
        visitors.add(new PieEntry(2000,"2018"));
        visitors.add(new PieEntry(1000,"2019"));
        visitors.add(new PieEntry(1000,"2020"));
        visitors.add(new PieEntry(5000,"2021"));
        visitors.add(new PieEntry(3000,"2022"));
        visitors.add(new PieEntry(6000,"2023"));


        PieDataSet pieDataSet = new PieDataSet(visitors,"Visitors");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(10f);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.setData(pieData);
        pieChart.getDescription().setText("Báo cáo Phân tích tài chính");
        pieChart.animate();
    }
}