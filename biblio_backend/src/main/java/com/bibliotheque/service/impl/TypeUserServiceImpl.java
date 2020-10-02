package com.bibliotheque.service.impl;

import com.bibliotheque.modele.dao.TypeUserDao;
import com.bibliotheque.modele.entities.TypeUser;
import com.bibliotheque.service.TypeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeUserServiceImpl implements TypeUserService {
    @Autowired
    TypeUserDao typeUserDao;
    @Override
    public List<TypeUser> listerTypeUser() {
        List<TypeUser> typeUsers = typeUserDao.findAll();
        return typeUsers;
    }

    @Override
    public TypeUser chercherUserLecteur(){
        TypeUser typeUser = typeUserDao.findByTypeUserEquals("lecteur");
        return typeUser;
    }
}
