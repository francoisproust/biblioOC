package bibliotheque.modele;

import java.io.Serializable;

public class ResultatExemplaire implements Serializable {
    public String nom;
    public Integer nombreDispo;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getNombreDispo() {
        return nombreDispo;
    }

    public void setNombreDispo(Integer nombreDispo) {
        this.nombreDispo = nombreDispo;
    }
}
