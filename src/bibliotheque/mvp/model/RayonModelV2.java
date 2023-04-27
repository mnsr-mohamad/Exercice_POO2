package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Rayon;

import java.util.ArrayList;
import java.util.List;

public class RayonModelV2 implements DAO<Rayon>,SpecialRayon{
    private List<Rayon> rayons = new ArrayList<>();
    @Override
    public Rayon add(Rayon lrayon) {
        boolean present = rayons.contains(lrayon);
        if (!present) {
            rayons.add(lrayon);
            return lrayon;
        } else return null;
    }

    @Override
    public boolean remove(Rayon lrayon) {
        return rayons.remove(lrayon);
    }

    @Override
    public Rayon update(Rayon lrayon) {
        boolean present = rayons.contains(lrayon.getCodeRayon());
        if (!present) {
            return lrayon;
        } else return null;
    }

    @Override
    public Rayon read(Rayon rech) {
        int p = rayons.indexOf(rech);
        if(p<0) return null;
        return rayons.get(p);
    }

    @Override
    public List<Rayon> getAll() {
        return rayons;
    }

    @Override
    public List<Exemplaire> lExemplaires(Rayon r) {
        return  r.listerExemplaires();
    }
}
