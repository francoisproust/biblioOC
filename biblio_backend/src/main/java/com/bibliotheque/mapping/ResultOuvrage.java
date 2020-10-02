package com.bibliotheque.mapping;

public class ResultOuvrage {
    String nom;
    Long nombreDispo;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getNombreDispo() {
        return nombreDispo;
    }

    public void setNombreDispo(Long nombreDispo) {
        this.nombreDispo = nombreDispo;
    }
}
