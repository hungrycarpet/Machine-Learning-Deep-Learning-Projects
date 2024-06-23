package com.example.quakedec;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class About extends AppCompatActivity {
    @Override
    protected void onStart() {
        TextView textViewOne =findViewById(R.id.introduction);
        TextView textViewTwo =findViewById(R.id.body);
        textViewOne.setText(new USGSClass().getIntroduction());
        textViewTwo.setText(new USGSClass().getBody());
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = findViewById(R.id.toolbar_about);
        setSupportActionBar(toolbar);
        NavigationView navigationView = findViewById(R.id.navmenu_about);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_about);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_home:
                    Intent homeIntent = new Intent(this, MainActivity.class);
                    drawerLayout.closeDrawer(GravityCompat.START);
                    startActivity(homeIntent);
                    break;
                case R.id.menu_About:
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case R.id.menu_Setting: Intent settingIntent = new Intent(this, setting.class);
                    drawerLayout.closeDrawer(GravityCompat.START);
                    startActivity(settingIntent);
                    break;
                default:
            }
            return true;
        });
    }
}