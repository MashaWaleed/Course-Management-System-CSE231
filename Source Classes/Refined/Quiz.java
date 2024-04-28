package project.Refined;
import java.util.ArrayList;
//import java.util.InputMismatchException;
import java.util.Scanner;

public class Quiz {
	
	Scanner input = new Scanner(System.in);
	private int counter = 0;
	//private int[] correctAnswerStream = new int[4];
	private String[] questions;
	private String[][] questionsAnswers;
	private int[] correctAnswers;
//	private ArrayList<Integer> correctAnswerStream = new ArrayList<Integer>();
	private ArrayList<Questions> questionStream = new ArrayList<Questions>();
//	public Quiz(String[] question, String[][] questionAnswer,int correctAnswer) {
//		
//	}
	public void addQuestion () {
		questionStream.add(new Questions(questions[counter],questionsAnswers[counter],correctAnswers[counter]));
//		correctAnswerStream.add(counter);
		counter++;	
	}
	
	public void removeQuestion (int questionNumber) {
		try {
			questionStream.remove(questionNumber);
			System.out.println("Question no." + (questionNumber+1) +" is successfully removed");
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("This Question doesn't exist");
		}
	}
	
	public int getTotalQuestions () {
		return counter;
	}
	
	public void viewQuiz() {
		for(int i =0; i < counter; i++) {
			System.out.println("Q"+(i+1)+"."+questionStream.get(i).getQuestion());
			questionStream.get(i).viewChoices();
		}
	}
//	public ArrayList <Integer> getAnswerSheet() {
//		return correctAnswerStream;
//	}
	public String[] getQuestions() {
		return questions;
	}
	public void setQuestions(String[] questions) {
		this.questions = questions;
	}
	public String[][] getQuestionsAnswers() {
		return questionsAnswers;
	}
	public void setQuestionsAnswers(String[][] questionsAnswers) {
		this.questionsAnswers = questionsAnswers;
	}
	public int[] getCorrectAnswers() {
		return correctAnswers;
	}
	public void setCorrectAnswers(int[] correctAnswers) {
		this.correctAnswers = correctAnswers;
	}
		
}
