package com.bibliotheque.service.impl;

import com.bibliotheque.modele.entities.Ouvrage;
import com.bibliotheque.service.OuvrageCustomService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Service
public class OuvrageCustomServiceImpl implements OuvrageCustomService {
    private EntityManager em;

    public OuvrageCustomServiceImpl(EntityManager em){ this.em = em;}

    @Override
    public List<Ouvrage> multiCriteriaOuvrage(OuvrageFromCriterias criterias) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Ouvrage> query = builder.createQuery(Ouvrage.class);

        Root<Ouvrage> ouvrageRoot = query.from(Ouvrage.class);
        List<Predicate> predicates = new ArrayList<>();

        if (!criterias.getAuteur().equals("")) {
            predicates.add(builder.equal(ouvrageRoot. get("auteur"), criterias.getAuteur()));
        }
        if (!criterias.getNom().equals("")) {
            predicates.add(builder.equal(ouvrageRoot. get("nom"), criterias.getNom()));
        }
        if (criterias.getIsbn() != null) {
            predicates.add(builder.equal(ouvrageRoot. get("isbn"), criterias.getIsbn()));
        }

        query.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(query.distinct(true)).getResultList();
    }
}
