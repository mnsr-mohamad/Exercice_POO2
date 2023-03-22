package bibliotheque.mvp.model;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Lecteur;

import java.util.ArrayList;
import java.util.List;

public class AuteurModel implements DAOAuteur {

    private List<Auteur> auteurs = new ArrayList<>();

    @Override
    public Auteur addAuteur(Auteur laut) {
        boolean present= auteurs.contains(laut);
        if(!present){
            auteurs.add(laut);
            return laut;
        }
        else return null;
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
        boolean present = auteurs.contains(laut.getNom()) && auteurs.contains(laut.getPrenom());
        if (!present) {
            return laut;
        } else return null;
    }
}
