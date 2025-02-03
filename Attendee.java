/**
* Attendee.java class for creating attendee objects in Party Planner
* @author Brady OC
* @since 2/3/25
* Precodnitions: txt files to import attendee objects
* Postconditions: generates and attendee object with name, tableID, tablePos, and companyID
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
	//get tableID
	public int getTableID {
		return tableID;
	}
	
	//get SeatID
	public int getSeatID {
		return seatID;
	}
	
	//get coID
	public int getCompanyID {
		return companyID;
	}
	
	//toString
	public String getAttendee {
		if (seatID == -1 && tableID == -1)
		{
			return name + 
}
		
		
		
		//set tableID
		//set seatID
		//set
