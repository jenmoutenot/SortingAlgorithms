/**
 * This is my code with help from Dr. Binkley ASN6
 * It’s goal is to do a tree sort
 * CS 312 - Assignment 7
 * @author Jen Moutenot
 * @version 1.0 11/16/2018
 */

import java.util.*;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

class Tree<E extends Comparable<E>>
{
  protected Node root;
  protected boolean debug;

  protected class Node implements Comparable<Node>
  {
    protected E value;
    protected Node right, left;
   
    /*
     * purpose: Node constructor
     * input: v, left, and right
     * output: nothing
     */
    public Node(E v, Node l, Node r)
    { 
      value = v;
      left = l;
      right = r;
    }

    /*
     * purpose: compare to method 
     * input: the other guy and the other
     * output: number 1 or 0
     */
    public int compareTo(Node otherguy)
    {
      return value.compareTo(otherguy.value);
    }
    
    /* 
     * purpose: to promote a note
     * input: none
     * output: promoted node
     */
    private Node promote()
    {
      if (left == null)
        return right;
      else if (right == null)
        return left;
      else if (left.compareTo(right) < 0)
      {
        value = left.value;
        left = left.promote();
      }
      else
      {
        value = right.value;
        right = right.promote();
      } 
      return this;
    }
    
    /*
     * purpose: to string method to print node
     * input: none
     * output: string
     */
    public String toString()
    {
      String l = left == null ? "null" : left.toString();
      String r = right == null ? "null" : right.toString();
      return "(" + value +  "," + l + "," + r + ")";
    }
  } //end of nested Node class
  
  /* 
   * purpose: to string method for tree
   * input: none
   * output: string
   */
  public String toString() { return root == null ? "nil" : root.toString(); }
  
  /*
   * purpose: to get the next power of 2
   * input: the number n
   * output: number
   */
  private int nextPowerOf2(int n)
  {
    if (n > 0 && (n & (n - 1)) == 0)
      return n;
    
    int count = 0;
    for (;n != 0; n = n >> 1)
      count += 1;
    
    return 1 << count;
  }
  
  /*
   * purpose: tree constructor
   * input: values of the list and boolean
   * output: none
   */
  public Tree(List<E> values, boolean d)
  {
    debug = d;
    Node empty = new Node(null, null, null);
    Deque<Node> worklist = new ArrayDeque<>();
    int size = values.size();
    int leafCount = nextPowerOf2(size);
    int i;
    
    for(i = 0; i < size; i++)
      if (values.get(i) == null)
        System.out.println("ignoring null value");
      else
        worklist.addLast(new Node(values.get(i), null, null));

    for(; i < leafCount; i++)
      worklist.addLast(empty);
    
    while (worklist.size() > 1)
    {
      if (debug)
      {
        System.out.println("\n worklist length = " + worklist.size());
        System.out.println("worklist = " + worklist);
      }
      Node n1 = worklist.pollFirst();
      Node n2 = worklist.pollFirst();
      
      if (n1 == empty)
        worklist.addLast(n2);
      else if (n2 == empty)
        worklist.addLast(n1);
      else if (n1.compareTo(n2) < 0)
        worklist.addLast(new Node(n1.value, n1.promote(), n2));
      else
        worklist.addLast(new Node(n2.value, n1, n2.promote()));
    }
   
    root = worklist.pollFirst();
    if (root.value == null)
      root = null;
  }

  /*
   * purpose: sort method to sort tree
   * input: none (tree)
   * output: the sorted list
   */
  public List<E> sort()
  {
    ArrayList<E> answer = new ArrayList<>();
    
    while (root != null)
    {
      if(debug)
        System.out.println("root = " + root);
      answer.add(root.value);
      root = root.promote();
    }
    return answer;
  }
}

class SandyTreeSort
{
  /*
   * purpose: to print out the sorted numbers
   * input: the argument from standard in
   * output: the sorted printed array
   */
  public static void main(String args[])
  {
    boolean debug = false;  

    Scanner sc = new Scanner(System.in); 
    ArrayList<Integer> arraylist = new ArrayList<Integer>();
    while (sc.hasNextInt()) 
    {
      arraylist.add(sc.nextInt());
    }

    Tree<Integer> tree = new Tree<>(arraylist, debug);
    List<Integer> it = tree.sort(); 
  
    for (int i = 0; i < it.size(); i++)
    {
      System.out.println(it.get(i));
    }
  }
}  
