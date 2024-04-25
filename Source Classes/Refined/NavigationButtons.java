package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NavigationButtons {

    private Stage primaryStage;
    private Main main;

    public NavigationButtons(Stage primaryStage, Main main) {
        this.primaryStage = primaryStage;
        this.main = main;
    }

    public Scene getScene() {
        // Create buttons for navigation
        Button adminButton = new Button("Admin");
        adminButton.setOnAction(e -> main.showAdminScene());

        Button studentsButton = new Button("Students");
        studentsButton.setOnAction(e -> main.showStudentsScene());

        Button instructorsButton = new Button("Instructors");
        instructorsButton.setOnAction(e -> main.showInstructorsScene());

        Button coursesButton = new Button("Courses");
        coursesButton.setOnAction(e -> main.showCoursesScene());

        // Layout for navigation buttons
        VBox buttonLayout = new VBox(10);
        buttonLayout.getChildren().addAll(adminButton, studentsButton, instructorsButton, coursesButton);

        // Set scene
        Scene scene = new Scene(buttonLayout, 200, 200);
        return scene;
    }
}
