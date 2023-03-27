package bibliotheque.mvp.presenter;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;
import bibliotheque.mvp.model.DAOLecteur;
import bibliotheque.mvp.model.SpecialLecteur;
import bibliotheque.mvp.view.LecteurViewInterface;

import java.util.List;

public class LecteurPresenter {
    private DAOLecteur model;
    private LecteurViewInterface view;

    public LecteurPresenter(DAOLecteur model, LecteurViewInterface view) {
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
    }

    public void start() {
        List<Lecteur> lecteurs = model.getLecteurs();
        view.setListDatas(lecteurs);
    }

    public void addLecteur(Lecteur lecteur) {
        Lecteur lec = model.addLecteur(lecteur);
        if(lec!=null) view.affMsg("création de :"+lec);
        else view.affMsg("erreur de création");
        List<Lecteur> lecteurs = model.getLecteurs();
        view.setListDatas(lecteurs);
    }


    public void removeLecteur(Lecteur lecteur) {
        boolean ok = model.removeLecteur(lecteur);
        if(ok) view.affMsg("lecteur effacé");
        else view.affMsg("lecteur non effacé");
        List<Lecteur> lecteurs = model.getLecteurs();
        view.setListDatas(lecteurs);
    }


    public void modifierLecteur(Lecteur lecteur){

        Lecteur lec=model.modifierLecteur(lecteur);
        if(lec!=null) view.affMsg("Modification de : "+lec);
        else view.affMsg("erreur de modification");
        List<Lecteur> lecteurs = model.getLecteurs();
        view.setListDatas(lecteurs);


    }
    public void search(int idLecteur) {
        Lecteur l = model.readLecteur(idLecteur);
        if(l==null) view.affMsg("recherche infructueuse");
        else view.affMsg(l.toString());
    }

    public void exemplairesEnLocation(Lecteur l) {
        List<Exemplaire> lex =   ((SpecialLecteur)model).exemplairesEnLocation(l);
        if(lex==null || lex.isEmpty()) view.affMsg("aucun exemplaire trouvé");
        else view.affList(lex);
    }
    public void exemplairesLoues(Lecteur l) {
        List<Exemplaire> lex =   ((SpecialLecteur)model).exemplairesLoues(l);
        if(lex==null || lex.isEmpty()) view.affMsg("aucun exemplaire trouvé");
        else view.affList(lex);
    }
}
