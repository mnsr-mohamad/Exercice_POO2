package bibliotheque.mvp.presenter;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;
import bibliotheque.metier.Rayon;
import bibliotheque.mvp.model.DAORayon;
import bibliotheque.mvp.model.SpecialLecteur;
import bibliotheque.mvp.model.SpecialRayon;
import bibliotheque.mvp.view.RayonViewInterface;

import java.util.List;

public class RayonPresenter {

    private DAORayon model;
    private RayonViewInterface view;

    public RayonPresenter(DAORayon model, RayonViewInterface view) {
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
    }
    public void start() {
        List<Rayon> rayons = model.getRayon();
        view.setListDatas(rayons);
    }

    public void addRayon(Rayon rayon) {
        Rayon lrayon = model.addRayon(rayon);
        if(lrayon!=null) view.affMsg("création de :"+lrayon);
        else view.affMsg("erreur de création");
        List<Rayon> rayons = model.getRayon();
        view.setListDatas(rayons);
    }


    public void removeRayon(Rayon rayon) {
        boolean ok = model.removeRayon(rayon);
        if(ok) view.affMsg("rayon effacé");
        else view.affMsg("rayon non effacé");
        List<Rayon> rayons = model.getRayon();
        view.setListDatas(rayons);
    }


    public void modifierRayon(Rayon rayon){

        Rayon lrayon=model.modifierRayon(rayon);
        if(lrayon!=null) view.affMsg("Modification de : "+lrayon);
        else view.affMsg("erreur de modification");
        List<Rayon> rayons = model.getRayon();
        view.setListDatas(rayons);


    }

    public void lExemplaires(Rayon r) {
        List<Exemplaire> lex =   ((SpecialRayon)model).lExemplaires(r);
        if(lex==null || lex.isEmpty()) view.affMsg("aucun exemplaire trouvé");
        else view.affList(lex);
    }


}
