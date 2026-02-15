package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RecapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recap);

        TextView tvRecap = findViewById(R.id.tvRecap);
        Button btnRetour = findViewById(R.id.btnRetour);
        Button btnOk = findViewById(R.id.btnOk);

        Intent intent = getIntent();
        if (intent != null) {
            String nom = intent.getStringExtra("KEY_NOM");
            String prenom = intent.getStringExtra("KEY_PRENOM");
            String age = intent.getStringExtra("KEY_AGE");
            String skills = intent.getStringExtra("KEY_COMPETENCES");
            String phone = intent.getStringExtra("KEY_PHONE");
            StringBuilder sb = new StringBuilder();

            sb.append(getString(R.string.recap_nom)).append(" ").append(nom).append("\n");
            sb.append(getString(R.string.recap_prenom)).append(" ").append(prenom).append("\n");
            sb.append(getString(R.string.recap_age)).append(" ").append(age).append("\n");
            sb.append(getString(R.string.recap_skills)).append(" ").append(skills).append("\n");
            sb.append(getString(R.string.recap_phone)).append(" ").append(phone);

            tvRecap.setText(sb.toString());
        }

        btnRetour.setOnClickListener(v -> finish());

        btnOk.setOnClickListener(v -> {
            Intent intentFinal = new Intent(RecapActivity.this, FinalActivity.class);
            startActivity(intentFinal);
        });
    }
}