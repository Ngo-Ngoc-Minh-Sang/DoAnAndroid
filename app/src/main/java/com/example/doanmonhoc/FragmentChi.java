package com.example.doanmonhoc;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FragmentChi extends Fragment {
    FrameLayout animBtnCategory1, animBtnCategory2, animBtnCategory3, animBtnCategory4, animBtnCategory5, animBtnCategory6;
    Button btnToday, btnYesterday, btnCustomDay;
    ImageButton btnCategory1, btnCategory2, btnCategory3, btnCategory4, btnCategory5, btnCategory6;
    ImageButton[] imageButtons;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chi, container, false);
        addControls(view);
        imageButtons = initializeButtons(view,6);
        checkButtonCLicked(view);
        setTextBtnDay();
        animationBtnDay(view);
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
                setBackgroundNoneForButtonDate();
                btnCustomDay.setBackground(ContextCompat.getDrawable(viewParent.findViewById(R.id.btnToday).getContext(), R.drawable.custom_background_buttondate));

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
}