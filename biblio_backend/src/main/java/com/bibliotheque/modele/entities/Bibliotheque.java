package com.bibliotheque.modele.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="bibliotheque", schema = "public")
public class Bibliotheque implements Serializable {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    @Column (name = "biblio_id",nullable = false)
    private Integer biblioId;
    @Column (name = "lieu",nullable = false,length = 255)
    private String lieu;

    @OneToMany(mappedBy = "bibliotheque", cascade = CascadeType.ALL)
    private Set<Exemplaire> exemplaires;

    public Integer getBiblioId() {
        return biblioId;
    }

    public void setBiblioId(Integer biblioId) {
        this.biblioId = biblioId;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Set<Exemplaire> getExemplaires() {
        return exemplaires;
    }

    public void setExemplaires(Set<Exemplaire> exemplaires) {
        this.exemplaires = exemplaires;
    }
}
