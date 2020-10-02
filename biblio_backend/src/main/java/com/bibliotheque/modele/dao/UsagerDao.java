package com.bibliotheque.modele.dao;

import com.bibliotheque.modele.entities.Usager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsagerDao extends JpaRepository<Usager, Integer> {
    Usager findByIdentifiant(String identifiant);
}
