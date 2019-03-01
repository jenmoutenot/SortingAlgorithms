/**
 * This is my code! It’s goal is to generate random numbers
 * CS 312 - Assignment 7
 * @author Jen Moutenot
 * @version 1.0 11/16/2018
 */

import java.util.*;

/*
 * purpose: to generate random numbers
 * input: argument (seed and count)
 * output: nothing
 */
public class generator
{
  public static int max_bound = 1024;

  public static void main(String args[])
  {
    int arg1 = Integer.parseInt(args[1]);
    int arg0 = Integer.parseInt(args[0]);
    
    Random generator = new Random(arg0);

    int arr[] = new int[arg1];
    for (int i = 0; i < arg1; i++)
    { 
      arr[i] = generator.nextInt(max_bound);
    } 
    
    for (int i = 0; i < arg1; i++)
    {
      System.out.println(arr[i]);
    }
  }
}
