/*
*Ethan Chang
*echang28@u.rochester.edu
*
*Partner: Darron King
*
*07/28/2024: Creating Binary Search Trees
*/
public class MyTreeNode <T extends Comparable<T>>
{
  T data ;
  MyTreeNode<T> leftchild, rightchild, parent;

  /*recursive insert method*/
  public MyTreeNode<T> insertRec(MyTreeNode<T> node, T x, MyTreeNode<T> parent) 
  {
    if (node == null) //empty case
    {
      MyTreeNode<T> newNode = new MyTreeNode<>(x); //create new node
      newNode.parent = parent; //set node's parent
      return newNode;
    }
    if (x.compareTo(node.data) < 0) 
    {
      node.leftchild = insertRec(node.leftchild, x, node); //recursively call function for left side and current node as parent
    } 
    else if (x.compareTo(node.data) > 0) 
    {
      node.rightchild = insertRec(node.rightchild, x, node); //recursively call function for right side and current node as parent
    }
    return node; //if equal to the current node, do nothing to prevent duplicates
  }

  /*recursive PreOrder method*/
  public void printPreOrderRec(MyTreeNode<T> node) 
  {
    if (node != null) 
    {
      System.out.print(node.data + " "); //print out node
      printPreOrderRec(node.leftchild); //travel down left
      printPreOrderRec(node.rightchild); //then travel down right
    }
  }

  /*recursive InOrder method*/
  public void printInOrderRec(MyTreeNode<T> node) 
  {
    if (node != null) 
    {
      printInOrderRec(node.leftchild); //travel down left
      System.out.print(node.data + " "); //print out node
      printInOrderRec(node.rightchild); //travel down right
    }
  }
 
  /*recursive PostOrder method*/
  private void printPostOrderRec(MyTreeNode<T> node) 
  {
    if (node != null) 
    {
      printPostOrderRec(node.leftchild); //travel down left
      printPostOrderRec(node.rightchild); //travel down right
      System.out.print(node.data + " "); //print out node
    }
  }

  /*recursive lookup method*/
  private boolean lookupRec(MyTreeNode<T> node, T x) 
  {
    if (node == null) 
    {
      return false;
    }
    if (x.compareTo(node.data) == 0) 
    {
      return true;
    } 
    else if (x.compareTo(node.data) < 0) 
    {
      return lookupRec(node.leftchild, x);
    } 
    else 
    {
      return lookupRec(node.rightchild, x);
    }
  }
}
