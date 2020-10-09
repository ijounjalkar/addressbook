package address;

import java.util.*;
public class AddressBookMain{
	
	public static Map<String,AddressBook> addressBookMap;
	
	public AddressBookMain() {
		addressBookMap = new HashMap<>();
	}
	
	public void addAddressBook(String city) {
		AddressBook addBook = new AddressBook(city);
		addressBookMap.put(city,addBook);
	}
	
	public List<Contact> Book = new ArrayList<Contact>();	
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		AddressBookMain addBookMain = new AddressBookMain();
		
		int v;
		while(true) {
			System.out.println("1.to create addbook");
			System.out.println("2.to add person");
			System.out.println("3.to edit contact");
			System.out.println("4.to delete contact");
			System.out.println("5.to view addbook");
			System.out.println("6.exit");
			v = scanner.nextInt();
			scanner.nextLine();
			switch(v) {
				case 1:
					System.out.println("Enter the city name to create addressBook");
					String City = scanner.nextLine();
					addBookMain.addAddressBook(City);
					break;
				case 2:  
					System.out.println("Enter the details of person");
					System.out.println("Enter the first name");
					String firstName = scanner.nextLine();
					System.out.println("Enter the last name");
					String lastName = scanner.nextLine();
					System.out.println("Enter the address");
					String address = scanner.nextLine();
					System.out.println("Enter the city name");
					String city = scanner.nextLine();
					System.out.println("Enter the state name");
					String state = scanner.next();
					System.out.println("Enter the ZIP code");
					String zip = scanner.next();
					System.out.println("Enter the phone number");
					long phoneNumber = scanner.nextLong();
					scanner.nextLine();
					System.out.println("Enter the email");
					String email = scanner.nextLine();
					Contact c = new Contact(firstName,lastName,address,city,state,zip,phoneNumber,email);
					
					for (Map.Entry<String,AddressBook> entry : addressBookMap.entrySet()) {   
						if(entry.getKey().equalsIgnoreCase(city)) {
							entry.getValue().addContact(c);
						}
						else {
							System.out.println("The addressbook does not exist, please create addressbook for that city");
						}
					}
					break;
				case 3:
					System.out.println("Enter the name to edit contact");
					String x = scanner.nextLine();
					System.out.println("Enter the city");
					String city2 = scanner.nextLine();
					for (Map.Entry<String,AddressBook> entry : addressBookMap.entrySet()) {   
						if(entry.getKey().equalsIgnoreCase(city2)) {
							entry.getValue().editContact(x);
						}
						else {
							System.out.println("The addressbook does not exist, please create addressbook for that city");
						}
					}
					break;
				case 4:
					System.out.println("Enter the name to delete");
					String y = scanner.nextLine();
					System.out.println("Enter the city");
					String city1 = scanner.nextLine();
					for (Map.Entry<String,AddressBook> entry : addressBookMap.entrySet()) {   
						if(entry.getKey().equalsIgnoreCase(city1)) {
							entry.getValue().deleteContact(y);
						}
						else {
							System.out.println("The addressbook does not exist, please create addressbook for that city");
						}
					}
					break;
				case 5:
					for (Map.Entry<String,AddressBook> entry : addressBookMap.entrySet()) {
						System.out.println("The addressbook for city "+entry.getKey()+" is :");
						entry.getValue().viewList();
					}
					break;
				case 6:
					System.exit(0);
					break;
			}
		}
	}
}