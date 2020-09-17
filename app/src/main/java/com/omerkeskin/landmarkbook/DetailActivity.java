package com.omerkeskin.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    ImageView ivLandmarkDetail;
    TextView tvLandmarkDetail, tvCountry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivLandmarkDetail = findViewById(R.id.ivLandmarkDetail);
        tvLandmarkDetail = findViewById(R.id.tvLandmarkDetail);
        tvCountry = findViewById(R.id.tvCountry);

        Intent i = getIntent();
        String name = i.getStringExtra("name");
        String country = i.getStringExtra("country");

        tvLandmarkDetail.setText(name);
        tvCountry.setText(country);
        ivLandmarkDetail.setImageBitmap(Singleton.getInstance().getLandmark().getPhoto());

    }
}