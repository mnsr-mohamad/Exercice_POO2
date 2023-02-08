package Classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Lecteur extends Personne {

    private int numLecteur;
    private String mail;
    private String adresse;
    private String tel;
    private List<Location> loc = new ArrayList<>();


    public Lecteur(String nom, String prenom, LocalDate dn) {
        super(nom, prenom, dn);
        this.numLecteur = numLecteur;
        this.adresse = adresse;
        this.mail = mail;
        this.tel = tel;
    }

    public Lecteur(String nom, String prenom, LocalDate dn, int numLecteur, String mail, String adresse, String tel, List<Location> loc) {
        super(nom, prenom, dn);
        this.numLecteur = numLecteur;
        this.mail = mail;
        this.adresse = adresse;
        this.tel = tel;
        this.loc = loc;
    }

    public int getNumLecteur() {
        return numLecteur;
    }

    public void setNumLecteur(int numLecteur) {
        this.numLecteur = numLecteur;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<Location> getLoc() {
        return loc;
    }

    public void setLoc(List<Location> loc) {
        this.loc = loc;
    }


    @Override
    public String toString() {
        return "Lecteur{" +
                "numLecteur=" + numLecteur +
                ", mail='" + mail + '\'' +
                ", adresse='" + adresse + '\'' +
                ", tel='" + tel + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dn=" + dn +
                '}';
    }

    public void listerExemplairesEnLocation() {


    }

    public void listerExemplairesEnLoues() {


    }
}
