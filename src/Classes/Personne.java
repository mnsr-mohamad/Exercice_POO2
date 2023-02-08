package Classes;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Personne {
    protected String nom, prenom;
    protected LocalDate dn;

    public Personne(String nom, String prenom, LocalDate dn) {
        this.nom = nom;
        this.prenom = prenom;
        this.dn = dn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return Objects.equals(nom, personne.nom) && Objects.equals(prenom, personne.prenom) && Objects.equals(dn, personne.dn);
    }


    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, dn);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDn() {
        return dn;
    }

    public void setDn(LocalDate dn) {
        this.dn = dn;
    }
}
