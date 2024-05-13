package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class AdminScene extends Scene {

    private Main main;

    public AdminScene(Stage primaryStage, Main main) {
        super(new ScrollPane(), 600, 600);
        this.main = main;
        VBox container = new VBox();
        container.setPadding(new Insets(20));
        container.setSpacing(10);

        // Create HBox for navigation buttons
        HBox navButtons = new HBox(10);
        Button studentsButton = new Button("Students   ");
        studentsButton.setOnAction(e -> main.showStudentsScene());

        Button instructorsButton = new Button("Instructors");
        instructorsButton.setOnAction(e -> main.showInstructorsScene());

        Button coursesButton = new Button("Courses    ");
        coursesButton.setOnAction(e -> main.showCoursesScene());

        Button statsButton = new Button("Stats");
        statsButton.setOnAction(e -> main.showStatsScene());

        navButtons.getChildren().addAll(studentsButton, instructorsButton, coursesButton, statsButton);
        container.getChildren().add(navButtons);

        // Add labels and text fields for student creation
        Label studentLabel = new Label("Create Student:");
        TextField studentNameField = new TextField();
        studentNameField.setPromptText("Name");
        TextField studentPasswordField = new TextField();
        studentPasswordField.setPromptText("Password");
        
        // Add radio buttons for gender selection
        ToggleGroup studentGenderGroup = new ToggleGroup();
        RadioButton maleRadioButton = new RadioButton("Male");
        RadioButton femaleRadioButton = new RadioButton("Female");
        maleRadioButton.setToggleGroup(studentGenderGroup);
        femaleRadioButton.setToggleGroup(studentGenderGroup);
        HBox genderBox = new HBox(10, maleRadioButton, femaleRadioButton);
        
        TextField studentAgeField = new TextField();
        studentAgeField.setPromptText("Age");
        TextField studentFacultyField = new TextField();
        studentFacultyField.setPromptText("Faculty");
        TextField studentIDField = new TextField();
        studentIDField.setPromptText("ID");

        // Add a button to create a student
        Button createStudentButton = new Button("Create Student");
        createStudentButton.setOnAction(e -> {
            // Create Student object
            String studentName = studentNameField.getText();
            String studentPassword = studentPasswordField.getText();
            String studentGender = ((RadioButton) studentGenderGroup.getSelectedToggle()).getText(); // Get selected gender
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
        });

        // Add labels and text fields for instructor creation
        Label instructorLabel = new Label("Create Instructor:");
        TextField instructorNameField = new TextField();
        instructorNameField.setPromptText("Name");
        TextField instructorPasswordField = new TextField();
        instructorPasswordField.setPromptText("Password");
        
        // Add radio buttons for gender selection
        ToggleGroup instructorGenderGroup = new ToggleGroup();
        RadioButton instructorMaleRadioButton = new RadioButton("Male");
        RadioButton instructorFemaleRadioButton = new RadioButton("Female");
        instructorMaleRadioButton.setToggleGroup(instructorGenderGroup);
        instructorFemaleRadioButton.setToggleGroup(instructorGenderGroup);
        HBox instructorGenderBox = new HBox(10, instructorMaleRadioButton, instructorFemaleRadioButton);
        
        TextField instructorAgeField = new TextField();
        instructorAgeField.setPromptText("Age");
        TextField instructorDepartmentField = new TextField();
        instructorDepartmentField.setPromptText("Department");

        // Add a button to create an instructor
        Button createInstructorButton = new Button("Create Instructor");
        createInstructorButton.setOnAction(e -> {
            // Create Instructor object
            String instructorName = instructorNameField.getText();
            String instructorPassword = instructorPasswordField.getText();
            String instructorGender = ((RadioButton) instructorGenderGroup.getSelectedToggle()).getText(); // Get selected gender
            int instructorAge = Integer.parseInt(instructorAgeField.getText());
            String instructorDepartment = instructorDepartmentField.getText();
            try {
                Instructor instructor = new Instructor(instructorName, instructorPassword, instructorGender, instructorAge, instructorDepartment);
                System.out.println("Instructor created: " + instructor.getName());
                main.addInstructorObj(instructor);
            } catch (InvalideAgeException ex) {
                showAgeExceptionWindow(ex);
                System.out.println("Invalid age for instructor: " + ex.getMessage());
            }
        });

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

        // Add a button to create a course
        Button createCourseButton = new Button("Create Course");
        createCourseButton.setOnAction(e -> {
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

        // Add a button to call the test method in Main
        Button testButton = new Button("Test");
        testButton.setOnAction(e -> main.test());

        // Add elements to the container
        container.getChildren().addAll(
                studentLabel, studentNameField, studentPasswordField, genderBox, studentAgeField, studentFacultyField, studentIDField, createStudentButton,
                instructorLabel, instructorNameField, instructorPasswordField, instructorGenderBox, instructorAgeField, instructorDepartmentField, createInstructorButton,
                courseLabel, courseNameField, courseDescriptionField, coursePriceField, courseDurationField, createCourseButton, testButton);

        // Set the content of the ScrollPane
        ScrollPane scrollPane = new ScrollPane(container);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        // Set the scene
        this.setRoot(scrollPane);
    }

    private void showAgeExceptionWindow(InvalideAgeException ex) {
        Stage ageExceptionStage = new Stage();
        VBox ageBox = new VBox(10);
        ageBox.setPadding(new Insets(20));
        ageBox.setAlignment(Pos.CENTER);

        Label resultLabel = new Label(ex.getMessage());

        Button okButton = new Button("OK");
        okButton.setOnAction(e -> ageExceptionStage.close());

        ageBox.getChildren().addAll(resultLabel, okButton);

        Scene ageExceptionScene = new Scene(ageBox, 150, 150);
        ageExceptionStage.setScene(ageExceptionScene);
        ageExceptionStage.setTitle("Invalid Age");
        ageExceptionStage.show();
    }
}
