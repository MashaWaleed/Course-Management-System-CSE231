package application;

import java.util.Date;

public abstract class User implements Comparable<User> {
    private String name;
    private String password;
    private Date dateCreated;
    private String gender;
    private int age;

    public User() {
        setDateCreated(new Date());
    }

    public User(String name, String password, String gender, int age) throws InvalideAgeException {
        this.name = name;
        this.password = password;
        this.gender = gender;
        setDateCreated(new Date());
        if (age >= 0)
            this.age = age;
        else
            throw new InvalideAgeException(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws InvalideAgeException {
        if (age >= 0)
            this.age = age;
        else
            throw new InvalideAgeException(age);
    }

    public Date getDate() {
        return getDateCreated();
    }

    public abstract void displayInfo();

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public int compareTo(User o) {
        return this.getName().compareTo(o.getName());
    }
}