package com.example.doanmonhoc;



import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NowFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NowFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    MainActivity mainActivity;
    TextView textView;
    View view;

    public NowFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NowFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NowFragment newInstance(String param1, String param2) {
        NowFragment fragment = new NowFragment();
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
        view=inflater.inflate(R.layout.fragment_now, container, false);
        textView=view.findViewById(R.id.txt_now);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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


        DatePickerDialog datePickerDialog=new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

            }
        },ngay,thang,nam);
        datePickerDialog.show();
    }

}