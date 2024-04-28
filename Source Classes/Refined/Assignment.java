package project.Refined;
//import java.util.InputMismatchException;
//import java.util.Scanner;
//import java.util.ArrayList;

public class Assignment {
	//Scanner input = new Scanner(System.in);
	
	private int averageScore = 0;
	private int AssignmentID;
	private int numOfQuestions;
	private int endDay;
	private int endMonth;
	private int endYear;
	private myDate endDate;
	private Quiz quiz = new Quiz();
	
	public Assignment() {
		
	}
	public Assignment(int endDay,int endMonth, int endYear, int numOfQuestions ,String[] question, String[][] questionAnswer,int[] correctAnswer) {
		this.endDay = endDay;
		this.endMonth = endMonth;
		this.endYear = endYear;
		this.numOfQuestions = numOfQuestions;
		quiz.setQuestions(question);
		quiz.setQuestionsAnswers(questionAnswer);
		quiz.setCorrectAnswers(correctAnswer);
	}
	
	public void addQuiz () {
		for(int questionI = 0; questionI < numOfQuestions; questionI++) {
			quiz.addQuestion();
		}
		
	}
	public void RemoveQuiz () {
		quiz = null;
	}
	
	public void createAssignmentDate() {
		endDate = new myDate(endDay, endMonth, endYear);
		if(endDate.isValid() == false) {
			System.out.println("The date is invalid");
			endDate = new myDate(0,0,0);
		}
		else {
			System.out.println(endDate.toString());
		}
	}
	
	public int getAverageScore () {
		return averageScore;	
	}
	
	public void takeQuiz() {
//		int temp;
//		int sizeOfArray = quiz.getAnswerSheet().size();
//		int[] answerStream = new int[sizeOfArray];
		System.out.println("The Quiz is "+ quiz.getTotalQuestions() + " Questions");
		if(quiz != null) {
			quiz.viewQuiz();
			
		}
		else {
			System.out.println("This Exam is not Avaliable");
		}
	}
	
	
	
	/******************************************************************************************************
	 Normal Setters and Getters
	*******************************************************************************************************/
	
	
	public int getAssignmentID() {
		return AssignmentID;
	}
	public void setAssignmentID(int assignmentID) {
		AssignmentID = assignmentID;
	}
	public int getEndDay() {
		return endDay;
	}
	public void setEndDay(int endDay) {
		
		this.endDay = endDay;
	}
	public int getEndMonth() {
		return endMonth;
	}
	public void setEndMonth(int endMonth) {
		this.endMonth = endMonth;
	}
	public int getEndYear() {
		return endYear;
	}
	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}
	
}
