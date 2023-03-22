package bibliotheque.mvp;

import bibliotheque.mvp.model.*;
import bibliotheque.mvp.presenter.AuteurPresenter;
import bibliotheque.mvp.presenter.LecteurPresenter;
import bibliotheque.mvp.presenter.RayonPresenter;
import bibliotheque.mvp.view.*;
import bibliotheque.utilitaires.Utilitaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GestBiblio {

    public static void main(String[] args) {
        List options = new ArrayList<>(Arrays.asList("Lecteur", "Auteur", "Rayon", "Fin"));
        do {
            int ch = Utilitaire.choixListe(options);

            switch (ch) {
                case 1:
                    DAOLecteur lm = new LecteurModel();
                    LecteurViewInterface lv = new LecteurViewConsole();
                    LecteurPresenter lp = new LecteurPresenter(lm, lv);
                    lp.start();
                    break;
                case 2:
                    DAOAuteur am = new AuteurModel();
                    AuteurViewInterface av = new AuteurViewConsole();
                    AuteurPresenter ap = new AuteurPresenter(am, av);
                    ap.start();
                    break;
                case 3:
                    DAORayon rm = new RayonModel();
                    RayonViewInterface rv = new RayonViewConsole();
                    RayonPresenter rp = new RayonPresenter(rm, rv);
                    rp.start();
                    break;

                case 4:
                    System.exit(0);
            }

        } while (true);


    }

}