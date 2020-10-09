package address;

import java.util.*;
import java.util.stream.Collectors;
public class AddressBookMain{
	
	public static Map<String,AddressBook> addressBookMap;
	
	public AddressBookMain() {
		addressBookMap = new HashMap<>();
	}
	public void addAddressBook(String city) {
		AddressBook addBook = new AddressBook(city);
		addressBookMap.put(city,addBook);
	}
	public void searchPersonByCity(String name, String city) {
		List<Contact> list = new ArrayList<Contact>();
		for(Map.Entry<String,AddressBook> entry : addressBookMap.entrySet()) {
			list = entry.getValue().getBook().stream().filter(c-> c.getCity().equals(city))
					.filter(c->(c.getFirstName()+" "+c.getLastName())
					.equals(name)).collect(Collectors.toList());
		}
		for(Contact c : list) {
			System.out.println(c);
		}
	}	
	public void searchPersonByState(String name, String state) {
		List<Contact> list = new ArrayList<Contact>();
		for(Map.Entry<String,AddressBook> entry : addressBookMap.entrySet()) {
			list = entry.getValue().getBook().stream().filter(c-> c.getState().equals(state))
					.filter(c->(c.getFirstName()+" "+c.getLastName())
					.equals(name)).collect(Collectors.toList());
		}
		for(Contact c : list) {
			System.out.println(c);
		}
	}
	public void viewDataByCity(String city) {
		List<Contact> list = new ArrayList<Contact>();
		for(Map.Entry<String,AddressBook> entry : addressBookMap.entrySet()) {
			list = entry.getValue().getBook().stream().filter(c-> c.getState().equals(city))
					.collect(Collectors.toList());
		}
		for(Contact c : list) {
			System.out.println(c);
		}
	}
	public void viewDataByState(String state) {
		List<Contact> list = new ArrayList<Contact>();
		for(Map.Entry<String,AddressBook> entry : addressBookMap.entrySet()) {
			list = entry.getValue().getBook().stream().filter(c-> c.getState().equals(state))
					.collect(Collectors.toList());
		}
		for(Contact c : list) {
			System.out.println(c);
		}
	}
	public void countByCity(String city) {
		long count = 0;
		for(Map.Entry<String,AddressBook> entry : addressBookMap.entrySet()) {
			count = entry.getValue().getBook().stream().filter(c-> c.getCity().equals(city))
					.count();
		}
		System.out.println("count is "+count);
	}
	public void countByState(String state) {
		long count = 0;
		for(Map.Entry<String,AddressBook> entry : addressBookMap.entrySet()) {
			count = entry.getValue().getBook().stream().filter(c-> c.getState().equals(state))
					.count();
		}
		System.out.println("count is "+count);
	}
	public void sortByName() {
		for(Map.Entry<String,AddressBook> entry : addressBookMap.entrySet()) {
			Collections.sort(entry.getValue().getBook(),new SortByName());
		}

	}
	public void sortByZip() {
		for(Map.Entry<String,AddressBook> entry : addressBookMap.entrySet()) {
			Collections.sort(entry.getValue().getBook(),new SortByZip());
		}
	}
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
			System.out.println("6.to search contact in city");
			System.out.println("7.to search contact in state");
			System.out.println("8.to view data by city");
			System.out.println("9.to view data in state");
			System.out.println("10.to count contact from city");
			System.out.println("11.to count contact from state");
			System.out.println("12.to sort the addressbook by name");
			System.out.println("13.to sort the addressbook by zip");
			System.out.println("14.exit");
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
					long zip = scanner.nextLong();
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
					System.out.println("Enter the name to search");
					String person = scanner.nextLine();
					System.out.println("Enter the city");
					String citi = scanner.nextLine();
					addBookMain.searchPersonByCity(person,citi);
					break;
				case 7:
					System.out.println("Enter the name to search");
					String per = scanner.nextLine();
					System.out.println("Enter the state");
					String stat = scanner.nextLine();
					addBookMain.searchPersonByCity(per,stat);
					break;
				case 8:
					System.out.println("Enter the city");
					String citii = scanner.nextLine();
					addBookMain.viewDataByCity(citii);
					break;
				case 9:
					System.out.println("Enter the state");
					String stats = scanner.nextLine();
					addBookMain.viewDataByState(stats);
					break;
				case 10:
					System.out.println("Enter the city");
					String citi1 = scanner.nextLine();
					addBookMain.countByCity(citi1);
					break;
				case 11:
					System.out.println("Enter the city");
					String stat1 = scanner.nextLine();
					addBookMain.countByState(stat1);
					break;
				case 12:
					addBookMain.sortByName();
					break;
				case 13:
					addBookMain.sortByZip();
					break;
				case 14:
					System.exit(0);
					break;
			}
		}
	}
}