package exception;

public class ExceptionTacheInexistante extends Exception{
    public ExceptionTacheInexistante(){
        System.out.println("La Tache n'existe pas ou n'appartient pas à cette personne");
        // TraitementDonnees.attributionTache
    }
}