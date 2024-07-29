/*
*Ethan Chang
*echang28@u.rochester.edu
*
*Partner: Darron King
*
*07/28/2024: Creating Binary Search Trees
*/
public class ImplementBST<T extends Comparable<T>> implements MyBST<T>
{
  private MyTreeNode<T> root = null; //create root node

  /*insert method calling on recursive insert*/
  public void insert(T x) 
  {
    if (!lookup(x)) //only inserts if it does not already exist in BST
    {
      root = insertRec(root, x, null);
    }
  }

  /*PreOrder method calling on recursive PreOrder*/
  public void printPreOrder() 
  {
    printPreOrderRec(root);
  }

  /*InOrder method calling on recursive InOrder*/
  public void printInOrder() 
  {
    printInOrderRec(root);
  }

  /*PostOrder method calling on recursive PostOrder*/
  public void printPostOrder() 
  {
    printPostOrderRec(root);
  }

  /*lookup method calling on recursive lookup*/
  public boolean lookup(T x) 
  {
    return lookupRec(root, x);
  }

  /*delete method calling on recursive delete*/
  public void delete(T x) 
  {
    if (lookup(x)) //only calls delete if x is in BST
    {
      root = deleteRec(root, x);
    }
  }
}
