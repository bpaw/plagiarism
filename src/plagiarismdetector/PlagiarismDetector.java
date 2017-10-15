package plagiarismdetector;

import java.util.ArrayList;

public class PlagiarismDetector {

	public int detectPlagiarism(String synonyms, String file1, String file2, int window) {
		
		int plagiarized = 0, total = 0;
		
		PhraseStorage storage = new PhraseStorage();
		
		ArrayList<String> syn = FileParser.reader(synonyms);
		ArrayList<String> fil1 = FileParser.reader(file1);
		ArrayList<String> fil2 = FileParser.reader(file2);
		
		for (int i = 0; i < fil1.size() - window + 1; i++) {
			storage.addPhrase(Phrase.generatePhrases(fil1, i, i + window, syn));
		}

		for (int i = 0; i < fil2.size() - window + 1; i++) {
			if (storage.checkPhrase(new Phrase(fil2, i, i + window, syn))) {
				plagiarized++;
			}
			total++;
		}
		
		double ratio = (double) plagiarized / (double) total; 
		int percentage = (int) (ratio * 100);
		return percentage;
	}
}
