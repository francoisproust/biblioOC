package com.bibliotheque.service;

import com.bibliotheque.modele.entities.Exemplaire;
import com.bibliotheque.modele.entities.Ouvrage;

import java.util.Date;
import java.util.List;

public interface OuvrageService {
    List<Ouvrage> listerOuvrage();
    Integer chercherOuvragresDispo(Integer biblioId);
    List<Exemplaire> listerEmpruntEnRetard();
    Integer nbResaAutorise(Integer ouvrageId);
    Date dateRetourPrevue(Integer ouvrageId);
    Integer chercherRang(Integer ouvrageId,Integer usagerId);
}
