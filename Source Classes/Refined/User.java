package application;
public abstract class User {
    private String name;
    private String password;
    private java.util.Date dateCreated;
    private String gender;
    private int age;

    public User(){
        setDateCreated(new java.util.Date());
    }
    public User(String name, String password,String gender,int age)throws InvalideAgeException {
        this.name = name;
        this.password = password;
        this.gender = gender;
        setDateCreated(new java.util.Date());
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
    public void setAge(int age)throws InvalideAgeException {
       if(age>=0)
            this.age=age;
        else
            throw new InvalideAgeException(age);
    }
    public java.util.Date getDate() {
        return getDateCreated();
    }

    public abstract void displayInfo();
	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(java.util.Date dateCreated) {
		this.dateCreated = dateCreated;
	}
}
