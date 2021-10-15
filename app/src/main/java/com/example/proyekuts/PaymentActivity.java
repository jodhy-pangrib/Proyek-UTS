package com.example.proyekuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyekuts.SharedPreferences.Entity.User;
import com.example.proyekuts.SharedPreferences.Preferences.UserPreferences;
import com.google.android.material.button.MaterialButton;

public class PaymentActivity extends AppCompatActivity {
    private User user;
    private UserPreferences userPreferences;
    TextView judul,hiUser,nama, checkin, checkout, roomType, harga;
    EditText cash;
    ImageView arrow;
    MaterialButton payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        judul = findViewById(R.id.judul);
        hiUser = findViewById(R.id.hiUsernamePayment);
        nama = findViewById(R.id.isiNamaPayment);
        checkin = findViewById(R.id.isiCheckInPayment);
        checkout = findViewById(R.id.isiCheckOutPayment);
        roomType = findViewById(R.id.isiRoomTypePayment);
        harga = findViewById(R.id.isiTotalPricePayment);
        cash = findViewById(R.id.yourCashPayment);
        arrow = findViewById(R.id.arrow);
        payment = findViewById(R.id.payment);

        userPreferences = new UserPreferences(PaymentActivity.this);
        user = userPreferences.getUserLogin();
        judul.setText("Payment");
        hiUser.setText("Hi, "+user.getNama()+"\nComplete Your Payment");
        nama.setText(user.getNama());

        roomType.setText(getIntent().getStringExtra("typeRoom"));
        checkin.setText(getIntent().getStringExtra("checkIn"));
        checkout.setText(getIntent().getStringExtra("checkOut"));

        double price = Double.parseDouble(getIntent().getStringExtra("harga"));
        double days = Double.parseDouble(getIntent().getStringExtra("days"));
        price = days*price;
        harga.setText(String.valueOf(price));

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PaymentActivity.this, ReservationActivity.class));
                finish();
            }
        });

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double bayar = Double.parseDouble(cash.getText().toString().trim());
                double price = Double.parseDouble(harga.getText().toString().trim());
                if(bayar < price) {
                    Toast.makeText(PaymentActivity.this, "Uang Kurang!!!",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(PaymentActivity.this, "Pembayaran Berhasil!",Toast.LENGTH_LONG).show();
                    userPreferences.setLogin(user.getNama(),user.getJenisKelamin(),user.getAlamat(),user.getEmail(),user.getNoTelp(),user.getUsername(),user.getPassword(),user.getUmur(),roomType.getText().toString().trim());
                    startActivity(new Intent(PaymentActivity.this, FinalPageActivity.class));
                    finish();
                }
            }
        });

    }
}