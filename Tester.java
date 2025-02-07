/**
* Tester.java class for testing the program
* @author Brady OC
* @since 2/7/25
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
		//create array list
		
		ArrayList<Attendee> attendees = new ArrayList<Attendee>(); //list for the attendees
		
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
		
		//attempting the loop to run the code
		Boolean runner = true; //to make sure the script is running
		Scanner scan1 = new Scanner(System.in); //scanner to search for inputs by the user
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
				String[] registerPer = registerPerTemp.split(",");
				Attendee att = new Attendee(registerPer[0], Integer.parseInt(registerPer[1]));
				attendees.add(att);
				
				System.out.println("\n");
			}
			else if (loopInput == 2)
			{
				//search for someone
				System.out.println("Please enter their first and last name like so: (first name) (last name)");
				String searchAttendee = scan1.nextLine();
				
				Boolean tempFinder = true;
				for (Attendee attendee : attendees)
				{
					if (attendee.getName().equals(searchAttendee))
					{
						System.out.println(attendee.getAttendee());
						tempFinder = false;
					}
				}
				if (tempFinder)
				{
					System.out.println("Person not found");
				}
				
				System.out.println("\n");
			}
			else if (loopInput == 3)
			{
				runner = false;
			}
		}
		
		
		
		//add an else after this if later to maybe re prompt the user to put in what they want to do
		
		
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
		
