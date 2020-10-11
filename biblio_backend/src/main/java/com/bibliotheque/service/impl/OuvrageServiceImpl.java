package com.bibliotheque.service.impl;

import com.bibliotheque.modele.dao.ExemplaireDao;
import com.bibliotheque.modele.dao.OuvrageDao;
import com.bibliotheque.modele.entities.Exemplaire;
import com.bibliotheque.modele.entities.Ouvrage;
import com.bibliotheque.service.OuvrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OuvrageServiceImpl implements OuvrageService {
    @Autowired
    OuvrageDao ouvrageDao;
    @Autowired
    ExemplaireDao exemplaireDao;
    @Override
    public List<Ouvrage> listerOuvrage() {
        List<Ouvrage> ouvrages = ouvrageDao.findAll();
        return ouvrages;
    }

    @Override
    public Integer chercherOuvragresDispo(Integer ouvrageId) {
        Integer nbDispo = exemplaireDao.findAllByOuvrage_OuvrageIdAndAndDisponibleTrue(ouvrageId).size();
        return nbDispo;
    }

    @Override
    public List<Exemplaire> listerEmpruntEnRetard() {
        Date date = new Date();
        List<Exemplaire> exemplaires = exemplaireDao.findAllByDateFinBefore(date);
        return exemplaires;
    }

    @Override
    public Integer nbResaAutorise(Integer ouvrageId) {
        return ouvrageDao.findAllByOuvrageId(ouvrageId).getExemplaires().size() * 2;
    }
}
