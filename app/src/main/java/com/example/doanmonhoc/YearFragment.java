package com.example.doanmonhoc;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link YearFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class YearFragment extends Fragment{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String DATE_PICKER = "mDatePicker";
    private static final String DAY_FIELD = "day";
    private static final String ID = "id";
    private static final String ANDROID = "android";

    private DatePickerDialog mDatePickerDialog;
    private TimePickerDialog mTimePickerDialog;
    private Calendar mCalendar;
    View view;
    TextView textView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public YearFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment YearFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static YearFragment newInstance(String param1, String param2) {
        YearFragment fragment = new YearFragment();
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
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_year, container, false);
        textView=view.findViewById(R.id.txt_year);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonngay();
            }
        });

        return view;
    }


    public void chonngay()
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
                        int monthSpinnerId =
                                Resources.getSystem().getIdentifier("month", "id", "android");
                        if (daySpinnerId != 0&& monthSpinnerId!=0) {
                            View daySpinner = datePicker.findViewById(daySpinnerId);
                            View monthSpinner = datePicker.findViewById(monthSpinnerId);

                            if (daySpinner != null&&monthSpinner!=null) {
                                //Ẩn cột date, chỉ còn lại month và year
                                daySpinner.setVisibility(View.GONE);
                                monthSpinner.setVisibility(View.GONE);
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