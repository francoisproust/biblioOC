package com.bibliotheque.service.impl;

import java.math.BigInteger;

public class OuvrageFromCriterias {
    private String nom;
    private String auteur;
    private BigInteger isbn;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public BigInteger getIsbn() {
        return isbn;
    }

    public void setIsbn(BigInteger isbn) {
        this.isbn = isbn;
    }
}
