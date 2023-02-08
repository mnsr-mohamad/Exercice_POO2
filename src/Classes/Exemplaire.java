package Classes;

import java.util.ArrayList;
import java.util.List;

public class Exemplaire {
    private String matricule;
    private String descriptionEtat;
    private List<Location> loc = new ArrayList<>();
    private Rayon rayon;

    public Exemplaire(String matricule, String descriptionEtat) {
        this.matricule = matricule;
        this.descriptionEtat = descriptionEtat;
    }

    public Exemplaire(String matricule, String descriptionEtat, List<Location> loc, Rayon rayon) {
        this.matricule = matricule;
        this.descriptionEtat = descriptionEtat;
        this.loc = loc;
        this.rayon = rayon;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getDescriptionEtat() {
        return descriptionEtat;
    }

    public void setDescriptionEtat(String descriptionEtat) {
        this.descriptionEtat = descriptionEtat;
    }

    public List<Location> getLoc() {
        return loc;
    }

    public void setLoc(List<Location> loc) {
        this.loc = loc;
    }

    public Rayon getRayon() {
        return rayon;
    }

    public void setRayon(Rayon rayon) {
        this.rayon = rayon;
    }

    public void modifEtat() {


    }

    public void lecteurActuel() {


    }

    public void lecteurs() {


    }

    public void enVoiMailLecteurActuel(Mail mail) {


    }

    public void enVoiMailLecteurs(Mail mail) {


    }

    public boolean enRetard() {

        return true;

    }

    public int joursRetard() {

        return 0;
    }

    public boolean enLocation() {

        return true;

    }

    public void rendre() {


    }
}
