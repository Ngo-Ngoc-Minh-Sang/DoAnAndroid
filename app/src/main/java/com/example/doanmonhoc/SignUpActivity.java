package com.example.doanmonhoc;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity {

    TextView txtSignIn;
    RadioButton genderradioButton;
    RadioGroup radioGroup;

    DatePickerDialog datePickerDialog;
    Button dateButton;
    Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);

        txtSignIn = findViewById(R.id.txtSignIn);
        btnSignUp = findViewById(R.id.btnSignUp);

        // datePicker
        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText(getTodaysDate());

        txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Tạo đối tượng
                AlertDialog.Builder b = new AlertDialog.Builder(SignUpActivity.this);
                //Thiết lập tiêu đề
                b.setTitle("Thông báo");
                b.setIcon(R.drawable.baseline_check_circle_outline_24);
                b.setMessage("Đăng ký thành công");
                b.setCancelable(false);
                // Nút Ok
                b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
                //Tạo dialog
                AlertDialog al = b.create();
                //Hiển thị
                al.show();
            }
        });
    }
    public void radioButtonhandler(View v){
        int selectedId = radioGroup.getCheckedRadioButtonId();
        genderradioButton = (RadioButton) findViewById(selectedId);
        if(selectedId==-1){
            Toast.makeText(SignUpActivity.this,"Nothing selected", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(SignUpActivity.this,genderradioButton.getText(), Toast.LENGTH_SHORT).show();
        }
    }

    //datePicker
    private String getTodaysDate()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        //datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }

    private String makeDateString(int day, int month, int year)
    {
        return day + " " + month + " " + year;
    }

    private String getMonthFormat(int month)
    {
        if(month == 1)
            return "Th01";
        if(month == 2)
            return "Th02";
        if(month == 3)
            return "Th03";
        if(month == 4)
            return "Th04";
        if(month == 5)
            return "Th05";
        if(month == 6)
            return "Th06";
        if(month == 7)
            return "Th07";
        if(month == 8)
            return "Th08";
        if(month == 9)
            return "Th09";
        if(month == 10)
            return "Th10";
        if(month == 11)
            return "Th11";
        if(month == 12)
            return "Th12";

        //default should never happen
        return "Th01";
    }

    public void openDatePicker(View view)
    {
        datePickerDialog.show();
    }
}