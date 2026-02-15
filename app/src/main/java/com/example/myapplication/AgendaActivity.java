package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgendaActivity extends AppCompatActivity {

    private CalendarView calendarView;
    private RecyclerView recyclerView;
    private TextView tvDateTitle;
    private FloatingActionButton fabAdd;

    private EventAdapter adapter;
    private List<Event> currentEventList;

    // Notre "Base de données" en mémoire : Date (String) -> Liste d'événements
    private Map<String, List<Event>> eventsMap;

    private String selectedDate; // La date actuellement sélectionnée (ex: "15/02/2026")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        // Initialisation des composants
        calendarView = findViewById(R.id.calendarView);
        recyclerView = findViewById(R.id.recyclerViewEvents);
        tvDateTitle = findViewById(R.id.tvDateTitle);
        fabAdd = findViewById(R.id.fabAddEvent);

        // Initialisation des données
        eventsMap = new HashMap<>();
        currentEventList = new ArrayList<>();

        // Configuration de la liste
        adapter = new EventAdapter(currentEventList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Définir la date par défaut (Aujourd'hui)
        // Note: C'est une simplification, idéalement on formate la date du jour système
        selectedDate = "Aujourd'hui";

        // 1. GESTION DU CALENDRIER
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            // Le mois commence à 0 (Janvier = 0), donc on ajoute 1
            selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
            tvDateTitle.setText("Événements du : " + selectedDate);

            // On charge les événements de cette date
            loadEventsForDate(selectedDate);
        });

        // 2. GESTION DU BOUTON AJOUTER
        fabAdd.setOnClickListener(v -> showAddEventDialog());
    }

    private void loadEventsForDate(String date) {
        currentEventList.clear();

        // Si des événements existent pour cette date, on les ajoute
        if (eventsMap.containsKey(date)) {
            currentEventList.addAll(eventsMap.get(date));
        }

        // On rafraîchit l'affichage
        adapter.notifyDataSetChanged();
    }

    private void showAddEventDialog() {
        // Création d'une vue personnalisée pour la boite de dialogue (2 champs texte)
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Nouvel événement le " + selectedDate);

        // On crée un layout simple en code Java pour la popup (Linear Layout vertical)
        // Pour faire plus propre, on pourrait créer un fichier xml dialog_add_event.xml
        View dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add_event, null);

        // NOTE : Crée le fichier res/layout/dialog_add_event.xml (voir étape bonus ci-dessous)
        // Si tu ne veux pas créer de fichier XML, tu peux utiliser des EditText simples ici.

        final EditText etTime = dialogView.findViewById(R.id.etDialogTime);
        final EditText etTitle = dialogView.findViewById(R.id.etDialogTitle);

        builder.setView(dialogView);

        builder.setPositiveButton("Ajouter", (dialog, which) -> {
            String time = etTime.getText().toString();
            String title = etTitle.getText().toString();

            if (!title.isEmpty()) {
                addEvent(selectedDate, time, title);
            } else {
                Toast.makeText(this, "Titre requis", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Annuler", (dialog, which) -> dialog.dismiss());
        builder.show();
    }

    private void addEvent(String date, String time, String title) {
        // 1. Récupérer ou créer la liste pour cette date
        List<Event> events = eventsMap.get(date);
        if (events == null) {
            events = new ArrayList<>();
            eventsMap.put(date, events);
        }

        // 2. Ajouter le nouvel événement
        events.add(new Event(time, title));

        // 3. Rafraîchir l'écran actuel
        loadEventsForDate(date);
    }
}