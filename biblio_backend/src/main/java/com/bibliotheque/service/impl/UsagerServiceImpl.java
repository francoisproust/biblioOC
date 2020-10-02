package com.bibliotheque.service.impl;

import com.bibliotheque.modele.dao.UsagerDao;
import com.bibliotheque.modele.entities.Exemplaire;
import com.bibliotheque.modele.entities.Usager;
import com.bibliotheque.service.UsagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UsagerServiceImpl implements UsagerService {
    @Autowired
    UsagerDao usagerDao;
    @Override
    public void ajouterUsager(Usager usager) {
        usagerDao.save(usager);
    }

    @Override
    public Boolean verifierUsager(Usager usager) {
        Usager usagerEnbase = usagerDao.findByIdentifiant(usager.getIdentifiant());
        if (usagerEnbase.getPassword().equals(usager.getPassword())){
            boolean usagerVerifie = true;
        }
            boolean usagerVerifie = false;
        return usagerVerifie;
    }

    @Override
    public List<Usager> listerUsager() {
        List<Usager> listeUsager = usagerDao.findAll();
        return listeUsager;
    }

    @Override
    public Usager chercherUsagerParIdentifiant(String identifiant) {
        Usager usager = usagerDao.findByIdentifiant(identifiant);
        return usager;
    }

    @Override
    public Usager chercherParUsagerId(Integer usagerId) {
        Usager usager = chercherParId(usagerId);
        return usager;
    }

    private Usager chercherParId(Integer usagerId){
        Optional<Usager> usager = usagerDao.findById(usagerId);
        return usager.isPresent() ? usager.get() :null ;
    }
}
