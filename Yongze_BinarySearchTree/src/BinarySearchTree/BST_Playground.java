package BinarySearchTree;

public class BST_Playground {

  
  public static void main(String[]args){
	  BST T= new BST();
	  
	  T.insert("A");
	  T.remove("A");
	  T.insert("B");
	  printInOrder(T.root);
  }

  static void printLevelOrder(BST tree){ 
  //will print your current tree in Level-Order
    int h=tree.getRoot().getHeight(tree.getRoot());
    for(int i=0;i<=h;i++){
      printGivenLevel(tree.getRoot(), i);
    }
    
  }
  static void printGivenLevel(BST_Node root,int level){
    if(root==null)return;
    if(level==0)System.out.print(root.data+" ");
    else if(level>0){
      printGivenLevel(root.left,level-1);
      printGivenLevel(root.right,level-1);
    }
  }
  static void printInOrder(BST_Node root){
  //will print your current tree In-Order
  if(root!=null){
    printInOrder(root.getLeft());
    System.out.print(root.getData() + " ");
    printInOrder(root.getRight());
  }
  }
}