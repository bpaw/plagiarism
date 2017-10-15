package plagiarismdetector;

import java.util.HashSet;
import java.util.Scanner;

/**
 *	Driver class contains the main method where the user can interact with the program
 *	
 *	User is prompted with 4 things to input:  
 * 		1. synonym file
 * 		2. first input file
 * 		3. second input file
 * 		4. (optional) tuple size, default is 3 and can be set by just pressing enter
 */
public class Driver {
	
	public static int DEFAULT_TUPLE_SIZE = 3;
	
	public static void main(String[] args) {
		
		String synonym_file, file1, file2, tuple_input;
		int tuple_size = DEFAULT_TUPLE_SIZE;
		Scanner scanner = new Scanner(System.in);
		
		// Prompts
		
		System.out.println("Please specify the file containing synonyms.");
		synonym_file = scanner.nextLine();
		
		System.out.println("Please specify the first input file.");
		file1 = scanner.nextLine();
		
		System.out.println("Please specify the second input file.");
		file2 = scanner.nextLine();
		
		System.out.println("Specify how large a tuple should be: (just press enter for default : 3)");
		tuple_input = scanner.nextLine();
		if (tuple_input.length() > 0) {
			tuple_size = Integer.parseInt(tuple_input.trim());
		}
		
		// Use PlagiarismDetector detectPlagiarism method to get result
		PlagiarismDetector detector = new PlagiarismDetector();
		int percentage = detector.detectPlagiarism(synonym_file, file1, file2, tuple_size);
		String result = String.format("There is a %d%% similarity between the two files.", percentage);
		
		// Print resulting message to the user 
		System.out.println(result);
	}
}
