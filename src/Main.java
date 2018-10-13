import domaine.*;
import exception.ExceptionDateAnterieur;
import doa.*;
import exception.ExceptionTacheInexistante;
import vue.*;

import java.util.ArrayList;

public class Main {

    private static ArrayList<Personne> arrPersonnes = null;
    private static ChargerDonnees donnees = new ChargerDonnees();
    private static TraitementDonnees traitement = new TraitementDonnees();
    private static AffichageDonne aff = new AffichageDonne();

    public static void main(String[] args) throws ExceptionDateAnterieur, ExceptionTacheInexistante
    {
        arrPersonnes = donnees.DonneesCompleteAleatoire();
        aff.afficherDonne(arrPersonnes);
        aff.consulterTache(arrPersonnes);
        traitement.AjouterTachesAleatoireArrayPersonne(arrPersonnes,29);
        traitement.AjouterTacheseArrayPersonne (arrPersonnes,29,"description","18-09-2020",Status.OPEN,Resolution.STANDBY,Mode.PARTAGE);
        traitement.addPersonne(arrPersonnes,new Personne("kmsc", "mksmxk"));
        traitement.annulerTache(arrPersonnes,29,301);
        traitement.replanifierTache(arrPersonnes,29,  301 , "02-12-2020");
        traitement.attributionTache(arrPersonnes,30, 60 );



        aff.consulterTacheDate(arrPersonnes,"08-09-2018");
        aff.consulterTacheStatus(arrPersonnes,Status.CANCELED);
        aff.rappelUnjourAvant(arrPersonnes);
        aff.rappelTacheDateDepasse(arrPersonnes);
        aff.afficherDonne(arrPersonnes);



        // Question :
        // Pourquoi faire des Interfaces dans notre cas ?

        // get(idPersonne) -> je devrais utiliser le equals
        // qui doit faire la tache il doit y avoir un attribut personneFaitTache dans tache!

    }

}
