import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList; // Import the ArrayList utilities

public class Tester {
	public static void main(String[] args) {
		//create array list
		
		ArrayList<Attendee> attendees = new ArrayList<Attendee>(); //list for the attendees
		
		//reading the file is this try catch
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
		
		//attempting to add someone to the array list
		Scanner scan1 = new Scanner(System.in);
		System.out.println("would you like to register someone? y/n");
		
		String registerAns = "";
		registerAns = scan1.nextLine();
		
		if (registerAns.equals("y"))
		{
			System.out.println("Please enter their first and last name and company ID like so: (first name) (last name),(companyID)");
			String registerPerTemp = scan1.nextLine();
			String[] registerPer = registerPerTemp.split(",");
			Attendee att = new Attendee(registerPer[0], Integer.parseInt(registerPer[1]));
			attendees.add(att);
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
		
