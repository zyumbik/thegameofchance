import java.util.Random;

public class Main3 {

	public static void main(String[] args) {

		int p = 20;
		boolean b = true;
		String s = generatePass(p, b);
		System.out.print(s);

	}

	public static String generatePass(int length, boolean isComplicated) {
		Random rnd = new Random();
		StringBuffer sb = new StringBuffer();
		char[] alphabet = new char[78];

		//Filling the array of symbols (0 - 61, chars: 0-9, a-z, A-Z)
		for (int i = 0; i < 10; i++) {
			alphabet[i] = (char) (i + 48);
		}
		for (int i = 10; i < 36; i++) {
			alphabet[i] = (char) (i + 55);
		}
		for (int i = 36; i < 62; i++) {
			alphabet[i] = (char) (i + 61);
		}
		//For complicated passwords (indexes 62 - 77)
		char[] additional = {'!', '?', '#', '$', '%', '(', ')', '.', '+', '*', '^', '/', '@', '_', '~', '&'};
		for (int i = 0; i < additional.length; i++) {
			alphabet[i + 62] = additional[i];
		}

		char character;
		if (isComplicated) {
			for (int i = 0; i <= length; i++) {
				if (i % 5 == 0) {
					sb.append('-');
				} else {
					character = (char) alphabet[rnd.nextInt(78)];
					sb.append(character);
				}
			}
		} else {
			for (int i = 0; i <= length; i++) {
				character = (char) alphabet[rnd.nextInt(62)];
				sb.append(character);
			}
		}

		return sb.toString();
	}

}
