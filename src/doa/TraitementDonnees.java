package doa;


import domaine.*;
import exception.ExceptionDateAnterieur;
import exception.ExceptionIdPersonneIntrouvable;
import exception.ExceptionTacheInexistante;
import outils.TypeRandomizer;

import java.util.ArrayList;

public class TraitementDonnees {
    private static TypeRandomizer r = new TypeRandomizer();

    public void AjouterTachesAleatoireArrayPersonne (ArrayList<Personne> arrPersonnes, int idpersonne) throws ExceptionDateAnterieur
    {
        arrPersonnes.get(idpersonne).addTache(new Tache(idpersonne,r.ranndomString(), r.RandomDate(), r.RandomEnum(Status.class), r.RandomEnum(Resolution.class), r.RandomEnum(Mode.class)));
    }


    public void AjouterTacheseArrayPersonne (ArrayList<Personne> arrPersonnes, int idpersonne,String description, String date,Status status, Resolution resolution, Mode mode) throws ExceptionDateAnterieur
    {
        arrPersonnes.get(idpersonne).addTache(new Tache(idpersonne,description,date,status,resolution,mode));
    }

    public void annulerTache(ArrayList<Personne> arrPersonnes,int idpersonne,int idTache)
    {
        arrPersonnes.get(idpersonne).annulerTache(idTache);
    }

    public void replanifierTache( ArrayList<Personne> arrPersonnes, int idpersonne, int idTache , String date)
    {
        arrPersonnes.get(idpersonne).replanifierTache(idTache,date);
    }


    public void attributionTache(ArrayList<Personne> arrPersonnes, int idpersonne, int idTache ) throws ExceptionTacheInexistante {
        Tache t = null;
        for(int i = 0; arrPersonnes.size()>i; i++) {
            t = arrPersonnes.get(i).rechercheTache(idTache,idpersonne);
            if(t != null) {
                arrPersonnes.get(idpersonne).addTache(t);
            }
        }
        throw new ExceptionTacheInexistante();
    }

    public void addPersonne( ArrayList<Personne> arrPersonnes,Personne p)
    {
        arrPersonnes.add(p);
    }

}
