import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Marks marks = null;
		int choice;
		String commandsList = ">>> Commands list <<<\n0. Commands\n1. Create new marks list\n2. Create new student\n3. Set student's marks\n4. Show all marks\n 5. Show chosen student's marks\n6. Highest mark of a student\n7. Average mark of a student\n";
		System.out.println(commandsList);
		while (true) {
			System.out.print("*** Enter the command: ");
			choice = sc.nextInt();
			switch (choice) {
			case 0:
				System.out.println(commandsList);
				break;
			case 33:
				System.out.println(7);
				break;
			case 1:
				System.out.print("* Enter the quantity of students: ");
				marks = new Marks(sc.nextInt());
				break;
			case 2:
				System.out.print("* Enter new student's name: ");
				marks.newStudent(sc.next());
				break;
			case 3:
				System.out.print("* Enter student's ID to set marks: ");
				marks.setMarks(sc.nextInt());
				break;
			case 4:
				System.out.print("* There are marks of all students: ");
				marks.getMarks();
				break;
			case 5:
				System.out.print("* Enter student's ID to see marks: ");
				marks.getMarks(sc.nextInt());
				break;
			case 6:
				System.out.print("* Enter student's ID to see highest mark: ");
				marks.maxMark(sc.nextInt());
				break;
			case 7:
				System.out.print("* Enter student's ID to see average mark: ");
				marks.averageMark(sc.nextInt());
				break;
			default:
				System.out.println("\n(!) Quitting...");
				sc.close();
				System.exit(choice);
				break;
			}
		}
		
	}

}
