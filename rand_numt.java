/* 
Name: Michael Daley
Course: CSC 122 001
Project Lab # 5

Project description: program which generates an array filled with random numbers and saves to file

What the program does: it uses the random method to generate random numbers which then fill an array and saves it to a file

How program was tested: program was tested by utilizing many file names to test the file creation part, afterwards
writting to file was tested by simple try to write to file and test if it was writting correctly by opening the file itself and
looking if it was written to and what was written to file was correct. lastly using print statements and generating multiple arrays and filling them
to also check if the arrays were filled and afterwards sorting and printing them to see if they were also sorted correctly.

Limiations: code doesn't allow for numbers to have a good spread of random numbers if there are repititions. a number can appear much
more than others in the current code than others. ex generate 10 numbers, ceiling number is 20, array = [1,1,1,1,2,3,4,12,18,19];
in this array the number 1 is generate many times when other numbers between 1 and 20 could of taken it's place.
*/



import java.util.*;
import java.io.*;

public class rand_numt{
	public static Scanner console = new Scanner(System.in); //initializes a global scanner
	public static int quantity; //global int to save user input of array size
	public static int ceiling; // global int to save user input of max random number value of array
	public static String fileNameIn; //global String to save user input for file name
	public static File outFile; //global variable to save File
	
	public static void main(String[] args)throws FileNotFoundException{
		start();// program which takes user inputs and prompts them
		
		Random rand_generate = new Random(); //creates new random method called rand_generate
		PrintStream output = new PrintStream(outFile); //creates a printstream to write to outFile we created
		int [] num_array = new int[quantity]; //array which will save random numbers, size determined by user input
		for(int i = 0; i < quantity; i++){// for loop to fill array
			int rand_num = rand_generate.nextInt(ceiling + 1);// generates random numbers between 1 to user input, 1 was used to include ceiling number
			num_array[i] = rand_num;//fills elements i(current i value) with the rand_num we generated
		}
		System.out.println(Arrays.toString(num_array) + "random number array"); //outputs the random array we created as a string
		
		for(int i = 0; i < quantity - 1; i++){//for loop for sorting our random number array using bubble sort
			for(int j = 0; j < quantity-i-1; j++){
				if(num_array[j] > num_array[j+1]){//swaps element j with its proceeding value if proceeding value is less than current.
					int temp = num_array[j];
					num_array[j] = num_array[j+1];
					num_array[j+1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(num_array)+ "sorted random number array"); //outputs sorted array to screen
		output.println(Arrays.toString(num_array));//saves sorted array to created file
	}
	
	public static void start(){// prompts user and takes input based on given prompt(takes and stores all parameters for code)
		System.out.println("This is a random generator that generates a certain amount of random numbers and saves to a file based on user input");
		System.out.println();
		file_creation();// code for creating file
		System.out.print("Enter the quantity of random numbers you'd like generated: ");//prompts user for array size
		quantity = console.nextInt();//takes user input for array size
		System.out.print("Enter the ceiling of random numbers: ");//prompts user to enter max number value for array
		ceiling = console.nextInt();//takes user input for max value for array
	}
	
	public static void file_creation(){//takes user input and checks if files exists and also creates file
		System.out.print("enter the name of the file you'd like the data saved to: ");// prompts user to enter file name
		fileNameIn = console.nextLine();// takes file name
		String fileName = fileNameIn + ".txt";//concatenates .txt to file to make it a full file name for a text file
		outFile = new File(fileName);//makes a new file out of user given file name.
		try{//tries to execute code block for creating file
			if(!(outFile.exists())){// checks if file exists and if not it creates a new file and tells user file is created
				outFile.createNewFile();
				System.out.println("File created.");
			
			}
			else{// if file does exists it tells user and gives choice to create new file or overwrite current file
				System.out.println("File already exists");
				System.out.println("Would you like to create a new file or overwrite the current one?"); 
				System.out.print("enter 'y' to create a new file or 'n' to overwrite current: ");
				String choice = console.nextLine();// saves user choice on whether or not to create a new file or use current
				if(choice.equals("y")){//if user chooses to create file we recursively use program
					file_creation();
				}
			}
		}
		catch(IOException e){//if there was an error with our try block,in other words an exception, this block catches it and executes instead
			System.out.println("There was an error while creating file, please try again");//informs user issue with creating file and prompts to try again
			file_creation();//calls program again to start from beginning
		}
	}
}
/*
Microsoft Windows [Version 10.0.19041.572]
(c) 2020 Microsoft Corporation. All rights reserved.

C:\Users\mdale>d:

D:\>cd CSC_122

D:\CSC_122>dir
 Volume in drive D is New Volume
 Volume Serial Number is F2FB-864A

 Directory of D:\CSC_122

11/04/2020  10:50 AM    <DIR>          .
11/04/2020  10:50 AM    <DIR>          ..
10/26/2020  04:12 PM             1,343 class_practice.class
10/26/2020  04:12 PM               996 class_practice.java
10/28/2020  09:00 AM             1,725 file_creation.class
10/28/2020  08:49 AM               796 file_creation.java
10/19/2020  09:56 AM             2,107 First Test.txt
09/02/2020  07:34 PM               417 Hello.class
09/02/2020  07:34 PM               111 Hello.java
09/11/2020  10:44 AM             1,200 Hourglass.class
11/04/2020  12:58 AM                22 jeff.txt
10/14/2020  10:27 AM             1,368 Key terms for study.txt
09/21/2020  07:19 AM               697 loops1.class
10/25/2020  09:33 AM             3,265 loops1.java
11/04/2020  10:50 AM                 0 michael.txt
11/04/2020  10:50 AM             2,049 RandomIntegersFileCreation.class
11/04/2020  10:50 AM             2,196 RandomIntegersFileCreation.java
09/28/2020  10:13 AM             1,074 randomnumber.class
10/25/2020  09:33 AM             3,813 randomnumber.java
09/28/2020  09:53 AM             1,504 random_number.class
09/29/2020  06:38 PM             1,213 random_number.txt
10/26/2020  08:16 AM             1,525 random_numbers.class
10/26/2020  08:41 AM             1,055 random_numbers.java
10/28/2020  09:24 AM             1,706 rand_num1.java
10/28/2020  09:32 AM                48 rand_nums.txt
11/04/2020  10:40 AM             3,105 rand_numt.class
11/04/2020  11:19 AM             5,553 rand_numt.java
10/30/2020  09:52 AM             2,003 Rnumfilev3.java
10/02/2020  09:39 AM               826 rock paper scissor planning.txt
10/06/2020  03:48 AM             2,033 rock_paper_scissors.class
10/25/2020  04:53 PM             3,790 r_p_s.class
10/25/2020  04:55 PM            12,653 r_p_s.java
11/03/2020  12:07 PM           614,075 Screen Shot 2020-11-03 at 11.02.49 AM.png
10/14/2020  09:15 AM             4,563 Student link Zoom csc 122.txt
11/02/2020  10:14 AM                 0 uuu.txt
              33 File(s)        678,831 bytes
               2 Dir(s)  749,772,357,632 bytes free

D:\CSC_122>javac rand_numt.java

D:\CSC_122>java rand_numt
This is a random generator that generates a certain amount of random numbers and saves to a file based on user input

enter the name of the file you'd like the data saved to: &*SD
There was an error while creating file, please try again
enter the name of the file you'd like the data saved to: michael
File already exists
Would you like to create a new file or overwrite the current one?
enter 'y' to create a new file or 'n' to overwrite current: y
enter the name of the file you'd like the data saved to: jen
File created.
Enter the quantity of random numbers you'd like generated: 15
Enter the ceiling of random numbers: 30
[17, 13, 8, 21, 17, 16, 25, 5, 29, 16, 22, 9, 24, 6, 7]random number array
[5, 6, 7, 8, 9, 13, 16, 16, 17, 17, 21, 22, 24, 25, 29]sorted random number array

D:\CSC_122>dir
 Volume in drive D is New Volume
 Volume Serial Number is F2FB-864A

 Directory of D:\CSC_122

11/04/2020  11:21 AM    <DIR>          .
11/04/2020  11:21 AM    <DIR>          ..
10/26/2020  04:12 PM             1,343 class_practice.class
10/26/2020  04:12 PM               996 class_practice.java
10/28/2020  09:00 AM             1,725 file_creation.class
10/28/2020  08:49 AM               796 file_creation.java
10/19/2020  09:56 AM             2,107 First Test.txt
09/02/2020  07:34 PM               417 Hello.class
09/02/2020  07:34 PM               111 Hello.java
09/11/2020  10:44 AM             1,200 Hourglass.class
11/04/2020  12:58 AM                22 jeff.txt
11/04/2020  11:21 AM                57 jen.txt
10/14/2020  10:27 AM             1,368 Key terms for study.txt
09/21/2020  07:19 AM               697 loops1.class
10/25/2020  09:33 AM             3,265 loops1.java
11/04/2020  10:50 AM                 0 michael.txt
11/04/2020  10:50 AM             2,049 RandomIntegersFileCreation.class
11/04/2020  10:50 AM             2,196 RandomIntegersFileCreation.java
09/28/2020  10:13 AM             1,074 randomnumber.class
10/25/2020  09:33 AM             3,813 randomnumber.java
09/28/2020  09:53 AM             1,504 random_number.class
09/29/2020  06:38 PM             1,213 random_number.txt
10/26/2020  08:16 AM             1,525 random_numbers.class
10/26/2020  08:41 AM             1,055 random_numbers.java
10/28/2020  09:24 AM             1,706 rand_num1.java
10/28/2020  09:32 AM                48 rand_nums.txt
11/04/2020  11:20 AM             3,105 rand_numt.class
11/04/2020  11:19 AM             5,553 rand_numt.java
10/30/2020  09:52 AM             2,003 Rnumfilev3.java
10/02/2020  09:39 AM               826 rock paper scissor planning.txt
10/06/2020  03:48 AM             2,033 rock_paper_scissors.class
10/25/2020  04:53 PM             3,790 r_p_s.class
10/25/2020  04:55 PM            12,653 r_p_s.java
11/03/2020  12:07 PM           614,075 Screen Shot 2020-11-03 at 11.02.49 AM.png
10/14/2020  09:15 AM             4,563 Student link Zoom csc 122.txt
11/02/2020  10:14 AM                 0 uuu.txt
              34 File(s)        678,888 bytes
               2 Dir(s)  749,772,357,632 bytes free

D:\CSC_122>type jen.txt
[5, 6, 7, 8, 9, 13, 16, 16, 17, 17, 21, 22, 24, 25, 29]

D:\CSC_122>
*/

	