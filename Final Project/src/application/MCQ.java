package application;
public class MCQ {
	private String Question;
	private String[] choices;
	private int answer;
	
	public MCQ(String Question, String[] choices, int answer) {
		this.Question = Question;
		this.choices = choices;
		this.answer = answer;
	}
	
	public MCQ() {
		choices  = new String[4];
	}
	
	public String[] getChoices() {
		return choices;
	}
	public void setChoices(String[] choices) {
		this.choices = choices;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	
	public boolean checkAnswer (int answer) {
		if(this.answer == answer) {
			return true;
		}
		return false;
	}
}
