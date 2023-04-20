package bibliotheque.mvp.model;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Lecteur;
import bibliotheque.metier.Livre;
import bibliotheque.metier.Ouvrage;

import java.util.ArrayList;
import java.util.List;

public class AuteurModel implements DAOAuteur,SpecialAuteur {

    private List<Auteur> auteurs = new ArrayList<>();

    @Override
    public Auteur addAuteur(Auteur laut) {
        boolean present = auteurs.contains(laut);
        if (!present) {
            auteurs.add(laut);
            return laut;
        } else return null;
    }


    @Override
    public boolean removeAuteur(Auteur laut) {
        return auteurs.remove(laut);
    }

    @Override
    public List<Auteur> getAuteurs() {
        return new ArrayList<>(auteurs);
    }

    @Override
    public Auteur modifierAuteur(Auteur laut) {
       /* boolean present = auteurs.contains(laut.getNom()) && auteurs.contains(laut.getPrenom());
        if (!present) {
            return laut;
        } else return null;*/

        int p = auteurs.indexOf(laut);
        if (p<0) {
            return null;
        }
        auteurs.set(p,laut);
        return laut;
    }

    public List<Ouvrage> lOuvrage(Auteur a) {
        return a.listerOuvrages();
    }

    @Override
    public List<Ouvrage> lOuvrageTypeOuvrage(Auteur a, Ouvrage to) {
        return a.listerOuvrages();
    }

    @Override
    public List<Ouvrage> lOuvrageTypeLivre(Auteur a, Livre to) {
        return null;
    }

  /*  @Override
    public List<Ouvrage> lOuvrageTypeLivre(Auteur a, Livre to) {
        return a.listerLivres();
    }*/


}
