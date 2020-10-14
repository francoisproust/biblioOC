package com.bibliotheque.mapping;

import java.util.Date;

public class ResultOuvrage {
    String nom;
    Integer nombreDispo;
    Date dateDeRetourPrevu;
    Integer nombreResaFaites;
    Integer nombreResaPossibles;
    Integer ouvrageId;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getNombreDispo() {
        return nombreDispo;
    }

    public void setNombreDispo(Integer nombreDispo) {
        this.nombreDispo = nombreDispo;
    }

    public Date getDateDeRetourPrevu() {
        return dateDeRetourPrevu;
    }

    public void setDateDeRetourPrevu(Date dateDeRetourPrevu) {
        this.dateDeRetourPrevu = dateDeRetourPrevu;
    }

    public Integer getNombreResaFaites() {
        return nombreResaFaites;
    }

    public void setNombreResaFaites(Integer nombreResaFaites) {
        this.nombreResaFaites = nombreResaFaites;
    }

    public Integer getNombreResaPossibles() {
        return nombreResaPossibles;
    }

    public void setNombreResaPossibles(Integer nombreResaPossibles) {
        this.nombreResaPossibles = nombreResaPossibles;
    }

    public Integer getOuvrageId() {
        return ouvrageId;
    }

    public void setOuvrageId(Integer ouvrageId) {
        this.ouvrageId = ouvrageId;
    }
}
