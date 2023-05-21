package com.example.doanmonhoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doanmonhoc.DAO.NguoiDungDAO;
import com.example.doanmonhoc.R;
import com.example.doanmonhoc.SQLiteHelper;
import com.example.doanmonhoc.model.NguoiDungModel;

public class Manh_LoginActivity extends AppCompatActivity {
    NguoiDungDAO nguoiDungDAO;
    NguoiDungModel nguoiDungModel;
    SQLiteHelper sqLiteHelper;
    TextView txtSignUp;
    Button btnLogin;
    EditText edtEmail, edtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manh_activity_login);

        nguoiDungDAO = new NguoiDungDAO(this);

        addControls();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int cw = checkWrite();
                    if (cw != -1) {
                        int login = nguoiDungDAO.checkNguoiDung(edtEmail.getText().toString(), edtPassword.getText().toString());
                        if (login == 1)
                            Toast.makeText(Manh_LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Manh_LoginActivity.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_LONG).show();
                    }
//                NguoiDungModel ngDung = new NguoiDungModel(1, 2002, 200000, "Ngô Ngọc Minh Sang", "0946885098", "avatar.png", "ngos810@gmail.com", "sang123", "Nữ");
//                int kq = nguoiDungDAO.insertNguoiDung(ngDung);


                } catch (Exception e) {
                    Toast.makeText(Manh_LoginActivity.this, "Đăng nhập lỗi!", Toast.LENGTH_LONG).show();
                }
            }
        });
        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Manh_LoginActivity.this, Manh_SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public int checkWrite(){
        addControls();
        String email = edtEmail.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            edtEmail.setError("Email không được để trống");
            return -1;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtEmail.setError("Email không hợp lệ");
            return -1;
        }
        if (TextUtils.isEmpty(edtPassword.getText().toString().trim())) {
            edtEmail.setError("Mật khẩu không được để trống");
            return -1;
        }
        return 1;
    }
    public void addControls(){
        txtSignUp = findViewById(R.id.txtSignUp);
        btnLogin = findViewById(R.id.btnSignIn);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
    }
}