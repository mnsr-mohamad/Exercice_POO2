package bibliotheque.utilitaires;

import bibliotheque.metier.*;

import java.util.Comparator;
import java.util.List;

public class TriUtilitaire {

    public static <T> void trierParNomPrenom(List<Auteur> ldatas) {
        ldatas.sort(Comparator.comparing(Auteur::getNom).thenComparing(Auteur::getPrenom));
    }

    public static <T> void trierParTitre(List<Ouvrage> ldatas) {
        ldatas.sort(Comparator.comparing(Ouvrage::getTitre));
    }

    public static <T> void trierParNom(List<Lecteur> ldatas) {
        ldatas.sort(Comparator.comparing(Lecteur::getNom).thenComparing(Lecteur::getPrenom));
    }

    public static <T> void trierParCode(List<Exemplaire> ldatas) {
        ldatas.sort(Comparator.comparing(Exemplaire::getMatricule));
    }

    public static <T> void trierParGenre(List<Rayon> ldatas) {
        ldatas.sort(Comparator.comparing(Rayon::getGenre));
    }
}
