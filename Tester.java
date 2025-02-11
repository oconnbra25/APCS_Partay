/**
* Tester.java class for testing the program
* @author Brady OC
* @since 2/11/25
* Precodnitions: nothing
* Postconditions: runs the entire program from start to end
* 
*/

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList; // Import the ArrayList utilities

public class Tester {
	public static void main(String[] args) {
		
		//scanner to search for inputs by the user
		Scanner scan1 = new Scanner(System.in);
		
		//prompting user for # of tables & chairs
		System.out.println("Enter how many tables and chairs you want like so: (Tables),(Chairs)");
		String tableChairTemp = scan1.nextLine();
		String[] tableChair = tableChairTemp.split(",");
		
		//making a partay object
		Partay party = new Partay(Integer.parseInt(tableChair[0]), Integer.parseInt(tableChair[1]));
		
		//attempting the loop to run the code
		Boolean runner = true; //to make sure the script is running
		
		while (runner)
		{
			System.out.println("Enter the number corresponding to what you would like to do:");
			System.out.println("1. Add a person");
			System.out.println("2. Search for someone");
			System.out.println("3. Quit Program");
			
			int loopInput = scan1.nextInt();
			String tempLine = scan1.nextLine(); //clear the buffer
			if (loopInput == 1)
			{
				//attempting to add someone to the array list
				System.out.println("Please enter their first and last name and company ID like so: (first name) (last name),(companyID)");
				String registerPerTemp = scan1.nextLine();
				party.addAttendee(registerPerTemp);
				
				System.out.println("\n");
			}
			else if (loopInput == 2)
			{
				//search for someone
				System.out.println("Please enter their first and last name like so: (first name) (last name)");
				String searchAttendee = scan1.nextLine();
				
				System.out.println(party.searchAttendees(searchAttendee));
				
				System.out.println("\n");
			}
			else if (loopInput == 3)
			{
				runner = false;
			}
		}
		
		//Graveyard:
			/* //spacer between the data being printed and the test print for the entire array list
			
			System.out.println("");
			
			//test print
			for (Attendee j : attendees)
			{
				System.out.println(j.getAttendee());
			}
			*/
			
			/* //finds a specific attendee with the name nico
			
			String searchName = "Nico";
			
			for (Attendee j : attendees)
			{
				if (j.getName().equals("Nico"))
				{
					System.out.println(j.getAttendee());
					break;
				}
				else
				{
					System.out.println("");
				}
			}
			*/
	}
}
		
