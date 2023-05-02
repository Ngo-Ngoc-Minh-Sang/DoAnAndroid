package com.example.doanmonhoc;


import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OptionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OptionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    EditText edtstart,edtend;
    int ngay,thang,nam;
    ImageView imgstart,imgend;
    SimpleDateFormat sdf=new SimpleDateFormat("YYYY/MM/DD");
    View view;

    public OptionFragment() {
        // Required empty public constructor
    }

    public static OptionFragment newInstance(String param1, String param2) {
        OptionFragment fragment = new OptionFragment();
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
        view= inflater.inflate(R.layout.fragment_option, container, false);
        edtstart=view.findViewById(R.id.edt_daystart);
        edtend=view.findViewById(R.id.edt_dayend);
        imgstart=view.findViewById(R.id.img_daystart);
        imgend=view.findViewById(R.id.img_dayend);
        imgstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar=Calendar.getInstance();
                ngay=calendar.get(Calendar.DATE);
                thang=calendar.get(Calendar.MONTH);
                nam=calendar.get(Calendar.YEAR);
                DatePickerDialog d=new DatePickerDialog(getActivity(),daystart,ngay,thang,nam);
                d.show();
            }
        });
        imgend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar=Calendar.getInstance();
                ngay=calendar.get(Calendar.DATE);
                thang=calendar.get(Calendar.MONTH);
                nam=calendar.get(Calendar.YEAR);
                DatePickerDialog d=new DatePickerDialog(getActivity(),dayend,ngay,thang,nam);
                d.show();

            }
        });
        return view;
    }
    DatePickerDialog.OnDateSetListener daystart=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            ngay = dayOfMonth;
            thang = month;
            nam = year;
            GregorianCalendar c = new GregorianCalendar(ngay, thang, nam);
            edtstart.setText(sdf.format(c.getTime()));
        }
    };
    DatePickerDialog.OnDateSetListener dayend=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            ngay = dayOfMonth;
            thang = month;
            nam = year;
            GregorianCalendar c = new GregorianCalendar(ngay, thang, nam);
            edtend.setText(sdf.format(c.getTime()));
        }
    };

}