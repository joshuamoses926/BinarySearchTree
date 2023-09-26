package BST;
import java.util.Queue;
import java.util.LinkedList;

//BinarySearchTree class
//
//CONSTRUCTION: with no initializer
//
//******************PUBLIC OPERATIONS*********************
//void insert( x )       --> Insert x
//void remove( x )       --> Remove x
//boolean contains( x )  --> Return true if x is present
//Comparable findMin( )  --> Return smallest item
//Comparable findMax( )  --> Return largest item
//boolean isEmpty( )     --> Return true if empty; else false
//void makeEmpty( )      --> Remove all items
//void printTree( )      --> Print tree in sorted order
//******************ERRORS********************************
//Throws UnderflowException as appropriate

/**
* Implements an unbalanced binary search tree.
* Note that all "matching" is based on the compareTo method.
* @author Mark Allen Weiss
*/
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>
{
 /**
  * Construct the tree.
  */
 public BinarySearchTree( )
 {
     root = null;
 }

 /**
  * Insert into the tree; duplicates are ignored.
  * @param x the item to insert.
  */
 public void insert( AnyType x )
 {
     root = insert( x, root );
 }

 /**
  * Remove from the tree. Nothing is done if x is not found.
  * @param x the item to remove.
  */
 public void remove( AnyType x )
 {
     root = remove( x, root );
 }

 /**
  * Find the smallest item in the tree.
  * @return smallest item or null if empty.
  */
 public AnyType findMin( )
 {
     if( isEmpty( ) )
         throw new UnderflowException( );
     return findMin( root ).element;
 }

 /**
  * Find the largest item in the tree.
  * @return the largest item of null if empty.
  */
 public AnyType findMax( )
 {
     if( isEmpty( ) )
         throw new UnderflowException( );
     return findMax( root ).element;
 }

 /**
  * Find an item in the tree.
  * @param x the item to search for.
  * @return true if not found.
  */
 public boolean contains( AnyType x )
 {
     return contains( x, root );
 }

 /**
  * Make the tree logically empty.
  */
 public void makeEmpty( )
 {
     root = null;
 }

 /**
  * Test if the tree is logically empty.
  * @return true if empty, false otherwise.
  */
 public boolean isEmpty( )
 {
     return root == null;
 }

 /**
  * Print the tree contents in sorted order.
  */
 public void printTree( )
 {
     if( isEmpty( ) )
         System.out.println( "Empty tree" );
     else
         printTree( root );
 }

 /**
  * Internal method to insert into a subtree.
  * @param x the item to insert.
  * @param t the node that roots the subtree.
  * @return the new root of the subtree.
  */
 private BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t )
 {
     if( t == null )
         return new BinaryNode<>( x, null, null );
     
     int compareResult = x.compareTo( t.element );
         
     if( compareResult < 0 )
         t.left = insert( x, t.left );
     else if( compareResult > 0 )
         t.right = insert( x, t.right );
     else
         ;  // Duplicate; do nothing
     return t;
 }

 /**
  * Internal method to remove from a subtree.
  * @param x the item to remove.
  * @param t the node that roots the subtree.
  * @return the new root of the subtree.
  */
 private BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t )
 {
     if( t == null )
         return t;   // Item not found; do nothing
         
     int compareResult = x.compareTo( t.element );
         
     if( compareResult < 0 )
         t.left = remove( x, t.left );
     else if( compareResult > 0 )
         t.right = remove( x, t.right );
     else if( t.left != null && t.right != null ) // Two children
     {
         t.element = findMin( t.right ).element;
         t.right = remove( t.element, t.right );
     }
     else
         t = ( t.left != null ) ? t.left : t.right;
     return t;
 }

 /**
  * Internal method to find the smallest item in a subtree.
  * @param t the node that roots the subtree.
  * @return node containing the smallest item.
  */
 private BinaryNode<AnyType> findMin( BinaryNode<AnyType> t )
 {
     if( t == null )
         return null;
     else if( t.left == null )
         return t;
     return findMin( t.left );
 }

 /**
  * Internal method to find the largest item in a subtree.
  * @param t the node that roots the subtree.
  * @return node containing the largest item.
  */
 private BinaryNode<AnyType> findMax( BinaryNode<AnyType> t )
 {
     if( t != null )
         while( t.right != null )
             t = t.right;

     return t;
 }

 /**
  * Internal method to find an item in a subtree.
  * @param x is item to search for.
  * @param t the node that roots the subtree.
  * @return node containing the matched item.
  */
 private boolean contains( AnyType x, BinaryNode<AnyType> t )
 {
     if( t == null )
         return false;
         
     int compareResult = x.compareTo( t.element );
         
     if( compareResult < 0 )
         return contains( x, t.left );
     else if( compareResult > 0 )
         return contains( x, t.right );
     else
         return true;    // Match
 }

 /**
  * Internal method to print a subtree in sorted order.
  * @param t the node that roots the subtree.
  */
 private void printTree( BinaryNode<AnyType> t )
 {
     if( t != null )
     {
         printTree( t.left );
         System.out.println( t.element );
         printTree( t.right );
     }
 }

 /**
  * Internal method to compute height of a subtree.
  * @param t the node that roots the subtree.
  */
 private int height( BinaryNode<AnyType> t )
 {
     if( t == null )
         return -1;
     else
         return 1 + Math.max( height( t.left ), height( t.right ) );    
 }
 
 // Basic node stored in unbalanced binary search trees
 private static class BinaryNode<AnyType>
 {
         // Constructors
     BinaryNode( AnyType theElement )
     {
         this( theElement, null, null );
     }

     BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt )
     {
         element  = theElement;
         left     = lt;
         right    = rt;
     }
     AnyType element;            // The data in the node
     BinaryNode<AnyType> left;   // Left child
     BinaryNode<AnyType> right;  // Right child
 }
 
 /** The tree root. */
 private BinaryNode<AnyType> root;

 	//Given a binary tree.
 	//Print the nodes in 
 	//level order using array
 	int size()
 	{
 		return size(root);
 	}
    
     //Returns an int of the number of nodes in the tree. 
     public int size(BinaryNode n)
     {
    	 //if the tree is empty it will
    	 //return 0
    	 if(n == null)
    	 {
    		 return 0;
    	 }
    	 //get the size of the left subtree
    	 //and the right subtree
    	 else
    	 {
    		 return(size(n.left) + 1 + size(n.right));
    	 }
     }
     
     //Function to get the count of 
     //leaf nodes in a binary tree
     int numLeaves()
     {
    	 return numLeaves(root);
     }
     
     //Returns the number of leaf nodes.
     public int numLeaves(BinaryNode n)
     {
    	 //if the tree is empty it will
    	 //return 0
    	 if(n == null)
    	 {
    		 return 0;
    	 }
    	 //if the tree has no left
    	 //or right child nodes it 
    	 //will return 1
    	 if(n.left == null && n.right == null)
    	 {
    		 return 1;
    	 }
    	 //get the count of leaf nodes from
    	 //the left and the right
    	 else
    	 {
    		 return numLeaves(n.left) + numLeaves(n.right);
    	 }
     }
     
     //Returns the number of nodes that have a left child.
     int numLeftChildren()
     {
    	 //if the tree is empty it will
    	 //return 0
    	 if (root == null)
    	 {
    		 return 0;
    	 }
    	 
    	 //Do level order traversal 
    	 //from the root
    	 Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
    	 queue.add(root);
    	 
    	 //Initialize the count of nodes
    	 int n = 0;
    	 while(!queue.isEmpty())
    	 {
    		 BinaryNode t = queue.poll();
    		 if(t.left != null)
    		 {
    			 n++;
    		 }
    		 //Enqueue left children
    		 if(t.left != null)
    		 {
    			 queue.add(t.left);
    		 }
    	 }
    	 return n;
     }
     
     //Returns true is every node has either two children 
     //or no children.
     boolean isFull(BinaryNode n)
     {
    	 //if the tree is empty
    	 //it will return true
    	 if(n == null)
    	 {
    		 return true;
    	 }
    	 //if node has both left and
    	 //right children it will return
    	 //true
    	 if(n.left != null && n.right != null)
    	 {
    		 return true;
    	 }
    	 else
    	 {
    		 return false;
    	 }
     }
     
     //Receives a node value and returns the depth of this node, 
     //or -1 if not found.
     int nodeDepth(BinaryNode root)
     {
    	 //Return 0 for the null node
    	 if(root == null)
    	 {
    		 return 0;
    	 }
    	 //return the depth of the subtree rooted at root
    	 int leftDepth = nodeDepth(root.left);
    	 int rightDepth = nodeDepth(root.right);
    	 return Math.max(leftDepth, rightDepth) + 1;
     }
     
     //Print the root, then it's children, 
     //then their children, etc.
     public int printByLevels(BinaryNode root)
     {
    	 if(root == null) 
    	 {
    		 return 0;
    	 }
    	 // Create an empty queue for level order traversal
    	 Queue<BinaryNode> que = new LinkedList<BinaryNode>();
    	 
    	 //Enqueue Root
    	 que.add(root);
    	 
    	 while(true)
    	 {
    		 //queue size indicates number of nodes
    		 //at level
    		 int count = que.size();
    		 if(count == 0)
    		 {
    			 break;
    		 }
    		 //Dequeue all nodes of current level
    		 //Enqueue all nodes of next level
    		 while(count > 0)
    		 {
    			 BinaryNode node = que.peek();
    			 System.out.print(node.element + " ");
    			 que.remove();
    			 if(node.left != null)
    			 {
    				 que.add(node.left);
    			 }
    			 if(node.right != null)
    			 {
    				 que.add(node.right);
    			 }
    			 count--;
    		 }
    		 System.out.println();
    	 }
		return 0;
     }

     // Test program
 public static void main( String [ ] args )
 {
     BinarySearchTree<Integer> t = new BinarySearchTree<>( );
     final int NUMS = 4000;
     final int GAP  =   37;

     System.out.println( "Checking... (no more output means success)" );

     for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
         t.insert( i );

     for( int i = 1; i < NUMS; i+= 2 )
         t.remove( i );

     if( NUMS < 40 )
         t.printTree( );
     if( t.findMin( ) != 2 || t.findMax( ) != NUMS - 2 )
         System.out.println( "FindMin or FindMax error!" );

     for( int i = 2; i < NUMS; i+=2 )
          if( !t.contains( i ) )
              System.out.println( "Find error1!" );

     for( int i = 1; i < NUMS; i+=2 )
     {
         if( t.contains( i ) )
             System.out.println( "Find error2!" );
     }
     
     //prints the size of the tree
     System.out.println("Size of the tree is: " + t.size());
     //prints the number of leaf nodes
     System.out.println("Number of leaf nodes: " + t.numLeaves());
     //prints the number of left children
     System.out.println("Number of left children: " + t.numLeftChildren());
     //prints out a true or false if the node
     //is or isn't full
     System.out.println("The tree is full: " + t.isFull(t.root));
     //Prints out the Depth of the Node
     System.out.println("Depth of the node: " + t.nodeDepth(t.root));
     //Prints out the tree level by level
     System.out.println("the tree: ");
     System.out.print(t.printByLevels(t.root));
 }

}

