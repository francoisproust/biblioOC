package com.bibliotheque.service;

import com.bibliotheque.modele.entities.TypeUser;

import java.util.List;

public interface TypeUserService {
    List<TypeUser> listerTypeUser();
    TypeUser chercherUserLecteur();
}
