package com.example.doanmonhoc;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DoiMatKhau extends AppCompatActivity {

    private EditText etOldPassword, etNewPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_doi_mat_khau);

        etOldPassword = findViewById(R.id.etOldPassword);
        etNewPassword = findViewById(R.id.etNewPassword);

        Button btnChangePassword = findViewById(R.id.btn_ChangePassword);
        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldPassword = etOldPassword.getText().toString();
                String newPassword = etNewPassword.getText().toString();

                // Kiểm tra mật khẩu cũ
                if (checkOldPassword(oldPassword)) {
                    // Lưu mật khẩu mới vào SharedPreferences
                    saveNewPassword(newPassword);

                    // Thông báo cho người dùng biết về sự thay đổi mật khẩu
                    Toast.makeText(DoiMatKhau.this, "Đổi mật khẩu thành công !", Toast.LENGTH_SHORT).show();
                } else {
                    // Hiển thị thông báo lỗi
                    Toast.makeText(DoiMatKhau.this, "Mật khẩu cũ không đúng !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // kiểm tra mật khẩu cũ có khớp không
    private boolean checkOldPassword(String oldPassword) {
        // Đọc mật khẩu hiện tại từ SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
        String currentPassword = sharedPreferences.getString("password", "");

        // Kiểm tra mật khẩu cũ có khớp với mật khẩu hiện tại hay không
        return oldPassword.equals(currentPassword);
    }

    //lưu thông tin mật khẩu mới
    private void saveNewPassword(String newPassword) {
        // Lưu mật khẩu mới vào SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("password", newPassword);
        editor.apply();
    }
}