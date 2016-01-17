import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.util.Random;

public class BinaryTree {

	Node root;

	public static void main(String[] args) {

		Random rnd = new Random();

		BinaryTree tree = new BinaryTree();

		int[] keys = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		shuffle(keys);

		System.out.print("Mixed array (1-9): ");
		for (int i = 0; i < keys.length; i++) {
			if (i == keys.length - 1) {
				System.out.println(keys[i]);
			}
			else {
				System.out.print(keys[i] + ", ");
			}
		}

		for (int i = 0; i < keys.length; i++) {
			tree.addNode(keys[i]);
		}

		tree.root.selectGenType(rnd.nextInt(9) + 1);

		System.out.print(tree.root.getValue());

	}

	public void addNode(int key) {
		Node newNode = new Node(key);
		if (root == null) {
			root = newNode;
		} else {
			Node focusNode = root;
			Node parent;
			while (true) {
				parent = focusNode;
				if (key < focusNode.key) {
					focusNode = focusNode.leftChild;
					if (focusNode == null) {
						parent.leftChild = newNode;
						newNode.parent = parent;
						return;
					}
				}
				else {
					focusNode = focusNode.rightChild;
					if (focusNode == null) {
						parent.rightChild = newNode;
						newNode.parent = parent;
						return;
					}
				}
			}
		}
	}

	public static int[] shuffle(int[] a) {
		int index;
		Random rnd = new Random();
		for (int i = a.length - 1; i > 0; i--) {
			index = rnd.nextInt(i + 1);
			if (index != i) {
				a[index] ^= a[i];
				a[i] ^= a[index];
				a[index] ^= a[i];
			}
		}
		return a;
	}

	public void preOrderTraverse(Node focusNode) {
		if (focusNode != null) {
			System.out.print(focusNode.getValue());
			preOrderTraverse(focusNode.leftChild);
			preOrderTraverse(focusNode.rightChild);
		}
	}

}

class Node {
	Random rnd = new Random();
	int key;
	int x, y, answer;
	char op;
	Node leftChild;
	Node rightChild;
	Node parent;

	public Node(int key) {
		this.key = key;
	}

	private void generateExpressionAny(int a) {
		char op = '$';
		int y;
		double x = 0.5;

		do {
			int choice = rnd.nextInt(6);
			y = rnd.nextInt(100);
			switch (choice) {

				case 0:
					x = a + y;
					op = '-';
					break;

				case 1:
					x = a - y;
					op = '+';
					break;

				case 2:
					if ((Math.abs(a) * y) > 10000) {
						y = rnd.nextInt(20);
						if ((Math.abs(a) * y) > 10000) {
							break;
						}
					}
					x = a * y;
					op = '/';
					break;

				case 3:
					y = rnd.nextInt(20) + 1;
					x = (double) a / y;
					op = '*';
					break;

				case 4:
					x = Math.pow(a, 2);
					if (x > 1000) {
						x = 0.5;
						break;
					}
					y = (int) x;
					op = '√';
					break;

				case 5:
					if (Math.sqrt(a) % 1 == 0) {
						x = Math.sqrt(a);
						y = (int) x;
						op = '^';
					}
					break;

			}
		} while ((int) x != x);	//to check if x is integer and if no - regenerate

		this.op = op;
		this.y = y;
		this.x = (int) x;
	}

	private void generateExpressionTwoNumbers(int a) {
		char op = '$';
		int x;
		double y = 0.5;

		do {
			int choice = rnd.nextInt(4);
			x = rnd.nextInt(100);
			switch (choice) {
				case 0:
					y = a + x;
					op = '-';
					break;
				case 1:
					y = a - x;
					op = '+';
					break;
				case 2:
					if ((Math.abs(a) * x) > 10000) {
						x = rnd.nextInt(20);
						if ((Math.abs(a) * x) > 10000) {
							break;
						}
					}
					y = a * x;
					op = '/';
					break;
				case 3:
					x = rnd.nextInt(20) + 1;
					y = (double) a / x;
					op = '*';
					break;
			}
		} while ((int) y != y);	//to check if y is integer and if no - regenerate

		this.y = x;
		this.op = op;
		this.x = (int) y;

	}

	public void selectGenType(int answer) {
		this.answer = answer;
		if ((leftChild != null) && (rightChild != null)) {
			generateExpressionTwoNumbers(answer);
			leftChild.selectGenType(x);
			rightChild.selectGenType(y);
		}
		else {
			generateExpressionAny(answer);

		 	if (leftChild != null) {
				leftChild.selectGenType(x);
			} else if (rightChild != null) {
				rightChild.selectGenType(y);
			}
		}
	}

	public String getValue() {
		if (op == '^') {
			return xExpression() + "^2";
		}
		if (op == '√') {
			return "√" + x;
		}
		if (op == '+') {
			String parenthesisLeft = "", paranthesisRight = "";
			if (parent != null) {
				if ((parent.op != '-') && (parent.op != '+')) {
					paranthesisRight = ")";
					parenthesisLeft = "(";
				}
			}
			if (y < 0) {
				op = '-';
				if (rightChild != null) {
					rightChild.y = Math.abs(rightChild.y);
				}
				return parenthesisLeft + String.valueOf(xExpression()) + op + String.valueOf(yExpression()) + paranthesisRight; //Math.abs to y and x second expressions
			}
			if (x < 0) {
				op = '-';
				if (leftChild != null) {
					leftChild.x = Math.abs(leftChild.x);
				}
				return parenthesisLeft + String.valueOf(yExpression()) + op + String.valueOf(xExpression()) + paranthesisRight;
			}
		}
		if (op == '-') {
			String parenthesisLeft = "", paranthesisRight = "";
			if (parent != null) {
				if ((parent.op != '-') && (parent.op != '+')) {
					paranthesisRight = ")";
					parenthesisLeft = "(";
				}
			}
			if (y < 0) {
				op = '+';
				if (rightChild != null) {
					rightChild.y = Math.abs(rightChild.y);
				}
				return parenthesisLeft + String.valueOf(xExpression()) + op + "" + String.valueOf(yExpression()) + paranthesisRight;
			}
			if (x < 0) {
				op = '+';
				if (leftChild != null) {
					leftChild.x = Math.abs(leftChild.x);
				}
				return parenthesisLeft + String.valueOf(yExpression()) + op + String.valueOf(xExpression()) + parenthesisLeft;
			}
		}

		return String.valueOf(xExpression()) + op + String.valueOf(yExpression());
	}

	private String xExpression() {
		if (leftChild != null) {
			return leftChild.getValue();
		}
		return String.valueOf(x);
	}

	private String yExpression() {
		if (rightChild != null) {
			return rightChild.getValue();
		}
		return String.valueOf(y);
	}

}