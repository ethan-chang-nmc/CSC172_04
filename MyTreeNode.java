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
      return false; //return false if null
    }
    if (x.compareTo(node.data) == 0) 
    {
      return true; //returns true if node is found
    } 
    else if (x.compareTo(node.data) < 0) 
    {
      return lookupRec(node.leftchild, x); //continue traversing left if less than current node
    } 
    else 
    {
      return lookupRec(node.rightchild, x); //continue traversing right if greater than current node
    }
  }

  /*recursive delete method*/
  private MyTreeNode<T> deleteRec(MyTreeNode<T> node, T x) 
  {
    if (node == null) 
    {
      return null; //check for null node
    }
    if (x.compareTo(node.data) < 0) 
    {
      node.leftchild = deleteRec(node.leftchild, x); //traverse left if less than current node
    } 
    else if (x.compareTo(node.data) > 0) 
    {
      node.rightchild = deleteRec(node.rightchild, x); //traverse right if greater than current node
    } 
    else //node found
    {
      if (node.leftchild == null && node.rightchild == null) //case 1: leaf node, sets it to null
      {
        return null; 
      } 
      else if (node.leftchild == null) //cases 2: one child right
      {
        node.rightchild.parent = node.parent;  //sets right child's parent to be current nodes parent
        return node.rightchild; //sets current node to right child, removes current node
      } 
      else if (node.rightchild == null) //cases 2: one child left
      {
        node.leftchild.parent = node.parent; //sets left child's parent to be current nodes parent
        return node.leftchild; //sets current node to left child, removes current node
      } 
      else //case 3: two children
      {
        MyTreeNode<T> successor = findMin(node.rightchild); //sets successor to be minimum of right side current node
        node.data = successor.data; //set current nodes data to be equal to successor
        node.rightchild = deleteRec(node.rightchild, successor.data); //removes the successor node
      }
    }
    return node;
  }

  /*find minimum of current node to use in delete function*/
  private MyTreeNode<T> findMin(MyTreeNode<T> node) 
  {
    while (node.leftchild != null) 
    {
      node = node.leftchild; //continues traversing left to find minimum
    }
    return node;
  }
}
