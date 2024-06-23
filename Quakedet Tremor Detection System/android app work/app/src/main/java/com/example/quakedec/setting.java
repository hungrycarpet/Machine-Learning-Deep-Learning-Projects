package com.example.quakedec;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Locale;

public class setting extends AppCompatActivity {
    private String startDateString;
    private String endDateString;
    @Override
    protected void onStart() {
        super.onStart();
        ImageView imageView = findViewById(R.id.SpeechRecognition);
        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
            if(intent.resolveActivity(getPackageManager())!= null)
            startActivityForResult(intent,10);
            else
                Toast.makeText(setting.this,"Your Device does not support this feature",Toast.LENGTH_SHORT).show();
        });
        Button button = findViewById(R.id.StartChangeURL);
        button.setOnClickListener(v -> {
            EditText startDate = findViewById(R.id.startDate);
            EditText endDate = findViewById(R.id.endDate);
            endDateString = endDate.getText().toString();
            startDateString = startDate.getText().toString();
            if(endDateString.isEmpty() && startDateString.isEmpty())
            {
                Toast.makeText(setting.this,"Enter End and Start Date",Toast.LENGTH_SHORT).show();
            }
            else if (startDateString.isEmpty())
            {
                Toast.makeText(setting.this,"Enter Start Date",Toast.LENGTH_SHORT).show();
            }
            else if (endDateString.isEmpty())
            {
                Toast.makeText(setting.this,"Enter End Date",Toast.LENGTH_SHORT).show();
            }
            else
            {
              Intent intent = new Intent(setting.this,MainActivity.class);
              intent.putExtra("IntentStartDate",startDateString);
              intent.putExtra("IntentEndDate",endDateString);
              startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Toolbar toolbar = findViewById(R.id.toolbar_setting);
        setSupportActionBar(toolbar);
        NavigationView navigationView = findViewById(R.id.navmenu_setting);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_setting);
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
                    Intent aboutIntent = new Intent(this, About.class);
                    drawerLayout.closeDrawer(GravityCompat.START);
                    startActivity(aboutIntent);

                    break;
                case R.id.menu_Setting: drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                default:
            }
            return true;
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case 10 : if(requestCode == RESULT_OK && data!=null)
            {
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                //Intent intent = new Intent(setting.this,MainActivity.class);
                //intent.putExtra("CountryName",result.get(0).toLowerCase());
                //startActivity(intent);
            }
                break;
        }
    }
}