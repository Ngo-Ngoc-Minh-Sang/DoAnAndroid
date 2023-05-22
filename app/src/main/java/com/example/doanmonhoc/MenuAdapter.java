package com.example.doanmonhoc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<Category> lstCat;

    public MenuAdapter(Context mContext, ArrayList<Category> lstCat) {
        this.mContext = mContext;
        this.lstCat = lstCat;
    }

    @Override
    public int getCount() {
        return lstCat.size();
    }

    @Override
    public Object getItem(int i) {
        return lstCat.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
            view = LayoutInflater.from(mContext).inflate(R.layout.list_menu, viewGroup, false);

        TextView textView = view.findViewById(R.id.textviewItem);

        Category category = (Category) lstCat.get(i);

        textView.setText(category.get_name());

        return view;
    }
}
