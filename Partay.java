/**
* Partay.java class for running the party
* @author Brady OC
* @since 2/21/25
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
	Attendee[][] temp;
	int tableNum;
	int chairNum;
	
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
		
		tableNum = table;
		chairNum = chair;
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
					for (Attendee h : attendees) //setting benchmark for who we are looking at in the array
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
					
					if (counter > attendees.size()) //here so that when it reaches the end of the attendees it wont try to add a null num
					{
						break;
					}
					
					//check each row of seats for if a person has the same company
					noCompany = true;
					
					for (int j = 0; j < chairNum; j++) //checks to see if there is someone from the same company at the table
					{
						if (tables[i][j] == null)
						{
						}
						else if (tables[i][j].getCompany() == attendees.get(benchmark).getCompany())
						{
							noCompany = false;
						}
					}
					
					if (noCompany) //this actually adds the person to the table
					{
						tables[i][k] = attendees.get(benchmark);
						attendees.get(benchmark).setSpot(k, i);
						//System.out.println(attendees.get(benchmark).getAttendee());
					}
					
					counter++;	//to iterate to the next attendee
				}
			}
		}
		temp = tables; //this is used for later when we need to get specific tables
	}
		
	public void addAttendee(String input) //just a tester
	{
		String[] registerInput = input.split(",");
		Attendee att = new Attendee(registerInput[0], Integer.parseInt(registerInput[1]));
		attendees.add(att);
		
		int tempTable = 0;
		
		for (int c = 0; c < tableNum; c++) //finds the first open table
		{
			if (temp[c][chairNum - 1] != null)
			{
				tempTable = c;
				break;
			}
		}
		
		ArrayList<Integer> openChairs = new ArrayList<Integer>(); //to see what chairs are open
		boolean noCompany = true;
		while (true)
		{
			//check each row of seats for if a person has the same company
			noCompany = true;
		
			for (int j = 0; j < chairNum; j++) //checks to see if there is someone from the same company at the table
			{
				if (temp[tempTable][j] == null)
				{
					openChairs.add(j);
				}
				else if (temp[tempTable][j].getCompany() == attendees.get(attendees.size() - 1).getCompany())
				{
					noCompany = false;
				}
			}
			
			if (noCompany) //this actually adds the person to the table
			{
				temp[tempTable][openChairs.get(0)] = attendees.get(attendees.size() - 1);
				attendees.get(attendees.size() - 1).setSpot(openChairs.get(0), tempTable);
				//System.out.println(attendees.get(benchmark).getAttendee());
				break;
			}
			
			tempTable++;
		}
	}
	
	public String searchAttendees(String input) //searches trhgouh the entire attendees list for someone by name
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
	
	public Attendee[] tableRost(int tablePos) //returns an array that holds the people at a specific table
	{
		Attendee[] table = {temp[tablePos][0], temp[tablePos][1], temp[tablePos][2], temp[tablePos][3], 
		temp[tablePos][4], temp[tablePos][5], temp[tablePos][6], temp[tablePos][7], temp[tablePos][8], temp[tablePos][9]};
		return table; //to figure out
	}
	
	public ArrayList<Attendee> returnList()
	{
		return attendees;
	}
}
