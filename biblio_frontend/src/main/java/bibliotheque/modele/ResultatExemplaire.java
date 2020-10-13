package bibliotheque.modele;

import java.io.Serializable;
import java.util.Date;

public class ResultatExemplaire implements Serializable {
    public String nom;
    public Integer nombreDispo;
    Date dateDeRetourPrevu;
    Integer nombreResaFaites;
    Integer nombreResaPossibles;
    Integer ouvrageId;

    public Integer getOuvrageId() {
        return ouvrageId;
    }

    public void setOuvrageId(Integer ouvrageId) {
        this.ouvrageId = ouvrageId;
    }

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

    public Date getDateDeRetourPrevu() {
        return dateDeRetourPrevu;
    }

    public void setDateDeRetourPrevu(Date dateDeRetourPrevu) {
        this.dateDeRetourPrevu = dateDeRetourPrevu;
    }

    public Integer getNombreResaFaites() {
        return nombreResaFaites;
    }

    public void setNombreResaFaites(Integer nombreResaFaites) {
        this.nombreResaFaites = nombreResaFaites;
    }

    public Integer getNombreResaPossibles() {
        return nombreResaPossibles;
    }

    public void setNombreResaPossibles(Integer nombreResaPossibles) {
        this.nombreResaPossibles = nombreResaPossibles;
    }
}
