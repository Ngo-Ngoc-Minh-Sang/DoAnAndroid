package com.example.doanmonhoc;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

public class FragmentBaoCao extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bao_cao, container, false);
        tabLayout=view.findViewById(R.id.tab_baocao);
        viewPager=view.findViewById(R.id.view_pager_baocao);
        ViewPagerAdapterBaoCao adapterBaoCao=new ViewPagerAdapterBaoCao(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapterBaoCao);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}