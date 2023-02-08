package Classes;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Ouvrage {
    protected String titre;
    protected int ageMin;
    protected LocalDate dateParution;
    protected TypeOuvrage typeouvrage;
    protected double prixLocation;
    protected String langue;
    protected String genre;
    private Boolean enLocation = false;


    public Ouvrage(String titre, int ageMin, LocalDate dateParution, TypeOuvrage typeouvrage, double prixLocation, String langue, String genre) {
        this.titre = titre;
        this.ageMin = ageMin;
        this.dateParution = dateParution;
        this.typeouvrage = typeouvrage;
        this.prixLocation = prixLocation;
        this.langue = langue;
        this.genre = genre;

    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(int ageMin) {
        this.ageMin = ageMin;
    }

    public LocalDate getDateParution() {
        return dateParution;
    }

    public void setDateParution(LocalDate dateParution) {
        this.dateParution = dateParution;
    }

    public TypeOuvrage getTypeouvrage() {
        return typeouvrage;
    }

    public void setTypeouvrage(TypeOuvrage typeouvrage) {
        this.typeouvrage = typeouvrage;
    }

    public double getPrixLocation() {
        return prixLocation;
    }

    public void setPrixLocation(double prixLocation) {
        this.prixLocation = prixLocation;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void listerExemplaires() {


    }

    public void listerExemplaires(Boolean EnLocation) {


    }

    public double amendeRetard(int njours) {

        return 0;
    }


}
