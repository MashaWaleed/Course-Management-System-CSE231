package application;
public class InvalideAgeException extends Exception{
    private int age;
    public InvalideAgeException(int age){
        super("InvalideAge"+age);
        this.age=age;
    }
}
