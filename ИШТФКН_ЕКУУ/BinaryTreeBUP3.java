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

		tree.preOrderTraverse(tree.root);

	}

	public void addNode (int key) {
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
						return;
					}
				}
				else {
					focusNode = focusNode.rightChild;
					if (focusNode == null) {
						parent.rightChild = newNode;
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
			System.out.println(focusNode.getValue());
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
	boolean brackets;
	Node leftChild;
	Node rightChild;

	public Node(int key) {
		this.key = key;
	}

	public String getValue () {
		return "Node " + key + ": " + x + op + "" + y + "=" + answer;
	}

	private void generateExpressionAny (int a) {
		char op = '$';
		int x;
		double y = 0.5;

		do {
			int choice = rnd.nextInt(6);
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
					y = a * x;
					op = '/';
					break;

				case 3:
					x = rnd.nextInt(a + 10) + 1;
					y = (double) a / x;
					op = '*';
					break;

				case 4:
					y = Math.pow(a, 2);
					x = (int) y;
					op = '√';
					break;

				case 5:
					if (Math.sqrt(a) % 1 == 0) {
						y = Math.sqrt(a);
						x = (int) y;
						op = '^';
					}
					break;

			}
		} while ((int) y != y);	//to check if y is integer and if no - regenerate

		this.op = op;
		this.x = x;
		this.y = (int) y;
	}

	private void generateExpressionTwoNumbers (int a) {
		char op = '$';
		int x;
		double y = 0.5;

		do {
			int choice = rnd.nextInt(7);
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
					y = a * x;
					op = '/';
					break;
				case 3:
					x = rnd.nextInt(a + 10) + 1;
					y = (double) a / x;
					op = '*';
					break;
			}
		} while ((int) y != y);	//to check if y is integer and if no - regenerate

		this.x = x;
		this.op = op;
		this.y = (int) y;

	}

	public void selectGenType (int answer) {
		this.answer = answer;
		if ((leftChild != null) && (rightChild != null)) {
			generateExpressionTwoNumbers(answer);
			leftChild.selectGenType(x);
			rightChild.selectGenType(y);
		}
		else {
			generateExpressionAny(answer);

			if ((leftChild == null) && (rightChild == null)) {
				return;
			}

		 	if (leftChild == null) {
				rightChild.selectGenType(y);
			} else if (rightChild == null) {
				leftChild.selectGenType(x);
			}
		}
	}

}