package com.example.doanmonhoc;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.doanmonhoc.DAO.NguoiDungDAO;
import com.example.doanmonhoc.R;
import com.example.doanmonhoc.SQLiteHelper;
import com.example.doanmonhoc.model.NguoiDungModel;

import java.io.File;
import java.util.Calendar;

public class Manh_SignUpActivity extends AppCompatActivity {

    SQLiteHelper sqLiteHelper;
    NguoiDungDAO ngDung;
    TextView txtSignIn, txtHide;
    RadioButton rdNam, rdNu, genderradioButton;
    RadioGroup radioGroup;
    DatePickerDialog datePickerDialog;
    Button dateButton;
    Button btnSignUp;
    EditText edtEmail, edtMatkhau, edtNhaplaiMK, edtHoten, edtSdt;
    CheckBox cBox;
    private static final int REQUEST_CODE_SELECT_IMAGE = 1;
    private ImageView imageView;

    // Khởi tạo Intent để mở hộp thoại chọn tệp

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manh_activity_sign_up);
        ngDung = new NguoiDungDAO(this);

        //Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), );

        //Khoi tao
        addControls();


        // datePicker
        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText(getTodaysDate());

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });
        txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Manh_SignUpActivity.this, Manh_LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    int cw = checkWrite();
                    if(cw != -1){
                        String email = edtEmail.getText().toString();
                        String hoten = edtHoten.getText().toString();
                        String pass = edtMatkhau.getText().toString();
                        String confirmPassword = edtNhaplaiMK.getText().toString();
                        String sdt = edtSdt.getText().toString();
                        String gioitinh = "";
                        if (rdNam.isChecked())
                            gioitinh = rdNam.getText().toString();
                        if (rdNu.isChecked())
                            gioitinh = rdNu.getText().toString();
                        String namsinh1 = dateButton.getText().toString().trim();
                        String[] namsinhArr = namsinh1.split(" ");
                        int nsinh = Integer.parseInt(namsinhArr[2]);
                        String linkImg = txtHide.getText().toString();
                        NguoiDungModel ndm = new NguoiDungModel(0, nsinh, 0, hoten, sdt, linkImg, email, pass, gioitinh);
                        int kq = ngDung.insertNguoiDung(ndm);
                        if (kq == 1)
                        {
                            Toast.makeText(Manh_SignUpActivity.this, "Đăng ký thành công!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(Manh_SignUpActivity.this, Manh_LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                           if (kq == -1)
                            Toast.makeText(Manh_SignUpActivity.this, "Đăng ký thất bại!", Toast.LENGTH_LONG).show();
                    }
//                    NguoiDungModel ngDungM = new NguoiDungModel(1, 2002, 200000, "Ngô Ngọc Minh Sang", "0946885098", "avatar.png", "ngos810@gmail.com", "sang123", "Nữ");
//                    int kq1 = ngDung.insertNguoiDung(ngDungM);

                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(Manh_SignUpActivity.this, "Đăng ký lỗi!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void selectImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_CODE_SELECT_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try{
            // Kiểm tra request code có trùng với mã request ban đầu hay không
            if (requestCode == REQUEST_CODE_SELECT_IMAGE) {
                // Kiểm tra kết quả trả về có thành công hay không
                if (resultCode == RESULT_OK && data != null) {
                    // Nhận URI của tệp ảnh từ Intent result
                    Uri uri = data.getData();
                    //lấy đường dẫn của file ảnh đã chọn
                    File file = new File(uri.getPath());
                    String filePath = file.getAbsolutePath();
                    ImageView.ScaleType scaletype = ImageView.ScaleType.CENTER_CROP;
                    imageView.setScaleType(scaletype);
                    imageView.setImageURI(uri);
                    txtHide.setText(filePath);
                    Toast.makeText(Manh_SignUpActivity.this, "Lấy url img thành công", Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception e){
            Toast.makeText(Manh_SignUpActivity.this, "Lấy url img lỗi", Toast.LENGTH_LONG).show();
        }

    }

    public void radioButtonhandler(View v){
        int selectedId = radioGroup.getCheckedRadioButtonId();
        genderradioButton = (RadioButton) findViewById(selectedId);
        if(selectedId==-1){
            Toast.makeText(Manh_SignUpActivity.this,"Nothing selected", Toast.LENGTH_SHORT).show();
        }
        else{
            //Toast.makeText(Manh_SignUpActivity.this,genderradioButton.getText(), Toast.LENGTH_SHORT).show();
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
    public int checkWrite(){
        addControls();

        if (TextUtils.isEmpty(edtHoten.getText().toString().trim())) {
            edtHoten.setError("Họ tên không được để trống");
            return -1;
        }
        String email = edtEmail.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            edtEmail.setError("Email không được để trống");
            return -1;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtEmail.setError("Email không hợp lệ");
            return -1;
        }

        if (TextUtils.isEmpty(edtSdt.getText().toString().trim())) {
            edtSdt.setError("Số điện thoại không được để trống");
            return -1;
        }
        String password = edtMatkhau.getText().toString().trim();
        String confirmPassword = edtNhaplaiMK.getText().toString().trim();
        if (password.length() > 20) {
            edtMatkhau.setError("Mật khẩu không được quá 20 kí tự");
            return -1;
        }
        if (password.length() < 8){
            edtMatkhau.setError("Mật khẩu phải có ít nhất 8 kí tự");
            return -1;
        }
        if (!password.matches("^[a-zA-Z0-9]*$")) {
            edtMatkhau.setError("Mật khẩu chỉ được có chữ cái và số");
            return -1;
        }

        if (TextUtils.isEmpty(password)) {
            edtMatkhau.setError("Mật khẩu không được để trống");
            return -1;
        }

        if (TextUtils.isEmpty(edtNhaplaiMK.getText().toString().trim())) {
            edtNhaplaiMK.setError("Không giống mật khẩu");
            return -1;
        }
        if (!confirmPassword.equals(password)){
            edtNhaplaiMK.setError("Không giống mật khẩu");
            return -1;
        }
        if (!cBox.isChecked()){
            cBox.setError("Bạn chưa đồng ý chính sách của chúng tôi!");
            return -1;
        }
        return 1;
    }
    public void addControls(){
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        rdNam = findViewById(R.id.rdNam);
        rdNu = findViewById(R.id.rdNu);
        txtSignIn = findViewById(R.id.txtSignIn);
        txtHide = findViewById(R.id.txtHide);
        btnSignUp = findViewById(R.id.btnSignUp);
        dateButton = findViewById(R.id.datePickerButton);
        edtEmail = findViewById(R.id.edtEmail);
        edtHoten = findViewById(R.id.edtHoten);
        edtMatkhau = findViewById(R.id.edtMatkhau);
        edtNhaplaiMK = findViewById(R.id.edtNhaplaiMK);
        edtSdt = findViewById(R.id.edtSdt);
        cBox = findViewById(R.id.cBox);
        imageView = findViewById(R.id.imgAvatar);
    }
}