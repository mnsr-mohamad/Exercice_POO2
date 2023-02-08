package Classes;

import java.util.ArrayList;
import java.util.List;

public class Rayon {
    private String codeRayon;
    private String genre;
    private List<Exemplaire> lex = new ArrayList<>();

    public Rayon(String codeRayon, String genre) {
        this.codeRayon = codeRayon;
        this.genre = genre;

    }

    public Rayon(String codeRayon, String genre, List<Exemplaire> lex) {
        this.codeRayon = codeRayon;
        this.genre = genre;
        this.lex = lex;
    }

    public String getCodeRayon() {
        return codeRayon;
    }

    public void setCodeRayon(String codeRayon) {
        this.codeRayon = codeRayon;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Exemplaire> getLex() {
        return lex;
    }

    public void setLex(List<Exemplaire> lex) {
        this.lex = lex;
    }

    @Override
    public String toString() {
        return "Rayon{" +
                "codeRayon='" + codeRayon + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }


    public void listerExamplaires() {

    }
}
