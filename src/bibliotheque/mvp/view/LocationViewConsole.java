package bibliotheque.mvp.view;

import bibliotheque.metier.*;
import bibliotheque.mvp.presenter.LecteurPresenter;
import bibliotheque.mvp.presenter.LocationPresenter;
import bibliotheque.mvp.presenter.RayonPresenter;
import bibliotheque.mvp.presenter.SpecialLocationPresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static bibliotheque.utilitaires.Utilitaire.*;
import static bibliotheque.utilitaires.Utilitaire.modifyIfNotBlank;

public class LocationViewConsole extends AbstractViewConsole<Location> implements SpecialLocationViewConsole {
    protected  List<Exemplaire> lex;
    @Override
    protected void rechercher() {

    }

    @Override
    protected void modifier() {
        int choix = choixElt(ldatas);
        Location l = ldatas.get(choix-1);
        do {
            try {
                l.enregistrerRetour();
                break;
            } catch (Exception e) {
                System.out.println("erreur :" + e);
            }
        }while(true);
        presenter.update(l);
        ldatas=presenter.getAll();//rafraichissement
        affListe(ldatas);
    }

    @Override
    protected void ajouter() {
        Lecteur l = ((LocationPresenter) presenter).choixLecteur();
        Exemplaire ex = null;
        boolean exemplaireDisponible = false;

        while (!exemplaireDisponible) {
            ex = ((LocationPresenter) presenter).choixExemplaire();

            boolean exemplairePris = false;
            for (Location loc : ldatas) {
                if (loc.getExemplaire().equals(ex)) {
                    System.out.println("Exemplaire déjà pris, veuillez choisir un autre exemplaire.");
                    exemplairePris = true;
                    break;
                }
            }

            if (!exemplairePris) {
                exemplaireDisponible = true;
            }
        }

        Location loc = new Location(l, ex);
        presenter.add(loc);
       /* boolean ok = true;
        Lecteur l = ((LocationPresenter) presenter).choixLecteur();
        Exemplaire ex = ((LocationPresenter) presenter).choixExemplaire();
        ok=ex.enLocation();
        if(ok){
            System.out.println("Exemplaire deja prit");
        }
        Location loc= new Location(l, ex);
        presenter.add(loc);*/



    }

    @Override
    protected void special() {
        /*int choix =  choixElt(ldatas);
        Location l = ldatas.get(choix-1);

        List options = new ArrayList<>(Arrays.asList("calculer amende","enregistrer retour","fin"));
        do {
            int ch = choixListe(options);

            switch (ch) {

                case 1:
                    amende(l);
                    break;
                case 2:
                    retour(l);
                    break;
                case 3 :return;
            }
        } while (true);
*/List<Location> locationsEnCours = new ArrayList<>();
        for (Location loc : ldatas) {
            if (loc.getDateRestitution() == null) {
                locationsEnCours.add(loc);
            }
        }
        int choix =  choixElt(locationsEnCours);
        Location l = locationsEnCours.get(choix-1);

        List options = new ArrayList<>(Arrays.asList("calculer amende","enregistrer retour","fin"));
        do {
            int ch = choixListe(options);

            switch (ch) {

                case 1:
                    amende(l);
                    break;
                case 2:
                    retour(l);
                    break;
                case 3 :return;
            }
        } while (true);
    }

    @Override
    public void retour(Location l) {
        ((SpecialLocationPresenter)presenter).enregistrerRetour(l);
    }

    @Override
    public void amende(Location l) {
        ((SpecialLocationPresenter)presenter).calculerAmende(l);
    }
}
