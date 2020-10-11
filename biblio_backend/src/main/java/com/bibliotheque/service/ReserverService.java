package com.bibliotheque.service;

import com.bibliotheque.mapping.CreerReservation;
import com.bibliotheque.modele.entities.Reserver;

import java.util.List;

public interface ReserverService {
    List<Reserver> rechercherResa(Integer usagerId);
    void annulerResa(Integer reserverId);
    Reserver creerResa(CreerReservation creerReservation);
    void sendMailToMember(Reserver reserver);
}
