package plagiarismdetector;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 	PhraseStorage is a class mainly created for better design: 
 * 
 * 	It abstracts away the usage of a HashSet<Phrase> in order to make the
 * 	object relationships more intuitive
 */
public class PhraseStorage {
	HashSet<Phrase> storage;
	
	public PhraseStorage() {
		storage = new HashSet<Phrase>();
	}
	
	public void addPhrase(ArrayList<Phrase> phrases) {
		for (Phrase phrase : phrases) {
			storage.add(phrase);
		}
	}
	
	public boolean checkPhrase(Phrase phrase) {
		return storage.contains(phrase);
	}
}
