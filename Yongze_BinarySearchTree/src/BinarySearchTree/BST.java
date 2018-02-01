package BinarySearchTree;

public class BST implements BST_Interface {
	public BST_Node root;
	int size;

	public BST() {
		size = 0;
		root = null;
	}

	@Override
	public BST_Node getRoot() {
		return root;
	}

	@Override
	public boolean insert(String s) {
		// TODO Auto-generated method stub
		if (root == null) {
			root = new BST_Node(s);
			size++;
			return true;
		}
		if (root.containsNode(s) == true) {
			return false;
		} else {
			size++;
			root.insertNode(root, new BST_Node(s));
			return true;
		}
	}

	@Override
	public boolean remove(String s) {
		if (root == null) {// ||(root.left==null&&root.right==null)) {
			return false;
		} else if (root != null && root.left == null & root.right == null && root.getData() == s) {
			root = null;
			size--;
			return true;
		} else if (root.containsNode(s) != true) {
			return false;
		} else {
			size--;
			root.removeNode(root, s);
			return true;
		}
	}

	@Override
	public String findMin() {
		// TODO Auto-generated method stub
		if (root == null) {
			return null;
		} else if (root.left == null) {
			return root.getData();
		} else {
			return root.findMin(root).getData();
		}
	}

	@Override
	public String findMax() {
		// TODO Auto-generated method stub
		if (root == null) {
			return null;
		} else if (root.right == null) {
			return root.getData();
		} else {
			return root.findMax(root).getData();
		}
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		if (this.size == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean contains(String s) {
		// TODO Auto-generated method stub
		if (root.getData() == s) {
			return true;
		} else {
			return root.containsNode(s);
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return -1;
		} else {
			return root.getHeight(root);
		}
	}
}