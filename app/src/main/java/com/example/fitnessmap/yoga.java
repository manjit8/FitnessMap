package com.example.fitnessmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class yoga extends AppCompatActivity {
    ImageButton profile1Btn,wellBtn,centerBtn,yoga1Btn,location1Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);
        wellBtn=findViewById(R.id.well_bnt);

        yoga1Btn=findViewById(R.id.yoga1_btn);

        profile1Btn=findViewById(R.id.profile1_btn);

        centerBtn=findViewById(R.id.center_btn);

        location1Btn=findViewById(R.id.location1_btn);
        wellBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(yoga.this,well.class);
                startActivity(intent);
            }
        });
        yoga1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(yoga.this,yoga1.class);
                startActivity(intent);
            }
        });
        profile1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(yoga.this,Profile1.class);
                startActivity(intent);
            }
        });
        centerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(yoga.this,center.class);
                startActivity(intent);
            }
        });
        location1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(yoga.this,location.class);
                startActivity(intent);
            }
        });


    }
}