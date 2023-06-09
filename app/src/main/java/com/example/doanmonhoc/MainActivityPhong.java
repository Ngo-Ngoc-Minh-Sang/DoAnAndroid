package com.example.doanmonhoc;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.doanmonhoc.sang.Sang_MainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivityPhong extends AppCompatActivity {
    BottomNavigationView bottomNav;
    String message;
    ViewPager view_Pager;
    Button btnPTThuNhap, btnPTChiTieu, btnPTTaiChinh, btnTaiChinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_phong);
        Intent intent = getIntent();
        message = intent.getStringExtra("MESSAGE_KEY");
        bottomNav = findViewById(R.id.bottom_nav);
        view_Pager = findViewById(R.id.view_pager);
        setUpViewPager();

            bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.menu_TongQuan:
                            view_Pager.setCurrentItem(0);
                            break;
                        case R.id.menu_TaiKhoan:
                            view_Pager.setCurrentItem(1);
                            break;
                        case R.id.menu_Add:
//                            view_Pager.setCurrentItem(2);
                            Intent it = new Intent();
                            it.setClass(MainActivityPhong.this, Sang_MainActivity.class);
                            startActivity(it);
                            break;
                        case R.id.menu_BaoCao:
                            view_Pager.setCurrentItem(3);
                            break;
                        case R.id.menu_Khac:
                            Intent np = new Intent();
                            np.setClass(MainActivityPhong.this, MainActivityThongTin.class);
                            startActivity(np);
                            //view_Pager.setCurrentItem(4);
                            break;
                    }
                    return true;
                }
            });
        }

        private void setUpViewPager() {
            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
            view_Pager.setAdapter(viewPagerAdapter);

        }

}