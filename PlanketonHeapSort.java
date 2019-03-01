/**
 * This is my code with help from Dr.Binkley
 * It’s goal is to do a heap sort
 * CS 312 - Assignment 7
 * @author Jen Moutenot
 * @version 1.0 11/16/2018
 */

import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;

public class PlanketonHeapSort
{
  public static final int NO_CHANGE = 1;
  public static final int SWAPPED_WITH_LEFT = 2;
  public static final int SWAPPED_WITH_RIGHT = 3;

  /*
   * purpose: methods for the left child, right child, and parent 
   * input: number n
   * output: new number to find left right and parent
   */
  public int leftChild(int n) { return 2*n+1; }
  public int rightChild(int n) { return 2*n+2; }
  public int parent(int n) { return (n-1)/2; }

  /*
   * purpose: swap the numbers
   * input: the array and the numbers
   * output: nothing
   */
  public void swap(int [] A, int i, int j)
  {
    int tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;
  }

  /*
   * purpose: to shift for the triad property
   * input: the array, number, and last number
   * output:
   */
  // given parent node n, make n, left(n), right(n) satisfy the triad property
  public int shift(int [] A, int n, int last)
  {
    int lc = leftChild(n) > last ? A[n]-1 : A[leftChild(n)];
    int rc = rightChild(n) > last ? A[n]-1 : A[rightChild(n)];

    if (A[n] > lc && A[n] > rc)
      return NO_CHANGE;

    if (rightChild(n) > last || lc > rc) // swap left
    {
      swap(A, n, leftChild(n));
      return SWAPPED_WITH_LEFT;
    }
    else // swap right
    {
      swap(A, n, rightChild(n));
      return SWAPPED_WITH_RIGHT;
    }
  } 

  /*
   * purpose: to heapify up from the leaf
   * input: the array, the leaf, and the last
   * output: nothing
   */
  public void heapifyUpFromLeaf(int [] A, int leaf, int last)
  {
    int n = leaf;
    do
    {
      n = parent(n);
      if (shift(A, n, last) == NO_CHANGE)
        break;
    } while(n != 0);
  }

  /*
   * purpose: to heapify the array
   * input: the array to be heapified
   * output: nothing
   */
  public void heapify(int [] A)
  {
    int last = A.length;
    for(int n=1; n<last; n++)
    {
      heapifyUpFromLeaf(A, n, n);
    }
  }

  /*
   * purpose: to extract the array
   * input: the array
   * output: nothing
   */
  public void extract(int [] A )
  {
    int last = A.length-1;
    while (last > 0)
    {
      swap(A, 0, last);
      last--;
      heapifyDownFromRoot(A, last);
    }
  }

  /*
   * purpose: to heapify down from the root
   * input: the array and the last int
   * output: nothing
   */
  public void heapifyDownFromRoot(int [] A, int last)
  {
    int n = 0;
    int with = shift(A, n, last);
    while (with != NO_CHANGE)
    {
      if (with == SWAPPED_WITH_LEFT)
        n = leftChild(n);
      else
	n = rightChild(n);
      with = shift(A, n, last);
    }
  }

  /*
   * purpose: sort method to sort the array 
   * input: the array to be sorted
   * output: nothing
   */
  public void sort(int [] A)
  {
    heapify(A);
    extract(A);
  }


  /*
   * purpose: to print out the sorted array 
   * input: the argument from standard in
   * output: the printed sorted array
   */
  public static void main (String [] args)
  {
    PlanketonHeapSort hs = new PlanketonHeapSort();
    Scanner sc = new Scanner(System.in);

    ArrayList<Integer> arraylist = new ArrayList<Integer>();
    while (sc.hasNextInt()) 
    {
      arraylist.add(sc.nextInt());
    }  
    int[] array =  new int[arraylist.size()];
    for (int i = 0; i < array.length; i++)
    {
      array[i] = arraylist.get(i);
    }

    hs.sort(array);
    
    for (int i = 0; i < array.length; i++)
    {
       System.out.println(array[i]);
    }
  }
}
