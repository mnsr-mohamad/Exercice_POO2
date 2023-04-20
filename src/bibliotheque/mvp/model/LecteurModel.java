package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
public class LecteurModel implements DAOLecteur,SpecialLecteur {
    private int numcli =0;
    private List<Lecteur> lecteurs = new ArrayList<>();
    public LecteurModel(){
        populate();
    }



    @Override
    public Lecteur addLecteur(Lecteur lec) {
        boolean present= lecteurs.contains(lec);
        if(!present){
            numcli++;
            lec.setNumlecteur(numcli);
            lecteurs.add(lec);
            return lec;
        }
        else return null;
    }

    @Override
    public boolean removeLecteur(Lecteur lec) {
        return lecteurs.remove(lec);
    }

    @Override
    public List<Lecteur> getLecteurs() {
        return new ArrayList<>(lecteurs);
    }

    @Override
    public Lecteur modifierLecteur(Lecteur lec) {
        boolean present= lecteurs.contains(lec.getNumlecteur());
        if(!present){
           return lec;
        }
        else return null;
    }

    @Override
    public Lecteur readLecteur(int idLecteur) {
        for (Lecteur l : lecteurs) {
            if (l.getNumlecteur() == idLecteur) return l;
        }
        return null;
    }
    private void populate(){
        try{
            Lecteur lec = new Lecteur(0,"Dupont","Jean", LocalDate.of(2000,1,4),"Mons","jean.dupont@mail.com","0458774411");
            addLecteur(lec);
            lec = new Lecteur(0,"Durant","Aline",LocalDate.of(1980,10,10),"Binche","aline.durant@mail.com","045874444");
            addLecteur(lec);
        }
        catch (Exception e ){
            System.out.println("Une erreur est survenue "+e);
        }

    }
    @Override
    public List<Exemplaire> exemplairesEnLocation(Lecteur l) {
        return l.listerExemplairesEnLocation();
    }

    @Override
    public List<Exemplaire> exemplairesLoues(Lecteur l) {
        return new ArrayList<>(l.listerExemplairesLoues());
    }


}

