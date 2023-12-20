/**
 * Assignment name : CS160HW4 Assignment
 * Author : Seerat Sandha 
 * Date : 04/09/2023
 */
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.*;
import java.util.Arrays;
public class UsingArray
{
    public static void main(String[] args) throws IOException
{
   Scanner scnr= null;
   // Here , this currentTimeMillis is used to measure the runtime for this program in Milli-Seconds 
   final long startTime = System.currentTimeMillis();
try
{
    // using try and catch for any exception 
    // using FileInputStream to read the file random.txt.
    FileInputStream fileName = new FileInputStream("C:\\Users\\sand4927\\Downloads\\random.txt");
    scnr = new Scanner(fileName);
    int [] numbers = new int[1000];
    System.out.println("File random.txt has successfully been loaded.\nArray loaded with 1000 integers\n");
    int i ;
    while(scnr.hasNextInt())     // while loop to read the content of file in an Array to the end . 
      {        
        for(i =0; i <numbers.length ;++i)
        {
          numbers[i] = scnr.nextInt();
        }
      }
    
    Scanner input = new Scanner(System.in);
    System.out.println("Enter Your first integer between 1 and 9999: ");
    int firstNum = input.nextInt();
        
    System.out.println("Enter Your Second integer between 1 and 9999: ");
    int secondNum = input.nextInt();
        
    boolean flag = false;
    while(!flag && firstNum<1 || firstNum>9999 ||secondNum<1 || secondNum>9999) 
    {
      if(firstNum<1 || firstNum>9999)
       {
        System.out.println("\nEntry not within the range. Please try again\n");
        System.out.println("Enter Your first integer between 1 and 9999: ");
        firstNum = input.nextInt();
        if(firstNum==secondNum)
        {
            System.out.println("\nEntry is a duplicate. Please try again\n");
            System.out.println("Enter Your first integer between 1 and 9999: ");
            firstNum = input.nextInt();
        }
        if(firstNum>=1 && firstNum<=9999)
        {
            flag = true;
        }
    }
    // In Above While loop, The if condition checks the range of First input number. 
    
    if(secondNum<1 || secondNum>9999)
       {
        System.out.println("\nEntry not within the range. Please try again\n");
        System.out.println("Enter Your second integer between 1 and 9999: ");
        secondNum = input.nextInt();
        if(firstNum==secondNum)
        {
            System.out.println("\nEntry is a duplicate. Please try again\n");
            System.out.println("Enter Your Second integer between 1 and 9999: ");
            secondNum = input.nextInt();
        }
        if(secondNum>=1 && secondNum<=9999)
        {
            flag = true;
        }
       }
    }

    // The above checks the same for second input integer 
    
    if(firstNum != secondNum ) 
      {
        int index1 =0;
        int index2 =0;
        for (int j  = 0; j < numbers.length; j++) // To find the index of input numbers
        {
          if (numbers[j] == firstNum) 
          {
             index1 = j;
          }
          
          if(numbers[j] == secondNum)
          {
              index2 = j;
          }
        }
        
        FileOutputStream  outputFile = new FileOutputStream ("ArraySandha.txt");
        PrintWriter outFs = new PrintWriter(outputFile);
        // Open a new file to print the output content in a file .
        // To print the content , use outFs PrintWriter Object
        
        if(index1!=0 && index2!=0 && index1<index2)
        {
            System.out.println("Success! The integers have been found in the array and in order.\n");
            outFs.println("Success! The integers have been found in the array and in order.\n");
            
        }
        if(index1!=0 && index2!=0 && index1>index2)
        {
          System.out.println("Partial Success. The integers have been found but are not in order found in the array.\n");
          outFs.println("Partial Success. The integers have been found but are not in order found in the array.\n");
        }
        
        if(index1==0 && index2!=0 || index1!=0 && index2==0)
        {
            System.out.println("Only one of the integers has been found in the array.\n");
            outFs.println("Only one of the integers has been found in the array.\n");
        }
        if(index1==0 && index2==0)
        {
            System.out.println("Neither of the integers has been found in the array.\n");
            outFs.println("Neither of the integers has been found in the array.\n");
        }
        
        if(index1 ==0)
        {
            System.out.println(firstNum+" has not been found.");
            outFs.println(firstNum+" has not been found.");
        }
        else
        {
            System.out.println(firstNum +" is in position "+ index1+".");
            outFs.println(firstNum +" is in position "+ index1+".");
        }
        if(index2 ==0)
        {
            System.out.println(secondNum+" has not been found.");
            outFs.println(secondNum+" has not been found.");
        }
        else
        {
           System.out.println(secondNum+" is in position " +index2+".");
           outFs.println(secondNum+" is in position " +index2+".");
       
        }
        
        
        
        System.out.println("\nFile successfully written to ArraySandha.txt.");
        final long endTime = System.currentTimeMillis();
        System.out.println("\nTotal execution time: " + (endTime - startTime)+" Milli Seconds");
        outFs.println("\nTotal execution time: " + (endTime - startTime)+" Milli Seconds");
         // Printing the runtime along with output in similar file . 
         
         
         fileName.close(); // closing the random.txt File 
         outFs.close();   // closing the ArraySandha.txt File 
    }
}
 catch(FileNotFoundException f )  // for IOExceptions .
 {
    System.out.println("File not found in the directory.");
 }
catch(IOException eof)
 {
    System.out.println("Error!! openning a file.");
 }

}
}






























