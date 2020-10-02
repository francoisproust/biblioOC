package com.bibliotheque.controleur;

import com.bibliotheque.modele.entities.TypeUser;
import com.bibliotheque.service.TypeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeUserController {
    @Autowired
    TypeUserService typeUserService;

    @GetMapping("/type-usager")
    public List<TypeUser> listerTypeUsager(){
        List<TypeUser> typeUsers = typeUserService.listerTypeUser();
        return typeUsers;
    }
}
