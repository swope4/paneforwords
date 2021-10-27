package sftwderv1mod2;

import java.io.*;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class MapFile {

	public static String getPeomWords() {
// class object
		
		Map<String, Word> countMap = new HashMap<String, Word>();// hash map for us to analyze the page
		Document doc = null;
		try { 
			doc = Jsoup.connect("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm").get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// the connection
		for (Element element : doc.select("div.chapter")) {
			String text = element.text();
			//System.out.println(text + " " );
			for (String word : text.replaceAll("[;—:!‘’?,“.”]", "").split(" ")) {
				Word wordObj = countMap.get(word);// declaration of wordObj from class Word
				if (wordObj == null) { // if wordobj equals null then just goto a new word
					wordObj = new Word();// new word
					wordObj.word = word;// setting the object equal to what word is
					wordObj.count = 0;
					countMap.put(word, wordObj);

				}
				wordObj.count++;
			}

		}
		ArrayList<Word> sortedWords = new ArrayList<Word>(countMap.values());

		Collections.sort(sortedWords, Collections.reverseOrder((a, b) -> {
			return a.count - b.count;
		}));
		String Poemwords = "";
		for (Word word : sortedWords) {
			//System.out.println(word.count + " " + word.word);
		 Poemwords += word.count + " " + word.word + "\n";
		}
		return Poemwords;
	}

	

	public static class Word implements Comparable<Word> {
		String word;
		int count;

		@Override
		public boolean equals(Object obj) {
			return word.equals(((Word) obj).word);
		}

		@Override
		public int compareTo(Word thisword) {
			return thisword.count;
		}
	}
}
