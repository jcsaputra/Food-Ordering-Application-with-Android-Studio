package com.example.hanying.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.AsyncTask;
import android.view.View;
import android.util.Log;
import android.widget.Toast;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hanying.Adapter.MenuAdapter;
import com.example.hanying.Adapter.PopularAdapter;
import com.example.hanying.Domain.FoodDomain;
import com.example.hanying.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    private LinearLayout homeBtn, menuBtn, locationBtn, profileBtn;
    private RecyclerView
            recyclerViewMenuList,
            recyclerViewMenuList2,
            recyclerViewMenuList3,
            recyclerViewMenuList4,
            recyclerViewMenuList5;
    private RecyclerView.Adapter adapter;
    private RecyclerView  recyclerViewPopularList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        bottomNavigation();

        recyclerViewPopularList = findViewById(R.id.menuview);
        recyclerViewMenuList2 = findViewById(R.id.menuview2);
        recyclerViewMenuList3 = findViewById(R.id.menuview3);
        recyclerViewMenuList4 = findViewById(R.id.menuview4);
        recyclerViewMenuList5 = findViewById(R.id.menuview5);

        new PopularList().execute();

    }

    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.order_btn);
        homeBtn = findViewById(R.id.homeBtn);
        menuBtn = findViewById(R.id.menuBtn);
        locationBtn = findViewById(R.id.locationBtn);
        profileBtn = findViewById(R.id.profileBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, OrderListActivity.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, MainActivity.class));
            }
        });

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, MenuActivity.class));
            }
        });

        locationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, MapLocation.class));
            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, MainActivity.class));
            }
        });
    }


    private class PopularList extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            // Update the URL or handle different URLs for each RecyclerView
            String urlString = "http://192.168.0.107/hanying/popular_item.php";

            try {
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("GET");

                try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;

                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }

                    return response.toString();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "error";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            try {
                JSONArray jsonArray = new JSONArray(result);

                // Proses data JSON ke dalam ArrayList<FoodDomain>
                ArrayList<FoodDomain> foodList = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String foodName = jsonObject.getString("foodname");
                    String foodPic = jsonObject.getString("foodpic");
                    String foodDescription = jsonObject.getString("fooddesc");
                    double foodPrice = jsonObject.getDouble("foodprice");

                    // Tambahkan data ke ArrayList
                    foodList.add(new FoodDomain(foodName, foodPic, foodDescription, foodPrice));
                }

                // Inisialisasi RecyclerView dan adapter
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MenuActivity.this, LinearLayoutManager.HORIZONTAL, false);
                recyclerViewPopularList.setLayoutManager(linearLayoutManager);
                adapter = new PopularAdapter(foodList);
                recyclerViewPopularList.setAdapter(adapter);

                LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(MenuActivity.this, LinearLayoutManager.HORIZONTAL, false);
                recyclerViewMenuList2.setLayoutManager(linearLayoutManager2);
                adapter = new PopularAdapter(foodList);
                recyclerViewMenuList2.setAdapter(adapter);

                LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(MenuActivity.this, LinearLayoutManager.HORIZONTAL, false);
                recyclerViewMenuList3.setLayoutManager(linearLayoutManager3);
                adapter = new PopularAdapter(foodList);
                recyclerViewMenuList3.setAdapter(adapter);

                LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(MenuActivity.this, LinearLayoutManager.HORIZONTAL, false);
                recyclerViewMenuList4.setLayoutManager(linearLayoutManager4);
                adapter = new PopularAdapter(foodList);
                recyclerViewMenuList4.setAdapter(adapter);

                LinearLayoutManager linearLayoutManager5 = new LinearLayoutManager(MenuActivity.this, LinearLayoutManager.HORIZONTAL, false);
                recyclerViewMenuList5.setLayoutManager(linearLayoutManager5);
                adapter = new PopularAdapter(foodList);
                recyclerViewMenuList5.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(MenuActivity.this, "Error processing JSON (Popular Menu)", Toast.LENGTH_SHORT).show();
            }
        }
    }
}