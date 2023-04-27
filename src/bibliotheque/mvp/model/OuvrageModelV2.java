package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Ouvrage;

import java.util.ArrayList;
import java.util.List;

public class OuvrageModelV2 implements DAO<Ouvrage>,SpecialOuvrage{

    List<Ouvrage> ouvrages = new ArrayList<>();
    @Override
    public Ouvrage add(Ouvrage ouv) {
        boolean present = ouvrages.contains(ouv);
        if(!present){
            ouvrages.add(ouv);
            return ouv;
        }
        else return null;
    }

    @Override
    public boolean remove(Ouvrage ouv) {
        return ouvrages.remove(ouv);
    }

    @Override
    public Ouvrage update(Ouvrage ouv) {
        boolean present = ouvrages.contains(ouv.getTitre());
        if(!present){
            return ouv;
        }
        else return null;
    }

    @Override
    public Ouvrage read(Ouvrage rech) {
        int p = ouvrages.indexOf(rech);
        if(p<0) return null;
        return ouvrages.get(p);
    }

    @Override
    public List<Ouvrage> getAll() {
        return ouvrages;
    }

    @Override
    public List<Exemplaire> lExemplaire(Ouvrage o) {
        return o.listerExemplaires();
    }

    @Override
    public List<Exemplaire> lExemplaireLoc(Ouvrage o) {
        return o.listerExemplaires();
    }

    @Override
    public double lAmendeEnRetard(Ouvrage o, int nbreJours) {
        return o.amendeRetard(nbreJours);
    }
}
