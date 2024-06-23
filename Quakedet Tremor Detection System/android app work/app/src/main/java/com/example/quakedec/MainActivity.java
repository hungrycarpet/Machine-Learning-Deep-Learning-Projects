package com.example.quakedec;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;

    String startDate = null;
    String endDate = null;
    StringBuilder jsonResponseBuilder = new StringBuilder();
    QueryUtils queryUtils;
    URL url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.navmenu_main);
        drawerLayout = findViewById(R.id.drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_home:
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case R.id.menu_About:
                    Intent aboutIntent = new Intent(this, About.class);
                    drawerLayout.closeDrawer(GravityCompat.START);
                    startActivity(aboutIntent);
                    break;
                case R.id.menu_Setting:  Intent settingIntent = new Intent(this, setting.class);
                    drawerLayout.closeDrawer(GravityCompat.START);
                    startActivity(settingIntent);
                    break;
                default:
            }
            return true;
        });
        Intent intent = getIntent();
        startDate = intent.getStringExtra("IntentStartDate");
        endDate = intent.getStringExtra("IntentEndDate");

        try {
            url = new URL(getURLString(startDate,endDate));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        queryUtils = new QueryUtils();
        MySyncTask mySyncTask = new MySyncTask();
        mySyncTask.execute(url);

    }

    private String getURLString(String startDate, String endDate) {
        if(startDate==null && endDate == null)
        {
            return "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02";
        }
        else
        {
            return "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime="+startDate+"&endtime="+endDate;
        }
    }

    private class MySyncTask extends AsyncTask<URL, Void, String> {
        @Override
        protected String doInBackground(URL... urls) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) urls[0].openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 200) {
                    InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream(), Charset.forName("UTF-8"));
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String line = bufferedReader.readLine();
                    while (line != null) {
                        jsonResponseBuilder.append(line);
                        line = bufferedReader.readLine();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return jsonResponseBuilder.toString();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            List<EarthQuakeData> earthQuakeDataList = queryUtils.getList(s);
            ListAdapter listAdapter = new ListAdapter(MainActivity.this, earthQuakeDataList);

            ListView earthquakeListView = (ListView) findViewById(R.id.list);
            earthquakeListView.setAdapter(listAdapter);

            earthquakeListView.setOnItemClickListener((parent, view, position, id) -> {
                try {
                    JSONArray jsonArray = queryUtils.getRoot();
                    JSONObject jsonObject = jsonArray.getJSONObject(position);
                    JSONObject propertyObject = jsonObject.getJSONObject("properties");
                    String url = propertyObject.getString("url");
                    Intent webSiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(webSiteIntent);
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            });

            super.onPostExecute(s);
        }

    }


    @Override
    protected void onDestroy() {

        super.onDestroy();
    }
}