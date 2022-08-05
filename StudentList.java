import java.io.*;
import java.security.spec.ECFieldF2m;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {

		// Check arguments
		if (args[0].equals(Constants.showAll)) {
			System.out.println(Constants.loadData);
			String names[] = readFile(Constants.studentList).split(Constants.comma);
			for (String name : names) {
				System.out.println(name.trim());
			}
			System.out.println(Constants.dataLoaded);

		} else if (args[0].equals(Constants.randomName)) {
			System.out.println(Constants.loadData);
			String names[] = readFile(Constants.studentList).split(Constants.comma);
			Random random = new Random();
			System.out.println(names[random.nextInt(4)].trim());
			System.out.println(Constants.dataLoaded);

		} else if (args[0].contains(Constants.addName)) {
			System.out.println(Constants.loadData);
			try {
				BufferedWriter bufferedWriter = writeFile(Constants.studentList);
				String newStudentName = args[0].substring(1);
				DateFormat dateFormat = new SimpleDateFormat(Constants.dateFormat);
				String formatedDate = dateFormat.format(new Date());
				bufferedWriter.write(Constants.comma + newStudentName + Constants.listUpdateMessage + formatedDate);
				bufferedWriter.close();
			} catch (Exception e) {
			}
			System.out.println(Constants.dataLoaded);

		} else if (args[0].contains(Constants.findName)) {
			System.out.println(Constants.loadData);
			String[] names = readFile(Constants.studentList).split(Constants.comma);
			int count = 0;
			for (int i = 0; i < names.length; i++) {
				if (names[i].trim().equals(args[0].substring(1))) {
					count++;
				}
			}
			if (count == 0) {
				System.out.println(args[0].substring(1) + Constants.notFoundMessage);
			} else {
				System.out.println(args[0].substring(1) + Constants.foundMessage + " " + count + " time(s)");
			}
			System.out.println(Constants.dataLoaded);

		} else if (args[0].equals(Constants.countStudents)) { // count total number of students
			System.out.println(Constants.loadData);
			String[] names = readFile(Constants.studentList).split(Constants.comma);
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