package com.example.doanmonhoc;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.doanmonhoc.sang.Phuong_BaoCao_Thang_Fragment;
import com.example.doanmonhoc.sang.Phuong_Tk_TuyChon_Fragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentTongQuan();
            case 1:
                return new FragmentTaiKhoan();
            case 2:
                return new FragmentAdd();
            case 3:
                return new FragmentBaoCao();
            case 4:
                return new FragmentKhac();
            default:
                return new FragmentAdd();
        }

    }
    @Override
    public int getCount() {

        return 5;
    }
}
