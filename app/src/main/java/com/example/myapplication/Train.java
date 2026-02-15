package com.example.myapplication;

public class Train {
    private String villeDepart;
    private String villeArrivee;
    private String heureDepart;
    private String heureArrivee;

    public Train(String villeDepart, String villeArrivee, String heureDepart, String heureArrivee) {
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.heureDepart = heureDepart;
        this.heureArrivee = heureArrivee;
    }

    public String getVilleDepart() { return villeDepart; }
    public String getVilleArrivee() { return villeArrivee; }
    public String getHeureDepart() { return heureDepart; }
    public String getHeureArrivee() { return heureArrivee; }
}