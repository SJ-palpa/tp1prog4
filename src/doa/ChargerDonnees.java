package doa;

import domaine.*;
import exception.ExceptionDateAnterieur;
import outils.TypeRandomizer;
import java.util.ArrayList;

public class ChargerDonnees {

    private static TypeRandomizer r = new TypeRandomizer();

    public ArrayList<Personne> DonneesCompleteAleatoire() throws ExceptionDateAnterieur {
        ArrayList<Personne> arrPersonnes = new ArrayList();
        ArrayList<Groupe> arrGroupe = new ArrayList();
        int taille = 30;
        for (int i = 0; taille > i; i++)
        {
            ArrayList<Tache> arrTaches = new ArrayList();
            int taille2= 10;
            for (int x = 0; taille2>x; x++)
            {
                Tache tache = new Tache(i,r.ranndomString(),r.RandomDate(),r.RandomEnum(Status.class), r.RandomEnum(Resolution.class), r.RandomEnum(Mode.class));
                arrTaches.add(tache);
                arrGroupe.add(new Groupe(r.RanndomInt(6,0),i,tache.getIdTache()));
            }
            arrPersonnes.add(new Personne(r.ranndomString(), r.ranndomString(),arrTaches));
        }
        return arrPersonnes;
    }


}
