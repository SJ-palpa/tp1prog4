import domaine.Mode;
import domaine.Resolution;
import domaine.Status;
import domaine.Tache;
import exception.ExceptionDateAnterieur;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class TacheTest {

    public final static Logger logger = Logger.getLogger(TacheTest.class);

    @Test(expected  =  ExceptionDateAnterieur.class)
    public void creerTache() throws ExceptionDateAnterieur
    {
        Tache tache = new Tache(3,"dds","08-04-2018",Status.OPEN,Resolution.STANDBY,Mode.PARTAGE);
        logger.warn("creerTache Test echoué");
    }

    @Test
    public void equalsTache() throws ExceptionDateAnterieur
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-LLLL-yyyy");
        Tache tache = new Tache(3,"dds", LocalDate.now().format(formatter),Status.OPEN,Resolution.STANDBY,Mode.PARTAGE);
        Assert.assertEquals(tache.equals(new Tache(tache.getIdTache())),true);
        logger.info("equalsTache Test bon");
    }
}
