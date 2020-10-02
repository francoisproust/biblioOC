package com.bibliotheque.service.impl;

import com.bibliotheque.modele.dao.BibliothequeDao;
import com.bibliotheque.modele.entities.Bibliotheque;
import com.bibliotheque.service.BibliothequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliothequeServiceImpl implements BibliothequeService {
    @Autowired
    BibliothequeDao bibliothequeDao;

    @Override
    public List<Bibliotheque> listerBiblio() {
        List<Bibliotheque> bibliotheques = bibliothequeDao.findAll();
        return bibliotheques;
    }


}
