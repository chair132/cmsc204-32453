
public class CourseDBElement {
	private String courseID;
	private int CRN;
	private int numOfCredits;
	private String roomNum;
	private String instructorName;
	
	//constructors
	public CourseDBElement() {
		courseID = null;
		CRN = 0;
		numOfCredits = 0;
		roomNum = null;
		instructorName = null;
	}
	
	public CourseDBElement(CourseDBElement element) {
		courseID = element.courseID;
		CRN = element.CRN;
		numOfCredits = element.numOfCredits;
		roomNum = element.roomNum;
		instructorName = element.instructorName;
	}
	
	public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor) {
		this.courseID = id;
		this.CRN = crn;
		this.numOfCredits = credits;
		this.roomNum = roomNum;
		this.instructorName = instructor;
	}
	
	
	//methods
	public void setID(String id) {
		courseID = id;
	}
	
	public String getID() {
		return courseID;
	}
	
	public void setCRN(int crn) {
		CRN = crn;
	}
	
	public int getCRN() {
		return CRN;
	}
	
	public void setCredits(int credits) {
		numOfCredits = credits;
	}
	
	public int getCredits() {
		return numOfCredits;
	}
	
	public void setInstructor(String instructor) {
		instructorName = instructor;
	}
	
	public String getInstructor() {
		return instructorName;
	}
	
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	
	public String getRoomNum() {
		return roomNum;
	}
	
	
	public int hashCode() {
		return Integer.toString(CRN).hashCode();
	}
	
	public boolean equals(Object anotheObject) {
		if (!(anotheObject instanceof CourseDBElement)) {
			return false;
		}
		if(this == anotheObject) {
			return true;
		}
		
		CourseDBElement otherObj = (CourseDBElement) anotheObject;
		//OVERHAUL
		return ((courseID == null && otherObj.courseID==null)||this.courseID.equals(otherObj.courseID)) && this.CRN == otherObj.CRN && this.numOfCredits == otherObj.numOfCredits && (instructorName == null && otherObj.instructorName==null) || this.instructorName.equals(otherObj.instructorName) && this.roomNum.equals(otherObj.roomNum); 
	}
	
	public String toString() {
		return "Course:" + getID() + " CRN:" + getCRN() + " Credits:" + getCredits() + " Instructor:" + getInstructor() + " Room:"+ getRoomNum();
	}
	
	
	
}
