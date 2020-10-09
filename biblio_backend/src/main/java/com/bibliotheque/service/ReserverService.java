package com.bibliotheque.service;

import com.bibliotheque.modele.entities.Reserver;

import java.util.List;

public interface ReserverService {
    List<Reserver> rechercherResa(Integer usagerId);
}
