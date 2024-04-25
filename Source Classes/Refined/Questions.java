package application;


public class Questions {
	private int choiceSize = 4;
	private String question;
	private String[] choices = new String[choiceSize];
	private int correctAnswer;
	
	/* functions that inputs choices of the questions */
	public Questions(String question, String[] choices, int correctAnswer) {
		this.question = question;
		this.choices = choices;
		this.correctAnswer = correctAnswer;
	}
	public Questions() {
		
	}
	
//	public void  setQChoices () {
//		for (int choiceSelector = 0 ; choiceSelector < choiceSize ; choiceSelector++) {
//			System.out.println("Enter choice no." + (choiceSelector +1));
//			choices[choiceSelector] = input.nextLine();
//		}
//	}
	
//	public void setCorrectAnswer (int correctAnswer) {
//		this.correctAnswer = correctAnswer;
//	}
	
	/* function checks if the user's choice number is same as the instructor choice number */
	public boolean checkAnswer (int userChoice) {
		if(correctAnswer == userChoice) {
			return true;
		}
		return false;
	}

	public void viewChoices() {
		for(int printIndex = 0; printIndex < choices.length ; printIndex++) {
			System.out.println((printIndex + 1) + ". " + choices[printIndex]);
		}
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	

}
