package domaine;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class Personne {
    private int idPersonne ;
    private String nom = null;
    private String prenom = null;
    private ArrayList<Tache> tache = new ArrayList<>();
    private static int ID = 0;

    public Personne( String nom, String prenom, ArrayList<Tache> tache) {
        this.idPersonne = ID++;
        this.nom = nom;
        this.prenom = prenom;
        this.tache = tache;
    }

    public Personne( String nom, String prenom) {
        this.idPersonne = ID++;
        this.nom = nom;
        this.prenom = prenom;
    }

    // uniquement pour le equals
    public Personne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Tache getTache(int idTache)
    {
        for(int i =0; tache.size()>i;i++)
        {
            if(tache.get(i).equals(new Tache(idTache)))
            {
              return tache.get(i);
            }
        }
        return null;
    }

    public boolean addTache(Tache tacheAjoute) {
        tache.add(tacheAjoute);
        return true;
    }

    public void annulerTache(int idTache)
    {
        for(int i =0; tache.size()>i;i++)
        {
            if(tache.get(i).equals(new Tache(idTache)))
            {
                tache.get(i).annulerTache();
            }
        }
    }

    public  void  replanifierTache(int idTache,String date)
    {
        for(int i =0; tache.size()>i;i++)
        {
            if(tache.get(i).equals(new Tache(idTache)))
            {
                tache.get(i).replanifierTache(date);
            }
        }
    }

    public void rappelUnjourAvant()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-LLLL-yyyy");
        formatter = formatter.withLocale( Locale.FRENCH );
        for(int i= 0; tache.size()>i ; i++)
        {
            if(  LocalDate.parse(tache.get(i).getDate(), formatter).compareTo(LocalDate.now().plusDays(1)) == 0  && tache.get(i).getStatus() == Status.OPEN)
                System.out.println(tache.get(i));
        }

    }

    public void rappelTacheDateDepasse() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-LLLL-yyyy");
        formatter = formatter.withLocale( Locale.FRENCH );
        for(int i= 0; tache.size()>i ; i++)
        {
            if(  LocalDate.parse(tache.get(i).getDate(), formatter).compareTo(LocalDate.now()) < 0  && tache.get(i).getStatus() == Status.OPEN)
                System.out.println(tache.get(i));
        }

    }

    public String afficherTaches()
    {
        String s = "";
        for(int i= 0; tache.size()>i ; i++)
        {
            s += "\r\n"+ tache.get(i); // METTRE UN SAUT DE LIGNE
        }
        return  s;
    }

    public String afficherTachesDate(String date)
    {
        String s = "";
        for(int i= 0; tache.size()>i ; i++)
        {
            if(tache.get(i).getDate().equals(date) && tache.get(i).getMode() == Mode.PARTAGE)
                s += "\r\n"+ tache.get(i);

        }
        return  s;
    }

    public String afficherTachesStatus(Status status)
    {
        String s = "";
        for(int i= 0; tache.size()>i ; i++)
        {
            if(tache.get(i).getStatus()==status && tache.get(i).getMode() == Mode.PARTAGE)
                s += "\r\n"+tache.get(i);
        }
        return s;
    }

    public Tache rechercheTache(int idTache, int idPersonneEnRecherche)
    {
        for(int i= 0; tache.size()>i ; i++)
        {
            if(tache.get(i).getIdTache() == idTache && tache.get(i).getMode() == Mode.PARTAGE && idPersonneEnRecherche!= tache.get(i).getIdCreateur())
                return tache.get(i);
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return idPersonne == personne.idPersonne ;
    }

    public boolean equalsNom(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return nom == personne.nom ;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idPersonne, nom, prenom, tache);
    }

    @Override
    public String toString() {
        return "domaine.Personne{" +
                "idPersonne=" + idPersonne +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '}';
    }


}
