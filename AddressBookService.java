package address;

import java.io.File;
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

public class AddressBookService {
	public static String PAYROLL_FILE_NAME = "AddressBook.txt";
	public static String CSV_FILE = "AddressBook.csv";

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

}



