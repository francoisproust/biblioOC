package com.bibliotheque.modele.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="type_user", schema = "public")
public class TypeUser implements Serializable {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    @Column (name = "type_id",nullable = false)
    private Integer typeId;
    @Column(name="type_user",nullable = false,length = 32)
    private String typeUser;

    @OneToMany(mappedBy = "typeUser", cascade = CascadeType.ALL)
    private Set<Usager> usagers;


    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    public Set<Usager> getUsagers() {
        return usagers;
    }

    public void setUsagers(Set<Usager> usagers) {
        this.usagers = usagers;
    }
}
