package ua.bigchuk.Tree;

public class MyTree {

	Integer sizeLeftTree;
	Integer sizeRightTree;
	Data root;

	public void add(Integer val) {

		Data data = new Data();

		if (root == null)

		{
			root = data;
		}// if

		else {
			Data node = root;
			// I change this but now I don't now what
			while (((node.val > val) && (node.left != null))
					|| ((node.val < val) && (node.right != null))) {

				if (node.val > val) {// if1
					node = node.left;

				}// if1

				else {// if2
					node = node.right;

				}// if2

				

			}// while

			if (node.val > val) {// if1
				node.left = data;

			}// if1

			if (node.val < val) {// if2
				node.right = data;

			}// if2

		}// else

		data.val = val;

	}

	private class Data {

		Data left;
		Data right;
		Integer val;

	}

	public static void main(String[] args) {

		MyTree tree = new MyTree();

		tree.add(15);
		tree.add(10);
		tree.add(12);
		tree.add(5);
		tree.add(6);
		tree.add(11);
		tree.add(13);
		tree.add(4);

		System.out.println(tree.root.val);// 15
		System.out.println(tree.root.left.val);// 10
		System.out.println(tree.root.left.right.val);// 12
		System.out.println(tree.root.left.left.val);// 5
		System.out.println(tree.root.left.left.right.val);// 6
		System.out.println(tree.root.left.right.left.val);// 11
		System.out.println(tree.root.left.right.right.val);// 13
		System.out.println(tree.root.left.left.left.val);// 4

	}// main

}// Mytree
