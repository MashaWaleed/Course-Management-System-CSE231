package project.Refined;
public class InvalideAgeException extends Exception{
    private int age;
    public InvalideAgeException(int age){
        super("Age cannot be "+age);
        this.age=age;
    }
}
