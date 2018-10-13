import doa.ChargerDonnees;
import doa.TraitementDonnees;
import domaine.*;
import exception.ExceptionDateAnterieur;
import exception.ExceptionTacheInexistante;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import vue.AffichageDonne;

import java.util.ArrayList;

public class TraitementDonneesTest {
    public final static Logger logger = Logger.getLogger(TraitementDonneesTest.class);
    private static TraitementDonnees traitement = new TraitementDonnees();
    @Before
    public void init()
    {

    }

    @Test()
    public void AjouterTacheseArrayPersonne() throws ExceptionDateAnterieur
    {
        ArrayList<Personne> arrPersonnes = new ArrayList<>();
        traitement.addPersonne(arrPersonnes,new Personne("kmsc", "mksmxk"));
        traitement.AjouterTacheseArrayPersonne (arrPersonnes,0,"description","18-09-2100",Status.OPEN,Resolution.STANDBY,Mode.PARTAGE);
        Assert.assertEquals(arrPersonnes.get(0).getTache(11),new Tache(11));
        logger.info("AjouterTacheseArrayPersonne Test bon");
    }

    @Test()
    public void annulerTache() throws ExceptionDateAnterieur
    {
        ArrayList<Personne> arrPersonnes = new ArrayList<>();
        traitement.addPersonne(arrPersonnes,new Personne("kmsc", "mksmxk"));
        traitement.AjouterTacheseArrayPersonne (arrPersonnes,0,"description","18-09-2020",Status.OPEN,Resolution.STANDBY,Mode.PARTAGE);
        traitement.annulerTache(arrPersonnes,0,0);
        Assert.assertEquals(arrPersonnes.get(0).getTache(12),null);
        logger.info("annulerTache Test bon");
    }


    @Test()
    public void replanifierTache() throws ExceptionDateAnterieur
    {
        ArrayList<Personne> arrPersonnes = new ArrayList<>();
        traitement.addPersonne(arrPersonnes,new Personne("kmsc", "mksmxk"));
        traitement.AjouterTacheseArrayPersonne (arrPersonnes,0,"description","18-09-2020",Status.OPEN,Resolution.STANDBY,Mode.PARTAGE);
        traitement.replanifierTache(arrPersonnes,0,  9 , "02-12-2020");
        Assert.assertEquals(arrPersonnes.get(0).afficherTachesDate("18-09-2020"),"\r\n"+"            Tache{  idTache=7, description='description', date='18-09-2020', status=OPEN, resolution=STANDBY, mode=PARTAGE, idCreateur=0}");
        logger.info("replanifierTache Test bon");
    }

    @Test()
    public void attributionTache() throws ExceptionDateAnterieur, ExceptionTacheInexistante
    {
        ArrayList<Personne> arrPersonnes = new ArrayList<>();
        traitement.addPersonne(arrPersonnes,new Personne("kmsc", "mksmxk"));
        traitement.AjouterTacheseArrayPersonne (arrPersonnes,0,"description","18-09-2020",Status.OPEN,Resolution.STANDBY,Mode.PARTAGE);
        traitement.addPersonne(arrPersonnes,new Personne("sadf", "asdf"));
        traitement.AjouterTacheseArrayPersonne (arrPersonnes,0,"asdfsdafasfdasdfsadf","18-09-2020",Status.OPEN,Resolution.STANDBY,Mode.PARTAGE);
        //traitement.attributionTache(arrPersonnes,1, 7 );
        Assert.assertEquals(arrPersonnes.get(0).getTache(9),new Tache(9));
        logger.info("attributionTache Test bon");
    }

    @Test(expected  =  exception.ExceptionTacheInexistante.class)
    public void attributionTacheException() throws ExceptionDateAnterieur, ExceptionTacheInexistante
    {
        ArrayList<Personne> arrPersonnes = new ArrayList<>();
        traitement.addPersonne(arrPersonnes,new Personne("kmsc", "mksmxk"));
        traitement.attributionTache(arrPersonnes,0, 10001 );
        logger.warn("attributionTache Test echoué");
    }

    @Test()
    public void addPersonne() throws ExceptionDateAnterieur
    {   ArrayList<Personne> arrPersonnes = new ArrayList<>();
        traitement.addPersonne(arrPersonnes,new Personne("kmsc", "mksmxk"));
        traitement.addPersonne(arrPersonnes,new Personne("asd", "dasffads"));
        Assert.assertEquals(arrPersonnes.get(1).equalsNom(new Personne("asd", "dasffads")),true);
        logger.info("addPersonne Test bon");
    }


}
