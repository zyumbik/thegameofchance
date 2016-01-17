import java.util.Random;

public class Example {

	int lim = 0;
	public static void main(String[] args) {
		Random rnd = new Random();
		int answer = rnd.nextInt(9) + 1;
		Example example = new Example();
		String express = example.expression(answer);
		System.out.print(express);
	}

	private String expression(int answer) {
		Random rnd = new Random();
		int choice = rnd.nextInt(7);
		switch (choice) {
			case 0:
				return String.valueOf(mul(answer));
			case 1:
				return String.valueOf(div(answer));
			case 2:
				return String.valueOf(add(answer));
			case 3:
				return String.valueOf(sub(answer));
			case 4:
				if (Math.sqrt(answer) != (int)Math.sqrt(answer)) {
					return String.valueOf(simpleInt(answer));
				}
				return String.valueOf(pow(answer));
			case 5:
				return String.valueOf(root(answer));
			case 6:
				return String.valueOf(simpleInt(answer));
		}
		return "error";
	}

	private String expressionBrackets(int answer) {
		return '(' + String.valueOf(expression(answer)) + ')';
	}

	private boolean limit() {
		lim++;
		return lim <= 9;
	}

	private String simpleInt(int answer) {
		limit();
		return String.valueOf(answer);
	}

	private String mul(int answer) {
		if (limit()) {
			Random rnd = new Random();
			int x;
			do {
				x = rnd.nextInt(answer) + 1;
			} while (answer % x != 0);
			int y = answer / x;
			return String.valueOf(expressionBrackets(x)) + '*' + String.valueOf(expressionBrackets(y));
		}
		return String.valueOf(answer);
	}

	private String div(int answer) {
		if (limit()) {
			Random rnd = new Random();
			int x;
			do {
				x = rnd.nextInt(answer) + 1;
			} while (answer * x > 99);
			int y = answer * x;
			return String.valueOf(expressionBrackets(y)) + '/' + String.valueOf(expressionBrackets(x));
		}
		return String.valueOf(answer);
	}

	private String add(int answer) {
		if (limit()) {
			Random rnd = new Random();
			int x;
			do {
				x = rnd.nextInt(answer);
			} while (answer - x > 99);
			int y = answer - x;
			return String.valueOf(expression(y)) + '+' + String.valueOf(expression(x));
		}
		return String.valueOf(answer);
	}

	private String sub(int answer) {
		if (limit()) {
			Random rnd = new Random();
			int x;
			do {
				x = rnd.nextInt(answer);
			} while (answer + x > 99);
			int y = answer + x;
			return String.valueOf(expression(y)) + '-' + String.valueOf(expressionBrackets(x));
		}
		return String.valueOf(answer);
	}

	private String pow(int answer) {
		if (limit()) {
			Random rnd = new Random();
			int y = (int) Math.sqrt(answer);
			return String.valueOf(expressionBrackets(y)) + "^2";
		}
		return String.valueOf(answer);
	}

	private String root(int answer) {
		if (limit()) {
			Random rnd = new Random();
			if (answer >= 10) {
				return String.valueOf(answer);
			}
			int y = (int) Math.pow(answer, 2);
			return '√' + String.valueOf(expressionBrackets(y));
		}
		return String.valueOf(answer);
	}

}