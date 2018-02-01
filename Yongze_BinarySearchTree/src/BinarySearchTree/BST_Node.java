package BinarySearchTree;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;

	BST_Node(String data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	// --- used for testing ----------------------------------------------
	//
	// leave these 3 methods in, as is

	public String getData() {
		return data;
	}

	public BST_Node getLeft() {
		return left;
	}

	public BST_Node getRight() {
		return right;
	}

	public boolean containsNode(String s) {
		int compare = s.compareTo(this.getData());
		if (s == this.getData()) {
			return true;
		} else if (compare < 0) {
			if (left == null)
				return false;
			else
				return left.containsNode(s);
		} else if (compare > 0) {
			if (right == null)
				return false;
			else
				return right.containsNode(s);
		}
		return false;
	}

	public BST_Node insertNode(BST_Node root, BST_Node nodeToBeInserted) {
		int compare = nodeToBeInserted.getData().compareTo(root.getData());
		if (compare < 0) {
			if (root.left == null)
				root.left = nodeToBeInserted;
			else
				insertNode(root.left, nodeToBeInserted);
		} else if (compare > 0)
			if (root.right == null)
				root.right = nodeToBeInserted;
			else
				insertNode(root.right, nodeToBeInserted);
		return root;
	}

	public BST_Node removeNode(BST_Node root, String s) {

		int compare = s.compareTo(root.getData());
		BST_Node p, p2, n;
		if (compare == 0) {
			BST_Node lt, rt;
			lt = root.getLeft();
			rt = root.getRight();
			if (lt == null && rt == null){
				return null;}
			else if (lt == null) {
				p = rt;
				return p;
			} else if (rt == null) {
				p = lt;
				return p;
			} else {
				p2 = rt;
				p = rt;
				while (p.getLeft() != null)
					p = p.getLeft();
				p.left = lt;
				return p2;
			}
		}
		if (compare < 0) {
			n = removeNode(root.getLeft(), s);
			root.left = n;
		} else {
			n = removeNode(root.getRight(), s);
			root.right = n;
		}
		return root;
	}

	public BST_Node findMin(BST_Node rt) {
		if (rt.left == null)
			return rt;
		else {
			return findMin(rt.left);
		}
	}

	public BST_Node findMax(BST_Node rt) {
		if (rt.right == null)
			return rt;
		else {
			return findMax(rt.right);
		}
	}

	public int getHeight(BST_Node rt) {
		if (rt == null) {
			return -1;
		}
		return 1 + Math.max(getHeight(rt.left), getHeight(rt.right));
	}

	public String toString() {
		return "Data: " + this.data + ", Left: " + ((this.left != null) ? left.data : "null") + ",Right: "
				+ ((this.right != null) ? right.data : "null");
	}
}