package vue;

import domaine.Personne;
import domaine.Status;

import java.util.ArrayList;

public class AffichageDonne {

    public void rappelTacheDateDepasse(ArrayList<Personne> arrPersonnes)
    {
        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                        Rappel taches date depasse                              ");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        for(int i = 0; arrPersonnes.size()>i ; i++)
        {
            arrPersonnes.get(i).rappelTacheDateDepasse();
        }

    }

    public void rappelUnjourAvant(ArrayList<Personne> arrPersonnes)
    {
        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                        Rappel taches un jours avant                            ");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        for(int i = 0; arrPersonnes.size()>i ; i++)
        {
            arrPersonnes.get(i).rappelUnjourAvant();
        }

    }


    public void consulterTache(ArrayList<Personne> arrPersonnes){
        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                             Affichage taches                                   ");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        for(int i = 0; arrPersonnes.size()>i ; i++)
        {
            System.out.println(arrPersonnes.get(i).afficherTaches());
        }
    }

    public void consulterTacheStatus(ArrayList<Personne> arrPersonnes ,Status status){
        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                             Affichage taches status "+ status +"               ");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        for(int i = 0; arrPersonnes.size()>i ; i++)
        {
            System.out.println(arrPersonnes.get(i).afficherTachesStatus(status));
        }
    }

    public void consulterTacheDate(ArrayList<Personne> arrPersonnes,String date){
        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                      Affichage taches du "+ date +"                            ");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        for(int i = 0; arrPersonnes.size()>i ; i++)
        {
            System.out.println(arrPersonnes.get(i).afficherTachesDate(date));
        }
    }

    public void afficherDonne(ArrayList<Personne> arrPersonnes)
    {
        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                             Affichage données                                  ");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        for(int i = 0; arrPersonnes.size()>i ; i++)
        {
            System.out.println(arrPersonnes.get(i));
            System.out.println(arrPersonnes.get(i).afficherTaches());
        }
    }

}
