package Classes;

import java.time.LocalDate;
import java.time.LocalTime;

public class CD extends Ouvrage {
    private int code;
    private int nbrePlages;
    private LocalTime dureeTotale;


    public CD(String titre, int ageMin, LocalDate dateParution, TypeOuvrage typeouvrage, double prixLocation, String langue, String genre, int code, int nbrePlages, LocalTime dureeTotale) {
        super(titre, ageMin, dateParution, typeouvrage, prixLocation, langue, genre);
        this.code = code;
        this.nbrePlages = nbrePlages;
        this.dureeTotale = dureeTotale;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getNbrePlages() {
        return nbrePlages;
    }

    public void setNbrePlages(int nbrePlages) {
        this.nbrePlages = nbrePlages;
    }

    public LocalTime getDureeTotale() {
        return dureeTotale;
    }

    public void setDureeTotale(LocalTime dureeTotale) {
        this.dureeTotale = dureeTotale;
    }

    @Override
    public String toString() {
        return "CD{" +
                "code=" + code +
                ", nbrePlages=" + nbrePlages +
                ", dureeTotale=" + dureeTotale +
                ", titre='" + titre + '\'' +
                ", ageMin=" + ageMin +
                ", dateParution=" + dateParution +
                ", typeouvrage=" + typeouvrage +
                ", prixLocation=" + prixLocation +
                ", langue='" + langue + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    public double amendeRetard(int njours) {

        return 0;
    }
}
