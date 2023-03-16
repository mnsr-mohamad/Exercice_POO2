package bibliotheque.mvp.model;

import bibliotheque.metier.Lecteur;

import java.util.List;

public interface DAOLecteur {
    Lecteur addLecteur(Lecteur lec);

    boolean removeLecteur(Lecteur lec);

    List<Lecteur> getLecteurs();

    Lecteur modifierLecteur(Lecteur lec);
}