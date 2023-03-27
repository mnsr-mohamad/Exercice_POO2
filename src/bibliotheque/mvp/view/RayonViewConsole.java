package bibliotheque.mvp.view;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Rayon;
import bibliotheque.mvp.presenter.AuteurPresenter;
import bibliotheque.mvp.presenter.RayonPresenter;
import bibliotheque.utilitaires.Utilitaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.affListe;
import static bibliotheque.utilitaires.Utilitaire.choixElt;

public class RayonViewConsole implements RayonViewInterface {

    private RayonPresenter presenter;
    private List<Rayon> lrayon;
    private Scanner sc = new Scanner(System.in);

    public RayonViewConsole() {

    }

    @Override
    public void setPresenter(RayonPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setListDatas(List<Rayon> rayons) {
        this.lrayon = rayons;
        Utilitaire.affListe(lrayon);
        menu();
    }

    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }

    @Override
    public void affList(List<Exemplaire> lex) {
        affListe(lex);
    }

    public void menu() {
        List options = new ArrayList<>(Arrays.asList("ajouter", "retirer", "modifier", "special ", "revenir en arrière"));
        do {
            int ch = Utilitaire.choixListe(options);

            switch (ch) {
                case 1:
                    ajouter();
                    break;
                case 2:
                    retirer();
                    break;
                case 3:
                    modifier();
                    break;
                case 4:
                    special();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    private void modifier() {


        if (!lrayon.isEmpty()) {
            Utilitaire.affListe(lrayon);
            int choix = Utilitaire.choixElt(lrayon);
            Rayon rayon = lrayon.get(choix - 1);
            opModification(rayon);
        } else {
            System.out.println("Aucun rayon trouvé");
        }


    }

    private void retirer() {
        if (!lrayon.isEmpty()) {
            Utilitaire.affListe(lrayon);
            int choix = Utilitaire.choixElt(lrayon);
            Rayon rayon = lrayon.get(choix - 1);
            presenter.removeRayon(rayon);
        } else {
            System.out.println("Aucun rayon trouvé");
        }

    }


    private void ajouter() {
        System.out.println("code :  ");
        String code = sc.nextLine();
        System.out.println("genre :  ");
        String genre = sc.nextLine();
        Rayon lr = new Rayon(code, genre);
        presenter.addRayon(lr);
    }

    public void opModification(Rayon rayon) {
        List options = new ArrayList<>(Arrays.asList("Code", "Genre", "Revenir en arrière"));
        do {
            int ch = Utilitaire.choixListe(options);

            switch (ch) {
                case 1:
                    System.out.println("code :  ");
                    String code = sc.nextLine();
                    rayon.setCodeRayon(code);
                    break;
                case 2:
                    System.out.println("genre :  ");
                    String genre = sc.nextLine();
                    rayon.setGenre(genre);
                    break;
                case 3:
                    return;
            }
            presenter.modifierRayon(rayon);

        } while (true);


    }

    private void special() {

        int choix = choixElt(lrayon);
        Rayon ray = lrayon.get(choix - 1);
        do {
            System.out.println("1.Exemplaire selon le rayon\n2.menu principal");
            System.out.println("choix : ");
            int ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    presenter.lExemplaires(ray);
                    break;
                case 2:
                    return;

                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (true);


    }


}



