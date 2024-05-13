package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        // Create an ImageView for the image
        ImageView imageView = new ImageView(new Image("./LOL2.png"));
        
        // Set the width of the image to fill the entire window
        imageView.setFitWidth(primaryStage.getWidth());
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);

        // Create buttons for navigation
        Button adminButton = new Button("Admin", createImageView("./Admin.png", 50));
        adminButton.setMaxWidth(Double.MAX_VALUE);
        adminButton.setOnAction(e -> main.showAdminScene());

        Button studentsButton = new Button("Students", createImageView("./Student.png", 50));
        studentsButton.setMaxWidth(Double.MAX_VALUE);
        studentsButton.setOnAction(e -> main.showStudentsScene());

        Button instructorsButton = new Button("Instructors", createImageView("./Instructor.png", 50));
        instructorsButton.setMaxWidth(Double.MAX_VALUE);
        instructorsButton.setOnAction(e -> main.showInstructorsScene());

        Button coursesButton = new Button("Courses", createImageView("./Course.png", 50));
        coursesButton.setMaxWidth(Double.MAX_VALUE);
        coursesButton.setOnAction(e -> main.showCoursesScene());
        
        Button statsButton = new Button("Stats", createImageView("./Stats.png", 50));
        statsButton.setMaxWidth(Double.MAX_VALUE);
        statsButton.setOnAction(e -> main.showStatsScene());

        // Layout for navigation buttons
        VBox buttonLayout = new VBox(5);
        buttonLayout.setAlignment(Pos.CENTER);
        buttonLayout.getChildren().addAll(adminButton, studentsButton, instructorsButton, coursesButton, statsButton);
        
        // Set VBox size to fill the whole screen
        buttonLayout.setMaxWidth(Double.MAX_VALUE);
        buttonLayout.setMaxHeight(Double.MAX_VALUE);

        // Layout for the entire scene
        VBox layout = new VBox();	
        layout.getChildren().addAll(imageView, buttonLayout);

        // Set scene
        Scene scene = new Scene(layout);
        return scene;
    }
    
    private ImageView createImageView(String imagePath, double height) {
        ImageView imageView = new ImageView(new Image(imagePath));
        imageView.setFitHeight(height);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        return imageView;
    }
}
