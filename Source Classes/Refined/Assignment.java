import java.util.ArrayList;

public class Assignment {
	
	private String assignmentName;
	private ArrayList <String> Questions = new ArrayList<String>();
	private int Score;
	
	public Assignment(ArrayList<String> Questions , String assignmentName) {
		this.assignmentName = assignmentName;
		this.Questions = Questions;
	}
	public Assignment() {
		setAssignmentName("unnamed") ;
	}
	
	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}

	public ArrayList <String> getQuestions() {
		return Questions;
	}
	
	public void setQuestions(ArrayList <String> questions) {
		Questions = questions;
	}
	
	public void setOneQuestion(String Question) {
		Questions.add(Question);
	}
	
	public String getOneQuestion(int QuestionIndex) {
		try {
			return Questions.get(QuestionIndex);
		}
		catch(IndexOutOfBoundsException e) 
		{
			return "Question doesn't exist";
		}
	}
	public String getAssignmentName() {
		return assignmentName;
	}
	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}
	
}
