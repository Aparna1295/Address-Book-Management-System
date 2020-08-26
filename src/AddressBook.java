import java.util.Collections;
import java.util.Scanner;

public class AddressBook extends ContactOperations {
		
		private static Scanner scanner = new Scanner(System.in);
		// Creating an instance with a default Attributes
		private static ContactOperations ops = new ContactOperations();
		private static void openAddressBook() {
			System.out.println("***********************Welcome to Address Book Management System**************************");
		}
		
		private static void displayActions() {
			System.out.println("\nPlease check for below available Operations:\nPress");
			System.out.println( "1 - To Print contacts\n"+
								"2 - To add a new contact\n"+
								"3 - To update an existing contact\n"+
								"4 - To remove an existing contact\n"+
								"5 - To Sort Contacts\n"+
								"6 - To print a list of available operations\n"+
							 	"0 - To Exit from Address Book");
	
		}
		
		private static void sortContacts() {
			Collections.sort(contactList);
			ops.printContactList();
		}
		
		private static void addNewContact() {
			System.out.println("Enter First name of new Contact: ");
			String fname = scanner.nextLine();
			System.out.println("Enter Last name of new contact: ");
			String lname = scanner.nextLine();
			System.out.println("Enter Address of new Contact: ");
			String add = scanner.nextLine();
			System.out.println("Enter Mobile Number of new contact: ");
			String mbno = scanner.nextLine();
			System.out.println("Enter City of new Contact: ");
			String city = scanner.nextLine();
			System.out.println("Enter State of new contact: ");
			String state = scanner.nextLine();
			System.out.println("Enter Zip Code of new contact: ");
			String zip = scanner.nextLine();
			Contacts newContact = Contacts.createContact(fname,lname,add,mbno,city,state,zip);
			
			if(ops.addNewContact(newContact)) {
				Contacts.storeContacts(newContact);
				System.out.println("New Contact is added successfully" );
			}else {
				System.out.println("The contact " + fname + lname +" is already exists in Address Book");
			}
		}
		
		
		private static void updateContact() {
			System.out.println("Enter first name of an existing Contact in order to update details : ");
			String name = scanner.nextLine();
			System.out.println("Enter last name of an existing Contact in order to update details : ");
			String surname = scanner.nextLine();
			Contacts extContact = ops.queryContact(name);
			if(extContact == null) 
			{
				System.out.println("The Contact name is not available in address book");
				return;
			}
			
			System.out.println("Enter Address of Contact to update: ");
			String newAdd = scanner.nextLine();
			System.out.println("Enter Mobile Number of new contact: ");
			String newMbno = scanner.nextLine();
			System.out.println("Enter City of new Contact: ");
			String newCity = scanner.nextLine();
			System.out.println("Enter State of new contact: ");
			String newState = scanner.nextLine();
			System.out.println("Enter Zip Code of new contact: ");
			String newZip = scanner.nextLine();
			
			Contacts newContact = Contacts.createContact(name,surname,newAdd, newMbno,newCity,newState,newZip);
			if(ops.updateContact(extContact, newContact)) 
			{
				System.out.println("The contact details are updated Successfully");
			}else {
				System.out.println("The contact details are not updated ");
			}
		}
		
		private static void removeContact() {
			System.out.println("Enter existing contact name : ");
			String name = scanner.nextLine();
			Contacts extContact = ops.queryContact(name);
			if(extContact == null) 
			{
				System.out.println("The contact is not exists in the Address Book");
				return;
			}
			
			if(ops.removeContact(extContact)) {
				System.out.println("The Contact is deleted Successfully");
			}else {
				System.out.println("There is an Error while deleting Contact");
			}
		}
		
		private static void queryContact() {
			System.out.println("Enter existing contact name : ");
			String name = scanner.nextLine();
			Contacts extContact = ops.queryContact(name);
			if(extContact == null) 
			{
				System.out.println("The contact is not exists in the Address Book");
				return;
			}
			
			System.out.println("First Name : " + extContact.getFirstName() + 
					           " Mobile Number is: " + extContact.getMobileNo());
		}
		
		

		public static void main(String[] args) {	
					
			boolean quit = false;
			openAddressBook();
			displayActions();
			while(!quit) {
				System.out.println("\n Enter your choice: (Please Press '6' to get available operations)");
				int action = scanner.nextInt();
				scanner.nextLine();
				
				switch (action) {
					
					case 1:
						ops.printContacts();
						break;
					
					case 2:
						addNewContact();
						break;
					
					case 3: 
						updateContact();
						break;
					case 4:
						removeContact();
						break;
					case 5:
						sortContacts();
						break;
					case 6:
						displayActions();
						break;
					case 0:
						System.out.println("\n You are exited from Address Book ");
						quit = true;
						break;
				 
				}
				
			}
	 
		}
		
}
