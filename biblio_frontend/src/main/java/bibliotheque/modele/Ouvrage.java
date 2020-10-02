package bibliotheque.modele;

import java.io.Serializable;
import java.math.BigInteger;

public class Ouvrage implements Serializable {
    private String nom;
    private String auteur;
    private BigInteger isbn;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public BigInteger getIsbn() {
        return isbn;
    }

    public void setIsbn(BigInteger isbn) {
        this.isbn = isbn;
    }
}
