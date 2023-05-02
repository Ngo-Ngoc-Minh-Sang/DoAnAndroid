package com.example.doanmonhoc;



import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MonthFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MonthFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView textView;
    View view;


    public MonthFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MonthFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MonthFragment newInstance(String param1, String param2) {
        MonthFragment fragment = new MonthFragment();
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
        view = inflater.inflate(R.layout.fragment_month, container, false);
        textView=view.findViewById(R.id.txt_month);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonthang();
            }
        });


        return view;
    }
    public void chonthang()
    {
        Calendar calendar= Calendar.getInstance();
        int ngay=calendar.get(calendar.DATE);
        int thang=calendar.get(calendar.MONTH);
        int nam=calendar.get(calendar.YEAR);
        DatePickerDialog datePickerDialog=new DatePickerDialog(getContext(),AlertDialog.THEME_HOLO_LIGHT, new DatePickerDialog.OnDateSetListener() {


            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

            }
        },ngay,thang,nam);

        try {
            Field[] datePickerDialogFields = datePickerDialog.getClass().getDeclaredFields();
            for (Field datePickerDialogField : datePickerDialogFields) {
                if (datePickerDialogField.getName().equals("mDatePicker")) {
                    datePickerDialogField.setAccessible(true);
                    DatePicker datePicker =
                            (DatePicker) datePickerDialogField.get(datePickerDialog);
                    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        int daySpinnerId =
                                Resources.getSystem().getIdentifier("day", "id", "android");

                        if (daySpinnerId != 0) {
                            View daySpinner = datePicker.findViewById(daySpinnerId);


                            if (daySpinner != null) {

                                daySpinner.setVisibility(View.GONE);

                            }
                        }
                    }
                }
            }
        } catch (IllegalAccessException e) {

        }
        datePickerDialog.show();
    }
}


