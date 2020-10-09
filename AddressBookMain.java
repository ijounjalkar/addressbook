package address;

import java.util.*;
public class AddressBookMain{
	Scanner sc = new Scanner(System.in);
	public List<Contact> Book = new ArrayList<Contact>();	
	
	public List<Contact> addContact(Contact c) {
		Book.add(c);
		return Book;
	}
	
	public void editContact(String name){
		String x = "";
		int i = 0;
		for(Contact c : Book) {
			x = c.getFirstName() +" "+ c.getLastName();
			if(name.equals(x)) {
				while(true) {
					System.out.println("1.Change the address");
					System.out.println("2.Change the city");
					System.out.println("3.Change the state");
					System.out.println("4.Change the ZIP code");
					System.out.println("5.Change the phone number");
					System.out.println("6.Change the Email id");
					int choice = sc.nextInt();
					sc.nextLine();

					switch(choice) {
						case 1 : 
							System.out.println("Enter new address");
							String address = sc.nextLine();
							c.setAddress(address);
							break;
						case 2 : 
							System.out.println("Enter new city");
							String city = sc.nextLine();
							c.setCity(city);
							break;
						case 3 : 
							System.out.println("Enter new state");
							String state = sc.nextLine();
							c.setAddress(state);
							break;
						case 4 : 
							System.out.println("Enter new ZIP code");
				 			String zip = sc.nextLine();
				 			c.setZip(zip);
				 			break;
						case 5 : 
							System.out.println("Enter new phone number");
				 			long phone = sc.nextLong();
				 			sc.nextLine();
				 			c.setPhoneNumber(phone);
				 			break;
						case 6 : 
							System.out.println("Enter new Email id");
				 			String email = sc.nextLine();
				 			c.setEmail(email);
				 			break;
						}
					}
				}
			Book.set(i,c);
			i++;
		}
	}
	
	public void deleteContact(String name){
		String x = "";
		for(Contact c : Book) {
			x = c.getFirstName() +" "+c.getLastName();
			if(name.equals(x)) {
				Book.remove(c);
			}
		}
	}
	
	public void viewList() {
		
		for(Contact c : Book) {
			System.out.println("First Name : " + c.getFirstName() + "Last Name : " + c.getLastName() + " Address : " + c.getAddress() + " City : " + c.getCity() 
							+ " State : " + c.getState() + " ZIP : " + c.getZip() + " Phone Number : " + c.getPhoneNumber() + " Email ID : " + c.getEmail() + "\n");
		}
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		AddressBookMain addBookMain = new AddressBookMain();
		
		while(true) {
			System.out.println("1.Add contact");
			System.out.println("2.Edit existing contact");
			System.out.println("3.Delete contact");
			System.out.println("4.Display contact");
			int choice = sc.nextInt();
			sc.nextLine();

			switch(choice) {
			
			case 1 :
				System.out.println("Enter the details of person");
				System.out.println("Enter the first name");
				String firstName = sc.nextLine();
				System.out.println("Enter the last name");
				String lastName = sc.nextLine();
				System.out.println("Enter the address");
				String address = sc.nextLine();
				System.out.println("Enter the city name");
				String city = sc.nextLine();
				System.out.println("Enter the state name");
				String state = sc.next();
				System.out.println("Enter the ZIP code");
				String zip = sc.next();
				System.out.println("Enter the phone number");
				long phoneNumber = sc.nextLong();
				sc.nextLine();
				System.out.println("Enter the email");
				String email = sc.nextLine();
				Contact c = new Contact(firstName,lastName,address,city,state,zip,phoneNumber,email);
				addBookMain.addContact(c);
				break;
			case 2 :
				System.out.println("Enter the Name to edit contact");
				String name = sc.nextLine();
				addBookMain.editContact(name);
				break;
			case 3 :
				System.out.println("Enter the Name to delete contact");
				String deleteName = sc.nextLine();
				addBookMain.deleteContact(deleteName);
				break;
			case 4 :
				addBookMain.viewList();
				break;

			}
		}

	}
}