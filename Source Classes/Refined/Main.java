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
    

}
