package bibliotheque.mvp.view;

import bibliotheque.metier.Rayon;
import bibliotheque.mvp.presenter.AuteurPresenter;
import bibliotheque.mvp.presenter.RayonPresenter;
import bibliotheque.utilitaires.Utilitaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RayonViewConsole implements RayonViewInterface{

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

    public void menu() {
        List options = new ArrayList<>(Arrays.asList("ajouter", "retirer", "modifier", "fin"));
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
                    System.exit(0);
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
            Rayon rayon= lrayon.get(choix - 1);
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
        Rayon lr = new Rayon(code,genre);
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




}
