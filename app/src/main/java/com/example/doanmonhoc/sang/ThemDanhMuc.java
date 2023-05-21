package com.example.doanmonhoc.sang;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmonhoc.R;

import java.util.ArrayList;

public class ThemDanhMuc extends AppCompatActivity {

    ImageButton danhMuc1,danhMuc2,danhMuc3,danhMuc4,danhMuc5,danhMuc6,danhMuc7,danhMuc8,danhMuc9,danhMuc10,danhMuc11,danhMuc12,danhMuc13,danhMuc14,danhMuc15;
    Button btnThem;
    EditText edtTenDanhMuc;
    GridLayout grdLayout;
    ImageButton button;
    int dong = 0, cot = -1;
    ArrayList<ImageButton> arrImgBtn = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_danh_muc);

        Intent it = getIntent();
        addControls();
        View.OnClickListener onClick = myOnClickListener();
        addOnClick(onClick);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cot == 2){
                    dong++;
                    cot = -1;
                }
                cot++;
                createButtonDanhMuc(button, edtTenDanhMuc.getText().toString(), dong, cot);
            }
        });
    }

    public void createButtonDanhMuc(ImageButton img, String tenDM, int dong, int cot){

        // Tạo LinearLayout
        LinearLayout linearLayout = new LinearLayout(ThemDanhMuc.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);

        LinearLayout.LayoutParams textViewLayoutParams =  new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textViewLayoutParams.setMargins(10,30,10,30);
        linearLayout.setLayoutParams(textViewLayoutParams);
        // Tạo ImageButton
        ImageButton imageButton = new ImageButton(ThemDanhMuc.this);
        imageButton.setLayoutParams(new LinearLayout.LayoutParams(280, 280));
        imageButton.setBackgroundResource(R.drawable.custom_button_category);
        imageButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.xam)));
        Drawable drawable = button.getDrawable();
        imageButton.setImageDrawable(drawable);
        imageButton.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetColorButton();
                ColorStateList backgroundTintList = imageButton.getBackgroundTintList();
                int defaultColor = backgroundTintList.getDefaultColor();
                int colorInPressedState = backgroundTintList.getColorForState(new int[]{android.R.attr.state_pressed}, defaultColor);
                if(colorInPressedState != R.color.xam){
                    imageButton.getBackground().setColorFilter(imageButton.getResources().getColor(R.color.xanh_la), PorterDuff.Mode.SRC);
                }
                Intent it = new Intent();
                it.setClass(ThemDanhMuc.this, Sang_MainActivity.class);
                startActivity(it);
                arrImgBtn.add(imageButton);
            }
        });

        // Thêm ImageButton vào LinearLayout
        linearLayout.addView(imageButton);

        // Tạo TextView
        TextView textView = new TextView(ThemDanhMuc.this);
        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        textView.setText(tenDM);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        textView.setGravity(Gravity.CENTER);

        // Thêm TextView vào LinearLayout
        linearLayout.addView(textView);

        // Thêm LinearLayout vào GridLayout
        GridLayout.Spec rowSpec = GridLayout.spec(dong);
        GridLayout.Spec colSpec = GridLayout.spec(cot);
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(rowSpec, colSpec);
        grdLayout.addView(linearLayout, layoutParams);
    }
    public void resetColorButton(){
        for(ImageButton bt: arrImgBtn){
            bt.getBackground().setColorFilter(bt.getResources().getColor(R.color.xam), PorterDuff.Mode.SRC);
        }
    }
    public void addControls(){
        danhMuc1 = (ImageButton) findViewById(R.id.danhMuc1);
        danhMuc2 = (ImageButton) findViewById(R.id.danhMuc2);
        danhMuc3 = (ImageButton) findViewById(R.id.danhMuc3);
        danhMuc4 = (ImageButton) findViewById(R.id.danhMuc4);
        danhMuc5 = (ImageButton) findViewById(R.id.danhMuc5);
        danhMuc6 = (ImageButton) findViewById(R.id.danhMuc6);
        danhMuc7 = (ImageButton) findViewById(R.id.danhMuc7);
        danhMuc8 = (ImageButton) findViewById(R.id.danhMuc8);
        danhMuc9 = (ImageButton) findViewById(R.id.danhMuc9);
        danhMuc10 = (ImageButton) findViewById(R.id.danhMuc10);
        danhMuc11 = (ImageButton) findViewById(R.id.danhMuc11);
        danhMuc12 = (ImageButton) findViewById(R.id.danhMuc12);
        danhMuc13 = (ImageButton) findViewById(R.id.danhMuc13);
        danhMuc14 = (ImageButton) findViewById(R.id.danhMuc14);
        danhMuc15 = (ImageButton) findViewById(R.id.danhMuc15);
        btnThem = (Button) findViewById(R.id.btnThem);
        grdLayout = (GridLayout) findViewById(R.id.gridLayout2);
        edtTenDanhMuc = (EditText) findViewById(R.id.edtTenDanhMuc);
    }
    public void clearBackground(){
        danhMuc1.getBackground().setColorFilter(danhMuc1.getResources().getColor(R.color.xam), PorterDuff.Mode.SRC);
        danhMuc2.getBackground().setColorFilter(danhMuc2.getResources().getColor(R.color.xam), PorterDuff.Mode.SRC);
        danhMuc3.getBackground().setColorFilter(danhMuc3.getResources().getColor(R.color.xam), PorterDuff.Mode.SRC);
        danhMuc4.getBackground().setColorFilter(danhMuc4.getResources().getColor(R.color.xam), PorterDuff.Mode.SRC);
        danhMuc5.getBackground().setColorFilter(danhMuc5.getResources().getColor(R.color.xam), PorterDuff.Mode.SRC);
        danhMuc6.getBackground().setColorFilter(danhMuc6.getResources().getColor(R.color.xam), PorterDuff.Mode.SRC);
        danhMuc7.getBackground().setColorFilter(danhMuc7.getResources().getColor(R.color.xam), PorterDuff.Mode.SRC);
        danhMuc8.getBackground().setColorFilter(danhMuc8.getResources().getColor(R.color.xam), PorterDuff.Mode.SRC);
        danhMuc9.getBackground().setColorFilter(danhMuc9.getResources().getColor(R.color.xam), PorterDuff.Mode.SRC);
        danhMuc10.getBackground().setColorFilter(danhMuc10.getResources().getColor(R.color.xam), PorterDuff.Mode.SRC);
        danhMuc11.getBackground().setColorFilter(danhMuc11.getResources().getColor(R.color.xam), PorterDuff.Mode.SRC);
        danhMuc12.getBackground().setColorFilter(danhMuc12.getResources().getColor(R.color.xam), PorterDuff.Mode.SRC);
        danhMuc13.getBackground().setColorFilter(danhMuc13.getResources().getColor(R.color.xam), PorterDuff.Mode.SRC);
        danhMuc14.getBackground().setColorFilter(danhMuc14.getResources().getColor(R.color.xam), PorterDuff.Mode.SRC);
        danhMuc15.getBackground().setColorFilter(danhMuc15.getResources().getColor(R.color.xam), PorterDuff.Mode.SRC);
    }

    public View.OnClickListener myOnClickListener(){
        View.OnClickListener myOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearBackground();
                button = new ImageButton(ThemDanhMuc.this);
                switch (v.getId()) {
                    case R.id.danhMuc1:
                        danhMuc1.getBackground().setColorFilter(danhMuc1.getResources().getColor(R.color.xanh_la), PorterDuff.Mode.SRC);
                        button = (ImageButton) findViewById(R.id.danhMuc1);
                        break;
                    case R.id.danhMuc2:
                        danhMuc2.getBackground().setColorFilter(danhMuc2.getResources().getColor(R.color.xanh_la), PorterDuff.Mode.SRC);
                        button = (ImageButton) findViewById(R.id.danhMuc2);
                        break;
                    case R.id.danhMuc3:
                        danhMuc3.getBackground().setColorFilter(danhMuc3.getResources().getColor(R.color.xanh_la), PorterDuff.Mode.SRC);
                        button = (ImageButton) findViewById(R.id.danhMuc3);
                        break;
                    case R.id.danhMuc4:
                        danhMuc4.getBackground().setColorFilter(danhMuc4.getResources().getColor(R.color.xanh_la), PorterDuff.Mode.SRC);
                        button = (ImageButton) findViewById(R.id.danhMuc4);
                        break;
                    case R.id.danhMuc5:
                        danhMuc5.getBackground().setColorFilter(danhMuc5.getResources().getColor(R.color.xanh_la), PorterDuff.Mode.SRC);
                        button = (ImageButton) findViewById(R.id.danhMuc5);
                        break;
                    case R.id.danhMuc6:
                        danhMuc6.getBackground().setColorFilter(danhMuc6.getResources().getColor(R.color.xanh_la), PorterDuff.Mode.SRC);
                        button = (ImageButton) findViewById(R.id.danhMuc6);
                        break;
                    case R.id.danhMuc7:
                        danhMuc7.getBackground().setColorFilter(danhMuc7.getResources().getColor(R.color.xanh_la), PorterDuff.Mode.SRC);
                        button = (ImageButton) findViewById(R.id.danhMuc7);
                        break;
                    case R.id.danhMuc8:
                        danhMuc8.getBackground().setColorFilter(danhMuc8.getResources().getColor(R.color.xanh_la), PorterDuff.Mode.SRC);
                        button = (ImageButton) findViewById(R.id.danhMuc8);
                        break;
                    case R.id.danhMuc9:
                        danhMuc9.getBackground().setColorFilter(danhMuc9.getResources().getColor(R.color.xanh_la), PorterDuff.Mode.SRC);
                        button = (ImageButton) findViewById(R.id.danhMuc9);
                        break;
                    case R.id.danhMuc10:
                        danhMuc10.getBackground().setColorFilter(danhMuc10.getResources().getColor(R.color.xanh_la), PorterDuff.Mode.SRC);
                        button = (ImageButton) findViewById(R.id.danhMuc10);
                        break;
                    case R.id.danhMuc11:
                        danhMuc11.getBackground().setColorFilter(danhMuc11.getResources().getColor(R.color.xanh_la), PorterDuff.Mode.SRC);
                        button = (ImageButton) findViewById(R.id.danhMuc11);
                        break;
                    case R.id.danhMuc12:
                        danhMuc12.getBackground().setColorFilter(danhMuc12.getResources().getColor(R.color.xanh_la), PorterDuff.Mode.SRC);
                        button = (ImageButton) findViewById(R.id.danhMuc12);
                        break;
                    case R.id.danhMuc13:
                        danhMuc13.getBackground().setColorFilter(danhMuc13.getResources().getColor(R.color.xanh_la), PorterDuff.Mode.SRC);
                        button = (ImageButton) findViewById(R.id.danhMuc13);
                        break;
                    case R.id.danhMuc14:
                        danhMuc14.getBackground().setColorFilter(danhMuc14.getResources().getColor(R.color.xanh_la), PorterDuff.Mode.SRC);
                        button = (ImageButton) findViewById(R.id.danhMuc14);
                        break;
                    case R.id.danhMuc15:
                        danhMuc15.getBackground().setColorFilter(danhMuc15.getResources().getColor(R.color.xanh_la), PorterDuff.Mode.SRC);
                        button = (ImageButton) findViewById(R.id.danhMuc15);
                        break;
                    default:
                        break;
                }
            }
        };
        return myOnClickListener;
    }
    public void addOnClick(View.OnClickListener myOnClickListener){
        danhMuc1.setOnClickListener(myOnClickListener);
        danhMuc2.setOnClickListener(myOnClickListener);
        danhMuc3.setOnClickListener(myOnClickListener);
        danhMuc4.setOnClickListener(myOnClickListener);
        danhMuc5.setOnClickListener(myOnClickListener);
        danhMuc6.setOnClickListener(myOnClickListener);
        danhMuc7.setOnClickListener(myOnClickListener);
        danhMuc8.setOnClickListener(myOnClickListener);
        danhMuc9.setOnClickListener(myOnClickListener);
        danhMuc10.setOnClickListener(myOnClickListener);
        danhMuc11.setOnClickListener(myOnClickListener);
        danhMuc12.setOnClickListener(myOnClickListener);
        danhMuc13.setOnClickListener(myOnClickListener);
        danhMuc14.setOnClickListener(myOnClickListener);
        danhMuc15.setOnClickListener(myOnClickListener);
    }
}