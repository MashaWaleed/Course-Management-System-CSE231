package project.Refined;
import java.util.ArrayList;
public class Student extends User implements Comparable<Student> {
    private String faculty;
    private int ID;
    private ArrayList<Course> enrolledCourses=new ArrayList<Course>();
    private ArrayList<Course> finishedCourses=new ArrayList<Course>();
    private int learningHours;
    public Student(){
    }
    public Student(String name, String password,String gender, int age ,String faculty, int ID)throws InvalideAgeException {
        super(name, password,gender,age);
        setFaculty(faculty);
        setID(ID);
    }
    public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
    public void setFaculty(String faculty)
    {
    	this.faculty = faculty;
    }
    public String getFaculty() {
        return faculty;
    }
    
    public int getLearningHours() {
        return learningHours;
    }

    public void setLearningHours(int learninghours) {
       this.learningHours = learninghours;
    }

    public void enroll(Course course) {
        getEnrolledCourses().add(course);
        course.addStudent(this);
    }
    public void unroll(Course course) {
        getEnrolledCourses().remove(course);
        course.deleteStudent(this);
    }
    public ArrayList<String> attemptAssignments(Course course , Assignment assignment) throws IllegalArgumentException {
        if(getEnrolledCourses().contains(course) ){
            if(course.getAssignments().contains(assignment)) {
                getFinishedCourses().add(course);
                learningHours = totalLearningHours();
                return assignment.getQuestions();
            }
            throw new IllegalArgumentException("Assignment '" + assignment.getAssignmentName() +"'not found in course" +course.getName() );
        }
        throw new IllegalArgumentException("course '" + course.getName()+"'not found. ");
    }
    public void submitAssignment (Course course , Assignment assignment) {
         if(getEnrolledCourses().contains(course) ){
            if(course.getAssignments().contains(assignment)) {
                assignment.setScore(10); //assume final score is 10
            }
            throw new IllegalArgumentException("Assignment '" + assignment.getAssignmentName() +"'not found in course" +course.getName() );
        }
        throw new IllegalArgumentException("course '" + course.getName()+"'not found. ");
    }
    public ArrayList<MCQ> attemptQuiz(Course course,Quiz quiz) throws IllegalArgumentException {
        if(getEnrolledCourses().contains(course) ){
            if(course.getQuizzes().contains(quiz)){
                return quiz.getQuestions();
            }
            throw new IllegalArgumentException ("Quiz '" + quiz.getQuizName() + "' not found in course '" + course.getName() + "'.");
        }
        throw new IllegalArgumentException("Course '" + course.getName() + "' not found.");
    }
    public String submitQuiz(Course course, Quiz quiz , int StudentCorrectAnswers){
        if (getEnrolledCourses().contains(course)){
            if (course.getQuizzes().contains(quiz)){
                return String.valueOf((quiz.getAverageScore()));
            }
            else{
            throw new IllegalArgumentException ("Quiz '" + quiz.getQuizName() + "' not found in course '" + course.getName() + "'.");
            }
        }
        else {
        throw new IllegalArgumentException("Course '" + course.getName() + "' not found.");
        }
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

    
    private int totalLearningHours(){
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
        System.out.println("learning hours: " + learningHours);
    }
    @Override
    public int compareTo(Student o) {
        
    if (this.learningHours < o.learningHours) {
    return 1;
    } else if (this.learningHours > o.learningHours) {
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
        ArrayList<String> courseNames = new ArrayList<String>();
        for (Course course : enrolledCourses) {
            courseNames.add(course.getName());
        }
        return courseNames;
    }

	
    }
