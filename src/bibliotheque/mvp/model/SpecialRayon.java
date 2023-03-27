package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;
import bibliotheque.metier.Rayon;

import java.util.List;

public interface SpecialRayon {

    public List<Exemplaire> lExemplaires(Rayon r);


}
