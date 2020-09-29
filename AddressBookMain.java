package address;


import java.util.*;
import java.util.ArrayList;

public class AddressBookMain {
	
		public ArrayList<Contact> addressBook = new ArrayList<Contact>();
		
		public ArrayList<Contact> getAddressBook() {
			return addressBook;
		}
		
		public void setAddressBook(ArrayList<Contact> addressBook) {
			this.addressBook = addressBook;
		}
		
		public void addContact(Contact contact) {
			addressBook.add(contact);
		}
		public void editContact(String name) {
			Scanner sc = new Scanner(System.in);
			String x = "";
			for(Contact contact : addressBook) {
				x = contact.getFirstName() + contact.getLastName();
				if(name.equals(x)) {
					System.out.println("1.Change the address");
					System.out.println("2.Change the city");
					System.out.println("3.Change the state");
					System.out.println("4.Change the ZIP code");
					System.out.println("5.Change the phone number");
					System.out.println("6.Change the Email id");
					int choice = sc.nextInt();
					sc.nextLine();
					switch(choice) {
					case 1 : System.out.println("Enter new address");
					String address = sc.nextLine();
					contact.setAddress(address);
					break;
					case 2 : System.out.println("Enter new city");
					String city = sc.nextLine();
					contact.setCity(city);
					break;
					case 3 : System.out.println("Enter new state");
					String state = sc.nextLine();
					contact.setAddress(state);
					break;
					case 4 : System.out.println("Enter new ZIP code");
					int zipcode = sc.nextInt();
					contact.setZipcode(zipcode);
					sc.nextLine();
					break;
					case 5 : System.out.println("Enter new phone number");
					long phone = sc.nextLong();
					sc.nextLine();
					contact.setPhoneNumber(phone);
					break;
					case 6 : System.out.println("Enter new Email id");
					String email = sc.nextLine();
					contact.setEmail(email);
					break;
					}	
				}
				else {
					 System.out.println("No such contact exist");
				}
			}
		

			
		}
		public void deleteContact(String name) {
			String x = "";
			for(Contact contact : addressBook) {
				x = contact.getFirstName() + contact.getLastName();
				if(name.equals(x)) {
					addressBook.remove(contact);
				}
			}
		}
    
	
	public static void main (String[] args) {
        AddressBookMain addressBook = new AddressBookMain();
    System.out.println("Welcome to Address Book");
    Scanner sc = new Scanner(System.in);
    do {
    	
    	sc.nextLine();
    	System.out.println("1.Add a new Contact");
    	System.out.println("2.Edit the contact details");
    	System.out.println("3.Delete a contact");
    	
    	int choice = sc.nextInt();
    	sc.nextLine();
    	switch(choice) {
    	
    	case 1:
    		System.out.println("Enter the first name");
    	    String firstName = sc.nextLine();
    	    System.out.println("Enter the last name");
    	    String lastName = sc.nextLine();
    	    System.out.println("Enter the address");
    	    String address = sc.nextLine();
    	    System.out.println("Enter the city name");
    	    String city = sc.nextLine();
    	    System.out.println("Enter the state name");
    	    String state = sc.nextLine();
    	    System.out.println("Enter the ZIP code");
    	    int zipcode = sc.nextInt();
    	    sc.nextLine();
    	    System.out.println("Enter the phone number");
    	    long phoneNumber = sc.nextLong();
    	    sc.nextLine();
    	    System.out.println("Enter the email");
    	    String email = sc.nextLine();
    	    Contact contact = new Contact(firstName,lastName,address,city,state,zipcode,phoneNumber,email);//Created Contact
    	    addressBook.addContact(contact);
    	    break;
    	case 2:
    		System.out.println("Enter the contact name");
    		String name=sc.nextLine();
    		addressBook.editContact(name);
    		break;
    	case 3:
    		System.out.println("Enter the contact name");
    		String  contactName = sc.nextLine();
    		addressBook.deleteContact(contactName);//deleted Contact
    		break;	
    	default:
    		break;
    	
    		
    	}
    	System.out.println("Do you wish to continue(Y/N)?");
    }while(sc.next().charAt(0)=='Y');
    System.out.println("Thank You");
}
}
    
    

	


