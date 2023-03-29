package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Ouvrage;

import java.util.List;

public interface SpecialOuvrage {

    public List<Exemplaire> lExemplaire (Ouvrage o);
    public List<Exemplaire> lExemplaireLoc (Ouvrage o);
    public double lAmendeEnRetard (Ouvrage o , int nbreJours);





}
