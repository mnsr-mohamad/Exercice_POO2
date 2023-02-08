package Classes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DVD extends Ouvrage{

    private String code;
    private int nbreBonus;
    private LocalTime dureeTotale;

    private List<String> autresLangues= new ArrayList<>();
    private List<String> sousTitres= new ArrayList<>();


    public DVD(String titre, int ageMin, LocalDate dateParution, TypeOuvrage typeouvrage, double prixLocation, String langue, String genre, String code, int nbreBonus, LocalTime dureeTotale, List<String> autresLangues, List<String> sousTitres) {
        super(titre, ageMin, dateParution, typeouvrage, prixLocation, langue, genre);
        this.code = code;
        this.nbreBonus = nbreBonus;
        this.dureeTotale = dureeTotale;
        this.autresLangues = autresLangues;
        this.sousTitres = sousTitres;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getNbreBonus() {
        return nbreBonus;
    }

    public void setNbreBonus(int nbreBonus) {
        this.nbreBonus = nbreBonus;
    }

    public LocalTime getDureeTotale() {
        return dureeTotale;
    }

    public void setDureeTotale(LocalTime dureeTotale) {
        this.dureeTotale = dureeTotale;
    }

    public List<String> getAutresLangues() {
        return autresLangues;
    }

    public void setAutresLangues(List<String> autresLangues) {
        this.autresLangues = autresLangues;
    }

    public List<String> getSousTitres() {
        return sousTitres;
    }

    public void setSousTitres(List<String> sousTitres) {
        this.sousTitres = sousTitres;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "code='" + code + '\'' +
                ", nbreBonus=" + nbreBonus +
                ", dureeTotale=" + dureeTotale +
                ", autresLangues=" + autresLangues +
                ", sousTitres=" + sousTitres +
                ", titre='" + titre + '\'' +
                ", ageMin=" + ageMin +
                ", dateParution=" + dateParution +
                ", typeouvrage=" + typeouvrage +
                ", prixLocation=" + prixLocation +
                ", langue='" + langue + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
    public double amendeRetard(int njours){

        return 0;

    }
}
