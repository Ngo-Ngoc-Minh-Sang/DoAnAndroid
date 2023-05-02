package com.example.doanmonhoc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity2 extends AppCompatActivity {
    private TabLayout mtabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addcontrol();
        ViewPagerAdapterThuChi viewPagerAdapter=new ViewPagerAdapterThuChi(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);
        mtabLayout.setupWithViewPager(viewPager);
    }
    public void addcontrol()
    {
        mtabLayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.viewpage);
    }
}