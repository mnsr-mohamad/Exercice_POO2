package bibliotheque.mvp.view;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeOuvrage;
import bibliotheque.mvp.presenter.OuvragePresenter;
import bibliotheque.utilitaires.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.affListe;
import static bibliotheque.utilitaires.Utilitaire.choixElt;

public class OuvrageViewConsole implements OuvrageViewInterface {
    private OuvragePresenter presenter;
    private List<Ouvrage> louv;
    private Scanner sc = new Scanner(System.in);

    public OuvrageViewConsole() {
    }

    @Override
    public void setPresenter(OuvragePresenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void setListDatas(List<Ouvrage> ouvrages) {
        this.louv=ouvrages;
        Utilitaire.affListe(louv);
        menu();
    }

    @Override
    public void affMsg(String msg) {
        System.out.println("information : " + msg);
    }

    @Override
    public void affList(List<Exemplaire> lex) {
        affListe(lex);
    }

    public void menu() {
        List options = new ArrayList<>(Arrays.asList("ajouter", "retirer", "modifier","special" ,"fin"));
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
                    System.exit(0);
            }
        } while (true);
    }

    private void modifier() {
        //Obligatoire d'écrire la date en format YYYY-MM-DD
        if(!louv.isEmpty()){
            Utilitaire.affListe(louv);
            int choix = Utilitaire.choixElt(louv);
            Ouvrage ouv = louv.get(choix-1);
            String ageMin = modifyIfNotBlank("age min",ouv.getAgeMin()+"");
            String dateParution = modifyIfNotBlank("date de parution",ouv.getDateParution()+"");
            String prixLocation = modifyIfNotBlank("prix location",ouv.getPrixLocation()+"");
            String langue = modifyIfNotBlank("langue",ouv.getLangue());
            String genre = modifyIfNotBlank("genre",ouv.getGenre());
            ouv.setAgeMin(Integer.parseInt(ageMin));
            ouv.setDateParution(LocalDate.parse(dateParution));
            ouv.setPrixLocation(Double.parseDouble(prixLocation));
            ouv.setLangue(langue);
            ouv.setGenre(genre);
            presenter.modifOuvrage(ouv);
        } else System.out.println("Aucun élément présent dans la liste");
    }

    private void retirer() {
        if(!louv.isEmpty()){
            Utilitaire.affListe(louv);
            int choix = Utilitaire.choixElt(louv);
            Ouvrage ouv = louv.get(choix-1);
            presenter.removeOuvrage(ouv);
        } else System.out.println("Aucun élément présent dans la liste");
    }

    private void ajouter() {
        TypeOuvrage[] tto = TypeOuvrage.values();
        List<TypeOuvrage> lto = new ArrayList<>(Arrays.asList(tto));
        int choix = Utilitaire.choixListe(lto);
        Ouvrage o = null;
        List<OuvrageFactory> lof = new ArrayList<>(Arrays.asList(new LivreFactory(),new CDFactory(),new DVDFactory()));
        o = lof.get(choix-1).create();
        presenter.addOuvrage(o);
    }

    public String modifyIfNotBlank(String label,String oldValue){
        System.out.println(label+" : "+oldValue);
        System.out.print("Nouvelle valeur (enter si pas de changement) : ");
        String newValue= sc.nextLine();
        if(newValue.isBlank()) return oldValue;
        return newValue;
    }


    private void special(){
        int choix =  choixElt(louv);
        Ouvrage llouv = louv.get(choix-1);
        do {
            System.out.println("1.Afficher exemplaire\n2.Exemplaires en Location\n3.Amende\n4.revenir au menu principal");
            System.out.println("choix : ");
            int ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    presenter.lExemplaire(llouv);
                    break;
                case 2:
                    presenter.lExemplaireLoc(llouv);
                    break;
                case 3:
                    //presenter.lAmendeEnRetard(llouv);
                    break;
                case 4 :
                    return;
                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (true);





    }
}