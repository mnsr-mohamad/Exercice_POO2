package bibliotheque.mvp.model;

import bibliotheque.metier.Auteur;

import java.util.List;

public interface DAOAuteur {

    Auteur addAuteur(Auteur laut);

    boolean removeAuteur(Auteur laut);

    List<Auteur> getAuteurs();

    Auteur modifierAuteur(Auteur laut);
}
