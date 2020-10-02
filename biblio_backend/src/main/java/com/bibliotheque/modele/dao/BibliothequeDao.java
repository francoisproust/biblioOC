package com.bibliotheque.modele.dao;

import com.bibliotheque.modele.entities.Bibliotheque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliothequeDao extends JpaRepository<Bibliotheque,Integer> {
}
