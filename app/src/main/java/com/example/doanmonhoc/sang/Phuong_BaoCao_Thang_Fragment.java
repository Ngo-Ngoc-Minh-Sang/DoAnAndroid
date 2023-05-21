package com.example.doanmonhoc.sang;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.doanmonhoc.DAO.ThuChiDAO;
import com.example.doanmonhoc.R;
import com.example.doanmonhoc.model.ChartData;
import com.example.doanmonhoc.model.ThuChiModel;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.LargeValueFormatter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Phuong_BaoCao_Thang_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Phuong_BaoCao_Thang_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView textView,txt_month,txt_tongthu,txt_tongchi,txt_tt;
    View view;

    BarChart barChart;
    CardView cardView;
    ThuChiDAO thuChiDAO;
    ArrayList<ThuChiModel> listgiaodich;
    Spinner monthSpinner;
    ArrayList<String> monthNames = new ArrayList<>();
    ArrayAdapter  adapter;
    Button btn_option;

    public Phuong_BaoCao_Thang_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Phuong_BaoCao_Thang_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Phuong_BaoCao_Thang_Fragment newInstance(String param1, String param2) {
        Phuong_BaoCao_Thang_Fragment fragment = new Phuong_BaoCao_Thang_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_phuong__bao_cao__thang_, container, false);



        barChart = view.findViewById(R.id.chart_theothang);
        txt_tongthu = view.findViewById(R.id.txt_tongthu);
        txt_tongchi = view.findViewById(R.id.tongchi);

        thuChiDAO = new ThuChiDAO(getContext());
        listgiaodich = thuChiDAO.getAllGiaoDich();


        cardView = view.findViewById(R.id.cardview);
        monthSpinner = view.findViewById(R.id.spinner);
        //cardView.setVisibility(View.GONE);
        monthNames.add("Tháng 1");
        monthNames.add("Tháng 2");
        monthNames.add("Tháng 3");
        monthNames.add("Tháng 4");
        monthNames.add("Tháng 5");
        monthNames.add("Tháng 6");
        monthNames.add("Tháng 7");
        monthNames.add("Tháng 8");
        monthNames.add("Tháng 9");
        monthNames.add("Tháng 10");
        monthNames.add("Tháng 11");
        monthNames.add("Tháng 12");
        adapter= new ArrayAdapter(getContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, monthNames);


        monthSpinner.setAdapter(adapter);
          monthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            int month = i+1 ;
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);

            List<ThuChiModel> transactions = thuChiDAO.getTransactionsByMonth(month);


            double totalIncome = 0;
            double totalExpense = 0;
            for (ThuChiModel t : transactions) {
                if (t.getPhanLoaiThuChi()==0) {
                    totalIncome += t.getTienGiaoDich();
                } else {
                    totalExpense += t.getTienGiaoDich();
                }
            }


            txt_tongthu.setText(String.format("Tổng tiền thu: %.2f", totalIncome));
            txt_tongchi.setText(String.format("Tổng tiền chi: %.2f", totalExpense));


            ArrayList<BarEntry> entries = new ArrayList<>();
            int j = 0;
            for (ThuChiModel t : transactions) {
                float value = (float) t.getTienGiaoDich();
                if (t.getPhanLoaiThuChi()==2) {
                    value = -value;
                }
                entries.add(new BarEntry(j++, value));
            }


            BarDataSet dataSet = new BarDataSet(entries, "Thu chi");


            int[] colors = { ContextCompat.getColor(getContext(), R.color.purple_700), ContextCompat.getColor(getContext(), R.color.blue_cardview) };
            dataSet.setColors(colors);


            BarData barData = new BarData(dataSet);


            barChart.setData(barData);
            barChart.setDrawValueAboveBar(true);
            barChart.getDescription().setEnabled(false);
            barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
            barChart.getXAxis().setDrawGridLines(false);
            barChart.getAxisLeft().setDrawGridLines(false);
            barChart.getAxisRight().setDrawGridLines(false);
            barChart.getAxisRight().setEnabled(false);
            barChart.animateY(2000);
       }





        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

       }
});

        return view;
    }




}