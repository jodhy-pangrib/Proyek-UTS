package com.example.proyekuts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ReservationActivity extends AppCompatActivity {
    ImageView imageRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        imageRoom = findViewById(R.id.imageRoom);
        String imageUrl = getIntent().getStringExtra("urlGambar");

        Glide.with(ReservationActivity.this)
                .setDefaultRequestOptions(new RequestOptions())
                .load(imageUrl)
                .into(imageRoom);
    }
}