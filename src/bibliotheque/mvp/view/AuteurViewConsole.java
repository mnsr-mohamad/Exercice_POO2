package bibliotheque.mvp.view;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Lecteur;
import bibliotheque.metier.Ouvrage;
import bibliotheque.mvp.presenter.AuteurPresenter;
import bibliotheque.utilitaires.Utilitaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.affListe;
import static bibliotheque.utilitaires.Utilitaire.choixElt;

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

    @Override
    public void affList(List<Ouvrage> lex) {
        affListe(lex);
    }

    public void menu() {
        List options = new ArrayList<>(Arrays.asList("ajouter", "retirer", "modifier",  "special" ,"revenir en arrière"));
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

                case 5 :
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

    private void special(){

        int choix =  choixElt(laut);
    Auteur aut  = laut.get(choix-1);
        do {
            System.out.println("1.Lister Ouvrage\n2.Lister Ouvrage type de livre\n3.Lister ouvrage avec type d'ouvrage\n4.menu principal");
            System.out.println("choix : ");
            int ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    presenter.lOuvrage(aut);
                    break;
                case 2:
                   // presenter.exemplairesLoues(aut);
                    break;
                case 3: return;
                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (true);





    }


}
