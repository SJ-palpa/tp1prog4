import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import domaine.*;
import exception.ExceptionDateAnterieur;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class PersonneTest {
    public final static Logger logger = Logger.getLogger(PersonneTest.class);

    @Test
    public void addTache() throws ExceptionDateAnterieur
    {
        Personne p = new Personne("kmsc", "mksmxk",new ArrayList<Tache>());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-LLLL-yyyy");
        Tache tache = new Tache(3,"dds", LocalDate.now().format(formatter),Status.OPEN,Resolution.STANDBY,Mode.PARTAGE);
        Assert.assertEquals(p.addTache(tache),true);
        logger.info("addTache Test bon");
    }

    @Test
    public void afficherTache() throws ExceptionDateAnterieur
    {
        Personne p = new Personne("kmsc", "mksmxk",new ArrayList<Tache>());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-LLLL-yyyy");
        Tache tache = new Tache(3,"dds", LocalDate.now().format(formatter),Status.OPEN,Resolution.STANDBY,Mode.PARTAGE);
        p.addTache(tache);
        Assert.assertEquals(p.afficherTaches(),"\r\n"+"            Tache{  idTache="+Integer.toString(tache.getIdTache())+", description='dds', date='"+LocalDate.now().format(formatter)+"', status=OPEN, resolution=STANDBY, mode=PARTAGE, idCreateur=3}");
        logger.info("afficherTache Test bon");
    }

    @Test
    public void afficherDateTache() throws ExceptionDateAnterieur
    {
        Personne p = new Personne("kmsc", "mksmxk",new ArrayList<Tache>());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-LLLL-yyyy");
        Tache tache = new Tache(3,"dds", LocalDate.now().format(formatter),Status.OPEN,Resolution.STANDBY,Mode.PARTAGE);
        p.addTache(tache);
        Assert.assertEquals(p.afficherTachesDate(LocalDate.now().format(formatter)),"\r\n"+"            Tache{  idTache="+Integer.toString(tache.getIdTache())+", description='dds', date='"+LocalDate.now().format(formatter)+"', status=OPEN, resolution=STANDBY, mode=PARTAGE, idCreateur=3}");
        logger.info("afficherDateTache Test bon");
    }

    @Test
    public void afficherDateTacheMODE_PRIVE() throws ExceptionDateAnterieur
    {
        Personne p = new Personne("kmsc", "mksmxk",new ArrayList<Tache>());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-LLLL-yyyy");
        Tache tache = new Tache(3,"dds", LocalDate.now().format(formatter),Status.OPEN,Resolution.STANDBY,Mode.PRIVE);
        p.addTache(tache);
        Assert.assertEquals(p.afficherTachesDate(LocalDate.now().format(formatter)),"");
        logger.info("afficherDateTacheMODE_PRIVE Test bon");
    }

    @Test
    public void afficherStatusTache() throws ExceptionDateAnterieur
    {
        Personne p = new Personne("kmsc", "mksmxk",new ArrayList<Tache>());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-LLLL-yyyy");
        Tache tache = new Tache(3,"dds", LocalDate.now().format(formatter),Status.OPEN,Resolution.STANDBY,Mode.PARTAGE);
        p.addTache(tache);
        Assert.assertEquals(p.afficherTachesStatus(Status.OPEN),"\r\n"+"            Tache{  idTache="+Integer.toString(tache.getIdTache())+", description='dds', date='"+LocalDate.now().format(formatter)+"', status=OPEN, resolution=STANDBY, mode=PARTAGE, idCreateur=3}");
        logger.info("afficherStatusTache Test bon");
    }

    @Test
    public void afficherStatusTacheMODE_PRIVE() throws ExceptionDateAnterieur
    {
        Personne p = new Personne("kmsc", "mksmxk",new ArrayList<Tache>());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-LLLL-yyyy");
        Tache tache = new Tache(3,"dds", LocalDate.now().format(formatter),Status.OPEN,Resolution.STANDBY,Mode.PRIVE);
        p.addTache(tache);
        Assert.assertEquals(p.afficherTachesStatus(Status.OPEN),"");
        logger.info("afficherStatusTacheMODE_PRIVE Test bon");
    }


}

