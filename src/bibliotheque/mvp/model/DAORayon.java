package bibliotheque.mvp.model;

import bibliotheque.metier.Rayon;

import java.util.List;

public interface DAORayon {

    Rayon addRayon(Rayon lrayon);

    boolean removeRayon(Rayon lrayon);

    List<Rayon> getRayon();

    Rayon modifierRayon(Rayon lrayon);


}
