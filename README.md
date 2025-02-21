# APCS_Partay
#party planner
#The goal of this project was to create party with an amount of tables and chairs someone can manually set. But, no one from the same company could be sitting at the same table. This project reads the two files companies.txt #and partyguests.txt. These are the people that are preset into the party but the user should be allowed to add more.
#Partay.java
#Partay is the main function of the program that deals with reading of partyguests.txt and sorts them into the correct tables. There are a few functinos outside of the constructor such as addAttendee which attempts to add an attendee to the first free chair. SearchAttendees finds an attendee with the same name. TableRost finds the table and then returns a new array with all the people that are at that table index.
