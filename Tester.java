/**
* Tester.java class for testing the program
* @author Brady OC
* @since 2/21/25
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
		ArrayList<String> companies = new ArrayList<String>(); //list for the companies
		
		//this try catch is reading the file 
		Scanner scan = new Scanner(System.in); //for keyboard inputs 
		try {
			File myObj = new File("companies.txt");
			Scanner myReader = new Scanner(myObj); //for the file inputs
			myReader.nextLine();
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] eachColumn = data.split(",");
				companies.add(eachColumn[1]);
				myReader.nextLine();
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		
		
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
			System.out.println("3. Print Table Rosters");
			System.out.println("4. Print Company Rosters");
			System.out.println("5. Quit Program");
			
			int loopInput = scan1.nextInt();
			String tempLine = scan1.nextLine(); //clear the buffer
			if (loopInput == 1) //add attendees
			{
				int counted = 0;
				for (Attendee b : party.returnList()) //to see if everyone has a seat or not
				{
					if (b.getSeat() != -1)
					{
						counted++;
					}
				}
				
				if (counted > (Integer.parseInt(tableChair[0]) * Integer.parseInt(tableChair[1])))
				{
					System.out.println("There is no space left for more Attendees");
				}
				else
				{
					//attempting to add someone to the array list
					System.out.println("Please enter their first and last name and company ID like so: (first name) (last name),(companyID)");
					String registerPerTemp = scan1.nextLine();
					party.addAttendee(registerPerTemp);
					
					System.out.println("\n");
				}
			}
			else if (loopInput == 2) //search attendees DONE
			{
				//search for someone
				System.out.println("Please enter their first and last name like so: (first name) (last name)");
				String searchAttendee = scan1.nextLine();
				
				System.out.println(party.searchAttendees(searchAttendee));
				
				System.out.println("\n");
			}
			else if (loopInput == 3) //print roster by table DONE
			{
				System.out.println("Please enter the table you would like to search for like so: (int)");
				int searchTable = scan1.nextInt();
				
				Attendee[] temp = party.tableRost(searchTable);
				
				for (int i = 0; i < Integer.parseInt((tableChair[1])); i++)
				{
					System.out.println(temp[i].getAttendee());
				}
			}
			else if (loopInput == 4) //print by company DONE
			{
				System.out.println("Please enter the companyID you would like to search for like so: (int)");
				int o = 1;
				
				for (String h : companies) //prints out companies and their respective IDs
				{
					System.out.println(o + h);
					o++;
				}
				
				int searchComp = scan1.nextInt();
				
				ArrayList<Attendee> temper = new ArrayList<Attendee>();
				
				temper = party.returnList();
				
				for (Attendee j : temper)
				{
					if (j.getCompany() == searchComp)
					{
						System.out.println(j.getAttendee());
					}
				}
			}
			else if (loopInput == 5) //end program DONE
			{
				runner = false;
			}
		}
	}
}
