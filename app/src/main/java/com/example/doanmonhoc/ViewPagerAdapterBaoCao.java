package com.example.doanmonhoc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.doanmonhoc.sang.Phuong_BaoCao_Thang_Fragment;
import com.example.doanmonhoc.sang.Phuong_Tk_TuyChon_Fragment;

public class ViewPagerAdapterBaoCao extends FragmentStatePagerAdapter {
    public ViewPagerAdapterBaoCao(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Phuong_BaoCao_Thang_Fragment();
            case 1:
                return new Phuong_Tk_TuyChon_Fragment();

            default:
                return new FragmentTongQuan();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return "THÁNG";
            case 1:
                return "TÙY CHỌN";
            default:
                return "THÁNG";
        }

    }
}
