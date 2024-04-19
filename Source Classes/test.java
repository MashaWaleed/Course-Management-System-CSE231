package javaproject;
import java.util.ArrayList;
import java.util.Arrays;
public class test {

    public static void main(String[] args) {
        Instructor[] Instructors= new Instructor[2];
   try{ 
             Instructors[0] =new Instructor ("Instructor 0","123123","male",54,"electronics");
             Instructors[1]= new Instructor("Instructor 1","321321","female",43,"computer");         
   }
   catch(InvalideAgeException ex){
       System.out.println(ex);
   }
CourseTest [] Courses={new CourseTest("embedded",4,Instructors[0]),//0
                   new CourseTest("java",7,Instructors[0]),//1
                   new CourseTest("control",11,Instructors[0]),//2
                   new CourseTest("digital",1,Instructors[1]),//3
                   new CourseTest("electronics",17,Instructors[1]),//4
                   new CourseTest("signal",9,Instructors[1])};//5
Student [] Students=new Student[6];
try{
             Students[0] =new Student("Student 0","123123","male",21,"engineering");
             Students[1] =new Student("Student 1","321321","female",23,"engineering");
             Students[2] =new Student("Student 2","123321","male",22,"Computer science");
             Students[3] =new Student("Student 3","321123","female",20,"Computer science");
             Students[4] =new Student("Student 4","231231","male",21,"engineering");
             Students[5] =new Student("Student 5","312312","female",23,"Computer science");        
   }
   catch(InvalideAgeException ex){
       System.out.println(ex);
   }
    Students[0].enroll(Courses[4]);Students[0].enroll(Courses[0]);
    Students[1].enroll(Courses[3]);Students[1].enroll(Courses[5]);
    Students[2].enroll(Courses[4]);Students[2].enroll(Courses[0]);
    Students[3].enroll(Courses[2]);Students[3].enroll(Courses[1]);
    Students[4].enroll(Courses[2]);Students[4].enroll(Courses[0]);
    Students[5].enroll(Courses[4]);Students[5].enroll(Courses[3]);
    Students[0].attemptassignments(Courses[4]);Students[0].attemptassignments(Courses[0]);
    Students[1].attemptassignments(Courses[3]);
    Students[2].attemptassignments(Courses[4]);Students[2].attemptassignments(Courses[0]);
    Students[3].attemptassignments(Courses[1]);
    Students[4].attemptassignments(Courses[2]);Students[4].attemptassignments(Courses[0]);
    Students[5].attemptassignments(Courses[4]);
        for (Student Student : Students) {
            Student.displayInfo();
            Student.printenrolledCourses();
            Student.printfinishedCourses();
            System.out.println("********************************************");
        }
Arrays.sort(Students);
  System.out.println("leadboard:-");
for(int i=0;i<Students.length;i++){
    System.out.println((i+1)+"-"+Students[i].getName());
}
 System.out.println("********************************************");
        for (Instructor Instructor : Instructors) {
            Instructor.displayInfo();
            Instructor.printTaughtCourses();
            System.out.println("********************************************");
        }

        for (CourseTest Course : Courses) {
            System.out.println(Course.getName());
            Course.printenrolledstudents();
            System.out.println("********************************************");
        }
}
}
