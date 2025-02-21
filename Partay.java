/**
* Partay.java class for running the party
* @author Brady OC
* @since 2/20/25
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
		
		//sorting people into tables
		
		int tableNum = table;
		int chairNum = chair;
		Attendee[][] tables = new Attendee [tableNum][chairNum];
		//ArrayList<Attendee> attendeeToSeat = attendees;
		boolean noCompany = true;
		boolean whileRunner = true;
		//int l = 0;
		int benchmark = 0;
		int counter = 0;
		
		
		for (int i = 0; i < tableNum; i++) //go through tables
		{
			for (int k = 0; k < chairNum; k++) //go through chairs
			{
				counter = 0;
				while (tables[i][k] == null)
				{
					for (Attendee h : attendees) //setting benchmark
					{
						if (h.getSeat() == -1)
						{
							benchmark = counter;
							break;
						}
						else
						{
							counter++;
						}
					}
					
					//check each row of seats for if a person has the same company
					noCompany = true;
					
					for (int j = 0; j < chairNum; j++)
					{
						if (tables[i][j] == null)
						{
						}
						else if (tables[i][j].getCompany() == attendees.get(benchmark).getCompany())
						{
							noCompany = false;
						}
					}
					
					if (counter == attendees.size()) //here so that when it reaches the end of the attendees
					{
						break;
					}
					
					if (noCompany)
					{
						tables[i][k] = attendees.get(benchmark);
						attendees.get(benchmark).setSpot(k, i);
						System.out.println(attendees.get(benchmark).getAttendee());
					}
					
					counter++;	
				}
			}
		}
	}
		
	public void addAttendee(String input) //just a tester
	{
		String[] registerInput = input.split(",");
		Attendee att = new Attendee(registerInput[0], Integer.parseInt(registerInput[1]));
		attendees.add(att);
	}	
		
	public String searchAttendees(String input)
	{
		for (Attendee attendee : attendees)
		{
			if (attendee.getName().equals(input))
			{
				return attendee.getAttendee();
			}
		}
		
		return "Person not found";
	}
	
	public Attendee[] tableRost(int tablePos, Attendee[][] tables)
	{
		Attendee[] table = {tables[tablePos][0], tables[tablePos][1], tables[tablePos][2], tables[tablePos][3], 
		tables[tablePos][4], tables[tablePos][5], tables[tablePos][6], tables[tablePos][7], tables[tablePos][8], tables[tablePos][9]};
		return table; //to figure out
	}
}
