package bibliotheque.mvp.view;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;
import bibliotheque.mvp.presenter.LecteurPresenter;
import bibliotheque.utilitaires.Utilitaire;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.affListe;
import static bibliotheque.utilitaires.Utilitaire.choixElt;

public class LecteurViewConsole implements LecteurViewInterface {
    private LecteurPresenter presenter;
    private List<Lecteur> llec;
    private Scanner sc = new Scanner(System.in);

    public LecteurViewConsole() {

    }

    @Override
    public void setPresenter(LecteurPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setListDatas(List<Lecteur> lecteurs) {
        this.llec = lecteurs;
        Utilitaire.affListe(llec);
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
        List options = new ArrayList<>(Arrays.asList("ajouter", "retirer", "modifier", "rechercher","special", "revenir en arrière"));
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
                    rechercher();
                    break;
                case 5:
                    special();
                    break;
                case 6 :
                    return;
            }
        } while (true);
    }

    private void modifier() {
        //TODO choisir elt et demander les nouvelles valeurs puis appeler méthode maj(lecteur) (à développer) du presenter

        if (!llec.isEmpty()) {
            Utilitaire.affListe(llec);
            int choix = Utilitaire.choixElt(llec);
            Lecteur lecteur = llec.get(choix - 1);
            opModification(lecteur);
        } else {
            System.out.println("Aucun lecteur trouvé");
        }


    }

    private void retirer() {
        if (!llec.isEmpty()) {
            Utilitaire.affListe(llec);
            int choix = Utilitaire.choixElt(llec);
            Lecteur lecteur = llec.get(choix - 1);
            presenter.removeLecteur(lecteur);
        } else {
            System.out.println("Aucun lecteur trouvé");
        }

    }

    private void rechercher() {
        System.out.println("numLecteur : ");
        int idLecteur = sc.nextInt();
        presenter.search(idLecteur);
    }
    private void ajouter() {
        System.out.println("nom ");
        String nom = sc.nextLine();
        System.out.println("prénom ");
        String prenom = sc.nextLine();
        System.out.println("date de naissance");
        String[] jma = sc.nextLine().split(" ");
        int j = Integer.parseInt(jma[0]);
        int m = Integer.parseInt(jma[1]);
        int a = Integer.parseInt(jma[2]);
        LocalDate dn = LocalDate.of(a, m, j);
        System.out.println("adresse");
        String adr = sc.nextLine();
        System.out.println("mail");
        String mail = sc.nextLine();
        System.out.println("tel ");
        String tel = sc.nextLine();
        Lecteur lec = new Lecteur(0, nom, prenom, dn, adr, mail, tel);
        presenter.addLecteur(lec);
    }

    public void opModification(Lecteur lecteur) {
        List options = new ArrayList<>(Arrays.asList("Nom", "Prenom", "Date de naissance", "Adresse", "Mail", "Tel", "Revenir en arrière"));
        do {
            int ch = Utilitaire.choixListe(options);

            switch (ch) {
                case 1:
                    System.out.println("nom :  ");
                    String nom = sc.nextLine();
                    lecteur.setNom(nom);
                    break;
                case 2:
                    System.out.println("prénom :  ");
                    String prenom = sc.nextLine();
                    lecteur.setPrenom(prenom);
                    break;
                case 3:
                    System.out.println("date de naissance : ");
                    String[] jma = sc.nextLine().split(" ");
                    int j = Integer.parseInt(jma[0]);
                    int m = Integer.parseInt(jma[1]);
                    int a = Integer.parseInt(jma[2]);
                    LocalDate dn = LocalDate.of(a, m, j);
                    lecteur.setDn(dn);
                    break;
                case 4:
                    System.out.println("adresse : ");
                    String adr = sc.nextLine();
                    lecteur.setAdresse(adr);
                    break;
                case 5:
                    System.out.println("mail : ");
                    String mail = sc.nextLine();
                    lecteur.setMail(mail);
                    break;
                case 6:
                    System.out.println("tel :  ");
                    String tel = sc.nextLine();
                    lecteur.setTel(tel);
                    break;
                case 7:
                    return;
            }
            presenter.modifierLecteur(lecteur);

        } while (true);

    }
    private void special(){

    int choix =  choixElt(llec);
    Lecteur lec = llec.get(choix-1);
            do {
        System.out.println("1.Exemplaire en location\n2.Exemplaires loués\n3.menu principal");
        System.out.println("choix : ");
        int ch = sc.nextInt();
        sc.skip("\n");
        switch (ch) {
            case 1:
                presenter.exemplairesEnLocation(lec);
                break;
            case 2:
                presenter.exemplairesLoues(lec);
                break;
            case 3: return;
            default:
                System.out.println("choix invalide recommencez ");
        }
    } while (true);


}

}

