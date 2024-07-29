/*
*Ethan Chang
*echang28@u.rochester.edu
*
*Partner: Darron King
*
*07/28/2024: Creating Binary Search Trees
*/
public class MyBSTImpl<T extends Comparable<T>> implements MyBST<T>
{
  private MyTreeNode<T> root = null; //create root node

  /*insert method calling on recursive insert*/
  public void insert(T x) 
  {
    root = insertRec(root, x, null);
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
}
