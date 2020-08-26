import java.util.ArrayList;

public class ContactOperations extends Contacts{
	
	protected static ArrayList<Contacts> myContacts;
	
	public ContactOperations() {
		super(firstName, lastName, address, mobileNo, cityName, stateName, zipCode);
		myContacts = new ArrayList<Contacts>();
	}
	
	
	// Adding a new contact
	public boolean addNewContact(Contacts contact) {
		
		// Before adding a contact we are checking that its exist or not
		
		if(findContact(contact.getFirstName()) >= 0) {
			System.out.println("Contact is already exists in Address Book");
		}
		
		//If Not exist then add our contact
		Contacts cont = new Contacts(firstName, lastName, address, mobileNo, cityName, stateName, zipCode); 
		myContacts.add(cont);
		
	     		
		
		
		return true;
	}
	
	//Update Contact using set method
	public boolean updateContact(Contacts oldContact , Contacts newContact) {
		int foundPosition = findContact(oldContact);
		if(foundPosition < 0) {
			System.out.println(oldContact.getFirstName() + " , was not found");
			return false;
		}
		
		this.myContacts.set(foundPosition, newContact);
		System.out.println(oldContact.getFirstName() + ", was replaced with " + newContact.getFirstName());
		return true;
	}
	
	// Remove Contact
	public boolean removeContact(Contacts contact) {
		int foundPosition = findContact(contact);
		if(foundPosition < 0) {
			System.out.println(contact.getFirstName() + " , was not found");
			return false;
		}
		this.myContacts.remove(foundPosition);
		System.out.println(contact.getFirstName() + " was deleted");
		return true;
	}
	
	
	// Find Contact Position
	private int findContact(Contacts contact) {
		return this.myContacts.indexOf(contact);
	}
	
	// Find Contact Names
	private int findContact(String contactName) {
		 for(int i =0; i < myContacts.size(); i++) {
			 // Creating another temporary object to hold the name and compare
			 Contacts contacts = this.myContacts.get(i);
			 if(contacts.getFirstName().equals(contactName)) {
				 return i;
			 }
		 }
		 return -1;
	}
	
	// query contact
	public String queryContact(Contacts contact) {
		if(findContact(contact) >= 0) {
			return contact.getFirstName();
		}
		return null;
	}
	
	public Contacts queryContact(String name) {
		int position = findContact(name);
		if(position >=0) {
			return this.myContacts.get(position);
		}
		return null;
	}
	
	
	public void printContacts() {
		System.out.println("The Contact list:");
		System.out.println(contactList);
		printContactList();
		System.out.println("The Contacts present in Contact List:");
		System.out.println(myContacts);
		/*for(int i = 0; i < this.myContacts.size(); i++) {
			System.out.println((i+1) + "." + 
								this.myContacts.get(i).getFirstName() + this.myContacts.get(i).getLastName());
		}*/
	}
 
}