package com.example.doanmonhoc.sang;

import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.doanmonhoc.R;

public class Sang_MainActivity extends AppCompatActivity {
    TextView underlineButton;
    boolean checkPos = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        underlineButton = (TextView) findViewById(R.id.underlineButton);
    }
    public void animationBtnChi(View view){
        TranslateAnimation translate = new TranslateAnimation(415, 0, 0,0);
        if(checkPos == true)
            return;
        else{
            translate.setFillAfter(true);
            translate.setDuration(500);
            underlineButton.startAnimation(translate);
            checkPos = true;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag("FragmentThu");
        fragmentManager.beginTransaction().remove(fragment).commit();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameContent, new Sang_FragmentChi(), "FragmentChi");
        fragmentTransaction.commit();
    }
    public void animationBtnThu(View view){
        TranslateAnimation translate = new TranslateAnimation(0, 463, 0,0);
        if(checkPos == false)
            return;
        else{
            translate.setFillAfter(true);
            translate.setDuration(500);
            underlineButton.startAnimation(translate);
            checkPos = false;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentChi);
        if(fragment == null)
            fragment = fragmentManager.findFragmentByTag("FragmentChi");
        fragmentManager.beginTransaction().remove(fragment).commit();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameContent, new Sang_FragmentThu(), "FragmentThu");
        fragmentTransaction.commit();
    }
}