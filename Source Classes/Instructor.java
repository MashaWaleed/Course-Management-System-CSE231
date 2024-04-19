package javaproject;
import java.util.ArrayList;

public class Instructor extends User {
    private String department;
    private ArrayList<CourseTest> taughtCourses=new ArrayList<>();

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
        if(!(taughtCourses.isEmpty())){
        for(int i=0;i<taughtCourses.size();i++){
            System.out.println("taughtCourse"+(i+1) +": "+(taughtCourses.get(i)).getName());
        }
        }
    }
  void addcourse(CourseTest couse){
         taughtCourses.add(couse);
     }
    public void createCourse(String courseName, int duration) {
        CourseTest newCourse = new CourseTest(courseName, duration, this);
        taughtCourses.add(newCourse);
//        return newCourse;
    }

    @Override
    public void displayInfo() {
         System.out.println("Instructor Name: " + getName());
        System.out.println("Instructor password: " + getpassword());
        System.out.println("Instructor gender: " + getgender());
        System.out.println("Instructor age: " + getage());
        System.out.println("Instructor account date: " + getDate());
        System.out.println("Department: " + department);
    }
}
