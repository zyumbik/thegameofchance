import java.util.Random;

public class BinaryTree {

	Node root;

	public static void main(String[] args) {

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
			System.out.println(focusNode);
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

	public Node(int key) {
		this.key = key;
		this.answer = rnd.nextInt(9) + 1;
	}

	public String toString () {
		return "Node " + key + " has the answer " + answer;
	}
}