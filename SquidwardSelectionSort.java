/**
 * This is my code with help from java2novice.com
 * It’s goal is to do a selection sort
 * CS 312 - Assignment 7
 * @author Jen Moutenot
 * @version 1.0 11/16/2018
 */

import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;

public class SquidwardSelectionSort
{
  /*
   * purpose: to do the actual selection sort 
   * input: the array to be sorted
   * output: a sorted array
   */
  public static int[] doSelectionSort(int[] arr)
  {		
    for (int i = 0; i < arr.length - 1; i++)
    {
      int index = i;
      for (int j = i + 1; j < arr.length; j++)
        if (arr[j] < arr[index]) 
	  index = j;
	 
	int smallerNumber = arr[index];  
	arr[index] = arr[i];
	arr[i] = smallerNumber;
    }
    return arr;
  }

  /*
   * purpose: to print out the sorted array
   * input: the arguments from standard in
   * output: the sorted printed array
   */	
  public static void main(String a[])
  {
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

    doSelectionSort(array);
    
    for (int i = 0; i < array.length; i++)
    {
       System.out.println(array[i]);
    }
  }	
}
