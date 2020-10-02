package com.bibliotheque.modele.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;

@Entity
@Table(name="ouvrage", schema = "public")
public class Ouvrage implements Serializable {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    @Column (name = "ouvrage_id",nullable = false)
    private Integer ouvrageId;
    @Column (name = "nom",nullable = false,length = 255)
    private String nom;
    @Column (name = "auteur",nullable = false,length = 255)
    private String auteur;

    @Column (name = "isbn",nullable = false,length = 255)
    private BigInteger isbn;

    @OneToMany(mappedBy = "ouvrage", cascade = CascadeType.ALL)
    private Set<Exemplaire> exemplaires;

    public Integer getOuvrageId() {
        return ouvrageId;
    }

    public void setOuvrageId(Integer ouvrageId) {
        this.ouvrageId = ouvrageId;
    }

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

    public Set<Exemplaire> getExemplaires() {
        return exemplaires;
    }

    public void setExemplaires(Set<Exemplaire> exemplaires) {
        this.exemplaires = exemplaires;
    }
}
