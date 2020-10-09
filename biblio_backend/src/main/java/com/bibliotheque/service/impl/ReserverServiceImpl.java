package com.bibliotheque.service.impl;

import com.bibliotheque.modele.dao.ReserverDao;
import com.bibliotheque.modele.entities.Reserver;
import com.bibliotheque.service.ReserverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReserverServiceImpl implements ReserverService {

    @Autowired
    ReserverDao reserverDao;

    @Override
    public List<Reserver> rechercherResa(Integer usagerId) {
        List<Reserver> list = reserverDao.findAllByUsager_UsagerId(usagerId);
        return list;
    }
}
