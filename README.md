# BinarySearchTree

Project #2

Due Dates:  Tuesday, June 22 at 11:59pm 

Submit:    eLearning

Late Policy:  24-hour late period, then zero

Instructions: This is an individual assignment.  Answers should be your own work.
              You should use good programming style, such as using meaningful
              variable names, proper alignment, plenty of comments, etc.



Introduction:

   In this project you will add methods to an existing binary search tree class.


Description:

   Modify the author's "BinarySearchTree".
 
   It should have the following methods.  The methods should 
   all operate on the object making the call (none are static).  

   Perform checking of the parameters and throw exceptions if needed.
   Use recursion where indicated.


   15 points
   a) size
        returns an int of the number of nodes in the tree.  Use recursion.

   15 points
   b) numLeaves
        Returns the number of leaf nodes.  Use recursion.

   15 points
   c) numLeftChildren
        Returns the number of nodes that have a left child.  Use recursion.

   15 points
   d) isFull
        Returns true if every node has either two children or no children.
        (Assume an empty tree is full.)  Use recursion.

   15 points
   e) nodeDepth
        Receives a node value and returns the depth of this node, or -1 if not found. 
        Use recursion.

   15 points
   f) printByLevels 
        Print the root, then its children, then their children, etc.
        This can be done using a queue.  Enqueue the root, then while the queue 
        is not empty, dequeue and print, and enqueue its children.

   10 points
   g) main 
        Change the main method to demonstrate your new methods.


Submit to eLearning:
   BinarySearchTree.java
