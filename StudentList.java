import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {

		// Check arguments
		if (args[0].equals("a")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader s = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String r = s.readLine();
				String i[] = r.split(",");
				for (String j : i) {
					System.out.println(j.trim());
				}
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");

		} else if (args[0].equals("r")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader s = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String r = s.readLine();
				String i[] = r.split(",");
				Random x = new Random();
				int y = x.nextInt(4);
				System.out.println(i[y].trim());
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");

		} else if (args[0].contains("+")) {
			System.out.println("Loading data ...");
			try {
				BufferedWriter s = new BufferedWriter(
						new FileWriter("students.txt", true));
				String t = args[0].substring(1);
				Date d = new Date();
				String df = "dd/MM/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(df);
				String fd = dateFormat.format(d);
				s.write(", " + t + "\nList last updated on " + fd);
				s.close();
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");

		} else if (args[0].contains("?")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader s = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String r = s.readLine();
				if (r.contains(args[0].substring(1))) {
					System.out.println("We found it!");
				} else {
					System.out.println("Not found!");
				}
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");

		} else if (args[0].equals("c")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader s = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String D = s.readLine();
				String[] names = D.split(",");
				System.out.println(names.length + " word(s) found");
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");

		} else {
			System.out.println("Enter 'a' to see the list.");
			System.out.println("Enter 'r' to see a random students' name.");
			System.out.println("Enter 'c' to count number of students.");
			System.out.println("Enter '?StudentName' to find him/her");
			System.out.println("Enter '+StudentName' to add him/her.");
		}
	}
}