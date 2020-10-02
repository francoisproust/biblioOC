package com.bibliotheque.service;

import com.bibliotheque.modele.entities.Ouvrage;
import com.bibliotheque.service.impl.OuvrageFromCriterias;

import java.util.List;

public interface OuvrageCustomService {
    List<Ouvrage> multiCriteriaOuvrage(OuvrageFromCriterias criterias);
}
