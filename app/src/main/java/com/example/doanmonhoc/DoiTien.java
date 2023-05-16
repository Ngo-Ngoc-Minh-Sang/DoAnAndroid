package com.example.doanmonhoc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DoiTien extends AppCompatActivity {
    private EditText mAmountEditText;
    private Button mConvertButton;
    private ListView mCurrencyListView;

    private ArrayList<Currency> mCurrencyArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_tien);
        mAmountEditText = findViewById(R.id.editTextAmount);
        mConvertButton = findViewById(R.id.buttonConvert);
        mCurrencyListView = findViewById(R.id.listViewCurrency);
        mCurrencyArrayList.add(new Currency("USD", R.drawable.usd));
        mCurrencyArrayList.add(new Currency("EUR", R.drawable.eur));
        mCurrencyArrayList.add(new Currency("GBP", R.drawable.gbp));
        mCurrencyArrayList.add(new Currency("JPY", R.drawable.jpy));
        mCurrencyArrayList.add(new Currency("CAD", R.drawable.cad));
        mCurrencyArrayList.add(new Currency("AUD", R.drawable.aud));
        mCurrencyArrayList.add(new Currency("NZD", R.drawable.nzd));
        mCurrencyArrayList.add(new Currency("CHF", R.drawable.chf));
        mCurrencyArrayList.add(new Currency("SGD", R.drawable.sgd));
        mCurrencyArrayList.add(new Currency("INR", R.drawable.inr));
        mCurrencyArrayList.add(new Currency("CNY", R.drawable.cny));
        mCurrencyArrayList.add(new Currency("KRW", R.drawable.krw));

        // Khởi tạo
        final CurrencyAdapter currencyAdapter = new CurrencyAdapter(this, mCurrencyArrayList);
        mCurrencyListView.setAdapter(currencyAdapter);

        // Sự kiện button
        mConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = mAmountEditText.getText().toString();
                //Kiểm tra EditText không được rỗng
                if(amount.isEmpty()){
                    Toast.makeText(DoiTien.this, "Không dược để trống", Toast.LENGTH_SHORT).show();
                }
                else {
                    //
                    //Lặp lại các đối tượng tiền tệ và cập nhật số tiền đã chuyển đổi của chúng
                    for (Currency currency : mCurrencyArrayList) {
                        currency.convert(Double.parseDouble(amount));
                    }

                    //
                    //Thông báo cho bộ điều hợp về các thay đổi dữ liệu và cập nhật chế độ xem danh sách
                    currencyAdapter.notifyDataSetChanged();
                }

            }
        });

    }
    protected static class Currency {
        private String mCurrencyCode;
        private double mConversionRate;
        private double mConvertedAmount;
        private int mFlagResourceId;

        public Currency(String currencyCode, int flagResourceId) {
            mCurrencyCode = currencyCode;
            mFlagResourceId = flagResourceId;
            mConversionRate = getConversionRate(currencyCode);
        }

        private double getConversionRate(String currencyCode) {
            //Thực hiện chuyển đổi thực tế tại đây dựa trên mã tiền tệ
            switch (currencyCode) {
                case "USD":
                    return 23.495;
                case "EUR":
                    return 26.071;
                case "GBP":
                    return 29.21;
                case "JPY":
                    return 175.12;
                case "CAD":
                    return 17.176;
                case "AUD":
                    return 15.722;
                case "NZD":
                    return 14.425;
                case "CHF":
                    return 26.311;
                case "SGD":
                    return 17.597;
                case "INR":
                    return 286.38;
                case "CNY":
                    return 3.408;
                case "KRW":
                    return 17.66;
                default:
                    return 1.0;
            }
        }

        public void convert(double amount) {
            mConvertedAmount = amount / mConversionRate;
        }

        public String getCurrencyCode() {
            return mCurrencyCode;
        }

        public double getConversionRate() {
            return mConversionRate;
        }

        public double getConvertedAmount() {
            return mConvertedAmount;
        }

        public int getFlagResourceId() {
            return mFlagResourceId;
        }
    }
}