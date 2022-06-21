import java.io.*;
import java.security.spec.ECFieldF2m;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {

		// Check arguments
		if (args[0].equals(Constants.showAll)) {
			System.out.println(Constants.loadData);
			String studentNames = readFile(Constants.studentList);
			String names[] = studentNames.split(Constants.comma);
			for (String name : names) {
				System.out.println(name.trim());
			}
			System.out.println(Constants.dataLoaded);

		} else if (args[0].equals(Constants.randomName)) {
			System.out.println(Constants.loadData);
			String studentNames = readFile(Constants.studentList);
			String names[] = studentNames.split(Constants.comma);
			Random random = new Random();
			int studentNumber = random.nextInt(4);
			System.out.println(names[studentNumber].trim());
			System.out.println(Constants.dataLoaded);

		} else if (args[0].contains(Constants.addName)) {
			System.out.println(Constants.loadData);
			try {
				BufferedWriter bufferedWriter = writeFile(Constants.studentList);
				String newStudentName = args[0].substring(1);
				Date date = new Date();
				String dateFormat_d_M_y = Constants.dateFormat;
				DateFormat dateFormat = new SimpleDateFormat(dateFormat_d_M_y);
				String formatedDate = dateFormat.format(date);
				bufferedWriter.write(Constants.comma + newStudentName + Constants.listUpdateMessage + formatedDate);
				bufferedWriter.close();
			} catch (Exception e) {
			}
			System.out.println(Constants.dataLoaded);

		} else if (args[0].contains(Constants.findName)) {
			System.out.println(Constants.loadData);
			String studentNames = readFile(Constants.studentList);
			if (studentNames.contains(args[0].substring(1))) {
				System.out.println(Constants.foundMessage);
			} else {
				System.out.println(Constants.notFoundMessage);
			}
			System.out.println(Constants.dataLoaded);

		} else if (args[0].equals(Constants.countStudents)) {
			System.out.println(Constants.loadData);
			String studentNames = readFile(Constants.studentList);
			String[] names = studentNames.split(Constants.comma);
			System.out.println(names.length + Constants.wordFoundMessage);
			System.out.println(Constants.dataLoaded);

		} else {
			System.out.println(Constants.warningMessage);
		}
	}

	static String readFile(String fileName) {
		try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fileName)));
			String studentNames = bufferedReader.readLine();
			return studentNames;
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