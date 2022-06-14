import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
		try{
			if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt"))); 
				String studentsNameInSingleString = bufferedReader.readLine();
				String students[] = studentsNameInSingleString.split(",");			
				for(String student : students) { 
					System.out.println(student.trim()); 
				}
			} catch (Exception e){

			} 
			System.out.println("Data Loaded.");
			}
			else if(args[0].equals("r")) {
				System.out.println("Loading data ...");			
				try {
					BufferedReader bufferedReader = new BufferedReader(
							new InputStreamReader(
									new FileInputStream("students.txt"))); 
					String studentsNameInSingleString = bufferedReader.readLine();
					String students[] = studentsNameInSingleString.split(",");	
					Random random = new Random();
					int randomIndexForStudentSelection = random.nextInt(students.length);
					System.out.println(students[randomIndexForStudentSelection].trim());
				} catch (Exception e){

				} 
				System.out.println("Data Loaded.");			
			}
			else if(args[0].contains("+")){
				System.out.println("Loading data ...");			
				try {
					BufferedWriter bufferedWriter = new BufferedWriter(
							new FileWriter("students.txt", true));
					String newStudent = args[0].substring(1);
					Date date = new Date();
					String dateFormatModel = "dd-mm-yyyy hh:mm:ss a";
					DateFormat dateFormat = new SimpleDateFormat(dateFormatModel);
					String fomatedDateForOutput = dateFormat.format(date);
					bufferedWriter.write(", "+ newStudent + "\nList last updated on " + fomatedDateForOutput);
					bufferedWriter.close();
				} catch (Exception e){

				}
								
				System.out.println("Data Loaded.");	
			}
			else if(args[0].contains("?")) 
			{
				System.out.println("Loading data ...");			
				try {
					BufferedReader bufferedReader = new BufferedReader(
							new InputStreamReader(
									new FileInputStream("students.txt"))); 
					String studentsNameInSingleString = bufferedReader.readLine();
					String students[] = studentsNameInSingleString.split(",");	
					boolean done = false;
					String searchedStudentName = args[0].substring(1);
					for(int index = 0; index<students.length && !done; index++) {
						if(students[index].equals(searchedStudentName)) {
							System.out.println("We found it!");
							done=true;
						}
					}
				} catch (Exception e){

				} 
				System.out.println("Data Loaded.");				
			}
			else if(args[0].contains("c")) 
			{
				System.out.println("Loading data ...");			
				try {
					BufferedReader bufferedReader = new BufferedReader(
							new InputStreamReader(
									new FileInputStream("students.txt"))); 
					String studentsNameInSingleString = bufferedReader.readLine();
					String students[] = studentsNameInSingleString.split("[ ,]+");	
					System.out.println(students.length +" word(s) found ");
				} catch (Exception e){

				} 
				System.out.println("Data Loaded.");				
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("You have not provide any perimeter. Please provide a perimeter!");
		}
	}
}