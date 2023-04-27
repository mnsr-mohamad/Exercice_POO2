package bibliotheque.mvp.model;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Livre;
import bibliotheque.metier.Ouvrage;

import java.util.ArrayList;
import java.util.List;

public class AuteurModelV2 implements DAO<Auteur>,SpecialAuteur{

    private List<Auteur> auteurs = new ArrayList<>();

    @Override
    public Auteur add(Auteur laut) {
        boolean present = auteurs.contains(laut);
        if (!present) {
            auteurs.add(laut);
            return laut;
        } else return null;
    }

    @Override
    public boolean remove(Auteur laut) {
        return auteurs.remove(laut);
    }

    @Override
    public Auteur update(Auteur laut) {
        int p = auteurs.indexOf(laut);
        if (p<0) {
            return null;
        }
        auteurs.set(p,laut);
        return laut;
    }

    @Override
    public Auteur read(Auteur rech) {
        int p = auteurs.indexOf(rech);
        if(p<0) return null;
        return auteurs.get(p);
    }

    @Override
    public List<Auteur> getAll() {
        return auteurs;
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
}
