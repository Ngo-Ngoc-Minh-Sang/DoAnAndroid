package com.example.doanmonhoc.sang;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.doanmonhoc.DAO.ThuChiDAO;
import com.example.doanmonhoc.R;
import com.example.doanmonhoc.model.ThuChiModel;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Phuong_Tk_TuyChon_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Phuong_Tk_TuyChon_Fragment extends Fragment {

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
    BarChart barChart;
    CardView cardView;
    ThuChiDAO thuChiDAO;
    TextView txt_tongthu,txt_tongchi;
    Date startDate,endDate;
    Button btn_tk;

    View view;

    public Phuong_Tk_TuyChon_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Phuong_Tk_TuyChon_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Phuong_Tk_TuyChon_Fragment newInstance(String param1, String param2) {
        Phuong_Tk_TuyChon_Fragment fragment = new Phuong_Tk_TuyChon_Fragment();
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
        view= inflater.inflate(R.layout.fragment_phuong__tk__tuy_chon_, container, false);
        edtstart=view.findViewById(R.id.edt_daystart);
        edtend=view.findViewById(R.id.edt_dayend);
        imgstart=view.findViewById(R.id.img_daystart);
        imgend=view.findViewById(R.id.img_dayend);
        barChart = view.findViewById(R.id.chart_option);
        txt_tongthu = view.findViewById(R.id.txt_tongthu_1);
        txt_tongchi = view.findViewById(R.id.txt_tongchi_1);
        btn_tk=view.findViewById(R.id.btn_tk);
        thuChiDAO = new ThuChiDAO(getContext());
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
                Calendar calendar1=Calendar.getInstance();
                ngay=calendar1.get(Calendar.DATE);
                thang=calendar1.get(Calendar.MONTH);
                nam=calendar1.get(Calendar.YEAR);
                DatePickerDialog d=new DatePickerDialog(getActivity(),dayend,ngay,thang,nam);
                d.show();


            }
        });
        btn_tk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String b=edtstart.getText().toString();
                String k=edtend.getText().toString();

                List<ThuChiModel> transactions = thuChiDAO.getTransactionsByOption(b,k);


                double totalIncome = 0;
                double totalExpense = 0;
                for (ThuChiModel t : transactions) {
                    if (t.getPhanLoaiThuChi()==1) {
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

                    entries.add(new BarEntry(j++, value));
                }


                BarDataSet dataSet = new BarDataSet(entries, "Thu chi");
                int[] colors = { ContextCompat.getColor(getContext(), R.color.purple_700), ContextCompat.getColor(getContext(), R.color.Blue) };
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
        });
        return view;
    }
    DatePickerDialog.OnDateSetListener daystart=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            ngay = dayOfMonth;
            thang = month;
            nam = year;
            Calendar calendar = Calendar.getInstance();
            calendar.set(nam, thang, ngay);
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
            edtstart.setText(sdf.format(calendar.getTime()));
            Toast.makeText(getContext(),edtstart.getText().toString(),Toast.LENGTH_SHORT).show();

        }
    };
    DatePickerDialog.OnDateSetListener dayend=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            ngay = dayOfMonth;
            thang = month;
            nam = year;
            Calendar calendar = Calendar.getInstance();
            calendar.set(nam, thang, ngay);
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
            edtend.setText(sdf.format(calendar.getTime()));
            Toast.makeText(getContext(),edtend.getText().toString(),Toast.LENGTH_SHORT).show();

        }



    };
}