package com.bibliotheque.modele.entities;

import org.junit.Assert;
import org.junit.Test;

public class TypeUserTest {
    @Test
    public void testGettersAndSetters(){
        TypeUser typeUser = new TypeUser();
        typeUser.setTypeId(1);
        typeUser.setTypeUser("mon utilisateur");

        Assert.assertEquals("mon utilisateur",typeUser.getTypeUser());
        Assert.assertEquals(java.util.Optional.of(1).get(),typeUser.getTypeId());
    }
}
