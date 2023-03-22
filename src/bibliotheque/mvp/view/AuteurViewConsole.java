package bibliotheque.mvp.view;

import bibliotheque.metier.Auteur;
import bibliotheque.mvp.presenter.AuteurPresenter;
import bibliotheque.utilitaires.Utilitaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AuteurViewConsole implements AuteurViewInterface {
    private AuteurPresenter presenter;
    private List<Auteur> laut;
    private Scanner sc = new Scanner(System.in);

    public AuteurViewConsole() {

    }

    @Override
    public void setPresenter(AuteurPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setListDatas(List<Auteur> auteurs) {
        this.laut = auteurs;
        Utilitaire.affListe(laut);
        menu();
    }

    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }

    public void menu() {
        List options = new ArrayList<>(Arrays.asList("ajouter", "retirer", "modifier",  "revenir en arrière"));
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
                    return;
            }
        } while (true);
    }

    private void ajouter() {
        System.out.println("nom : ");
        String nom = sc.nextLine();
        System.out.println("prénom :  ");
        String prenom = sc.nextLine();
        System.out.println("nationalité : ");
        String nationalite = sc.nextLine();
        Auteur laut = new Auteur(nom, prenom, nationalite);
        presenter.addAuteur(laut);
    }

    private void retirer() {
        if (!laut.isEmpty()) {
            Utilitaire.affListe(laut);
            int choix = Utilitaire.choixElt(laut);
            Auteur auteur = laut.get(choix - 1);
            presenter.removeAuteur(auteur);
        } else {
            System.out.println("Aucun auteur trouvé");
        }

    }

    private void modifier() {

        if (!laut.isEmpty()) {
            Utilitaire.affListe(laut);
            int choix = Utilitaire.choixElt(laut);
            Auteur auteur = laut.get(choix - 1);
            opModification(auteur);
        } else {
            System.out.println("Aucun auteur trouvé");
        }
    }

    public void opModification(Auteur auteur) {
        List options = new ArrayList<>(Arrays.asList("Nom", "Prenom", "Nationalité", "Revenir en arrière"));
        do {
            int ch = Utilitaire.choixListe(options);

            switch (ch) {
                case 1:
                    System.out.println("nom :  ");
                    String nom = sc.nextLine();
                    auteur.setNom(nom);
                    break;
                case 2:
                    System.out.println("prénom :  ");
                    String prenom = sc.nextLine();
                    auteur.setPrenom(prenom);
                    break;
                case 3:
                    System.out.println("nationalité : ");
                    String nationalite = sc.nextLine();
                    auteur.setNationalite(nationalite);
                    break;
                case 4:
                    return;
            }
            presenter.modifierAuteur(auteur);

        } while (true);


    }


}
