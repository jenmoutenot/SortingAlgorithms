/**
 * This is my code with help from java2novice.com
 * It’s goal is to do a quick sort
 * CS 312 - Assignment 7
 * @author Jen Moutenot
 * @version 1.0 11/16/2018
 */

import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;

public class SpongebobQuickSort
{
	
  private int array[];
  private int length;

  /*
   * purpose: to sort the array 
   * input: the array to be sorted
   * output: nothing
   */
  public void sort(int[] inputArr)
  {
    if (inputArr == null || inputArr.length == 0)
    {
      return;
    }
    this.array = inputArr;
    length = inputArr.length;
    quickSort(0, length - 1);
  }

  /*
   * purpose: to do the actual quick sort
   * input: the indexes, lower and higher
   * output: nothing
   */
  private void quickSort(int lowerIndex, int higherIndex)
  {
    int i = lowerIndex;
    int j = higherIndex;
    // calculate pivot number, I am taking pivot as middle index number
    int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
    // Divide into two arrays
    while (i <= j)
    {
    /**
     * In each iteration, we will identify a number from left side which 
     * is greater then the pivot value, and also we will identify a number 
     * from right side which is less then the pivot value. Once the search 
     * is done, then we exchange both numbers.
     */
      while (array[i] < pivot)
      {
        i++;
      }
      while (array[j] > pivot) 
      {
        j--;
      }
      if (i <= j)
      {
        exchangeNumbers(i, j);
        //move index to next position on both sides 
        i++;
        j--;
      }
    }
    // call quickSort() method recursively
    if (lowerIndex < j)
      quickSort(lowerIndex, j);
    if (i < higherIndex)
      quickSort(i, higherIndex);
  }

  /*
   * purpose: to exchange numbers
   * input: the two numbers
   * output: nothing
   */
  private void exchangeNumbers(int i, int j)
  {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  /*
   * purpose: to print the sorted array
   * input: the argument from standard in
   * output: the sorted printed array
   */	
  public static void main(String a[])
  {
    SpongebobQuickSort sorter = new SpongebobQuickSort();
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

    sorter.sort(array);
    
    for (int i = 0; i < array.length; i++)
    {
       System.out.println(array[i]);
    }
  }
}
