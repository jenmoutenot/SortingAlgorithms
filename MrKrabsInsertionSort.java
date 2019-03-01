/**
 * This is my code with help from java2novice.com
 * It’s goal is to do an insertion sort
 * CS 312 - Assignment 7
 * @author Jen Moutenot
 * @version 1.0 11/16/2018
 */

import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;

public class MrKrabsInsertionSort
{
  /*
   * purpose: to print out the sorted numbers
   * input: arguments from standard in
   * output: printed sorted numbers
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

    doInsertionSort(array);
    
    for (int i = 0; i < array.length; i++)
    {
       System.out.println(array[i]);
    }
  }

  /*
   * purpose: to do the insertion sort
   * input: the array to be sorted
   * output: a sorted array
   */	
  public static int[] doInsertionSort(int[] input)
  {
    int temp;
    for (int i = 1; i < input.length; i++)
    {
      for(int j = i ; j > 0 ; j--)
      {
        if(input[j] < input[j-1])
        {
          temp = input[j];
          input[j] = input[j-1];
          input[j-1] = temp;
        }
      }	   
    }
  return input;
  }
}
