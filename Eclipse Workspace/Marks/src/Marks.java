import java.util.Scanner;

public class Marks {
	Scanner sc = new Scanner (System.in);
	private String[] students = null;
	private int[][] marks = null;
	private int studentId, studentCount = 0;
	
	public Marks(int q) {
		this.students = new String[q];
		this.marks = new int[q][10];
	}
	
	public void newStudent(String name) {
		studentId = studentCount;
		students[studentCount] = name; 
		marks[studentId][0] = studentId;
		studentCount++;
		System.out.println("(+) You've created the student.\n> Name: " + name + "\n> ID: " + studentId + 
				"\n (i) To set marks choose 3 and follow the instructions");
	}
	
	public void setMarks(int id){
		if (students[id] == null) {
			System.out.println("(!) There is no student with such ID!");
		}
		else
		{
			System.out.println("* Enter marks:");
			for (int i = 1; i < marks[0].length; i++) {
				marks[id][i] = sc.nextInt();
				if ((marks[id][i] > 5) || (marks[id][i] < 0)) {
					System.out.println("(!) You can only set marks from 5 to 0! Reset the mark, please:  ");
					i--;
				}
			}
			System.out.println("(+) You've set marks for " + students[id] + " (ID: " + id + ")");
		}
	}
	
	public void getMarks() {
		for (int i = 0; i < marks.length; i++) {
			System.out.println();
			if (students[i] == null) {
				break;
			}
			System.out.print("> " + students[i] + " (ID: " + marks[i][0] + "): ");
			for (int  j = 1; j < marks[0].length; j++) {
				System.out.print(marks[i][j] + " ");
			}
		}
	}
	
	public void getMarks(int id) {
		if (students[id] == null) {
			System.out.println("(!) There is no student with such ID!");
		}
		else
		{
			System.out.print("> Marks of " + students[id] + ": ");
			
			for (int i = 1; i < marks[0].length; i++) {
				System.out.print(marks[id][i] + " ");
			}
			System.out.println();
		}
	}

	public void maxMark (int id) {
		if (students[id] == null) {
			System.out.println("(!) There is no student with such ID!");
		}
		else
		{	
			int max = 0;
			for (int i = 1; i < marks[0].length; i++) {
				if (marks[id][i] > max) {
					max = marks[id][i];
				}
			}
			System.out.println("> Highest mark of " + students[id] + " is: " + max);
		}
	}

	public void averageMark (int id) {
		if (students[id] == null) {
			System.out.println("(!) There is no student with such ID!");
		}
		else
		{	
			int sum = 0;
			for (int i = 1; i < marks[0].length; i++) {
				sum += marks[id][i];
			}
			System.out.println("> Average mark of " + students[id] + " is: " + (sum/(marks[0].length-1)));
		}
	}
	
}
