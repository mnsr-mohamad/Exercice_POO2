package bibliotheque.Comparator;

import bibliotheque.metier.Lecteur;
import java.util.Comparator;

public class LecteurComparator implements Comparator<Lecteur> {
    @Override
    public int compare(Lecteur l1, Lecteur l2) {
        int compareNom = l1.getNom().compareToIgnoreCase(l2.getNom());
        if (compareNom != 0) {
            return compareNom;
        } else {
            return l1.getPrenom().compareToIgnoreCase(l2.getPrenom());
        }
    }
}
