/**
 * This is my code with help from java2novice.com
 * It’s goal is to do a bubble sort
 * CS 312 - Assignment 7
 * @author Jen Moutenot
 * @version 1.0 11/16/2018
 */

import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;

public class PatrickBubbleSort
{
  /*
   * purpose: to sort the numbers 
   * input: the array to be sorted
   * output: nothing
   */
  public static void bubble_srt(int array[])
  {
    int n = array.length;
    int k;
    for (int m = n; m >= 0; m--)
    {
      for (int i = 0; i < n - 1; i++)
      {
        k = i + 1;
        if (array[i] > array[k])
        {
          swapNumbers(i, k, array);
        }
      }
    }
  }
 
  /*
   * purpose: to swap the numbers 
   * input: the numbers and the array
   * output: nothing
   */
  private static void swapNumbers(int i, int j, int[] array) 
  {
    int temp;
    temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  /*
   * purpose: to print the sorted array
   * input: the argument from standard in
   * output: the sorted printed array
   */
  public static void main(String[] args)
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

    bubble_srt(array);
    
    for (int i = 0; i < array.length; i++)
    {
       System.out.println(array[i]);
    }
  }
}
