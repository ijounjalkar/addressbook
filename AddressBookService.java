package address;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonStreamParser;

public class AddressBookService {
	public static String PAYROLL_FILE_NAME = "AddressBook.txt";
	public static String CSV_FILE = "AddressBook.csv";
	public static String JSON_FILE = "AddressBook.json";

	public void writeData(Map<String, AddressBook> addressBookMap) {
		StringBuffer employeeBuffer = new StringBuffer();
		for(Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
			entry.getValue().getBook().forEach(contact -> {
			String empString = contact.toString().concat("\n");
			employeeBuffer.append(empString);
		});
		}
		try {
			Files.write(Paths.get(PAYROLL_FILE_NAME), employeeBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void readData() {
		try {
			Files.lines(new File(PAYROLL_FILE_NAME).toPath()).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Usecase14 For Writing the data to CSV File
	 * 
	 * @param cityBookMap
	 */
	public void writeDataToCSV(Map<String, AddressBook> cityBookMap) {
		Path path = Paths.get(CSV_FILE);
		try {
			FileWriter outputfile = new FileWriter(path.toFile());
			CSVWriter writer = new CSVWriter(outputfile);
			for (Map.Entry<String, AddressBook> entry : cityBookMap.entrySet()) {
				entry.getValue().getBook().forEach(contact -> {
					String[] data = contact.toString().split(",");
					writer.writeNext(data);
				});
			}
			writer.close();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * Reading data from the CSV file
	 * @throws CsvValidationException 
	 */
	public void readDataFromCSV() throws CsvValidationException {
		try {
			Reader fileReader = Files.newBufferedReader(Paths.get(CSV_FILE));
			@SuppressWarnings("resource")
			CSVReader csvReader = new CSVReader(fileReader);
			String[] data;
			while ((data = csvReader.readNext()) != null) {
				System.out.println("First Name: " + data[0] + " Last Name: " + data[1] + " Address: " + data[2]
						+ " City: " + data[3] + " State: " + data[4] + " ZIP: " + data[5] + " Phone: " + data[6]
						+ " Email: " + data[7]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Usecase15 using GSON writing data to JSON file
	 * 
	 * @param cityBookMap
	 * @throws IOException
	 */
	public void writeDataToJSON(Map<String, AddressBook> cityBookMap) throws IOException {
		Gson gson = new Gson();
		Path path = Paths.get(JSON_FILE);
		FileWriter writer = new FileWriter(path.toFile());
		for (Map.Entry<String, AddressBook> entry : cityBookMap.entrySet()) {
			entry.getValue().getBook().forEach(contact -> {
				String json = gson.toJson(contact);
				try {
					writer.write(json);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		}
		writer.close();
	}

	/**
	 * Usecase15 using GSON reading from a JSON file
	 */
	public void readDataFromJSON() {
		Gson gson = new Gson();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(Paths.get(JSON_FILE).toFile()));
			JsonStreamParser parser = new JsonStreamParser(bufferedReader);
			while (parser.hasNext()) {
				JsonElement jsonElement = parser.next();
				if (jsonElement.isJsonObject()) {
					Contact contact = gson.fromJson(jsonElement, Contact.class);
					System.out.println(contact);
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}



