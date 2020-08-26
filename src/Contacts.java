
import java.util.ArrayList;
class Contacts {
	
	protected static String firstName;
	protected static String lastName;
	protected static String address;
	protected static String mobileNo;
	protected static String cityName;
	protected static String stateName;
	protected static String zipCode;
	
	
	public Contacts(String firstName,String lastName, String address,String mobileNo,String cityName,String stateName,String zipCode) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.mobileNo = mobileNo;
		this.cityName = cityName;
		this.stateName = stateName;
		this.zipCode = zipCode;
	}
	
	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getCityName() {
		return cityName;
	}


	public String getStateName() {
		return stateName;
	}


	public String getZipCode() {
		return zipCode;
	}



	public String getMobileNo() {
		return mobileNo;
	}


	
	
	// Calling constructor in createContact Method
	public static Contacts createContact(String firstName,String lastName, String address,String mobileNo,String cityName,String stateName,String zipCode) {
		return new Contacts(firstName,lastName,address,mobileNo,cityName,stateName,zipCode);
	}
 
	static ArrayList<String> contactList = new ArrayList<String>();
 
	public ArrayList<String> getContactList() {
		return contactList;
	}

	
	public static void storeContacts(Contacts newContact) {
		contactList.addAll(contactList);	
	}
	public void printContactList() {
		System.out.println("You have " + contactList.size() + " Contacts in your Address Book.");
		for(int i = 0; i < contactList.size(); i++) {
			System.out.println(i + " - " + contactList.get(i));
		}
	}
 
	/*public static void storeContacts(String firstName,String lastName,String address,String mobileNo,String cityName,String stateName,String zipCode) {
		contactList.add(firstName);
		contactList.add(lastName);
		contactList.add(address);
		contactList.add(mobileNo);
		contactList.add(cityName);
		contactList.add(stateName);
		contactList.add(zipCode);
		
	}*/
	
	/*public void printContacts() {
		
		
	
	}*/
	

 
}
