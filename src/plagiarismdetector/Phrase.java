package plagiarismdetector;

import java.util.ArrayList;

public class Phrase {
	private String phrase; 
	private boolean synonyms; 
	
	public Phrase(String phrase, boolean synonyms) {
		this.setPhrase(phrase);
		this.setSynonyms(synonyms);
	}
	
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

	public static ArrayList<Phrase> generatePhrases(ArrayList<String> words, int start, int end, ArrayList<String> syns) {
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
