package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AdminScene extends Scene {

    private Main main;

    public AdminScene(Stage primaryStage, Main main) {
        super(new GridPane(), 400, 400);
        this.main = main;
        GridPane grid = (GridPane) this.getRoot();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Add labels and text fields for student creation
        Label studentLabel = new Label("Create Student:");
        TextField studentNameField = new TextField();
        studentNameField.setPromptText("Name");
        TextField studentPasswordField = new TextField();
        studentPasswordField.setPromptText("Password");
        TextField studentGenderField = new TextField();
        studentGenderField.setPromptText("Gender");
        TextField studentAgeField = new TextField();
        studentAgeField.setPromptText("Age");
        TextField studentFacultyField = new TextField();
        studentFacultyField.setPromptText("Faculty");
        TextField studentIDField = new TextField();
        studentIDField.setPromptText("ID");

        // Add labels and text fields for instructor creation
        Label instructorLabel = new Label("Create Instructor:");
        TextField instructorNameField = new TextField();
        instructorNameField.setPromptText("Name");
        TextField instructorPasswordField = new TextField();
        instructorPasswordField.setPromptText("Password");
        TextField instructorGenderField = new TextField();
        instructorGenderField.setPromptText("Gender");
        TextField instructorAgeField = new TextField();
        instructorAgeField.setPromptText("Age");
        TextField instructorDepartmentField = new TextField();
        instructorDepartmentField.setPromptText("Department");

        // Add labels and text fields for course creation
        Label courseLabel = new Label("Create Course:");
        TextField courseNameField = new TextField();
        courseNameField.setPromptText("Name");
        TextField courseDescriptionField = new TextField();
        courseDescriptionField.setPromptText("Description");
        TextField coursePriceField = new TextField();
        coursePriceField.setPromptText("Price");
        TextField courseDurationField = new TextField();
        courseDurationField.setPromptText("Duration");

        // Add a button to create objects
        Button createButton = new Button("Create");
        createButton.setOnAction(e -> {
            // Create Student object
            String studentName = studentNameField.getText();
            String studentPassword = studentPasswordField.getText();
            String studentGender = studentGenderField.getText();
            int studentAge = Integer.parseInt(studentAgeField.getText());
            String studentFaculty = studentFacultyField.getText();
            int studentID = Integer.parseInt(studentIDField.getText());
            try {
                Student student = new Student(studentName, studentPassword, studentGender, studentAge, studentFaculty, studentID);
                System.out.println("Student created: " + student.getName());
                main.addStudentObj(student);
            } catch (InvalideAgeException ex) {
                System.out.println("Invalid age for student: " + ex.getMessage());
            }
            
            

            // Create Instructor object
            String instructorName = instructorNameField.getText();
            String instructorPassword = instructorPasswordField.getText();
            String instructorGender = instructorGenderField.getText();
            int instructorAge = Integer.parseInt(instructorAgeField.getText());
            String instructorDepartment = instructorDepartmentField.getText();
            try {
                Instructor instructor = new Instructor(instructorName, instructorPassword, instructorGender, instructorAge, instructorDepartment);
                System.out.println("Instructor created: " + instructor.getName());
                main.addInstructorObj(instructor);
            } catch (InvalideAgeException ex) {
                System.out.println("Invalid age for instructor: " + ex.getMessage());
            }

            // Create Course object
            String courseName = courseNameField.getText();
            String courseDescription = courseDescriptionField.getText();
            int coursePrice = Integer.parseInt(coursePriceField.getText());
            int courseDuration = Integer.parseInt(courseDurationField.getText());
            Instructor courseInstructor = null; // You need to provide the instructor object
            try {
                Course course = new Course(courseName, courseDescription, courseInstructor, coursePrice, courseDuration);
                System.out.println("Course created: " + course.getName());
                main.addCoursesObj(course);
            } catch (Exception ex) {
                System.out.println("Error creating course: " + ex.getMessage());
            }
        });

        // Add a button to navigate to the Students scene
        Button studentsButton = new Button("Students");
        studentsButton.setOnAction(e -> main.showStudentsScene());

        // Add a button to navigate to the Instructors scene
        Button instructorsButton = new Button("Instructors");
        instructorsButton.setOnAction(e -> main.showInstructorsScene());

        // Add a button to navigate to the Courses scene
        Button coursesButton = new Button("Courses");
        coursesButton.setOnAction(e -> main.showCoursesScene());

        // Add elements to the grid
        grid.add(studentLabel, 0, 0);
        grid.add(studentNameField, 0, 1);
        grid.add(studentPasswordField, 1, 1);
        grid.add(studentGenderField, 0, 2);
        grid.add(studentAgeField, 1, 2);
        grid.add(studentFacultyField, 0, 3);
        grid.add(studentIDField, 1, 3);

        grid.add(instructorLabel, 0, 4);
        grid.add(instructorNameField, 0, 5);
        grid.add(instructorPasswordField, 1, 5);
        grid.add(instructorGenderField, 0, 6);
        grid.add(instructorAgeField, 1, 6);
        grid.add(instructorDepartmentField, 0, 7);

        grid.add(courseLabel, 0, 8);
        grid.add(courseNameField, 0, 9);
        grid.add(courseDescriptionField, 1, 9);
        grid.add(coursePriceField, 0, 10);
        grid.add(courseDurationField, 1, 10);

        grid.add(createButton, 0, 11);
        GridPane.setColumnSpan(createButton, 2);

        grid.add(studentsButton, 0, 12);
        grid.add(instructorsButton, 1, 12);
        grid.add(coursesButton, 2, 12);

        // Set the scene
        this.setRoot(grid);
    }
}
