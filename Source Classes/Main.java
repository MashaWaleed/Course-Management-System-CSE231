package application;

import javafx.application.Application;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Main extends Application {

    private Stage primaryStage;
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Instructor> instructors = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Course Management System");

        // Create navigation buttons
        NavigationButtons navigationButtons = new NavigationButtons(primaryStage, this);

        // Set scene and show stage
        primaryStage.setScene(navigationButtons.getScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void showAdminScene() {
        primaryStage.setScene(new AdminScene(primaryStage, this));
    }

    public void showStudentsScene() {
        primaryStage.setScene(new StudentsScene(primaryStage, this));
    }

    public void showInstructorsScene() {
        primaryStage.setScene(new InstructorsScene(primaryStage, this));
    }

    public void showCoursesScene() {
        primaryStage.setScene(new CoursesScene(primaryStage, this));
    }
    public void showStatsScene() {
        primaryStage.setScene(new StatsScene(primaryStage, this));
    }
    
    
    public void addStudentObj(Student s)
    {
    	students.add(s);
    	// for debugging
    	for(Student st : students)
    	{
    		st.displayInfo();
    	}
    }
    public void addInstructorObj(Instructor i)
    {
    	instructors.add(i);
    	for(Instructor in : instructors)
    	{
    		in.displayInfo();
    	}
    }
    public void addCoursesObj(Course c)
    {
    	courses.add(c);
    	for(Course co : courses)
    	{
    		System.out.println(co.getName());
    	}
    }
    public ArrayList<Student> getStudents()
    {
    	return this.students;
    }
    public ArrayList<Instructor> getInstructors()
    {
    	return this.instructors;
    }
    public ArrayList<Course> getCourses()
    {
    	return this.courses;
    }
    
    public void test() {
        // Creating students
        try {
            Student student1 = new Student("John Michael Doe", "password1", "Male", 20, "Computer Science", 101);
            Student student2 = new Student("Alice Jane Smith", "password2", "Female", 22, "Engineering", 102);
            Student student3 = new Student("Robert William Johnson", "password3", "Male", 21, "Physics", 103);
            addStudentObj(student1);
            addStudentObj(student2);
            addStudentObj(student3);
        } catch (InvalideAgeException e) {
            System.out.println("Invalid age provided for student.");
        }

        try {
            Instructor instructor1 = new Instructor("John Christopher Brown", "pass123", "Male", 40, "Computer Science");
            Instructor instructor2 = new Instructor("Alice Elizabeth Green", "pass456", "Female", 35, "Engineering");
            Instructor instructor3 = new Instructor("Robert James Davis", "pass789", "Male", 45, "Physics");
            addInstructorObj(instructor1);
            addInstructorObj(instructor2);
            addInstructorObj(instructor3);
        } catch (InvalideAgeException e) {
            System.out.println("Invalid age provided for instructor.");
        }

        Course course1 = new Course("Java Programming", "Learn Java programming basics", null, 100, 8);
        Course course2 = new Course("Mechanical Engineering", "Introduction to Mechanical Engineering", null, 150, 10);
        Course course3 = new Course("Quantum Physics", "Understanding Quantum Mechanics", null, 120, 6);
        Course course4 = new Course("Data Structures and Algorithms", "Advanced Data Structures and Algorithms", null, 120, 8);
        Course course5 = new Course("Artificial Intelligence", "Introduction to AI and Machine Learning", null, 140, 7);
        Course course6 = new Course("Digital Electronics", "Fundamentals of Digital Electronics", null, 110, 6);
        Course course7 = new Course("Database Management Systems", "Database Design and Implementation", null, 130, 7);
        Course course8 = new Course("Software Engineering", "Principles of Software Development", null, 140, 8);
        Course course9 = new Course("Network Security", "Network Security and Cryptography", null, 130, 7);
        
        addCoursesObj(course1);
        addCoursesObj(course2);
        addCoursesObj(course3);
        addCoursesObj(course4);
        addCoursesObj(course5);
        addCoursesObj(course6);
        addCoursesObj(course7);
        addCoursesObj(course8);
        addCoursesObj(course9);
    }

    

}
