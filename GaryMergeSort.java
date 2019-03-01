/**
 * This is my code with help from java2novice.com
 * It’s goal is to do a merge sort
 * CS 312 - Assignment 7
 * @author Jen Moutenot
 * @version 1.0 11/16/2018
 */

import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;

public class GaryMergeSort
{
  private int[] array;
  private int[] tempMergArr;
  private int length;

  /*
   * purpose: prints out sorted numbers 
   * input: argument from standard in
   * output: printed sorted numbers
   */ 
  public static void main(String args[])
  {
    GaryMergeSort gms = new GaryMergeSort();
    Scanner sc = new Scanner(System.in); //added
   
    ArrayList<Integer> arraylist = new ArrayList<Integer>();
    while (sc.hasNextInt()) //added
    {
      arraylist.add(sc.nextInt());
    }
  
    int[] array =  new int[arraylist.size()];
    for (int i = 0; i < array.length; i++)
    {
      array[i] = arraylist.get(i);
    }

    gms.sort(array);
    
    for (int i = 0; i < array.length; i++)
    {
       System.out.println(array[i]);
    }
  }

  /*
   * purpose: to sort the array
   * input: the array to be sorted
   * output: nothing
   */	
  public void sort(int inputArr[])
  {
    this.array = inputArr;
    this.length = inputArr.length;
    this.tempMergArr = new int[length];
    doMergeSort(0, length - 1);
  }
  
  /*
   * purpose: to merge the indexes
   * input: lower and higher indexes
   * output: nothing
   */	
  private void doMergeSort(int lowerIndex, int higherIndex)
  {	
    if (lowerIndex < higherIndex)
    {
      int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
      // Below step sorts the left side of the array
      doMergeSort(lowerIndex, middle);
      // Below step sorts the right side of the array
      doMergeSort(middle + 1, higherIndex);
      // Now merge both sides
      mergeParts(lowerIndex, middle, higherIndex);
    }
  }
 
  /*
   * purpose: to merge parts
   * input: lower, middle, and higher index
   * output: nothing
   */
  private void mergeParts(int lowerIndex, int middle, int higherIndex)
  {
    for (int i = lowerIndex; i <= higherIndex; i++)
    {
      tempMergArr[i] = array[i];
    }
    int i = lowerIndex;
    int j = middle + 1; 
    int k = lowerIndex;

    while (i <= middle && j <= higherIndex)
    {
      if (tempMergArr[i] <= tempMergArr[j])
      {
	array[k] = tempMergArr[i];
	i++;
      }
      else
      {	
 	array[k] = tempMergArr[j];
	j++;
      }
      k++;
    }
    while (i <= middle)
    {
      array[k] = tempMergArr[i];
      k++;
      i++;
    }
  }
}

