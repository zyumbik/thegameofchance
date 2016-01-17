import java.util.Random;

public class Main {
	
	int lim = 0;
	public static void main(String[] args) {
		Random rnd = new Random();
		Main m = new Main();
		int number = rnd.nextInt(9) + 1;
		
		String example;
		System.out.println("Answer: " + number);
		for (int i = 0; i < 20; i++) {
			example = m.expGen(number, false, false);
			System.out.println(example);
			m.lim = 0;
		}
		
	}

	private String expGen(int a, boolean brackets, boolean bracketshard) {
		Random rnd = new Random();
		lim++;
		int x, y;

		if (lim <= 5) {
			int choice = rnd.nextInt(7);
			if (lim < 2) {
				choice = rnd.nextInt(6);
			}
			switch (choice) {

			case 0:     // -
				do {
					x = rnd.nextInt(Math.abs(a) + 10);
				} while (a + x > 625);
				y = a + x;
				if (brackets) {
					return "(" + expGen(y, false, false) + "-" + expGen(x, true, false) + ")";
				}
				return expGen(y, false, false) + "-" + expGen(x, true, false);

			case 1:     // +
				do {
					x = rnd.nextInt(Math.abs(a) + 10);
				} while (a - x > 625);
				y = a - x;
				if (brackets) {
					return "(" + expGen(y, false, false) + "+" + expGen(x, false, false) + ")";
				}
				return expGen(y, false, false) + "+" + expGen(x, false, false);

			case 2:     // /
				do {
					x = rnd.nextInt(Math.abs(a) + 10) + 1;
				} while (a * x > 625);
				y = a * x;
				if (bracketshard) {
					return "(" + expGen(y, true, false) + "/" + expGen(x, true, false) + ")";
				}
				return expGen(y, true, false) + "/" + expGen(x, true, false);

			case 3:     // *
				do {
					x = rnd.nextInt(Math.abs(a) + 10) + 1;
				} while ((a % x != 0) && (a / x > 625) && (a / x != 0));
				y = a / x;
				if (bracketshard) {
					return "(" + expGen(y, true, false) + "*" + expGen(x, true, false) + ")";
				}
				return expGen(y, true, false) + "*" + expGen(x, true, false);
				
			case 4:     // √
				if (Math.pow(a, 2) < 1000) {
					y = (int) Math.pow(a, 2);
					if (bracketshard) {
						return "(v" + expGen(y, true, true) + ")";
					}
					return "v" + expGen(y, true, true);
				}
				if (lim < 2) {
					return expGen(a, false, false);
				}
				if (a < 0) {
					return "(" + a + ")";
				}
				return "" + a;
				
			case 5:     // ^
				if ((int) Math.sqrt(a) % 1 == 0) {
					y = (int) Math.sqrt(a);
					if (bracketshard) {
						return "(" + expGen(y, true, true) + "^2)";
					}
					return expGen(y, true, true) + "^2";
				}
				if (lim < 2) {
					lim--;
					return expGen(a, false, false);
				}
				if (a < 0) {
					return "(" + a + ")";
				}
				return "" + a;
				
			default:
				if (a < 0) {
					return "(" + a + ")";
				}
				return "" + a;
			
			}
		}
		if (a < 0) {
			return "(" + a + ")";
		}
		return "" + a;
	}

}
