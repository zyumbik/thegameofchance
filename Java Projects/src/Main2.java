import java.util.Random;

public class Main2 {

	public static void main(String[] args) {
		//System.out.print(generateNumber(-1));
		chars();
	}

	private static String generateNumber(int range) {
		Random rnd = new Random();
		try {
			int generatedNumber = rnd.nextInt(range);
			return "" + generatedNumber;
		} catch (IllegalArgumentException e) {
			return "You entered invalid number!";
		}
	}

	public static void chars() {
		char c;
		for (int i = 0; i < 300; i++) {
			c = (char) i;
			System.out.println(i + " - " + c);
		}
	}

}
