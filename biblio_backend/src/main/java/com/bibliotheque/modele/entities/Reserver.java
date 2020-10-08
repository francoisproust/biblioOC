package com.bibliotheque.modele.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="reserver", schema = "public")
public class Reserver  implements Serializable{
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    @Column(name = "reserver_id",nullable = false)
    private Integer reserverId;
    @Column(name="date_reservation")
    private Date dateReservation;
    @Column(name="date_alerte")
    private Date dateAlerte;
    @ManyToOne
    private Ouvrage ouvrage;
    @ManyToOne
    private Usager usager;

    public Integer getReserverId() {
        return reserverId;
    }

    public void setReserverId(Integer reserverId) {
        this.reserverId = reserverId;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public Date getDateAlerte() {
        return dateAlerte;
    }

    public void setDateAlerte(Date dateAlerte) {
        this.dateAlerte = dateAlerte;
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    public Usager getUsager() {
        return usager;
    }

    public void setUsager(Usager usager) {
        this.usager = usager;
    }
}
