import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {

		// Check arguments
		try {
			if (args[0].equals("a")) {
				System.out.println("Loading data ...");
				try {
					String studentsNameInSingleString = readFromFile("students.txt");
					String students[] = studentsNameInSingleString.split(",");
					for (String student : students) {
						System.out.println(student.trim());
					}
				} catch (Exception e) {

				}
				System.out.println("Data Loaded.");
			} else if (args[0].equals("r")) {
				System.out.println("Loading data ...");
				try {
					String studentsNameInSingleString = readFromFile("students.txt");
					String students[] = studentsNameInSingleString.split(",");
					Random random = new Random();
					int randomIndexForStudentSelection = random.nextInt(students.length);
					System.out.println(students[randomIndexForStudentSelection].trim());
				} catch (Exception e) {

				}
				System.out.println("Data Loaded.");
			} else if (args[0].contains("+")) {
				System.out.println("Loading data ...");
				try {
					String newStudent = args[0].substring(1);
					Date date = new Date();
					String dateFormatModel = "dd-mm-yyyy hh:mm:ss a";
					DateFormat dateFormat = new SimpleDateFormat(dateFormatModel);
					String formattedDateForOutput = dateFormat.format(date);
					writeInFile(", " + newStudent + "\nList last updated on " + formattedDateForOutput, "students.txt");
				} catch (Exception e) {

				}

				System.out.println("Data Loaded.");
			} else if (args[0].contains("?")) {
				System.out.println("Loading data ...");
				try {
					String studentsNameInSingleString = readFromFile("students.txt");
					String students[] = studentsNameInSingleString.split(",");
					boolean done = false;
					String searchedStudentName = args[0].substring(1);
					for (int index = 0; index < students.length && !done; index++) {
						if (students[index].equals(searchedStudentName)) {
							System.out.println("We found it!");
							done = true;
						}
					}
				} catch (Exception e) {

				}
				System.out.println("Data Loaded.");
			} else if (args[0].contains("c")) {
				System.out.println("Loading data ...");
				try {
					String studentsNameInSingleString = readFromFile("students.txt");
					String students[] = studentsNameInSingleString.split("[ ,]+");
					System.out.println(students.length + " word(s) found ");
				} catch (Exception e) {

				}
				System.out.println("Data Loaded.");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("You have not provide any perimeter. Please provide a perimeter!");
		}
	}

	public static String readFromFile(String fileName) {
		try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fileName)));
			String readLine = bufferedReader.readLine();
			bufferedReader.close();
			return readLine;
		} catch (Exception e) {
			System.out.println("Error reading file");
		}
		return "";
	}

	public static void writeInFile(String writingText, String fileName) {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(
					new FileWriter(fileName, true));
			bufferedWriter.write(writingText);
			bufferedWriter.close();
		} catch (Exception e) {
			System.out.println("Error writing file");
		}
	}
}