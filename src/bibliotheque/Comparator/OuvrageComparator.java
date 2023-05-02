package bibliotheque.Comparator;

import bibliotheque.metier.Ouvrage;

import java.util.Comparator;

public class OuvrageComparator implements Comparator<Ouvrage>{
    @Override
    public int compare(Ouvrage o1, Ouvrage o2) {
        return o1.getTitre().compareToIgnoreCase(o2.getTitre());
    }
}
