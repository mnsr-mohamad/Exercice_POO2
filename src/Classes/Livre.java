package Classes;

import java.time.LocalDate;

public class Livre extends Ouvrage {

    private String isbn;
    private int nombrePages;
    private TypeLivre typelivre;
    private String resume;

    public Livre(String titre, int ageMin, LocalDate dateParution, TypeOuvrage typeouvrage, double prixLocation, String langue, String genre, String isbn, int nombrePages, TypeLivre typelivre, String resume) {
        super(titre, ageMin, dateParution, typeouvrage, prixLocation, langue, genre);
        this.isbn = isbn;
        this.nombrePages = nombrePages;
        this.typelivre = typelivre;
        this.resume = resume;
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNombrePages() {
        return nombrePages;
    }

    public void setNombrePages(int nombrePages) {
        this.nombrePages = nombrePages;
    }

    public TypeLivre getTypelivre() {
        return typelivre;
    }

    public void setTypelivre(TypeLivre typelivre) {
        this.typelivre = typelivre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "isbn='" + isbn + '\'' +
                ", nombrePages=" + nombrePages +
                ", typelivre=" + typelivre +
                ", resume='" + resume + '\'' +
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
