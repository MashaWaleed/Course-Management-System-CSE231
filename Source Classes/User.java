package javaproject;
public abstract class User {
    private String name;
    private String password;
    private java.util.Date dateCreated;
    private String gender;
    private int age;

    public User(){
        dateCreated = new java.util.Date();
    }
    public User(String name, String password,String gender,int age)throws InvalideAgeException {
        this.name = name;
        this.password = password;
        this.gender = gender;
        dateCreated = new java.util.Date();
        if(age>=0)
            this.age=age;
        else
            throw new InvalideAgeException(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }
    
    public String getgender() {
        return gender;
    }
    public void setgender(String gender) {
        this.gender = gender;
    }

    public int getage() {
        return age;
    }
    public void setage(int age)throws InvalideAgeException {
       if(age>=0)
            this.age=age;
        else
            throw new InvalideAgeException(age);
    }
    public java.util.Date getDate() {
        return dateCreated;
    }

    public abstract void displayInfo();
}
