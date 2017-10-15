package plagiarismdetector;

import java.util.ArrayList;

/**
 * 	PlagiarismDetector is a class used to figure out the similarity between
 * 	two input files.
 * 
 * 	Use by the main method in Driver.java after supplying files and tuple size
 */
public class PlagiarismDetector {

	/**
	 *	detectPlagiarism is the primary method for figuring out the 
	 *	percentage similar between two files. 
	 *
	 *	It makes use of the FileParser, PhraseStorage, and Phrase classes to
	 *	convert, store, and analyze the input files 
	 */
	public int detectPlagiarism(String synonyms, String file1, String file2, int window) {
		
		int plagiarized = 0, total = 0;
		
		PhraseStorage storage = new PhraseStorage();
		
		// Use FileParser.reader to convert each file into an ArrayList of 
		// words in the files 
		ArrayList<String> syn = FileParser.reader(synonyms);
		ArrayList<String> fil1 = FileParser.reader(file1);
		ArrayList<String> fil2 = FileParser.reader(file2);
		
		// add every phrase in file1 to storage
		for (int i = 0; i < fil1.size() - window + 1; i++) {
			storage.addPhrase(Phrase.generatePhrases(fil1, i, i + window, syn));
		}

		// check every phrase in file2 against storage
		for (int i = 0; i < fil2.size() - window + 1; i++) {
			if (storage.checkPhrase(new Phrase(fil2, i, i + window, syn))) {
				plagiarized++;
			}
			total++;
		}
		
		// compute the percentage similar 
		double ratio = (double) plagiarized / (double) total; 
		int percentage = (int) (ratio * 100);
		return percentage;
	}
}
