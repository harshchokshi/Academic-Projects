package examResult;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test {
	//List of Global Variables
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static Scanner input = new Scanner (System.in);
	static Test initiate = new Test();
	static List courses = new ArrayList();
	static List students = new ArrayList();
	static List result = new ArrayList ();
	static List resultstudent = new ArrayList();
	static ArrayList<Double> scores = new ArrayList <Double>();
    //Main Method
	public static void main(String[] args) throws Throwable {
		initiate.menu();

	}
	
	public void calculateaverage ( ) {
		//Mathematical calculation for average
		double sum = 0;
		for (int i=0; i<scores.size(); i++){
			  sum += scores.get(i);
			}
		System.out.println("Average Result: "+sum/2);
		System.out.println(" ");
	}
	
	
	public void averageScore (Object Score ) {
	    //Since, marks is of Object type force to convert into String
		String artificalNum = Score.toString();
		//String type numbers are converted into actual number
		double actualScore = Double.parseDouble(artificalNum);
		//Marks are added into the arrayList
		scores.add(actualScore);
	}
	
	public void viewStudent( ){
		System.out.println("    ");
		//Verify currently enrolled student 
		System.out.print("Please enter Student ID: ");
		String selectedStudent = input.next();
		//System checks whether student exists or not
		if (students.contains(selectedStudent)){
			System.out.println("    ");
			//Obtain student details
			int indexofStudentID = students.indexOf(selectedStudent);
			Object StudentID = students.get(indexofStudentID);
			int indexofStudentName = indexofStudentID + 1;
			Object StudentName = students.get(indexofStudentName);
			System.out.println("Result for Student: "+StudentID +" - "+StudentName);
			System.out.println(" ");
			do {
				int indexofCourse = 1 + resultstudent.indexOf(selectedStudent);
				Object CourseCode = resultstudent.get(indexofCourse);
				int indexofScore  = 1+ indexofCourse;
				Object Score  = resultstudent.get(indexofScore);
				averageScore(Score);
				//String formatter is used to align information in a tabular format
				System.out.println(String.format( "%-10s %10s %n", CourseCode, Score));
				resultstudent.remove(selectedStudent);
				System.out.println("  ");
				} while (resultstudent.contains(selectedStudent)==true);
				  calculateaverage();
			      viewResult();
			}
		else {
			System.out.println("Student does not exist");
			viewStudent();
		}
		}
	
	public void viewCourse( ){
		//ArrayList is declare to store score values
		ArrayList<Double> score = new ArrayList <Double>();
		System.out.println("    ");
		//Verify currently enrolled student
		System.out.print("Please enter course code: ");
		String selectedCourse = input.next();
		if (courses.contains(selectedCourse)){
			System.out.println("    ");
			System.out.println("Result for course: "+selectedCourse);
			System.out.println(" ");
			do {
				//System obtain information of selected course
				int coursePosition = result.indexOf(selectedCourse);
				int scorePosition = coursePosition + 1;
				int studentPosition = coursePosition-1;
				Object studentFound = result.get(studentPosition);
				int studentList = students.indexOf(studentFound);
				int studentofName = studentList + 1;
				Object studentName = students.get(studentofName);
				Object Score = result.get(scorePosition);
				String artificialScore = Score.toString();
				double actualScore = Double.parseDouble(artificialScore);
				score.add(actualScore);
				System.out.println(String.format( "%-10s %10s %7s %n", result.get(studentPosition), studentName, Score));
				result.remove(selectedCourse);
				
				} while (result.contains(selectedCourse)==true);
			      //With the help of ArrayList minimum or maximum values of score will displayed
				  System.out.println("  ");
				  System.out.println("Maximum Score: " + Collections.max(score));
				  System.out.println("Minimum Score: " + Collections.min(score));
				  System.out.println("  ");
			      viewResult();  
			}
		else {
			System.out.println("Course does not exist");
			viewCourse();
		}
	}
	
	public void viewResult() {
		//Menu select item 4
		System.out.println("Would you like to view [C] Course result, [S] Student result or [R] Return");
		char controlView  = input.next().charAt(0);
		if ((controlView =='C') || (controlView =='c') ){
			resultstudent.addAll(0, result);
			viewCourse();
		}
		if ((controlView =='S') || (controlView =='s') ){
			viewStudent();
		}
		if ((controlView =='R') || (controlView =='r') ){
			//Return to Menu
		}
		}
	
	public void verifyscore(double score) {
		if(score<0 || score >100) {
			//Enter score again
		}
		
		
	}
	
	public void verifyCourse(Result marks ) {
		String input_code;
		boolean startLoop = false;
		double score;
		//System checks whether course exists or not
		System.out.print("Enter a course Code: ");
		input_code = input.next();
		if (courses.contains(input_code)){
			marks.setInputCode(input_code);
			result.add(marks.getInputCode());
		       while(!startLoop){
		    	   System.out.print("Enter final score: ");
		    	   String line = input.next();
		           try {
		        	   score = Double.parseDouble(line);
		        	   startLoop = true;
		        	   if (score<0 || score>100) {
		        		   System.out.println("Please enter the score between 0 to 100");
		   				   startLoop = false;
		   			}
		        	   else {
					       	marks.setScore(score);
							String point = Double.toString(marks.getScore());
							result.add(point);
							System.out.println("  ");
		        	   }
		           } catch (Exception e) {
		        	   System.out.println("Please enter the score between 0 to 100");
		           }
		           
		    	  }
		       }
		else{
			System.out.println("Course does not exist");
			verifyCourse(marks);
		}
	}
	
	public void addResult( ) throws IOException {
		//System checks whether students exists or not
		String input_id;
		boolean quit;
		Result marks = new Result();
		do {
			System.out.println("  ");
			System.out.print("Enter a student ID: ");
			input_id = input.next();
			
			if (students.contains(input_id)) {
				quit = false;
				marks.setInputID(input_id);
				result.add(marks.getInputID());
				verifyCourse(marks);
				System.out.print("Do you want to add another result? Select Yes or No: ");
				if(in.readLine().equalsIgnoreCase("Yes")) {
					addResult();
				}
				
				}
			else {
				quit = true;
				System.out.println("Student does not exist");
				input_id = null;
				addResult();
			    System.out.println("        ");
			}
			quit = true;
			
			}while(!quit);
			}
	
	public void addStudent( ) throws Throwable{
		//This method will store student information
		Student studentinfo = new Student();
		do {
		System.out.println("  ");
		System.out.print("Enter a student ID: ");
		String student_id = in.readLine();
		studentinfo.setstudentID(student_id);
		students.add(studentinfo.getstudentID());
		System.out.print("Enter a student name: ");
		String student_name = in.readLine();
		studentinfo.setstudentName(student_name);
		students.add(studentinfo.getstudentName());
		System.out.println("    ");
		System.out.print("Do you want to add another course? Select Yes or No: ");
		}while(in.readLine().equalsIgnoreCase("Yes"));
	}
	
	public void addCourse( ) throws Throwable{
		//This method will store course information
		Course courseinfo = new Course();
		do {
		System.out.println("  ");
		System.out.print("Enter a course code: ");
		String course_code = in.readLine();
		courseinfo.setcourseCode(course_code);
		courses.add(courseinfo.getcourseCode());
		System.out.print("Enter a course name: ");
		String course_name = in.readLine();
		courseinfo.setcourseName(course_name);
		courses.add(courseinfo.getcourseName());
		System.out.println("    ");
		System.out.print("Do you want to add another course? Yes or No -: ");
		}while(in.readLine().equalsIgnoreCase("Yes"));
	}

	// Switch operated Menu
	public void menu() throws Throwable {
		// Control switch
		boolean quit = false;
		// Selector
		int menuItem;
        // Menu Options 
		do {
			System.out.println("    ");
			System.out.println("1. Add a course");
			System.out.println("2. Add a student");
			System.out.println("3. Add a result");
			System.out.println("4. View result");
			System.out.println("5. Quit");
			System.out.println(" ");
			System.out.print("Choose menu item: ");
			menuItem = input.nextInt();
			//Select switch
			switch (menuItem) {
			case 1:
                //Invoke Add Course Method
				addCourse();
				break;
			case 2:
				//Invoke Add Student Method
				addStudent();
				break;
			case 3:
				//Invoke Add Result Method
				addResult();
				break;
			case 4:
				//Invoke View Result Method
				viewResult();
				break;
			case 5:
				//Assign variable to close the loop
				quit = true;
				break;
			default:
				//Any other choice make apart from number of given options
				System.out.println("Invalid choice.");
			}
		} while (!quit);
		System.out.println("Bye-bye!");
	}

}
