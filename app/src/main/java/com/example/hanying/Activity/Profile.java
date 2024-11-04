package com.example.hanying.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.hanying.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Profile extends AppCompatActivity {
    private LinearLayout homeBtn, menuBtn, locationBtn, profileBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        bottomNavigation();
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
                startActivity(new Intent(Profile.this, OrderListActivity.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, MainActivity.class));
            }
        });

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, MenuActivity.class));
            }
        });

        locationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, MapLocation.class));
            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, Profile.class));
            }
        });
    }

}