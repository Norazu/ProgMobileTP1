package com.example.myapplication;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnSubmit = findViewById(R.id.button);
        EditText etNom = findViewById(R.id.editText);
        EditText etPrenom = findViewById(R.id.editText2);
        EditText etCompetences = findViewById(R.id.editText3);
        EditText etAge = findViewById(R.id.editText4);
        EditText etPhone = findViewById(R.id.editText5);

        btnSubmit.setOnClickListener(v -> showConfirmationDialog(etNom, etPrenom, etCompetences, etAge, etPhone));
    }

    private void showConfirmationDialog(EditText... fields) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.dialog_titre);
        builder.setMessage(R.string.dialog_message);

        builder.setPositiveButton(R.string.btn_valider, (dialog, which) -> {
            for (EditText field : fields) {
                field.setBackgroundColor(Color.parseColor("#C8E6C9"));
            }
            Toast.makeText(MainActivity.this, R.string.msg_validation_ok, Toast.LENGTH_SHORT).show();
        });

        builder.setNegativeButton(R.string.btn_annuler, (dialog, which) -> {
            Toast.makeText(MainActivity.this, R.string.msg_action_annulee, Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });

        builder.show();
    }
}