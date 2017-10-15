package plagiarismdetector;

import java.util.ArrayList;

/**
 * 	Phrase is a class meant to show better object oriented design by creating
 * 	a logical representation of tuples that can have synonyms present
 */
public class Phrase {
	private String phrase; 
	private boolean synonyms; 
	
	// Standard constructor
	public Phrase(String phrase, boolean synonyms) {
		this.setPhrase(phrase);
		this.setSynonyms(synonyms);
	}
	
	// Constructor that takes a subset of an ArrayList and a list of synonyms
	public Phrase(ArrayList<String> words, int start, int end, ArrayList<String> syns) {
		String phrase = "";
		boolean synonym = false;
		for (int i = start; i < end; i++) {
			phrase += " " + words.get(i);
			if (syns.contains(words.get(i))) {
				synonym = true;
			}
		}
		this.phrase = phrase;
		this.synonyms = synonym;
	}

	// Function that returns a list of  type Phrase given a subset of a list of
	// words and a list of synonyms
	public static ArrayList<Phrase> generatePhrases(ArrayList<String> words,
			int start, int end, ArrayList<String> syns) {
		ArrayList<Phrase> phrases = new ArrayList<>();
		String phrase = "";
		String first_syn = "";
		boolean synonym = false;
		for (int i = start; i < end; i++) {
			phrase += " " + words.get(i);
			if (syns.contains(words.get(i))) {
				synonym = true;
				first_syn = words.get(i);
			}
		}
		phrases.add(new Phrase(phrase, synonym));
		if (synonym) {
			for (String syn : syns) {
				if (!syn.equals(first_syn)) {
					String synPhrase = phrase.replace(first_syn, syn);
					phrases.add(new Phrase(synPhrase, true));
				}
			}
		}
		return phrases;
	}
	
	// Getters and Setters for proper encapsulation
	
	public String getPhrase() {
		return phrase;
	}

	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}

	public boolean isSynonyms() {
		return synonyms;
	}

	public void setSynonyms(boolean synonyms) {
		this.synonyms = synonyms;
	}	
	
	// Below is for when Phrase objects are used in a HashSet<>
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Phrase) {
			Phrase other = (Phrase) o;
			return phrase.equals(other.phrase);
		}
		return false;
	}
	
	@Override
    public int hashCode() {
        return phrase.hashCode();
    }
}
