package javaproject;
import java.util.ArrayList;
public class Student extends User implements Comparable<Student> {
    private String faculty;
    private ArrayList<CourseTest> enrolledCourses=new ArrayList<>();
    private ArrayList<CourseTest> finishedCourses=new ArrayList<>();
    private int learinghours;
    public Student(){
    }
    public Student(String name, String password,String gender, int age ,String faculty)throws InvalideAgeException {
        super(name, password,gender,age);
        this.faculty = faculty;
    }
    public String getfaculty() {
        return faculty;
    }
    public int getlearinghours() {
        return learinghours;
    }

    public void setlearinghours(int learinghours) {
       this.learinghours = learinghours;
    }

    public void enroll(CourseTest course) {
        enrolledCourses.add(course);
        course.addStudent(this);
    }
    public void unenroll(CourseTest course) {
        enrolledCourses.remove(course);
        course.removeStudent(this);
    }
    public void attemptassignments(CourseTest course){
        if(enrolledCourses.contains(course)){
           finishedCourses.add(course);
        }
        learinghours=totallearinghours();
    }
    public void printenrolledCourses(){
        if(!(enrolledCourses.isEmpty())){
        for(int i=0;i<enrolledCourses.size();i++){
            System.out.println("enrolledCourses"+(i+1) +": "+(enrolledCourses.get(i)).getName());
        }
        }
    }
     public void printfinishedCourses(){
        if(!(finishedCourses.isEmpty())){
        for(int i=0;i<finishedCourses.size();i++){
            System.out.println("finishedCourses"+(i+1) +": "+(finishedCourses.get(i)).getName());
        }
        }
    }
    
    private int totallearinghours(){
        int x=0;
        if(!(finishedCourses.isEmpty())){
            for(int i=0;i<finishedCourses.size();i++){
                    x+=((finishedCourses.get(i)).getDuration());
            }
        }
        return x;
    }
    @Override
    public void displayInfo() {
        System.out.println("Student Name: " + getName());
        System.out.println("Student password: " + getpassword());
        System.out.println("Student gender: " + getgender());
        System.out.println("Student age: " + getage());
        System.out.println("Student faculty: " + getfaculty());
        System.out.println("Student account date: " + getDate());
        System.out.println("learing hours: " + learinghours);
    }
    @Override
    public int compareTo(Student o) {
        
    if (this.learinghours < o.learinghours) {
    return 1;
    } else if (this.learinghours > o.learinghours) {
    return -1;
    } else {
    return 0;
    }
    }
    }
