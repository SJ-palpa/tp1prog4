package outils;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class TypeRandomizer {
    private SecureRandom random = new SecureRandom();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-LLLL-yyyy");

    public String ranndomString()
    {
        Random rand = new Random();
        String str="";
        for(int i = 0 ; i < 20 ; i++){
            char c = (char)(rand.nextInt(26) + 97);
            str += c;
        }
        return str;
    }
    public int RanndomInt(int borneSup, int borneInf)
    {
        Random r = new Random();
        int valeur = r.nextInt(borneSup - borneInf);
        return valeur;
    }

    public <T extends Enum<?>> T RandomEnum(Class<T> clazz){

        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

     public String RandomDate() {
        LocalDate maxDate = LocalDate.of(2100,01,01);
        int minDay = (int) LocalDate.now().toEpochDay();
        int maxDay = (int) maxDate.toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        return LocalDate.ofEpochDay(randomDay).format(formatter);
    }

}
