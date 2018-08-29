package examResult;

public class Student {
	private String studentID;
	private String studentName;
    public Student( ){
    	
    }
	public Student(String studentID, String studentName) {
		this.studentID = studentID;
		this.studentName = studentName;
	}

	public void setstudentID (String studentID) {
		this.studentID = studentID;
	}

	public String getstudentID() {
		return studentID;
	}

	public void setstudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getstudentName(){
		return studentName;
	}
	public String toString(){
		return "Student ID is "+studentID+"\n"+"Student Name is "+studentName;
	}

}
