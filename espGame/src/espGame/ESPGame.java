package espGame;
import java.util.Random;
import java.util.Scanner;
import java.io.*;


/*
 * Class: CMSC 203
 * Instructor: Prof. Grigoriy Grinberg 
 * Description: Color randomizer game
 * Due: 09/16
 * Platform/compiler: Java/Eclipse
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Alayna Goss
 */


public class ESPGame {

	public static void main(String[] args) throws FileNotFoundException {
		
		//Initialize Scanner and Random functions
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
	
		//Open colors document and prepare variables for later
		File file = new File(".\\colors.txt");
		
		
		
		
		Scanner inputFile;
		inputFile = new Scanner(file);
		String line = "";
		String numberLine;
		String computerColor = "";
		String userColor;
		int rounds = 1;
		int correctGuesses = 0;
		int pickedColor;
		
		//Print welcome statement
		System.out.println("CMSC203 Assignment1: Test your ESP skills!");
		System.out.print("Enter the filename: ");
		System.out.println("\nThere are 16 colors from a file:");
		
		//Main loop of the program.
		while (rounds < 4) {
			
			//Picks a random number and adjusts it to be between 1-16
			pickedColor = rand.nextInt(16);
			pickedColor ++;
		
			//Sets lines to zero to prepare file reading loop
			int lines = 0;
			
			//Loop to read the colors from the file and parse the numbers on the left from the words on the right
			while (lines < 16)
			{
				//Get only the number on the left, and remove everything else
				line = inputFile.nextLine();
				numberLine = line.substring(0, 2);
				numberLine = numberLine.replaceAll("\\s", "");
				
				//Determine if the number chosen by the computer is equal to the number of the color chosen by the user
				if (numberLine.equals(Integer.toString(pickedColor)))
				{
				
					//Sanitize input, remove all unneeded characters
					line = line.substring(2, line.length());
					computerColor = line.replaceAll("\\s", "");
				
				}
				
				//Increment the line so we can exit the file reading loop after file has been completed
				lines ++;
			}
			
			//Display round number, increment
			System.out.println("Round " + rounds + "\n");
			rounds++;
			
			//Ask user for color guess
			System.out.println("I am thinking of a color. \nIs it on the list of the colors above?\nEnter your guess:");
			userColor = input.nextLine();
			userColor = userColor.toLowerCase();
			System.out.println("I was thinking of " + computerColor + "\n");
			
			//Increments correctGuesses if the user chose the correct color
			if (userColor.equals(computerColor))
			{
				correctGuesses ++;
				System.out.println("One has been added to correctGuesses");
			}
			
			//Close and reopen the scanner to start at the beginning of the file
			inputFile.close();
			inputFile = new Scanner(file);
		}
		
		//Ask user for their information
		System.out.println("You guesses " + correctGuesses + "/3 colors correctly.");
		System.out.println("Enter your name: ");
		String name = input.nextLine();
		System.out.println("Describe yourself: ");
		String description = input.nextLine();
		System.out.println("Due Date:");
		String dueDate = input.nextLine();
		
		//Display this information back to them
		System.out.println("User Name: " + name);
		System.out.println("User Description: "+ description);
		System.out.println("Due Date: " + dueDate);
	}

}