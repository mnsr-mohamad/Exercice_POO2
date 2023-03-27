package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;
import bibliotheque.metier.Rayon;

import java.util.ArrayList;
import java.util.List;

public class RayonModel implements DAORayon,SpecialRayon {
    private List<Rayon> rayons = new ArrayList<>();


    @Override
    public Rayon addRayon(Rayon lrayon) {
        boolean present = rayons.contains(lrayon);
        if (!present) {
            rayons.add(lrayon);
            return lrayon;
        } else return null;
    }

    @Override
    public boolean removeRayon(Rayon lrayon) {
        return rayons.remove(lrayon);
    }

    @Override
    public List<Rayon> getRayon() {
        return new ArrayList<>(rayons);
    }

    @Override
    public Rayon modifierRayon(Rayon lrayon) {
        boolean present = rayons.contains(lrayon.getCodeRayon());
        if (!present) {
            return lrayon;
        } else return null;
    }


    @Override
    public List<Exemplaire> lExemplaires(Rayon r) {
    return  r.listerExemplaires();
    }
}

