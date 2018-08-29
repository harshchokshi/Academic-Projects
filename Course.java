package examResult;

public class Course {
	private String courseCode;
	private String courseName;
    public Course( ){
    	
    }
	public Course(String courseCode, String courseName) {
		this.courseCode = courseCode;
		this.courseName = courseName;
	}

	public void setcourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getcourseCode() {
		return courseCode;
	}

	public void setcourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getcourseName(){
		return courseName;
	}
	public String toString(){
		return "Course Code is "+courseCode+"\n"+"Course Name is "+courseName;
	}

}
