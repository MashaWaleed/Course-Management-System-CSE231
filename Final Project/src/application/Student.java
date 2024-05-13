package application;

import java.util.ArrayList;
import java.util.Random;

public class Student extends User {
    private String faculty;
    private int ID;
    private ArrayList<Course> enrolledCourses = new ArrayList<Course>();
    
    private ArrayList<Integer> quizScores = new ArrayList<Integer>();
    private ArrayList<Integer> assignmentScores = new ArrayList<Integer>();
    
    private ArrayList<Course> finishedCourses = new ArrayList<Course>();
    private int learningHours;

    public Student() {
    }

    public Student(String name, String password, String gender, int age, String faculty, int ID)
            throws InvalideAgeException {
        super(name, password, gender, age);
        setFaculty(faculty);
        setID(ID);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getLearningHours() {
        this.learningHours = this.totalLearningHours();
        return learningHours;
    }

    public void setLearningHours(int learninghours) {
        this.learningHours = learninghours;
    }

    public void enroll(Course course) {
        getEnrolledCourses().add(course);
        course.addStudent(this);
    }

    public void unroll(Course course) {
        getEnrolledCourses().remove(course);
        course.deleteStudent(this);
    }

    public ArrayList<String> attemptAssignments(Course course, Assignment assignment) throws IllegalArgumentException {
        getFinishedCourses().add(course);
        learningHours = totalLearningHours();
        return assignment.getQuestions();
    }

    public void submitAssignment(Course course, Assignment assignment) {
        if (getEnrolledCourses().contains(course)) {
            assignment.setScore(10); // assume final score is 10}
        }
    }

    public ArrayList<MCQ> attemptQuiz(Course course, Quiz quiz) {
        return quiz.getQuestions();
    }

    public String submitQuiz(Course course, Quiz quiz, int StudentCorrectAnswers) {
        return String.valueOf((quiz.getAverageScore()));
    }

    public void printEnrolledCourses() {
        if (!(getEnrolledCourses().isEmpty())) {
            for (int i = 0; i < getEnrolledCourses().size(); i++) {
                System.out.println("enrolledCourses" + (i + 1) + ": "
                        + (getEnrolledCourses().get(i)).getName());
            }
        }
    }

    public void printFinishedCourses() {
        if (!(getFinishedCourses().isEmpty())) {
            for (int i = 0; i < getFinishedCourses().size(); i++) {
                System.out.println("finishedCourses" + (i + 1) + ": "
                        + (getFinishedCourses().get(i)).getName());
            }
        }
    }

    private int totalLearningHours() {
        int x = 0;
        if (!(getFinishedCourses().isEmpty())) {
            for (int i = 0; i < getFinishedCourses().size(); i++) {
                x += ((getFinishedCourses().get(i)).getDuration());
            }
        }
        return x;
    }

    @Override
    public void displayInfo() {
        System.out.println("Student Name: " + getName());
        System.out.println("Student password: " + getPassword());
        System.out.println("Student gender: " + getGender());
        System.out.println("Student age: " + getAge());
        System.out.println("Student faculty: " + getFaculty());
        System.out.println("Student account date: " + getDate());
        System.out.println("learning hours: " + learningHours);
    }


    @Override
  public int compareTo(User o) {
        return this.getName().compareTo(o.getName());
    } 
  
    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(ArrayList<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public ArrayList<Course> getFinishedCourses() {
        return finishedCourses;
    }

    public void setFinishedCourses(ArrayList<Course> finishedCourses) {
        this.finishedCourses = finishedCourses;
    }

    public ArrayList<String> getEnrolledCoursesNames() {
        ArrayList<String> courseNames = new ArrayList<String>();
        for (Course course : enrolledCourses) {
            courseNames.add(course.getName());
        }
        return courseNames;
    }

    public boolean isEnrolledInCourse(Course course) {
        return enrolledCourses.contains(course);
    }

    public boolean isFinishedCourse(Course c) {
        if (finishedCourses.contains(c)) {
            return true; // Course is already in finishedCourses list
        } else {
            int index = enrolledCourses.indexOf(c);
            if (index != -1) {
                if (index < quizScores.size() && index < assignmentScores.size()) {
                    Integer quizScore = quizScores.get(index);
                    Integer assignmentScore = assignmentScores.get(index);
                    if (quizScore != null && assignmentScore != null) {
                        finishedCourses.add(c);
                        return true; // Both quiz and assignment have been attempted
                    }
                }
            }
            return false; // Course not found in enrolledCourses or not attempted both quiz and assignment
        }
    }

    // FOR TESTING AND BREVITY

    public void randQuizSub(Course c) {
        int index = enrolledCourses.indexOf(c);
        if (index != -1) {
            Random random = new Random();
            int score = random.nextInt(11); // Generate a random score between 0 and 10
            if (index < quizScores.size()) {
                quizScores.set(index, score);
            } else {
                while (quizScores.size() <= index) {
                    quizScores.add(null);
                }
                quizScores.set(index, score);
                this.isFinishedCourse(c);
            }
            System.out.println("Random quiz score for course " + c.getName() + ": " + score);
        } else {
            System.out.println("Student is not enrolled in course " + c.getName());
        }
    }

    public void randAssignmentSub(Course c) {
        int index = enrolledCourses.indexOf(c);
        if (index != -1) {
            Random random = new Random();
            int score = random.nextInt(11); // Generate a random score between 0 and 10
            if (index < assignmentScores.size()) {
                assignmentScores.set(index, score);
            } else {
                while (assignmentScores.size() <= index) {
                    assignmentScores.add(null);
                }
                assignmentScores.set(index, score);
                this.isFinishedCourse(c);
            }
            System.out.println("Random assignment score for course " + c.getName() + ": " + score);
        } else {
            System.out.println("Student is not enrolled in course " + c.getName());
        }
    }

    public int getQuizScore(Course c) {
        if (enrolledCourses.contains(c)) {
            int index = enrolledCourses.indexOf(c);
            if (index >= 0 && index < quizScores.size()) {
                Integer score = quizScores.get(index);
                return score != null ? score : -1;
            }
        }
        return -1;
    }

    public int getAssignmentScore(Course c) {
        if (enrolledCourses.contains(c)) {
            int index = enrolledCourses.indexOf(c);
            if (index >= 0 && index < assignmentScores.size()) {
                Integer score = assignmentScores.get(index);
                return score != null ? score : -1;
            }
        }
        return -1;
    }
    @Override
  public String toString() {
        return getName();
    }
}