package exception;

public class ExceptionDateAnterieur extends Exception{
    public ExceptionDateAnterieur(){
        System.out.println("vous ne pouvez pas créer une tâche avec une date antérieur à aujourd'hui");
    }
}