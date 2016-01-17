import java.util.Random;
import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] randomNumber = createArray();
		int userNum;
		int[] userNumber;

		while (true) {
			System.out.print("\nEnter a number to guess: ");
			userNum = sc.nextInt();
			userNumber = createArray(userNum);
			boolean equal = true;
			for (int i = 0; i < randomNumber.length; i++) {
				if (randomNumber[i] == userNumber[i]) {
					System.out.print("Bull ");
				} else {
					System.out.print("Cow ");
					equal = false;
				}
			}
			if (equal) {
				System.out.print("\nYou won! The number was: ");
				for (int i = 0; i < randomNumber.length; i++) {
					System.out.print(randomNumber[i]);
				}
				System.out.println("\n");
				randomNumber = createArray();
			}
		}

	}

	//Creates a random array of 4 digits
	public static int[] createArray() {
		Random rnd = new Random();
		int number = rnd.nextInt(8999) + 1000;
		int[] array = new int[4];
		for (int i = array.length - 1; i >= 0; i--) {
			array[i] = number % 10;
			number /= 10;
		}
		return array;
	}

	//Splits number digits into an array
	public static int[] createArray(int number) {
		int[] array = new int[4];
		for (int i = array.length - 1; i >= 0; i--) {
			array[i] = number % 10;
			number /= 10;
		}
		return array;
	}
}
