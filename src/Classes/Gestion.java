package Classes;

import java.time.LocalDate;

public class Gestion {
    public static void main(String[] args){

        Auteur a = new Auteur("Verne","Jules","France");
        Livre l = new Livre("Vingt mille lieues sous les mers",10, LocalDate.of(1880,1,1),1.50,"français","aventure","a125",350,TypeLivre.ROMAN,"histoire de sous-marin");
        //a.getLouvrage().add(l);
        //l.getLauteurs().add(a);
        addLouvrage(a, l);
        addLauteur(l, a);
        Rayon r=new Rayon("120DFC","Bibliothèque");
        Exemplaire e = new Exemplaire("m12","état neuf",l);
        e.setRayon(r);
        r.getLex().add(e);
        Lecteur lec = new Lecteur(1,"Dupont","Jean", LocalDate.of(2000,1,4),"Mons","jean.dupont@mail.com","0458774411");
        Location loc = new Location(LocalDate.of(2023,2,1),LocalDate.of(2023,3,1),lec,e);
        lec.getLloc().add(loc);
        e.getLloc().add(loc);
        System.out.println(a);
        System.out.println(a.getLouvrage());
        System.out.println(l);
        System.out.println(l.getLauteurs());
        System.out.println(r);
        System.out.println(e);
        System.out.println(lec);
        System.out.println(loc);




    }
    public static void addLouvrage(Auteur a, Livre l) {
        a.getLouvrage().add(l);
    }

    public static void addLauteur(Livre l, Auteur a) {
        l.getLauteurs().add(a);
    }

}
