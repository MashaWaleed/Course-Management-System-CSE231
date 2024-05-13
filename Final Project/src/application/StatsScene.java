package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collections;

public class StatsScene extends Scene {

    private Main main;
    private ListView<User> usersListView;
    private ListView<Course> coursesListView;

    public StatsScene(Stage primaryStage, Main main) {
        super(new VBox(), 600, 600);
        this.main = main;
        VBox container = (VBox) this.getRoot();
        container.setPadding(new Insets(10));
        container.setSpacing(10);

        // Add navigation buttons for Admin, Instructors, Courses, and Stats scenes
        HBox navButtons = new HBox(10);
        Button adminButton = new Button("Admin");
        adminButton.setOnAction(e -> main.showAdminScene());

        Button instructorsButton = new Button("Instructors");
        instructorsButton.setOnAction(e -> main.showInstructorsScene());

        Button coursesButton = new Button("Courses");
        coursesButton.setOnAction(e -> main.showCoursesScene());

        Button statsButton = new Button("Stats");
        statsButton.setOnAction(e -> main.showStatsScene());

        navButtons.getChildren().addAll(adminButton, instructorsButton, coursesButton, statsButton);
        container.getChildren().add(navButtons);

        // Add list view to display users
        usersListView = new ListView<>();
        usersListView.setPrefWidth(200);
        container.getChildren().add(usersListView);

        // Add buttons row above usersListView
        HBox usersButtonsRow = new HBox(10);
        Button usersAscendingButton = new Button("Sort Ascending");
        usersAscendingButton.setOnAction(e -> sortUsersAscending());
        Button usersDescendingButton = new Button("Sort Descending");
        usersDescendingButton.setOnAction(e -> sortUsersDescending());
        usersButtonsRow.getChildren().addAll(usersAscendingButton, usersDescendingButton);
        container.getChildren().add(usersButtonsRow);

        // Check if any students or instructors exist and update the usersListView accordingly
        updateUsersListView(main.getStudents(), main.getInstructors());

        // Add list view to display courses
        coursesListView = new ListView<>();
        coursesListView.setPrefWidth(200);
        container.getChildren().add(coursesListView);

        // Add buttons row above coursesListView
        HBox coursesButtonsRow = new HBox(10);
        Button coursesAscendingButton = new Button("Sort Ascending");
        coursesAscendingButton.setOnAction(e -> sortCoursesAscending());
        Button coursesDescendingButton = new Button("Sort Descending");
        coursesDescendingButton.setOnAction(e -> sortCoursesDescending());
        coursesButtonsRow.getChildren().addAll(coursesAscendingButton, coursesDescendingButton);
        container.getChildren().add(coursesButtonsRow);

        // Check if any course exists and update the coursesListView accordingly
        updateCoursesListView(main.getCourses());
    }

    // Method to update the usersListView with students and instructors information
    public void updateUsersListView(ArrayList<Student> students, ArrayList<Instructor> instructors) {
        ObservableList<User> items = FXCollections.observableArrayList();

        // Combine both lists of students and instructors
        ArrayList<User> users = new ArrayList<>();
        users.addAll(students);
        users.addAll(instructors);

        // Add each user to the items list
        for (User user : users) {
            items.add(user);
        }

//        if (items.isEmpty()) {
//            items.add(new User("No Users Available"));
//        }

        usersListView.setItems(items);
    }

    // Method to update the coursesListView with new course information
    public void updateCoursesListView(ArrayList<Course> courses) {
        ObservableList<Course> items = FXCollections.observableArrayList();

        if (!courses.isEmpty()) {
            items.addAll(courses);
        } 
//        else {
//            items.add(new Course("No Courses Available"));
//        }

        coursesListView.setItems(items);
    }

    // Method to sort users list in ascending order
    private void sortUsersAscending() {
        ObservableList<User> items = usersListView.getItems();
        Collections.sort(items);
        usersListView.setItems(items);
    }

    // Method to sort users list in descending order
    private void sortUsersDescending() {
        ObservableList<User> items = usersListView.getItems();
        Collections.sort(items, Collections.reverseOrder());
        usersListView.setItems(items);
    }

    // Method to sort courses list in ascending order
    private void sortCoursesAscending() {
        ObservableList<Course> items = coursesListView.getItems();
        Collections.sort(items);
        coursesListView.setItems(items);
    }

    // Method to sort courses list in descending order
    private void sortCoursesDescending() {
        ObservableList<Course> items = coursesListView.getItems();
        Collections.sort(items, Collections.reverseOrder());
        coursesListView.setItems(items);
    }
}