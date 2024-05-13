package application;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class InstructorsScene extends Scene {

    private Main main;
    private int numQuestions = 0;

    public InstructorsScene(Stage primaryStage, Main main) {
        super(new VBox(), 750, 600);
        this.main = main;
        VBox container = (VBox) this.getRoot();
        container.setPadding(new Insets(10));
        container.setSpacing(10);

        // Add navigation buttons for Admin, Students, and Courses scenes
        HBox navButtons = new HBox(10);
        Button adminButton = new Button("Admin");
        adminButton.setOnAction(e -> main.showAdminScene());

        Button studentsButton = new Button("Students");
        studentsButton.setOnAction(e -> main.showStudentsScene());

        Button coursesButton = new Button("Courses");
        coursesButton.setOnAction(e -> main.showCoursesScene());

        Button statsButton = new Button("Stats");
        statsButton.setOnAction(e -> main.showStatsScene());

        navButtons.getChildren().addAll(adminButton, studentsButton, coursesButton, statsButton);
        container.getChildren().add(navButtons);

        ScrollPane scrollPane = new ScrollPane();
        VBox instructorContainer = new VBox(10);
        instructorContainer.setPadding(new Insets(10));
        instructorContainer.setSpacing(10);

        if (main.getInstructors().isEmpty()) {
            Label noInstructorsLabel = new Label("No Instructors Registered On System");
            noInstructorsLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 18px;");
            instructorContainer.getChildren().add(noInstructorsLabel);
        } else {
            // Iterate over each instructor to create a section for each
            for (Instructor instructor : main.getInstructors()) {
                VBox instructorBox = new VBox(10);
                instructorBox.setPadding(new Insets(10));
                instructorBox.setAlignment(Pos.TOP_LEFT);

                // Label to display instructor information
                Label instructorInfoLabel = new Label(instructor.getName() + " - " + instructor.getDepartment());
                instructorBox.getChildren().add(instructorInfoLabel);

                // HBox for the ComboBox, "Teach Course" button, "Create Quiz" button, and "Create Assignment" button
                HBox courseSelectionBox = new HBox(10);
                ComboBox<Course> courseComboBox = new ComboBox<>();
                courseComboBox.getItems().addAll(main.getCourses());

                // ListView to display courses taught by the instructor
                ListView<Course> taughtCoursesListView = new ListView<>();
                taughtCoursesListView.setPrefHeight(100); // Set a fixed height for the ListView

                for (Course course : instructor.getTaughtCourses()) {
                    taughtCoursesListView.getItems().add(course);
                }
                instructorBox.getChildren().add(taughtCoursesListView);

                Button addCourseButton = new Button("Teach Course");
                addCourseButton.setOnAction(e -> {
                    Course selectedCourse = courseComboBox.getValue();
                    if (selectedCourse != null && !instructor.isTeachingCourse(selectedCourse)) {
                        instructor.addCourse(selectedCourse);
                        selectedCourse.setInstructor(instructor);
                        taughtCoursesListView.getItems().add(selectedCourse);
                    }
                });

                Button createQuizButton = new Button("Create Quiz");
                createQuizButton.setOnAction(e -> {
                    Course selectedCourse = taughtCoursesListView.getSelectionModel().getSelectedItem();
                    if (selectedCourse != null && selectedCourse.getQuiz() == null) {
                        Quiz q = new Quiz();
                        showQuizCreationScene1(q);
                        
                        selectedCourse.setQuiz(q);
                        System.out.println("Creating quiz for: " + selectedCourse.getName());
                        createQuizButton.setDisable(true);

                    }
                });

                Button createAssignmentButton = new Button("Create Assignment");
                createAssignmentButton.setOnAction(e -> {
                    Course selectedCourse = taughtCoursesListView.getSelectionModel().getSelectedItem();
                    if (selectedCourse != null && selectedCourse.getAssignment() == null) {
                        Assignment a = new Assignment();
                        selectedCourse.setAssignment(a);
                        System.out.println("Creating assignment for: " + selectedCourse.getName());
                        createAssignmentButton.setDisable(true);
                    }
                });

                // Disable the buttons initially
                addCourseButton.setDisable(true);
                createQuizButton.setDisable(true);
                createAssignmentButton.setDisable(true);

                // Enable the buttons when a course is selected from the ListView
                taughtCoursesListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                    createQuizButton.setDisable(newValue == null || newValue.getQuiz() != null);
                    createAssignmentButton.setDisable(newValue == null || newValue.getAssignment() != null);
                });

                // Enable the "Teach Course" button based on the selection in the ComboBox
                courseComboBox.setOnAction(event -> {
                    Course selectedCourse = courseComboBox.getValue();
                    addCourseButton.setDisable(selectedCourse == null || instructor.isTeachingCourse(selectedCourse));
                });

                // Add buttons to the courseSelectionBox
                courseSelectionBox.getChildren().addAll(courseComboBox, addCourseButton, createQuizButton, createAssignmentButton);
                instructorBox.getChildren().add(courseSelectionBox);

                // Set a minimum height for the instructorBox
                instructorBox.setMinHeight(200); // Adjust this value as needed

                instructorContainer.getChildren().add(instructorBox);
            }
        }

        scrollPane.setContent(instructorContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        container.getChildren().add(scrollPane);
    }
    
    public void showQuizCreationScene1(Quiz quiz)
    {
    	
    	Stage QuizStage = new Stage();
    	// Create a VBox to hold the text fields
        VBox scene1Layout = new VBox();
        scene1Layout.setSpacing(8);
        
        Button btk = new Button("Next");

        // Create a TextField for quiz title
        TextField quizTitle = new TextField();
        quizTitle.setPromptText("Quiz Title");
        
        // Create a TextField for choosing the number of questions
        TextField numQuestionsField = new TextField();
        numQuestionsField.setPromptText("Enter number of questions");

        // Add the numQuestionsField to the VBox
        scene1Layout.getChildren().addAll(quizTitle ,numQuestionsField, btk);

        
        btk.setOnAction(e -> {
        	try {
        	numQuestions = Integer.parseInt(numQuestionsField.getText());
        	quiz.setQuizName(quizTitle.getText());
        	showQuizCreationScene2(QuizStage,quiz);
        	
	        }
	        catch(NumberFormatException ex) {
	        	Stage errorStage = new Stage();
	        	StackPane ERRORroot = new StackPane();
	        	Scene errorHandleScene = new Scene(ERRORroot , 300, 150);
	        	
	        	
	        	Text text = new Text();
	        	text.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
	        	text.setText("Invalid amount of questions !!");
	        	text.setTextAlignment(TextAlignment.CENTER);
	        	ERRORroot.getChildren().add(text);
	        	
	        	errorStage.setTitle("num of Questions error");
	        	errorStage.setResizable(false);
	        	errorStage.setScene(errorHandleScene);
	        	errorStage.show();
	        }
        });
        
        Scene scene1 = new Scene(scene1Layout, 400, 200);
        // Set initial scene
        QuizStage.setScene(scene1);
        QuizStage.setResizable(false);
        QuizStage.setTitle("Question App");
        QuizStage.show();
    }
    
    public void showQuizCreationScene2(Stage QuizStage,Quiz quiz)
    {
    	VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        
       
        
        Button btk2 = new Button("Submit");
        
        // Create an array of TextFields for the questions
        TextField[] questionFields = new TextField[numQuestions];
        
        // Create an arrayList for choices textfield array
        ArrayList <TextField[]> choicesFields = new ArrayList<TextField[]>();
        
        
        for (int i = 0; i < numQuestions; i++) {
            questionFields[i] = new TextField();
            questionFields[i].setPromptText("Question " + (i + 1));
            vbox.getChildren().add(questionFields[i]);
            
            for(int j = 0; j < 4; j+=2) {
            	
            	HBox hbox = new HBox();
            	
            	hbox.setAlignment(Pos.CENTER);
                hbox.setSpacing(50);

            	
            	choicesFields.add(new TextField[4]);
            	
            	choicesFields.get(i)[j] = new TextField();
            	choicesFields.get(i)[j].setPrefWidth(220);
            	
            	choicesFields.get(i)[j+1] = new TextField();
            	choicesFields.get(i)[j+1].setPrefWidth(220);
            	
            	choicesFields.get(i)[j].setPromptText("Choice" + (j+1));
            	choicesFields.get(i)[j+1].setPromptText("Choice" + (j+2));
            	
                // setting it to full width
            	
            	
            	hbox.getChildren().addAll(choicesFields.get(i)[j], choicesFields.get(i)[j+1]);
            	
            	vbox.getChildren().add(hbox);
            }   
        }
       
        btk2.setOnAction(e -> {
        	for (int i = 0; i < numQuestions; i++) {
        		quiz.getQuestions().add(new MCQ());
        		quiz.getQuestions().get(i).setQuestion(questionFields[i].getText());
        		
        		String[] tempString = new String[4];
        		for(int j = 0; j < 4; j++) {
        			tempString[j] = choicesFields.get(i)[j].getText();
        		}
        		quiz.getQuestions().get(i).setChoices(tempString);
        	}
        	QuizStage.close();
        });
        vbox.getChildren().add(btk2);
        
        // Create a ScrollPane to allow scrolling between the fields
        ScrollPane scrollPane = new ScrollPane(vbox);
        scrollPane.setFitToWidth(true);
        Scene scene2 = new Scene(scrollPane, 500, 500);
        // Set the scene and show the stage
        QuizStage.setScene(scene2);
    }
}
