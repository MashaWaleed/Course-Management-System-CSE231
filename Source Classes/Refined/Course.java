package project.Refined;

import java.util.ArrayList;

public class Course implements Comparable<Course> {
	
	public static int CoursesSpawned = 0;
	private String name, description;
	private int price;
	private int duration;
	private ArrayList<Review> reviews= new ArrayList<Review>();
	private Instructor inst;
	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<Module> modules = new ArrayList<Module>();
	private ArrayList<Assignment> assignments = new ArrayList<Assignment>(); 
	private ArrayList<Quiz> quizzes = new ArrayList<Quiz>(); 
	
	Course(){CoursesSpawned++;}
	
	Course(String name, String desc, Instructor inst, int price, int duration){
		this();
		this.name = name;
		this.description = desc;
		this.inst = inst;
		this.setPrice(price);
		setDuration(duration);
		
	}
	@Override public int compareTo(Course comp) {//need avg stars!
		if(this.getAvgStars()>comp.getAvgStars()){return 1;}
		else if(this.getAvgStars()==comp.getAvgStars()){return 0;}
		else {return -1;}
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String desc) {
		this.description = desc;
	}
	public Instructor getInstructor() {
		return this.inst;
	}
	public void setInstructor(Instructor inst) {
		this.inst = inst;
	}
	public void showStudents() {
		for(int i = 0; i < this.getStudents().size(); i++) {
			System.out.println(this.getStudents().get(i).getName());
		}
	}
	public void addStudent(Student x) {
		this.getStudents().add(x);
	}
	public void deleteStudent(Student x) {
		this.getStudents().remove(x);
	}
	public void deleteStudentByID(int ID) {
		for(int i = 0; i < this.getStudents().size(); i++) {
			if(this.getStudents().get(i).getID() == ID) {
				this.getStudents().remove(i);
			}
		}
		
	}
	public float getAvgStars() {
		float stars = 0;
		for(int i=0;i<getReviews().size();i++) {
			stars += this.getReviews().get(i).getStars();
		}
		return stars/this.getReviews().size();
	}	
	public void showModules() {
		for(int i = 0; i < this.modules.size(); i++) {
			System.out.println(this.modules.get(i).getName());
		}
	}
	public void removeModuleByName(String name) {
		for(int i = 0; i < this.modules.size(); i++) {
			if(this.modules.get(i).getName()==name) {
				this.modules.remove(i);
			}
		}
	}
	public void addReview(int stars, String feedback) {
		getReviews().add(new Review(stars, feedback));
	}
	public void removeReviewByID(int ID) {
		for(int i=0;i<getReviews().size();i++) {
			if(getReviews().get(i).getID() == ID) {
				getReviews().remove(i);
			}
		}
	}
	float getTotalDuration() {
		float total = 0;
		for(int i=0;i<modules.size();i++) {
			total += modules.get(i).getDuration();
		}
		return total;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public ArrayList<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(ArrayList<Assignment> assignments) {
		this.assignments = assignments;
	}

	public ArrayList<Quiz> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(ArrayList<Quiz> quizzes) {
		this.quizzes = quizzes;
	}

	// New method to add an assignment to the course
	public void addAssignment(Assignment assignment) {
	    assignments.add(assignment);
	}

	// New method to remove an assignment from the course
	public void removeAssignment(Assignment assignment) {
	    assignments.remove(assignment);
	}

	// New method to add a quiz to the course
	public void addQuiz(Quiz quiz) {
	    quizzes.add(quiz);
	}

	// New method to remove a quiz from the course
	public void removeQuiz(Quiz quiz) {
	    quizzes.remove(quiz);
	}

	public ArrayList<Review> getReviews() {
		return reviews;
	}

	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	
	
}
