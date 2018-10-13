package domaine;

import exception.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public class Tache {

    private String description = null;
    private int idTache;
    private int idCreateur;
    private String date = "01/01/2001";
    private Status status = Status.OPEN;
    private Resolution resolution = Resolution.STANDBY;
    private Mode mode = Mode.PARTAGE;

    private static int ID = 0;

    public Tache(int idCreateur, String description, String date, Status status, Resolution resolution, Mode mode) throws ExceptionDateAnterieur {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-LLLL-yyyy");
        formatter = formatter.withLocale( Locale.FRENCH );
        LocalDate dateString = LocalDate.parse(date, formatter);
        if(dateString.compareTo(LocalDate.now()) < 0)
        {
            throw new ExceptionDateAnterieur();
        }
        this.idTache = ID++;
        this.idCreateur = idCreateur;
        this.description = description;
        this.date = date;
        this.status = status;
        this.resolution = resolution;
        this.mode = mode;
    }

    public Tache(int idTache) {
        this.idTache = idTache;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tache tache = (Tache) o;
        return idTache == tache.idTache ;
    }

    @Override
    public String toString() {
        return "            Tache{" +
                "  idTache=" + idTache +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", status=" + status +
                ", resolution=" + resolution +
                ", mode=" + mode +
                ", idCreateur=" + idCreateur +
                '}';
    }

    public int getIdCreateur() { return idCreateur; }
    public int getIdTache() {
        return idTache;
    }
    public Mode getMode() { return mode; }
    public String getDate() {
        return date;
    }
    public Status getStatus() {
        return status;
    }
    public boolean annulerTache() { status = Status.CANCELED; return true; }
    public boolean replanifierTache(String date) { this.date = date;return true; }

    @Override
    public int hashCode() {

        return Objects.hash(description, idTache, date, status, resolution, mode);
    }
}
