package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StudentsScene extends Scene {

    private Main main;

    public StudentsScene(Stage primaryStage, Main main) {
        super(new VBox(), 750, 600);
        this.main = main;
        VBox container = (VBox) this.getRoot();
        container.setPadding(new Insets(10));
        container.setSpacing(10);

        // Add navigation buttons for Admin, Instructors, and Courses scenes
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

        ScrollPane scrollPane = new ScrollPane();
        VBox studentContainer = new VBox(10);
        studentContainer.setPadding(new Insets(10));
        studentContainer.setSpacing(10);

        if (main.getStudents().isEmpty()) {
            Label noStudentsLabel = new Label("No Students Registered On System");
            noStudentsLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 18px;");
            studentContainer.getChildren().add(noStudentsLabel);
        } else {

            // Add buttons and lists for each student
            for (Student student : main.getStudents()) {
                VBox studentBox = new VBox(10);
                studentBox.setPadding(new Insets(10));
                studentBox.setAlignment(Pos.TOP_LEFT);

                // Label to display student information
                Label studentInfoLabel = new Label(student.getName() + " - " + student.getID() + " - " + student.getLearningHours());
                studentBox.getChildren().add(studentInfoLabel);

                // Status label for displaying course status
                Label statusLabel = new Label("Status: ");
                statusLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
                studentBox.getChildren().add(statusLabel);

                // Drop-down menu to select a course
                ComboBox<Course> courseComboBox = new ComboBox<>();
                courseComboBox.getItems().addAll(main.getCourses());
                studentBox.getChildren().add(courseComboBox);

                // ListView to display enrolled courses
                ListView<Course> enrolledCoursesList = new ListView<>();
                enrolledCoursesList.setPrefHeight(100);

                for (Course course : student.getEnrolledCourses()) {
                    enrolledCoursesList.getItems().add(course);
                }
                studentBox.getChildren().add(enrolledCoursesList);

                // Button to enroll in the selected course
                Button enrollButton = new Button("Enroll in Course");
                enrollButton.setOnAction(e -> {
                    Course selectedCourse = courseComboBox.getValue(); // Get the selected course from the combo box
                    if (selectedCourse != null && !student.isEnrolledInCourse(selectedCourse)) {
                        student.enroll(selectedCourse); // Enroll the student in the selected course
                        enrolledCoursesList.getItems().add(selectedCourse); // Update the enrolled courses list
                    }
                });

                // Add buttons to attempt quiz and assignment if available
                Button attemptQuizButton = new Button("Attempt Quiz");
                attemptQuizButton.setDisable(true); // Initially disabled
                attemptQuizButton.setOnAction(e -> {
                    Course selectedCourse = enrolledCoursesList.getSelectionModel().getSelectedItem();
                    if (selectedCourse != null && selectedCourse.getQuiz() != null) {
                    	showAttemptQuiz(selectedCourse.getQuiz(),student,selectedCourse.getQuiz().getNumOfQuestions(),selectedCourse);
                        
                        if(student.isFinishedCourse(selectedCourse)) {
                            statusLabel.setText("Status: Finished");
                        }
                        attemptQuizButton.setDisable(true);
                    }
                });

                Button attemptAssignmentButton = new Button("Attempt Assignment");
                attemptAssignmentButton.setDisable(true); // Initially disabled
                attemptAssignmentButton.setOnAction(e -> {
                    Course selectedCourse = enrolledCoursesList.getSelectionModel().getSelectedItem();
                    if (selectedCourse != null && selectedCourse.getAssignment() != null) {
                        student.randAssignmentSub(selectedCourse);
                        showAttemptResult("Assignment",student.getAssignmentScore(selectedCourse));
                        if(student.isFinishedCourse(selectedCourse)) {
                            statusLabel.setText("Status: Finished");
                            studentInfoLabel.setText(student.getName() + " - " + student.getID() + " - " + student.getLearningHours());
                        }
                        attemptAssignmentButton.setDisable(true);
                    }
                });

                // Enable the attempt buttons based on course selection
                enrolledCoursesList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue != null && (!(student.isFinishedCourse(newValue)))) {
                        statusLabel.setText("Status: Pending");
                        attemptQuizButton.setDisable(newValue.getQuiz() == null);
                        attemptAssignmentButton.setDisable(newValue.getAssignment() == null);
                    } else {
                        statusLabel.setText("Status: Finished");
                        studentInfoLabel.setText(student.getName() + " - " + student.getID() + " - " + student.getLearningHours());
                        attemptQuizButton.setDisable(true);
                        attemptAssignmentButton.setDisable(true);
                    }
                });

                // Add components to student box
                HBox buttonsBox = new HBox(10);
                buttonsBox.getChildren().addAll(courseComboBox, enrollButton, attemptQuizButton, attemptAssignmentButton);
                studentBox.getChildren().add(buttonsBox);

                // Set a minimum height for the studentBox
                studentBox.setMinHeight(200); // Adjust this value as needed

                studentContainer.getChildren().add(studentBox);
            }

        }

        scrollPane.setContent(studentContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        container.getChildren().add(scrollPane);
    }

    // Method to show the attempt result in a popup window
    private void showAttemptResult(String taskType, int score) {
        Stage resultStage = new Stage();
        VBox resultBox = new VBox(10);
        resultBox.setPadding(new Insets(20));
        resultBox.setAlignment(Pos.CENTER);

        Label resultLabel = new Label(taskType + " attempted successfully!");
        Label scoreLabel = new Label("Score: " + score);

        resultBox.getChildren().addAll(resultLabel, scoreLabel);

        Scene resultScene = new Scene(resultBox, 300, 150);
        resultStage.setScene(resultScene);
        resultStage.setTitle("Attempt Result");
        resultStage.show();
    }
    
    private void showAttemptQuiz(Quiz quiz,Student student,int numQuestions,Course selectedCourse)
    {
    	Stage attemptStage = new Stage();
    	VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);
        vbox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        Button submitButton = new Button("Submit");

        Text[] questions = new Text[numQuestions];

        for (int i = 0; i < numQuestions; i++) {
            questions[i] = new Text();
            questions[i].setFont(Font.font("Verdana", FontWeight.BOLD, 14));
            questions[i].setText("Q" + (i + 1) + ". " + quiz.getQuestions().get(i).getQuestion());

            VBox questionBox = new VBox(10, questions[i]);
            questionBox.setPadding(new Insets(10));
            questionBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

            vbox.getChildren().add(questionBox);

            HBox choicesBox = new HBox(35);
            choicesBox.setAlignment(Pos.CENTER);

            for (int j = 0; j < 4; j++) {
                Circle choiceCircle = new Circle(10, Color.DARKGRAY);
                Text choice = new Text();
                choice.setFont(Font.font("Verdana", 13));
                choice.setText((char) ('A' + j) + ". " + quiz.getQuestions().get(i).getChoices()[j]);

                HBox choiceContainer = new HBox(10, choiceCircle, choice);
                choicesBox.getChildren().add(choiceContainer);
            }

            vbox.getChildren().add(choicesBox);
        }
        
        submitButton.setOnAction(e -> {
        	student.randQuizSub(selectedCourse);
            showAttemptResult("Quiz", student.getQuizScore(selectedCourse));
            attemptStage.close();
        });

        vbox.getChildren().add(submitButton);

        ScrollPane scrollPane = new ScrollPane(vbox);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        Scene scene = new Scene(scrollPane, 500, 500); // Scene size is 500x500
        attemptStage.setScene(scene);
        attemptStage.setResizable(false);
        attemptStage.setTitle("Question App");
        attemptStage.show();
    }
}
