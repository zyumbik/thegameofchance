import java.util.Scanner;

public class CommonFractions {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		double f, f2;
		while(true) {
			System.out.println("Enter the command: ");
			choice = sc.nextInt();
			switch (choice) {
			case 0:
				list();
				break;
			case 1:
				System.out.print("Enter the decimal: ");
				f = sc.nextDouble();
				Fraction fr = new Fraction(f);
				System.out.println("The absolute of this decimal is " + fr.abs());
				break;
			case 2:
				System.out.print("Enter the first decimal: ");
				f = sc.nextDouble();
				System.out.print("Enter the second decimal: ");
				f2 = sc.nextDouble();
				new Fraction (f, f2);
				break;
			case 3:
				System.out.println("Enter the decimal: ");
				f = sc.nextDouble();
				System.out.println("Rounded to int: " + new Fraction (f).round());
				break;
			default:
				sc.close();
				System.out.println("Quitting...");
				System.exit(choice);
				break;
			}
		}
	}

	private static void list () {
		System.out.println("Available commands:\n0. List of commands.\n1. Find the absolute of decimal.\n2. Sum of two decimals\n3. Round decimal to integer.\nOther - Quit.");
	}
	
}

class Fraction {
	private double a;
	
	public Fraction (double a) {
		this.a = a;
	}
	
	public Fraction (double a, double b) {
		System.out.println("Sum of your fractions equals to " + sum(a, b));
	}
	
	private double sum (double a, double b) {
		return (a + b);
	}
	
	public int abs () {
		return (int)(Math.abs(this.a)); 
	}
	
	public int round () {
		return (int)(Math.round(this.a));
	}
}
