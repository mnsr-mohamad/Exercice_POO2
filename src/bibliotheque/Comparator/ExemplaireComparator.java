package bibliotheque.Comparator;

import bibliotheque.metier.Exemplaire;
import java.util.Comparator;

public class ExemplaireComparator implements Comparator<Exemplaire> {
    @Override
    public int compare(Exemplaire e1, Exemplaire e2) {
        return e1.getMatricule().compareToIgnoreCase(e2.getMatricule());
    }
}