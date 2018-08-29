package examResult;

public class Result {
	private String inputID;
	private String inputCode;
	private double score;
	public Result( ){
		
	}
	public Result(String inputID, String inputCode, double score) {
		super();
		this.inputID = inputID;
		this.inputCode = inputCode;
		this.score = score;
	}
	public String getInputID() {
		return inputID;
	}
	public void setInputID(String inputID) {
		this.inputID = inputID;
	}
	public String getInputCode() {
		return inputCode;
	}
	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
    

}
