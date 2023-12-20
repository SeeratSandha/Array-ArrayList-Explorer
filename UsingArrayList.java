
/**
 * Assignment name : Array & ArrayList Explorer
 * Author : Seerat Sandha 
 * Date : 04/09/2023
 */
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
public class UsingArrayList
{
     public static void main(String[] args) throws IOException
    {
        
         Scanner scnr= null;
         // Using currentTimeMillis method to find the runtime of the programm 
         final long startTime = System.currentTimeMillis();
 try
{    
    
    FileInputStream fileName2 = new FileInputStream("C:\\Users\\sand4927\\Downloads\\random.txt");
    scnr = new Scanner(fileName2);
    // opening similar random.txt file using FileInputStream 
    
    System.out.println("File random.txt has successfully been loaded.\nArrayList loaded with 1000 integers\n");
    ArrayList<Integer> arrList = new ArrayList<Integer>(1000);
    int i ;
    while(scnr.hasNextInt())   // to read whole data of the file to the end 
      {        
          int a = scnr.nextInt();
          arrList.add(a);
    }
      
    
    Scanner input = new Scanner(System.in);
    System.out.println("Enter Your first integer between 1 and 9999: ");
    int numArr1 = input.nextInt();
        
    System.out.println("Enter Your Second integer between 1 and 9999: ");
    int numArr2 = input.nextInt();

    boolean flag = false;
    while(!flag && numArr1<1 || numArr1>9999 ||numArr2<1 || numArr2>9999)
    {
      if(numArr1<1 || numArr1>9999)
       {
        System.out.println("\nEntry not within the range. Please try again\n");
        System.out.println("Enter Your first integer between 1 and 9999: ");
        numArr1 = input.nextInt();
        if(numArr1==numArr2)
        {
            System.out.println("\nEntry is a duplicate. Please try again\n");
            System.out.println("Enter Your first integer between 1 and 9999: ");
            numArr1 = input.nextInt();
        }
        if(numArr1>=1 && numArr1<=9999)
        {
            flag = true;
        }
    }

    
    if(numArr2<1 || numArr2>9999)
       {
        System.out.println("\nEntry not within the range. Please try again\n");
        System.out.println("Enter Your second integer between 1 and 9999: ");
        numArr2 = input.nextInt();
        if(numArr1==numArr2)
        {
            System.out.println("\nEntry is a duplicate. Please try again\n");
            System.out.println("Enter Your Second integer between 1 and 9999: ");
            numArr2 = input.nextInt();
        }
        if(numArr2>=1 && numArr2<=9999)
        {
            flag = true;
        }
       }
    }

    // Using above if statements to check the range of the integers 
    
    FileOutputStream  outputFile = new FileOutputStream ("ALSandha.txt");
    PrintWriter alFs = new PrintWriter(outputFile);
    // opening a file to print the output in the file 
    // for that using alFs PrintWriter object 
    if(arrList.indexOf(numArr1)<arrList.indexOf(numArr2)&&arrList.contains(numArr1) && arrList.contains(numArr2))
    {
        System.out.println("Success! The integers have been found in the arrayList and in order.\n");
        alFs.println("Success! The integers have been found in the arrayList and in order.\n");
    }
    if(arrList.indexOf(numArr1)> arrList.indexOf(numArr2)&&arrList.contains(numArr1) && arrList.contains(numArr2))
    {
          System.out.println("Partial Success. The integers have been found but are not in order found in the arrayList.\n");
          alFs.println("Partial Success. The integers have been found but are not in order found in the arrayList.\n");
    }
    if(!arrList.contains(numArr1)&& arrList.contains(numArr2)|| !arrList.contains(numArr2)&& arrList.contains(numArr1))
    {
            System.out.println("Only one of the integers has been found in the arrayList.\n");
            alFs.println("Only one of the integers has been found in the arrayList.\n");
    }
    if(!arrList.contains(numArr1) && !arrList.contains(numArr2))
    {
            System.out.println("Neither of the integers has been found in the arrayList.\n");
            alFs.println("Neither of the integers has been found in the arrayList.\n");
    }
    if(!arrList.contains(numArr1))
        {
            System.out.println(numArr1+" has not been found.");
            alFs.println(numArr1+" has not been found.");
        }
        else
        {
            System.out.println(numArr1+" is in position "+ arrList.indexOf(numArr1)+".");
            alFs.println(numArr1 +" is in position "+ arrList.indexOf(numArr1)+".");
        }
    if(!arrList.contains(numArr2))
        {
            System.out.println(numArr2+" has not been found.");
            alFs.println(numArr2+" has not been found.");
        }
        else
        {
           System.out.println(numArr2+" is in position " +arrList.indexOf(numArr2)+".");
           alFs.println(numArr2+" is in position " +arrList.indexOf(numArr2)+".");
       
        }
        
        System.out.println("\nFile successfully written to ALSandha.txt.");
        final long endTime = System.currentTimeMillis();
        System.out.println("\nTotal execution time: " + (endTime - startTime)+" Milli Seconds");
        alFs.println("\nTotal execution time: " + (endTime - startTime)+" Milli Seconds");
        

         fileName2.close(); // closing the random.txt file 
         alFs.close();      // closing the ALSandha.txt file 
    }

     catch(FileNotFoundException f )   // for IOException
    {
      System.out.println("File not found in the directory.");
    }
     catch(IOException eof)
    {
      System.out.println("Error!! openning a file.");
    }
}
}
    

