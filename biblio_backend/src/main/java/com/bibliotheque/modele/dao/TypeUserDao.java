package com.bibliotheque.modele.dao;

import com.bibliotheque.modele.entities.TypeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeUserDao extends JpaRepository<TypeUser,Integer> {
    TypeUser findByTypeUserEquals(String typeUser);
}
