package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CoursesScene extends Scene {

    private Main main;

    public CoursesScene(Stage primaryStage, Main main) {
        super(new GridPane(), 400, 400);
        this.main = main;
        GridPane grid = (GridPane) this.getRoot();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Add navigation buttons for Admin, Students, and Instructors scenes
        Button adminButton = new Button("Admin");
        adminButton.setOnAction(e -> main.showAdminScene());

        Button studentsButton = new Button("Students");
        studentsButton.setOnAction(e -> main.showStudentsScene());

        Button instructorsButton = new Button("Instructors");
        instructorsButton.setOnAction(e -> main.showInstructorsScene());

        // Add navigation buttons to the grid
        grid.add(adminButton, 0, 0);
        grid.add(studentsButton, 1, 0);
        grid.add(instructorsButton, 2, 0);

        // Add labels to display course information
        int row = 1; // Starting row for course information
        for (Course course : main.getCourses()) {
            Label courseInfoLabel = new Label(course.getName() + " - " + course.getStudents().size()); // Customize according to your Course class
            grid.add(courseInfoLabel, 0, row);
            row++;
        }
    }
}
