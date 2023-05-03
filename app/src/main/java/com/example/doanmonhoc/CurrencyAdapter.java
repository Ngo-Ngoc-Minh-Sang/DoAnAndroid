package com.example.doanmonhoc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CurrencyAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<DoiTien.Currency> mCurrencyArrayList;

    public CurrencyAdapter(Context context, ArrayList<DoiTien.Currency> currencyArrayList) {
        mContext = context;
        mCurrencyArrayList = currencyArrayList;
    }

    @Override
    public int getCount() {
        return mCurrencyArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mCurrencyArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.currency_item, parent, false);
        }

        ImageView flagImageView = convertView.findViewById(R.id.imageViewFlag);
        TextView currencyCodeTextView = convertView.findViewById(R.id.textViewCurrencyCode);
        TextView conversionRateTextView = convertView.findViewById(R.id.textViewConversionRate);
        TextView convertedAmountTextView = convertView.findViewById(R.id.textViewConvertedAmount);

        DoiTien.Currency currency = mCurrencyArrayList.get(position);

        flagImageView.setImageResource(currency.getFlagResourceId());
        currencyCodeTextView.setText(currency.getCurrencyCode());

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        conversionRateTextView.setText(decimalFormat.format(currency.getConversionRate()));
        convertedAmountTextView.setText(decimalFormat.format(currency.getConvertedAmount()));

        return convertView;
    }
}
