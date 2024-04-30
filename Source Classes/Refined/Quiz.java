import java.util.ArrayList;

public class Quiz {
	private String QuizName;
	private static int counter = 1;
	private int averageScore = 0;
	private ArrayList<MCQ> questions = new ArrayList<MCQ>();
	private ArrayList<Integer> studentAnswer = new ArrayList<Integer>();
	
	public Quiz(String QuizName) {
		this.QuizName = QuizName;
	}
	public Quiz() {
		QuizName = "unnamed" + counter;
		counter ++;
	}
	
	public ArrayList<MCQ> getQuestions() {
		return questions;
	}
	public void setQuestions(ArrayList<MCQ> questions) {
		this.questions = questions;
	}
	
	public ArrayList<Integer> getStudentAnswer() {
		return studentAnswer;
	}
	public void setStudentAnswer(ArrayList<Integer> studentAnswer) {
		this.studentAnswer = studentAnswer;
	}
	
	public int getAverageScore() {
		try {
			for(int i = 0; i < questions.size() ;i++) {
				if ( studentAnswer.get(i).intValue() == questions.get(i).getAnswer()) {
					averageScore ++;
				}
			}
		}
		catch(IndexOutOfBoundsException e) {
			return 0;
		}
		return averageScore;
	}
	public String getQuizName() {
		return QuizName;
	}
	public void setQuizName(String quizName) {
		QuizName = quizName;
	}
	
}
