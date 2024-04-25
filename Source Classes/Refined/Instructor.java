package application;
import java.util.ArrayList;

public class Instructor extends User {
    private String department;
    private ArrayList<Course> taughtCourses=new ArrayList<>();

    public Instructor(){
    }
    public Instructor(String name, String password,String gender, int age ,String department)throws InvalideAgeException {
        super(name, password,gender,age);
        this.department = department;
    }
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public void printTaughtCourses(){
        if(!(getTaughtCourses().isEmpty())){
        for(int i=0;i<getTaughtCourses().size();i++){
            System.out.println("taughtCourse"+(i+1) +": "+(getTaughtCourses().get(i)).getName());
        }
        }
    }
    void addCourse(Course couse){
         getTaughtCourses().add(couse);
     }
    public void createCourse(String courseName, String desc, Instructor inst, int price, int duration) {
    	Course newCourse = new Course(courseName,desc ,this, price, duration);
        getTaughtCourses().add(newCourse);
//        return newCourse;
    }

    @Override
    public void displayInfo() {
         System.out.println("Instructor Name: " + getName());
        System.out.println("Instructor password: " + getPassword());
        System.out.println("Instructor gender: " + getGender());
        System.out.println("Instructor age: " + getAge());
        System.out.println("Instructor account date: " + getDate());
        System.out.println("Department: " + department);
    }
	public ArrayList<Course> getTaughtCourses() {
		return taughtCourses;
	}
	public void setTaughtCourses(ArrayList<Course> taughtCourses) {
		this.taughtCourses = taughtCourses;
	}
}
