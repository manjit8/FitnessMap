package com.example.fitnessmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class gym extends AppCompatActivity {

     ImageButton powerBtn,luckyBtn,ironBtn,profileBtn,locationBtn,paymentBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym);

        powerBtn=findViewById(R.id.power_btn);

        ironBtn=findViewById(R.id.iron_btn);

        luckyBtn=findViewById(R.id.lucky_btn);

        profileBtn=findViewById(R.id.profile_btn);

        locationBtn=findViewById(R.id.location_btn);

        paymentBtn=findViewById(R.id.payment_btn);

        powerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(gym.this,powergym.class);
                startActivity(intent);
            }
        });
        ironBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(gym.this,irongym.class);
                startActivity(intent);
            }
        });
        luckyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(gym.this,luckygym.class);
                startActivity(intent);
            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(gym.this,profile.class);
                startActivity(intent);
            }
        });

        locationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(gym.this,location.class);
                startActivity(intent);
            }
        });

        paymentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(gym.this,PaymentMethod.class);
                startActivity(intent);
            }
        });






    }
}