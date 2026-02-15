package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        TextView tvPhoneNumber = findViewById(R.id.tvPhoneNumber);
        Button btnCall = findViewById(R.id.btnCall);
        String phoneNumber = getIntent().getStringExtra("KEY_PHONE");

        // Sécurité : si le numéro est null, on met une valeur par défaut pour éviter le crash
        if (phoneNumber == null) {
            phoneNumber = "";
        }

        tvPhoneNumber.setText(phoneNumber);
        String finalPhoneNumber = phoneNumber;

        btnCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);

            intent.setData(Uri.parse("tel:" + finalPhoneNumber));

            startActivity(intent);
        });
    }
}