/**
* Attendee.java class for creating attendee objects in Party Planner
* @author Brady OC
* @since 2/13/25
* Precodnitions: txt files to import attendee objects
* Postconditions: generates an attendee object with name, tableID, tablePos, and companyID
* 
*/

public class Attendee {

//instance variables
	private String name;
	private int tableID;
	private int seatID;
	private int companyID;
	
//constructor	
	public Attendee (String attName, int compID)
	{
		name = attName;
		tableID = -1;
		seatID = -1;
		companyID = compID;
	}
	
//getters and setters
	
	//get name
	public String getName() {
		return name;
	}
	
	public int getCompany() {
		return companyID;
	}
	
	public int getSeat() {
		return seatID;
	}
	
	//toString
	public String getAttendee() { //to get general info about the attendee
		if (seatID == -1 && tableID == -1)
		{
			return name + ", " + companyID;
		}
		else if (seatID == -1)
		{
			return name + ", " + companyID + ", " + seatID;
		}
		else if (tableID == -1)
		{
			return name + ", " + companyID + ", " + tableID;
		}
		else 
		{
			return name + ", " + companyID + ", " + tableID + ", " + seatID;
		}
	}
	
	public void setSpot(int seat, int table) {
		seatID = seat;
		tableID = table;
	}
}
