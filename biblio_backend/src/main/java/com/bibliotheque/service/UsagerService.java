package com.bibliotheque.service;

import com.bibliotheque.modele.entities.Usager;

import java.util.List;

public interface UsagerService {
    void ajouterUsager(Usager usager);
    Boolean verifierUsager(Usager usager);
    List<Usager> listerUsager();
    Usager chercherUsagerParIdentifiant(String identifiant);
    Usager chercherParUsagerId(Integer usagerId);
}
