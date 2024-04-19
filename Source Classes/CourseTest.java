package javaproject;
import java.util.ArrayList;
public class CourseTest {
    private String name;
    private int duration; 
    private Instructor instructor;
    private ArrayList<Student> students=new ArrayList<>();
    public CourseTest(String name, int duration, Instructor instructor) {
        this.name = name;
        this.duration = duration;
        this.instructor = instructor;
        instructor.addcourse(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
    public void printenrolledstudents(){
        if(!(students.isEmpty())){
        for(int i=0;i<students.size();i++){
            System.out.println("enrolledstudent"+(i+1) +": "+(students.get(i)).getName());
        }
        }
    }
  public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }
}
