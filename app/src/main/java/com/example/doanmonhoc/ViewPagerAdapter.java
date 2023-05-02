package com.example.doanmonhoc;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new NowFragment();
            case 1:
                return new MonthFragment();
            case 2:
                return new YearFragment();
            case 3:
                return new OptionFragment();
            default:
                return new NowFragment();
        }

    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title="";
        switch (position)
        {
            case 0:
                title="HIỆN TẠI";
                break;
            case 1:
                title="THÁNG";
                break;
            case 2:
                title="NĂM";
                break;
            case 3:
                title="TÙY CHỌN";
                break;


        }
        return title;
    }
}
