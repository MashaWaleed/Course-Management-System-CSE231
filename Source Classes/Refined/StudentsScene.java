package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StudentsScene extends Scene {

    private Main main;

    public StudentsScene(Stage primaryStage, Main main) {
        super(new GridPane(), 400, 400);
        this.main = main;
        GridPane grid = (GridPane) this.getRoot();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Add navigation buttons for Admin, Instructors, and Courses scenes
        Button adminButton = new Button("Admin");
        adminButton.setOnAction(e -> main.showAdminScene());

        Button instructorsButton = new Button("Instructors");
        instructorsButton.setOnAction(e -> main.showInstructorsScene());

        Button coursesButton = new Button("Courses");
        coursesButton.setOnAction(e -> main.showCoursesScene());

        // Add navigation buttons to the grid
        grid.add(adminButton, 0, 0);
        grid.add(instructorsButton, 1, 0);
        grid.add(coursesButton, 2, 0);

        // Add buttons and lists for each student
        int row = 1; // Starting row for student information
        for (Student student : main.getStudents()) {
            // Label to display student information
            Label studentInfoLabel = new Label(student.getName() + " - " + student.getID()); // Customize according to your Student class
            grid.add(studentInfoLabel, 0, row);

            // Drop-down menu to select a course
            ComboBox<Course> courseComboBox = new ComboBox<>();
            courseComboBox.getItems().addAll(main.getCourses()); // Assuming you have a method to get all courses
            grid.add(courseComboBox, 1, row);

            // Button to enroll in the selected course
            Button enrollButton = new Button("Enroll in Course");
            enrollButton.setOnAction(e -> {
                Course selectedCourse = courseComboBox.getValue(); // Get the selected course from the combo box
                if (selectedCourse != null) {
                    student.enroll(selectedCourse); // Enroll the student in the selected course
                    //enrolledCoursesList.getItems().add(selectedCourse.getName()); // Update the enrolled courses list
                }
            });
            grid.add(enrollButton, 2, row);

            row++;
        }
    }
}
