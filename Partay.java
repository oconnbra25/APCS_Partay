/**
* Partay.java class for running the party
* @author Brady OC
* @since 2/13/25
* Precodnitions: attendee objects to put in at table and # of tables & chairs
* Postconditions: generates attendees seat numbers
* 
*/

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList; // Import the ArrayList utilities

public class Partay 
{
	//create array list
	ArrayList<Attendee> attendees = new ArrayList<Attendee>(); //list for the attendees
	
	public Partay (int table, int chair) 
	{
		//this try catch is reading the file 
		Scanner scan = new Scanner(System.in); //for keyboard inputs 
		try {
			File myObj = new File("partyguests.txt");
			Scanner myReader = new Scanner(myObj); //for the file inputs
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] eachColumn = data.split(",");
				Attendee att = new Attendee(eachColumn[2] + " " + eachColumn[1], Integer.parseInt(eachColumn[3]));
				attendees.add(att);
				//System.out.println(data);
		}
		myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		
		int tableNum = table;
		int chairNum = chair;
		Attendee[][] tables = new Attendee [tableNum][chairNum];
		ArrayList<Attendee> attendeesToSeat = attendees; //list for the attendees to be seated
		boolean noCompany = true;
		boolean whileRunner = true;
		int l = 0;
		
		
		for (int i = 0; i < tableNum; i++)
		{
			for (int k = 0; k < chairNum; k++)
			{
				l = 0;
				while (whileRunner)
				{
					//this loop iterates through the
					for (int j = 0; j < chairNum; j++) //this loops throguh the entirety of the current table to ensure no one sitting there is part of the same company
					{
						if (tables[i][j].getCompany() != attendeesToSeat.get(l).getCompany()) //l is a int to check every index of attendeesToSeat to make sure that its going to the next attendee
						{
							noCompany = true;
						}
						else
						{
							noCompany = false;
						}
					}
					
					if (noCompany) //this is there to say that there is no one from the same company
					{
						tables[i][k] = attendeesToSeat.get(0);
						attendeesToSeat.remove(0);
						break;
					}
					else if (l == attendeesToSeat.size() - 1)
					{
						whileRunner = false;
					}
					else
					{
						l++; //iterator to go to next Attendee in attendeesToSeat
					}
				}
			}
		}		
	}
	
	public void addAttendee(String input)
	{
		String[] registerInput = input.split(",");
		Attendee att = new Attendee(registerInput[0], Integer.parseInt(registerInput[1]));
		attendees.add(att);
	}
	
	public String searchAttendees(String input)
	{
		Boolean tempFinder = true;
		for (Attendee attendee : attendees)
		{
			if (attendee.getName().equals(input))
			{
				tempFinder = false;
				return attendee.getAttendee();
			}
		}
		
		if (tempFinder)
		{
			return "Person not found";
		}
		return "";
	}
}
