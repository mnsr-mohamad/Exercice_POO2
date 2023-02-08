package Classes;

import java.time.LocalDate;

public class Location {
    private LocalDate dateLoc;
    private LocalDate dateRestitution;
    private double amende;
    private Exemplaire exmp;
    private Lecteur lect;

    public Location(LocalDate dateLoc, LocalDate dateRestitution, double amende) {
        this.dateLoc = dateLoc;
        this.dateRestitution = dateRestitution;
        this.amende = amende;
    }

    public Location(LocalDate dateLoc, LocalDate dateRestitution, double amende, Exemplaire exmp, Lecteur lect) {
        this.dateLoc = dateLoc;
        this.dateRestitution = dateRestitution;
        this.amende = amende;
        this.exmp = exmp;
        this.lect = lect;
    }

    public LocalDate getDateLoc() {
        return dateLoc;
    }

    public void setDateLoc(LocalDate dateLoc) {
        this.dateLoc = dateLoc;
    }

    public LocalDate getDateRestitution() {
        return dateRestitution;
    }

    public void setDateRestitution(LocalDate dateRestitution) {
        this.dateRestitution = dateRestitution;
    }

    public double getAmende() {
        return amende;
    }

    public void setAmende(double amende) {
        this.amende = amende;
    }

    public Exemplaire getExmp() {
        return exmp;
    }

    public void setExmp(Exemplaire exmp) {
        this.exmp = exmp;
    }

    public Lecteur getLect() {
        return lect;
    }

    public void setLect(Lecteur lect) {
        this.lect = lect;
    }

    @Override
    public String toString() {
        return "Location{" +
                "dateLoc=" + dateLoc +
                ", dateRestitution=" + dateRestitution +
                ", amende=" + amende +
                '}';
    }

    public void calculerAmende() {


    }

    public void enregistrerRetour() {


    }
}
