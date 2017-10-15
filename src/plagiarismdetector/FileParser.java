package plagiarismdetector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *	FileParser is a helper class used to read a file and convert the 
 *	words in the file to an ArrayList of the words in it
 */
public class FileParser {
	
	/**
	 * 	reader is a function that takes in a filename (must be in the root dir)
	 * 	and returns an ArrayList of every word present in the file
	 */
	public static ArrayList<String> reader(String filename){
		BufferedReader reader = null;
		ArrayList<String> filewords = new ArrayList<>();
	    try {
	        File file = new File(filename);
	        reader = new BufferedReader(new FileReader(file));
	
	        String line;
	        while ((line = reader.readLine()) != null) {
	        		String[] wordsArray = line.split(" ");
	        		for (String word : wordsArray) {
	        			filewords.add(word);
	        		}
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return filewords;
	}
}
