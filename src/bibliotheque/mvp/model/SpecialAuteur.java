package bibliotheque.mvp.model;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Livre;
import bibliotheque.metier.Ouvrage;

import java.util.List;

public interface SpecialAuteur {

    public List<Ouvrage> lOuvrage(Auteur a );
    public List<Ouvrage> lOuvrageTypeOuvrage(Auteur a,Ouvrage to);
    public List<Ouvrage> lOuvrageTypeLivre(Auteur a, Livre to);
    //public List<Ouvrage>

}
