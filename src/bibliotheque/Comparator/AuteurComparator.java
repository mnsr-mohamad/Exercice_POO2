package bibliotheque.Comparator;

import bibliotheque.metier.Auteur;

import java.util.Comparator;

public class AuteurComparator implements Comparator<Auteur> {
    @Override
    public int compare(Auteur a1, Auteur a2) {
        int nomCompare = a1.getNom().compareTo(a2.getNom());
        if (nomCompare != 0) {
            return nomCompare;
        } else {
            return a1.getPrenom().compareTo(a2.getPrenom());
        }
    }
}