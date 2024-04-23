package project;
import java.util.ArrayList;
/*
 * TODO:
 * -remove for instructor and students
 * 
 * 
 * 
 * */

public class Course implements Comparable<Course> {
	public static int CoursesSpawned = 0;
	private String name, description;
	int price;
	private ArrayList<review> reviews= new ArrayList<review>();
	private Instructor inst;
	private ArrayList<Student> stud = new ArrayList<>();
	private ArrayList<module> modules = new ArrayList<>();
	Course(){CoursesSpawned++;}
	Course(String name, String desc, Instructor inst, int price){
		this();
		this.name = name;
		this.description = desc;
		this.inst = inst;
		this.price = price;
		
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
		for(int i = 0; i < this.stud.size(); i++) {
			System.out.println(this.stud.get(i).getName());
		}
	}
	public void addStudent(Student x) {
		this.stud.add(x);
	}
	public void deleteStudent(int index) {
		this.stud.remove(index);
	}
	public void deleteStudentByID(int ID) {
		for(int i = 0; i < this.stud.size(); i++) {
			if(this.stud.get(i).getID() == ID) {
				this.stud.remove(i);
			}
		}
		
	}
	public float getAvgStars() {
		float stars;
		for(int i=0;i<reviews.size();i++) {
			stars += this.reviews.get(i).getStars();
		}
		return stars/this.reviews.size();
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
		reviews.add(new review(stars, feedback));
	}
	public void removeReviewByID(int ID) {
		for(int i=0;i<reviews.size();i++) {
			if(reviews.get(i).getID() == ID) {
				reviews.remove(i);
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
}
class Student{
	String getName() {return "string";}
	int getID() {return 12;}
}
class Instructor{}
class review{
	
	private static int id_count = 0;
	private int id;
	private int stars;
	private String feedback;
	review(){
		id_count++;
		this.id = id_count;
	}
	review(int stars, String feedback){
		this();
		this.stars=stars;
		this.feedback=feedback;
		
	}
	public int getID() {
		return this.id;
	}
	public float getStars() {
		return this.stars;
	}
	public String getFeedback() {
		return this.feedback;
	}
}
class module implements Comparable<module>{
	public int modulesSpawned = 0;
	private float durationHours;
	private String name;
	module(){modulesSpawned++;}
	module(int hrs,String name){
		this();
		this.durationHours = hrs;
		this.name = name;
	}
	@Override public int compareTo(module comp) {
		if(this.getDuration() > comp.durationHours) {return 1;}
		else if(this.getDuration() == comp.durationHours) {return 0;}
		else {return 0;}
	}
	String getName() {
		return this.name;
	}
	float getDuration() {
		return this.durationHours;
	}
}