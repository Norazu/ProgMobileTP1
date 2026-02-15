package com.example.myapplication;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // --- 1. CRÉATION DU CONTENEUR PRINCIPAL (ConstraintLayout) ---
        ConstraintLayout layout = new ConstraintLayout(this);
        layout.setId(View.generateViewId());
        layout.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        // --- 2. CRÉATION DES VUES (WIDGETS) ---

        // EditText : Nom
        EditText etNom = new EditText(this);
        etNom.setId(View.generateViewId()); // Indispensable pour le positionnement relatif
        etNom.setHint("Nom");
        layout.addView(etNom);

        // EditText : Prénom
        EditText etPrenom = new EditText(this);
        etPrenom.setId(View.generateViewId());
        etPrenom.setHint("Prénom");
        layout.addView(etPrenom);

        // EditText : Compétences
        EditText etCompetences = new EditText(this);
        etCompetences.setId(View.generateViewId());
        etCompetences.setHint("Compétences");
        layout.addView(etCompetences);

        // EditText : Age
        EditText etAge = new EditText(this);
        etAge.setId(View.generateViewId());
        etAge.setHint("Age");
        etAge.setInputType(InputType.TYPE_CLASS_NUMBER); // Clavier numérique
        layout.addView(etAge);

        // EditText : Téléphone
        EditText etPhone = new EditText(this);
        etPhone.setId(View.generateViewId());
        etPhone.setHint("Téléphone");
        etPhone.setInputType(InputType.TYPE_CLASS_PHONE); // Clavier téléphone
        layout.addView(etPhone);

        // Button : Submit
        Button btnSubmit = new Button(this);
        btnSubmit.setId(View.generateViewId());
        btnSubmit.setText("Submit");
        layout.addView(btnSubmit);

        // Petit bonus : Action sur le bouton pour tester que ça marche
        btnSubmit.setOnClickListener(v -> {
            String message = "Bonjour " + etPrenom.getText().toString();
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        });

        // --- 3. DÉFINITION DES CONTRAINTES (POSITIONNEMENT) ---
        ConstraintSet set = new ConstraintSet();
        set.clone(layout); // On charge les vues ajoutées précédemment

        // -- Contraintes pour etNom (Haut de l'écran avec marge) --
        set.connect(etNom.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, dpToPx(16));
        set.connect(etNom.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START);
        set.connect(etNom.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END);
        set.constrainWidth(etNom.getId(), ConstraintSet.MATCH_CONSTRAINT); // 0dp

        // -- Contraintes pour etPrenom (Sous Nom) --
        set.connect(etPrenom.getId(), ConstraintSet.TOP, etNom.getId(), ConstraintSet.BOTTOM);
        set.connect(etPrenom.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START);
        set.connect(etPrenom.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END);
        set.constrainWidth(etPrenom.getId(), ConstraintSet.MATCH_CONSTRAINT);

        // -- Contraintes pour etCompetences (Sous Prénom) --
        set.connect(etCompetences.getId(), ConstraintSet.TOP, etPrenom.getId(), ConstraintSet.BOTTOM);
        set.connect(etCompetences.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START);
        set.connect(etCompetences.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END);
        set.constrainWidth(etCompetences.getId(), ConstraintSet.MATCH_CONSTRAINT);

        // -- Contraintes pour etAge (Sous Compétences) --
        set.connect(etAge.getId(), ConstraintSet.TOP, etCompetences.getId(), ConstraintSet.BOTTOM);
        set.connect(etAge.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START);
        set.connect(etAge.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END);
        set.constrainWidth(etAge.getId(), ConstraintSet.MATCH_CONSTRAINT);

        // -- Contraintes pour etPhone (Sous Age) --
        set.connect(etPhone.getId(), ConstraintSet.TOP, etAge.getId(), ConstraintSet.BOTTOM);
        set.connect(etPhone.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START);
        set.connect(etPhone.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END);
        set.constrainWidth(etPhone.getId(), ConstraintSet.MATCH_CONSTRAINT);

        // -- Contraintes pour btnSubmit (Sous Phone) --
        set.connect(btnSubmit.getId(), ConstraintSet.TOP, etPhone.getId(), ConstraintSet.BOTTOM);
        set.connect(btnSubmit.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START);
        set.connect(btnSubmit.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END);
        set.constrainWidth(btnSubmit.getId(), ConstraintSet.WRAP_CONTENT); // Largeur adaptée au contenu

        // Appliquer toutes les contraintes au layout
        set.applyTo(layout);

        // --- 4. AFFICHAGE DE LA VUE ---
        // On passe l'objet Java 'layout' directement, plus besoin de R.layout.activity_main
        setContentView(layout);
    }

    /**
     * Méthode utilitaire pour convertir les dp en pixels
     * car les méthodes Java (setMargin, etc.) attendent des pixels.
     */
    private int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }
}