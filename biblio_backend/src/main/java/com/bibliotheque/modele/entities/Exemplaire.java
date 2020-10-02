package com.bibliotheque.modele.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="exemplaire", schema = "public")
public class Exemplaire implements Serializable {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    @Column (name = "exemplaire_id",nullable = false)
    private Integer exemplaireId;
    @Column(name = "date_debut", nullable = true)
    private Date dateDebut;
    @Column(name = "date_fin", nullable = true)
    private Date dateFin;
    @Column(name = "prolongation", nullable = false)
    private Boolean prolongation;
    @Column(name = "disponible", nullable = false, length = 32)
    private Boolean disponible;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "usager_id")
    private Usager usager;

    @ManyToOne
    //@JsonIgnore
    @JsonIgnoreProperties({"exemplaires"})
    @JoinColumn(name = "ouvrage_id")
    private Ouvrage ouvrage;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "biblio_id")
    private Bibliotheque bibliotheque;

    public Integer getExemplaireId() {
        return exemplaireId;
    }

    public void setExemplaireId(Integer exemplaireId) {
        this.exemplaireId = exemplaireId;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Boolean getProlongation() {
        return prolongation;
    }

    public void setProlongation(Boolean prolongation) {
        this.prolongation = prolongation;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Usager getUsager() {
        return usager;
    }

    public void setUsager(Usager usager) {
        this.usager = usager;
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    public Bibliotheque getBibliotheque() {
        return bibliotheque;
    }

    public void setBibliotheque(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
    }
}
