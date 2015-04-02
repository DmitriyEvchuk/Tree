package ua.bigchuk.Tree;

import ua.bigchuk.wordcounter.FileReaderImplement;
import ua.bigchuk.wordcounter.ImplementWordsExtraction;

public class MyTree {

	Integer sizeLeftTree;
	Integer sizeRightTree;
	MyTreeItem root;

	public void add(String word, int count) {

		MyTreeItem data = new MyTreeItem();

		if (root == null)

		{
			root = data;
		}// if

		else {

			MyTreeItem node = find(word);

			if (compare(node.word, word) == 1) {// if1
				node.left = data;

			}// if1

			if (compare(node.word, word) == -1) {// if2
				node.right = data;

			}// if2

			if (compare(node.word, word) == 0) {// if3
				data = node;

			}// if3

		}// else

		data.word = word;
		data.count = count;

	}

	public Integer get(String key) {

		MyTreeItem current = null;
		if (root != null) {
			current = find(key);

			if (current.word.equals(key))
				return current.count;
		}

		return null;

	}

	private MyTreeItem find(String key) {

		MyTreeItem node = root;
		// I change this but now I don't now what
		while (((compare(node.word, key) == 1) && (node.left != null))
				|| ((compare(node.word, key) == -1) && (node.right != null))) {

			if (compare(node.word, key) == 1) {// if1
				node = node.left;

			}// if1

			else {// if2
				node = node.right;

			}// if2

		}// while

		return node;

	}

	private int compare(String nodeVal, String val) {

		if (nodeVal.hashCode() > val.hashCode())
			return 1;

		if (nodeVal.hashCode() < val.hashCode())
			return -1;

		// else
		return 0;
	}

	private class MyTreeItem {

		MyTreeItem left;
		MyTreeItem right;

		String word;
		Integer count;

	}

	public static void main(String[] args) {

		FileReaderImplement file = new FileReaderImplement();
		file.readFile();

		String s = file.getFileString();

		ImplementWordsExtraction word = new ImplementWordsExtraction();
		word.parseString(s);
		String f[] = word.getWords();

		MyTree words = new MyTree();

		long totalT = -System.currentTimeMillis();
		for (int i = 0; i < f.length; i++) {

			Integer count = words.get(f[i]);
			words.add(f[i], count == null ? 1 : count + 1);
		}
		// time 30-34ms in base version WordsCounterImplement 1454ms
		totalT += System.currentTimeMillis();

		System.out.println(words.get("Acknowledgement"));
		System.out.println(totalT);

		// E:\work\rfc2822.txt

	}// main

}// Mytree
