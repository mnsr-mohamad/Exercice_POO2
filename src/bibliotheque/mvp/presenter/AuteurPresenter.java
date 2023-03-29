package bibliotheque.mvp.presenter;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;
import bibliotheque.metier.Ouvrage;
import bibliotheque.mvp.model.DAOAuteur;
import bibliotheque.mvp.model.SpecialAuteur;
import bibliotheque.mvp.model.SpecialLecteur;
import bibliotheque.mvp.view.AuteurViewInterface;

import java.util.List;

public class AuteurPresenter {
    private DAOAuteur model;
    private AuteurViewInterface view;

    public AuteurPresenter(DAOAuteur model, AuteurViewInterface view) {
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
    }

    public void start() {
        List<Auteur> auteurs = model.getAuteurs();
        view.setListDatas(auteurs);
    }

    public void addAuteur(Auteur auteur) {
        Auteur laut = model.addAuteur(auteur);
        if(laut!=null) view.affMsg("création de :"+laut);
        else view.affMsg("erreur de création");
        List<Auteur> auteurs = model.getAuteurs();
        view.setListDatas(auteurs);
    }


    public void removeAuteur(Auteur auteur) {
        boolean ok = model.removeAuteur(auteur);
        if (ok) view.affMsg("auteur effacé");
        else view.affMsg("auteur non effacé");
        List<Auteur> auteurs = model.getAuteurs();
        view.setListDatas(auteurs);
    }
        public void modifierAuteur(Auteur auteur){

            Auteur laut=model.modifierAuteur(auteur);
            if(laut!=null) view.affMsg("Modification de : "+laut);
            else view.affMsg("erreur de modification");
            List<Auteur> auteurs = model.getAuteurs();
            view.setListDatas(auteurs);
    }

    public void lOuvrage(Auteur a) {
        List<Ouvrage> lex =  ((SpecialAuteur)model).lOuvrage(a);
        if(lex==null || lex.isEmpty()) view.affMsg("aucun ouvrage trouvé");
        else view.affList(lex);
    }
   //finir auteur


}
