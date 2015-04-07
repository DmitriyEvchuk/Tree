package ua.bigchuk.Tree;

import java.util.*;

import ua.bigchuk.wordcounter.FileReaderImplement;
import ua.bigchuk.wordcounter.ImplementWordsExtraction;
import ua.bigchuk.wordcounter.WordSaveImplement;
import ua.bigchuk.wordcounter.WordsCounterImplement;

public class MyTree implements Iterable<String> {

	public MyTree() {

		this.caller = new WithCaseSensitive();
	}

	public MyTree(CaseSensitive caller, TreeItemProcess callerProcess) {

		this.callerProcess = callerProcess;
		this.caller = caller;
	}

	public MyTree(CaseSensitive caller) {
		this.caller = caller;
	}

	public MyTree(TreeItemProcess callerProcess) {

		this.callerProcess = callerProcess;
		this.caller = new WithCaseSensitive();
	}

	private TreeItemProcess callerProcess;
	private CaseSensitive caller;

	private Integer sizeLeftTree;
	private Integer sizeRightTree;
	private MyTreeItem root;

	// when I will do balanse I need size and I change this method
	public boolean isEmpty1() {

		if (root != null)
			return false;

		return true;
	}

	public void add(String word, int count) {

		MyTreeItem data = new MyTreeItem();

		if (root == null)

		{
			root = data;
		}// if

		else {

			MyTreeItem node = find(word);

			if (caller.compare(node.word, word) == 1) {// if1
				node.left = data;

			}// if1

			if (caller.compare(node.word, word) == -1) {// if2
				node.right = data;

			}// if2

			if (caller.compare(node.word, word) == 0) {// if3
				data = node;

			}// if3

		}// else

		data.word = word;
		data.count = count;

	}

	public Integer get(String key) {
		
		MyTreeItem node=null;
		if(root!=null)
			{node = find(key);

		if (caller.equals(key, node.word))
			return node.count;
			}
		return null;
	}

	public void treeTraversal() {

		Stack<MyTreeItem> stack = new Stack<MyTreeItem>();

		MyTreeItem current = root;
		while (!stack.isEmpty() || current != null) {// while1

			if (!stack.isEmpty()) {
				current = stack.pop();

				if ((!stack.isEmpty())
						&& (current.right == stack.lastElement())) {// 1

					current = stack.pop();
				}// 1

				else {

					callerProcess.process(current);

					current = null;
				}

			}

			while (current != null) {// while 0

				stack.push(current);

				if (current.right != null) {// if0

					stack.push(current.right);
					stack.push(current);

				}// if0

				current = current.left;

			}// while 0

		}// while1
	}

	protected MyTreeItem find(String key) {

		MyTreeItem node = root;
		// I change this but now I don't now what
		while (((caller.compare(node.word, key) == 1) && (node.left != null))
				|| ((caller.compare(node.word, key) == -1) && (node.right != null))) {

			if (caller.compare(node.word, key) == 1) {// if1
				node = node.left;

			}// if1

			else {// if2
				node = node.right;

			}// if2

		}// while

		return node;

	}

	//I work about this
	
	public Iterator<String>iterator(){
		
		
		
		
		
		return new Iterator<String>(){
			
		public boolean	hasNext(){
			
			return true;
		}
			
		public String next(){
			
			
			return "d";
		}
		
		public void remove(){}
		
		};
		
		
	}
	
	
	
	private class WithCaseSensitive implements CaseSensitive {

		public Integer compare(String nodeVal, String val) {

			if (nodeVal.hashCode() > val.hashCode())
				return 1;

			if (nodeVal.hashCode() < val.hashCode())
				return -1;

			return 0;
		}

		public boolean equals(String key, String current) {

			if (key.equals(current))
				return true;

			return false;

		}

	}

	public class MyTreeItem {

		private MyTreeItem left;
		private MyTreeItem right;

		private String word;
		private Integer count;

		public String getWord() {
			return word;
		}

		public Integer getCount() {
			return count;
		}

	}
	
	
	
	
	
	public static void main(String []args){
		
		
		
		
		MyTree test=new MyTree();
		test.add("b", 1);
		test.add("a", 1);
		test.add("z", 1);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}// Mytree
