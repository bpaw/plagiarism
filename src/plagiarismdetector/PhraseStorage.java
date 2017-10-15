package plagiarismdetector;

import java.util.ArrayList;
import java.util.HashSet;

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
