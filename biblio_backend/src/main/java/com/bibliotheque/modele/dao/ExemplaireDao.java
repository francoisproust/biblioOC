package com.bibliotheque.modele.dao;

import com.bibliotheque.modele.entities.Exemplaire;

import com.bibliotheque.modele.entities.Usager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ExemplaireDao extends JpaRepository<Exemplaire,Integer> {
    List<Exemplaire> findAllByUsager_UsagerId(Integer ouvrageId);
    List<Exemplaire> findAllByDisponibleFalse();
    List<Exemplaire> findAllByOuvrage_OuvrageIdAndAndDisponibleTrue(Integer ouvrageId);
    List<Exemplaire> findAllByDateFinBefore(Date dateFin);
    Exemplaire findByExemplaireId(Integer exemplaireId);
    List<Exemplaire> findAllByUsager(Usager usager);
    List<Exemplaire> findAllByOuvrage_OuvrageId(Integer ouvrageId);
    List<Exemplaire> findAllByOuvrage_OuvrageIdOrderByDateFin(Integer ouvrageId);
}
