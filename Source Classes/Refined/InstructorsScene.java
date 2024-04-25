package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InstructorsScene extends Scene {

    private Main main;

    public InstructorsScene(Stage primaryStage, Main main) {
        super(new GridPane(), 400, 400);
        this.main = main;
        GridPane grid = (GridPane) this.getRoot();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);
        // Add navigation buttons for Admin, Students, and Courses scenes
        Button adminButton = new Button("Admin");
        adminButton.setOnAction(e -> main.showAdminScene());

        Button studentsButton = new Button("Students");
        studentsButton.setOnAction(e -> main.showStudentsScene());

        Button coursesButton = new Button("Courses");
        coursesButton.setOnAction(e -> main.showCoursesScene());

        // Add navigation buttons to the grid
        grid.add(adminButton, 0, 0);
        grid.add(studentsButton, 1, 0);
        grid.add(coursesButton, 2, 0);

        // Add labels to display instructor information
        int row = 1; // Starting row for instructor information
        for (Instructor instructor : main.getInstructors()) {
            Label instructorInfoLabel = new Label(instructor.getName() + " - " + instructor.getDepartment()); // Customize according to your Instructor class
            grid.add(instructorInfoLabel, 0, row);
            row++;
        }
    }
}
