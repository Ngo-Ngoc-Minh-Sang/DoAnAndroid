package com.example.doanmonhoc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ArrayList<Category> lstCat;
    MenuAdapter adapterMenu;
    ListView lvMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.np_activity_main);
        try{
            linkView();
            actionBar();
            loadMenu();
            catchOnItemListView();
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Lỗi mainactivity", Toast.LENGTH_LONG).show();
        }
    }

    private void catchOnItemListView() {
        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:
                    {
                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                    }break;
                    case 1:
                    {
                        Intent intent = new Intent(MainActivity.this, Other.class);
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                    }break;
                }
            }
        });
    }

    private void loadMenu() {
        lstCat.add(new Category(1, "Trang chủ"));
        lstCat.add(new Category(2, "Tài khoản"));

        adapterMenu = new MenuAdapter(this, lstCat);
        lvMenu.setAdapter(adapterMenu);
    }

    private void actionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void linkView() {
        toolbar = (Toolbar) findViewById(R.id.toolbarHome);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);

        lstCat = new ArrayList<>();
        lvMenu = (ListView) findViewById(R.id.listviewMenu);
    }
}