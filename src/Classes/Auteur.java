package Classes;

import java.time.LocalDate;

public class Auteur extends Personne {
    private String nationalite;

    public Auteur(String nom, String prenom, LocalDate dn) {
        super(nom, prenom, dn);
        this.nationalite = nationalite;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    @Override
    public String toString() {
        return "Auteur{" +
                "nationalite='" + nationalite + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dn=" + dn +
                '}';
    }

    public void listerOuvrages() {


    }

    public void listerOuvrages(TypeOuvrage typeOuvrage, TypeLivre typeLivre) {


    }

    public void listerOuvrage(Ouvrage genre) {


    }

}
