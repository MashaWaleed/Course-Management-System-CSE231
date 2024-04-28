package project.Refined;
import java.util.ArrayList;
public class Student extends User implements Comparable<Student> {
    private String faculty;
    private int ID;
    private ArrayList<Course> enrolledCourses=new ArrayList<>();
    private ArrayList<Course> finishedCourses=new ArrayList<>();
    private int learingHours;
    public Student(){
    }
    public Student(String name, String password,String gender, int age ,String faculty, int ID)throws InvalideAgeException {
        super(name, password,gender,age);
        this.faculty = faculty;
        this.setID(ID);
    }
    public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
    public void setFaculty(String f)
    {
    	this.faculty = f;
    }
    public String getFaculty() {
        return faculty;
    }
    
    public int getLearingHours() {
        return learingHours;
    }

    public void setLearingHours(int learinghours) {
       this.learingHours = learinghours;
    }

    public void enroll(Course course) {
        getEnrolledCourses().add(course);
        course.addStudent(this);
    }
    public void unenroll(Course course) {
        getEnrolledCourses().remove(course);
        course.deleteStudent(this);
    }
    public void attemptAssignments(Course course){
        if(getEnrolledCourses().contains(course)){
           getFinishedCourses().add(course);
        }
        learingHours=totalLearingHours();
    }
    public void printEnrolledCourses(){
        if(!(getEnrolledCourses().isEmpty())){
        for(int i=0;i<getEnrolledCourses().size();i++){
            System.out.println("enrolledCourses"+(i+1) +": "+(getEnrolledCourses().get(i)).getName());
        }
        }
    }
     public void printFinishedCourses(){
        if(!(getFinishedCourses().isEmpty())){
        for(int i=0;i<getFinishedCourses().size();i++){
            System.out.println("finishedCourses"+(i+1) +": "+(getFinishedCourses().get(i)).getName());
        }
        }
    }
    
    private int totalLearingHours(){
        int x=0;
        if(!(getFinishedCourses().isEmpty())){
            for(int i=0;i<getFinishedCourses().size();i++){
                    x+=((getFinishedCourses().get(i)).getDuration());
            }
        }
        return x;
    }
    @Override
    public void displayInfo() {
        System.out.println("Student Name: " + getName());
        System.out.println("Student password: " + getPassword());
        System.out.println("Student gender: " + getGender());
        System.out.println("Student age: " + getAge());
        System.out.println("Student faculty: " + getFaculty());
        System.out.println("Student account date: " + getDate());
        System.out.println("learing hours: " + learingHours);
    }
    @Override
    public int compareTo(Student o) {
        
    if (this.learingHours < o.learingHours) {
    return 1;
    } else if (this.learingHours > o.learingHours) {
    return -1;
    } else {
    return 0;
    }
    }
	public ArrayList<Course> getEnrolledCourses() {
		return enrolledCourses;
	}
	public void setEnrolledCourses(ArrayList<Course> enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}
	public ArrayList<Course> getFinishedCourses() {
		return finishedCourses;
	}
	public void setFinishedCourses(ArrayList<Course> finishedCourses) {
		this.finishedCourses = finishedCourses;
	}
	public ArrayList<String> getEnrolledCoursesNames() {
        ArrayList<String> courseNames = new ArrayList<>();
        for (Course course : enrolledCourses) {
            courseNames.add(course.getName());
        }
        return courseNames;
    }
	
    }
