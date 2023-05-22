package com.example.doanmonhoc.sang;

import static android.app.Activity.RESULT_OK;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.doanmonhoc.R;
import com.example.doanmonhoc.model.ThuChiModel;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Sang_FragmentChi extends Fragment {
    FrameLayout animBtnCategory1, animBtnCategory2, animBtnCategory3, animBtnCategory4, animBtnCategory5, animBtnCategory6;
    Button btnToday, btnYesterday, btnCustomDay, buttonThemChi;
    ImageButton btnCategory1, btnCategory2, btnCategory3, btnCategory4, btnCategory5, btnCategory6;
    ImageButton[] imageButtons;
    EditText edtEnterMoney;
    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageButton imgBtnNote1Chi, imgBtnNote2Chi, imgBtnNote3Chi;
    private Uri mImageUri;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chi, container, false);
        addControls(view);
        imageButtons = initializeButtons(view,6);
        checkButtonCLicked(view);
        setTextBtnDay();
        animationBtnDay(view);
        imgBtnNote1Chi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
            }
        });
        imgBtnNote2Chi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 2);
            }
        });
        imgBtnNote3Chi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 3);
            }
        });
        buttonThemChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int phanLoai = 1;
                int tienGiaoDich = Integer.valueOf(edtEnterMoney.getText().toString());
                ThuChiModel thuChi = new ThuChiModel(1, 2, 2000, 3, 4, "2023-05-19", "Mua sữa chua" );
            }
        });
        return view;
    }
    private void addControls(View view){
        animBtnCategory1 = (FrameLayout) view.findViewById(R.id.animBtnCategory1);
        animBtnCategory2 = (FrameLayout) view.findViewById(R.id.animBtnCategory2);
        animBtnCategory3 = (FrameLayout) view.findViewById(R.id.animBtnCategory3);
        animBtnCategory4 = (FrameLayout) view.findViewById(R.id.animBtnCategory4);
        animBtnCategory5 = (FrameLayout) view.findViewById(R.id.animBtnCategory5);
        animBtnCategory6 = (FrameLayout) view.findViewById(R.id.animBtnCategory6);
        btnToday = (Button) view.findViewById(R.id.btnToday);
        btnYesterday = (Button) view.findViewById(R.id.btnYesterday);
        btnCustomDay = (Button) view.findViewById(R.id.btnCustomDay);
        btnCategory1 = (ImageButton) view.findViewById(R.id.btnCategory1);
        btnCategory2 = (ImageButton) view.findViewById(R.id.btnCategory2);
        btnCategory3 = (ImageButton) view.findViewById(R.id.btnCategory3);
        btnCategory4 = (ImageButton) view.findViewById(R.id.btnCategory4);
        btnCategory5 = (ImageButton) view.findViewById(R.id.btnCategory5);
        btnCategory6 = (ImageButton) view.findViewById(R.id.btnCategory6);
        imgBtnNote1Chi = (ImageButton) view.findViewById(R.id.imgBtnNote1Chi);
        imgBtnNote2Chi = (ImageButton) view.findViewById(R.id.imgBtnNote2Chi);
        imgBtnNote3Chi = (ImageButton) view.findViewById(R.id.imgBtnNote3Chi);
        buttonThemChi = (Button) view.findViewById(R.id.buttonThemChi);
        edtEnterMoney = (EditText) view.findViewById(R.id.edtEnterMoney);
    }
    private void animationBtnDay(View viewParent){

        btnToday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBackgroundNoneForButtonDate();
                btnToday.setBackground(ContextCompat.getDrawable(viewParent.findViewById(R.id.btnToday).getContext(), R.drawable.custom_background_buttondate));
            }
        });
        btnYesterday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBackgroundNoneForButtonDate();
                btnYesterday.setBackground(ContextCompat.getDrawable(viewParent.findViewById(R.id.btnToday).getContext(), R.drawable.custom_background_buttondate));
            }
        });
        btnCustomDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                setBackgroundNoneForButtonDate();
                btnCustomDay.setBackground(ContextCompat.getDrawable(viewParent.findViewById(R.id.btnToday).getContext(), R.drawable.custom_background_buttondate));
                DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String day_month = dayOfMonth+ "/" + (month + 1);
                        btnCustomDay.setText(day_month + "\n" + "Tùy chọn");
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

                datePickerDialog.show();
            }
        });
    }
    public ImageButton[] initializeButtons(View view, int x) {
        Resources res = getResources();
        ImageButton[] buttons = new ImageButton[x];
        for (int i = 0; i < x; i++) {
            int j = i + 1;
            String b = "btnCategory" + j;
            buttons[i] = (ImageButton) view.findViewById(res.getIdentifier(b, "id", view.getContext().getPackageName()));
        }
        return buttons;
    }
    public void checkButtonCLicked(View view){
        for(int i = 0; i < 6; i++){
            final ImageButton btn = imageButtons[i];
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int drawableId;
                    Drawable drawable;
                    setVisibleBackgroundSelected(view);
                    switch (btn.getId()){
                        case R.id.btnCategory1:
                            drawableId = view.getContext().getApplicationContext().getResources().getIdentifier("custom_background_select_category1", "drawable", view.getContext().getApplicationContext().getPackageName());
                            drawable = view.getContext().getApplicationContext().getResources().getDrawable(drawableId);
                            animBtnCategory1.setBackground(drawable);
                            break;
                        case R.id.btnCategory2:
                            drawableId = view.getContext().getApplicationContext().getResources().getIdentifier("custom_background_select_category2", "drawable", view.getContext().getApplicationContext().getPackageName());
                            drawable = view.getContext().getApplicationContext().getResources().getDrawable(drawableId);
                            animBtnCategory2.setBackground(drawable);
                            break;
                        case R.id.btnCategory3:
                            drawableId = view.getContext().getApplicationContext().getResources().getIdentifier("custom_background_select_category3", "drawable", view.getContext().getApplicationContext().getPackageName());
                            drawable = view.getContext().getApplicationContext().getResources().getDrawable(drawableId);
                            animBtnCategory3.setBackground(drawable);
                            break;
                        case R.id.btnCategory4:
                            drawableId = view.getContext().getApplicationContext().getResources().getIdentifier("custom_background_select_category4", "drawable", view.getContext().getApplicationContext().getPackageName());
                            drawable = view.getContext().getApplicationContext().getResources().getDrawable(drawableId);
                            animBtnCategory4.setBackground(drawable);
                            break;
                        case R.id.btnCategory5:
                            drawableId = view.getContext().getApplicationContext().getResources().getIdentifier("custom_background_select_category5", "drawable", view.getContext().getApplicationContext().getPackageName());
                            drawable = view.getContext().getApplicationContext().getResources().getDrawable(drawableId);
                            animBtnCategory5.setBackground(drawable);
                            break;
                        case R.id.btnCategory6:
                            drawableId = view.getContext().getApplicationContext().getResources().getIdentifier("custom_background_select_category6", "drawable", view.getContext().getApplicationContext().getPackageName());
                            drawable = view.getContext().getApplicationContext().getResources().getDrawable(drawableId);
                            animBtnCategory6.setBackground(drawable);
                            Intent it = new Intent();
                            it.setClass(view.getContext(), ThemDanhMuc.class);
                            startActivity(it);
                            break;
                        default:
                            break;
                    }
                }
            });
        }
    }
    private void setVisibleBackgroundSelected(View view){
        int drawableId = R.color.none;
        Drawable drawable = view.getContext().getApplicationContext().getResources().getDrawable(drawableId);
        animBtnCategory1.setBackground(drawable);
        animBtnCategory2.setBackground(drawable);
        animBtnCategory3.setBackground(drawable);
        animBtnCategory4.setBackground(drawable);
        animBtnCategory5.setBackground(drawable);
        animBtnCategory6.setBackground(drawable);
    }
    private void setBackgroundNoneForButtonDate(){
        btnToday.setBackgroundColor(getResources().getColor(R.color.none));
        btnYesterday.setBackgroundColor(getResources().getColor(R.color.none));
        btnCustomDay.setBackgroundColor(getResources().getColor(R.color.none));
    }
    private void setTextBtnDay(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatDay = new SimpleDateFormat("dd/MM"); //format: 21/06/2002
        btnToday.setText(formatDay.format(calendar.getTime()) + "\n" + "Hôm nay");
        calendar.add(Calendar.DATE, -1);
        btnYesterday.setText(formatDay.format(calendar.getTime()) + "\n" + "Hôm qua");
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(Sang_FragmentChi.this.getContext().getContentResolver(), selectedImage);
                switch (requestCode) {
                    case 1:
                        imgBtnNote1Chi.setImageBitmap(bitmap);
                        break;
                    case 2:
                        imgBtnNote2Chi.setImageBitmap(bitmap);
                        break;
                    case 3:
                        imgBtnNote3Chi.setImageBitmap(bitmap);
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}