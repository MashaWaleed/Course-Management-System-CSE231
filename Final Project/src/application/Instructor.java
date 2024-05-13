package application;
import java.util.ArrayList;

public class Instructor extends User {
    private String department;
    private ArrayList<Course> taughtCourses=new ArrayList<>();
  //  private ArrayList<Quiz> createdQuizzes=new ArrayList<Quiz>();


    public Instructor(){
    }
    public Instructor(String name, String password,String gender, int age ,String department)throws InvalideAgeException {
        super(name, password,gender,age);
        if (age < 18 || age > 150) { 
            throw new InvalideAgeException(age);
        }
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
        else {
            //System.out.println(" NO Available Courses ");
        }
    }
    void addCourse(Course course){getTaughtCourses().add(course);}
    public void createCourse(String courseName, String desc, Instructor inst, int price, int duration) {
    	Course newCourse = new Course(courseName,desc ,this, price, duration);
        getTaughtCourses().add(newCourse);

    }
    public void createdQuiz(String quizName, ArrayList<MCQ>Questions, Course course, int duration) throws IllegalArgumentException {
         Quiz newQuiz = new Quiz(quizName);
         newQuiz.setQuestions(Questions);
         course.setQuiz(newQuiz);
    }
    public void  createdMCQ(String Question, String[] choices, Course course,Quiz quiz,int answer ) throws IllegalArgumentException{
         MCQ newMCQ = new MCQ(Question,choices,answer);
    }
    public void createdAssignment(String assignmentName, ArrayList<String>Questions, Course course ) throws IllegalArgumentException {
        Assignment newAssignment = new Assignment(Questions,assignmentName);
        course.setAssignment(newAssignment);

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
		if(taughtCourses.isEmpty()){
            System.out.println(" NO available Courses ");
        }
        return taughtCourses;
    }
    /*public ArrayList<Quiz> getCreatedQuizzes() {
        if(createdQuizzes.isEmpty()){
            System.out.println(" NO available Quizzes ");
        }
        return createdQuizzes;
    }*/
	public void setTaughtCourses(ArrayList<Course> taughtCourses) {
		this.taughtCourses = taughtCourses;
	}
    public ArrayList<Student> StudentEnrolled (String CourseName){
        ArrayList<Student> StudentsEnrolledInCourse = new ArrayList<Student>();
        for (int i = 0; i < getTaughtCourses().size(); i++) {
            String str = (getTaughtCourses().get(i)).getName();
            if(!(str.equals(CourseName))){
                continue;
            }
            else{
                StudentsEnrolledInCourse.addAll((getTaughtCourses().get(i)).getStudents());
               break;
            }

        }
        return StudentsEnrolledInCourse ;

    }
    
    public boolean isTeachingCourse(Course course) {
        for (Course taughtCourse : taughtCourses) {
            if (taughtCourse.equals(course)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        return getName();
    }
    @Override
      public int compareTo(User o) {
    return this.getName().compareTo(o.getName());
}

}
