import java.io.*;
import java.security.spec.ECFieldF2m;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {

		// Check arguments
		if (args[0].equals("a")) {
			System.out.println("Loading data ...");
			BufferedReader bufferedReader = readFile("students.txt");
			String line = readOneLine(bufferedReader);
			String studentNames[] = line.split(",");
			for (String studentName : studentNames) {
				System.out.println(studentName.trim());
			}
			System.out.println("Data Loaded.");

		} else if (args[0].equals("r")) {
			System.out.println("Loading data ...");
			BufferedReader bufferedReader = readFile("students.txt");
			String line = readOneLine(bufferedReader);
			String studentNames[] = line.split(",");
			Random random = new Random();
			int studentNumber = random.nextInt(4);
			System.out.println(studentNames[studentNumber].trim());
			System.out.println("Data Loaded.");

		} else if (args[0].contains("+")) {
			System.out.println("Loading data ...");
			try {
				BufferedWriter bufferedWriter = writeFile("students.txt");
				String newStudentName = args[0].substring(1);
				Date date = new Date();
				String dateFormat_d_M_y = "dd/MM/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(dateFormat_d_M_y);
				String formatedDate = dateFormat.format(date);
				bufferedWriter.write(", " + newStudentName + "\nList last updated on " + formatedDate);
				bufferedWriter.close();
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");

		} else if (args[0].contains("?")) {
			System.out.println("Loading data ...");
			BufferedReader bufferedReader = readFile("students.txt");
			String line = readOneLine(bufferedReader);
			if (line.contains(args[0].substring(1))) {
				System.out.println("We found it!");
			} else {
				System.out.println("Not found!");
			}
			System.out.println("Data Loaded.");

		} else if (args[0].equals("c")) {
			System.out.println("Loading data ...");
			BufferedReader bufferedReader = readFile("students.txt");
			String line = readOneLine(bufferedReader);
			String[] studentNames = line.split(",");
			System.out.println(studentNames.length + " word(s) found");
			System.out.println("Data Loaded.");

		} else {
			System.out.println("Enter 'a' to see the list.");
			System.out.println("Enter 'r' to see a random students' name.");
			System.out.println("Enter 'c' to count number of students.");
			System.out.println("Enter '?StudentName' to find him/her");
			System.out.println("Enter '+StudentName' to add him/her.");
		}
	}

	static BufferedReader readFile(String fileName) {
		try {
			return new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fileName)));
		} catch (Exception e) {
			return null;
		}
	}

	static String readOneLine(BufferedReader bufferedReader) {
		try {
			return bufferedReader.readLine();
		} catch (Exception e) {
			return null;
		}
	}

	static BufferedWriter writeFile(String fileName) {
		try {
			return new BufferedWriter(
					new FileWriter(fileName, true));
		} catch (Exception e) {
			return null;
		}
	}
}