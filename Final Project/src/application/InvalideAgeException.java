package application;
public class InvalideAgeException extends Exception{
    public InvalideAgeException(int age){
        super("InvalideAge"+age);
    }
}
