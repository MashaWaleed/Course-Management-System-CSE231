package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CoursesScene extends Scene {

    private Main main;

    public CoursesScene(Stage primaryStage, Main main) {
        super(new GridPane(), 600, 600);
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
        
         Button statsButton = new Button("stats");
        statsButton.setOnAction(e -> main.showStatsScene());

        // Add navigation buttons to the grid
        grid.add(adminButton, 0, 0);
        grid.add(studentsButton, 1, 0);
        grid.add(instructorsButton, 2, 0);
        grid.add(statsButton, 3, 0);
         GridPane.setMargin(statsButton, new Insets(0, 0, 0, 10));
        // Create TableView for displaying courses
        TableView<Course> courseTable = new TableView<>();
        courseTable.setPrefWidth(500);

        // Create TableColumn for each course attribute
        TableColumn<Course, String> nameColumn = new TableColumn<>("Course Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Course, Integer> durationColumn = new TableColumn<>("Duration");
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));

        TableColumn<Course, Integer> studentsNumberColumn = new TableColumn<>("Students Number");
        studentsNumberColumn.setCellValueFactory(new PropertyValueFactory<>("studentsNumber"));

        TableColumn<Course, String> instructorColumn = new TableColumn<>("Instructor");
        instructorColumn.setCellValueFactory(new PropertyValueFactory<>("instructorName"));

        TableColumn<Course, String> reviewsColumn = new TableColumn<>("Reviews");
        reviewsColumn.setCellValueFactory(new PropertyValueFactory<>("reviews"));

        // Add columns to the table
        courseTable.getColumns().addAll(nameColumn, durationColumn, studentsNumberColumn, instructorColumn, reviewsColumn);

        // Add courses to the table
        ObservableList<Course> courses = FXCollections.observableArrayList(main.getCourses());
        courseTable.setItems(courses);

        // Add the table to the grid
        grid.add(courseTable, 0, 1, 4, 1);
    }
}
