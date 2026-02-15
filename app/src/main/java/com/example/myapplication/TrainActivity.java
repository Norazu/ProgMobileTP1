package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class TrainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TrainAdapter adapter;
    private List<Train> trainList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);

        EditText etDepart = findViewById(R.id.etDepartSearch);
        EditText etArrivee = findViewById(R.id.etArriveeSearch);
        Button btnSearch = findViewById(R.id.btnSearch);
        recyclerView = findViewById(R.id.recyclerViewTrains);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        trainList = new ArrayList<>();
        adapter = new TrainAdapter(trainList);
        recyclerView.setAdapter(adapter);

        btnSearch.setOnClickListener(v -> {
            trainList.clear(); // On vide la liste précédente

            String depart = etDepart.getText().toString();
            String arrivee = etArrivee.getText().toString();

            trainList.add(new Train(depart, arrivee, "08:00", "10:30"));
            trainList.add(new Train(depart, arrivee, "09:30", "12:00"));
            trainList.add(new Train(depart, arrivee, "14:15", "16:45"));
            trainList.add(new Train(depart, arrivee, "18:00", "20:30"));

            adapter.notifyDataSetChanged(); // Rafraîchir l'affichage
        });
    }
}