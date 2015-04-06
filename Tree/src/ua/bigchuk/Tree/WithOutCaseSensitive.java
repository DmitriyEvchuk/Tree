package ua.bigchuk.Tree;

import ua.bigchuk.Tree.MyTree.MyTreeItem;

public class WithOutCaseSensitive implements CaseSensitive  {

	public Integer compare(String nodeVal, String val) {

		
		nodeVal=nodeVal.toLowerCase();
		val=val.toLowerCase();
		
		
		if (nodeVal.hashCode() > val.hashCode())
			return 1;

		if (nodeVal.hashCode() < val.hashCode())
			return -1;

		
		return 0;
	}
	
	public Integer get(String key,MyTree tree) {

		MyTreeItem current = null;
		
		
		if (!tree.isEmpty1()) {
			current = tree.find(key);

			if (current.getWord().equalsIgnoreCase(key))
				return current.getCount();
		}

		return null;

	}


}
