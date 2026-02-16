# Projet de Développement d'Applications Mobiles Android

Ce dépôt contient l'ensemble des travaux pratiques réalisés dans le cadre du module de programmation Android. Le projet est structuré en trois exercices distincts, illustrant la progression des concepts fondamentaux vers des interfaces plus complexes.

## Structure du Projet et Versionning

L'architecture de ce dépôt repose sur l'utilisation de branches Git pour isoler chaque étape du développement. Il n'existe pas de version unique sur la branche principale (`main` ou `master`) regroupant toutes les fonctionnalités simultanément.

Pour évaluer un exercice spécifique, il est nécessaire de basculer sur la branche correspondante :

| Application / Exercice | Branche Git | Description Technique |
| :--- | :--- | :--- |
| **1. Formulaire & Appels** | `exercice_7` | Gestion du cycle de vie, Intents et interaction système. |
| **2. Horaires de Trains** | `exercice_8` | Affichage de listes dynamiques optimisées (RecyclerView). |
| **3. Agenda Personnel** | `exercice_9` | Manipulation de données temporelles et persistance mémoire. |

## Environnement Technique

* **Langage :** Java
* **IDE :** Android Studio
* **Interface Utilisateur :** XML, Material Design
* **Système de Build :** Gradle

## Description des Fonctionnalités

### 1. Gestion de Formulaire et Appels (Branche `exercice_7`)
Cette application implémente un flux de travail complet de saisie de données.
* **Fonctionnalités :** Saisie utilisateur, validation des champs, fenêtre de confirmation modale (`AlertDialog`) et transmission de données entre activités.
* **Intégration système :** Utilisation d'un Intent Implicite (`ACTION_DIAL`) pour déléguer l'appel téléphonique à l'application native.

### 2. Système d'Information Voyageurs (Branche `exercice_8`)
Application de consultation d'horaires simulant une réponse serveur.
* **Architecture UI :** Utilisation du composant `RecyclerView` et du pattern `ViewHolder` pour une gestion performante de la mémoire.
* **Modèle de données :** Séparation de la logique métier (classe `Train`) et de la vue (`TrainAdapter`).

### 3. Agenda Événementiel (Branche `exercice_9`)
Outil de planification combinant sélection calendaire et gestion de tâches.
* **Composants :** Intégration d'un `CalendarView` et de boîtes de dialogue personnalisées (Layout Inflation).
* **Logique métier :** Utilisation de structures de données (`HashMap`) pour associer dynamiquement des listes d'événements à des dates clés.

## Guide d'Installation et d'Exécution

Veuillez suivre la procédure suivante pour tester les différentes versions de l'application :

1.  **Clonage du dépôt :**
    ```bash
    git clone git@github.com:Norazu/ProgMobileTP1.git
    cd votre-repo
    ```

2.  **Sélection de l'exercice :**
    Utilisez la commande `checkout` pour charger le code de l'exercice souhaité :
    * Pour le Formulaire : `git checkout exercice_7`
    * Pour les Trains : `git checkout exercice_8`
    * Pour l'Agenda : `git checkout exercice_9`

3.  **Compilation :**
    * Ouvrez le projet dans Android Studio.
    * Effectuez une synchronisation Gradle (*File > Sync Project with Gradle Files*) pour mettre à jour les dépendances.
    * Lancez l'application sur un émulateur ou un terminal physique.

---

**Auteur :**
Nokrani Ilies
22203846
