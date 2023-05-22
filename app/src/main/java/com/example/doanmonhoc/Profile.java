package com.example.doanmonhoc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class Profile extends AppCompatActivity {

    private ImageView avatar;
    private EditText displayName, phoneNumber, dateOfBirth, address;
    private RadioGroup genderGroup;
    private Button updateButton;
    Spinner occupationSpinner;
    List<String> occupations;
    ArrayAdapter<String> adapter;
    Toolbar toolbar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_profile);
        try{
            linkView();
            actionBar();
            loadSpinner();
            eventButton();
        } catch (Exception e) {
            Toast.makeText(Profile.this, "Lỗi profile", Toast.LENGTH_LONG).show();
        }
    }

    private void actionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void eventButton() {
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String displayNameText = displayName.getText().toString();
                String phoneNumberText = phoneNumber.getText().toString();
                String dateOfBirthText = dateOfBirth.getText().toString();
                int genderId = genderGroup.getCheckedRadioButtonId();

                String genderText = "";
                if (genderId == R.id.male)
                {
                    genderText = "Nam";
                } else if (genderId == R.id.female)
                {
                    genderText = "Nữ";
                }

                String addressText = address.getText().toString();

                Intent intent = new Intent(Profile.this, Other.class);
                intent.putExtra("name", displayNameText );
                startActivity(intent);
            }
        });
    }

    private void loadSpinner() {
        occupations.add("Kĩ sư phần mềm");
        occupations.add("Bác sĩ");
        occupations.add("Giáo viên");
        occupations.add("Công nhân");
        occupations.add("Sinh viên");
        occupations.add("Khác");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, occupations);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        occupationSpinner.setAdapter(adapter);
    }

    private void linkView() {
        avatar = (ImageView) findViewById(R.id.avatar);
        displayName = (EditText) findViewById(R.id.display_name);
        phoneNumber = (EditText) findViewById(R.id.phone_number);
        dateOfBirth = (EditText) findViewById(R.id.date_of_birth);
        genderGroup = (RadioGroup) findViewById(R.id.gender_group);
        address = (EditText) findViewById(R.id.address);
        updateButton = (Button) findViewById(R.id.update_button);
        occupationSpinner = (Spinner  ) findViewById(R.id.occupation_spinner);

        occupations = new ArrayList<>();
        toolbar = (Toolbar) findViewById(R.id.toolBarProfile);
    }
}