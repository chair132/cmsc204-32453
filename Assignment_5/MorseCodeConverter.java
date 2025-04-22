import java.io.*;
import java.util.*;

public class MorseCodeConverter {
	//space represents a new letter, / represents a new word
	
	public static String convertToEnglish(String code) {
		MorseCodeTree tree = new MorseCodeTree();
		tree.buildTree();
		
		String finalString = "";
		
		//splits into words
		String[] words = code.split(" / ");
		
		//loops through the words
		for(String word : words) {
			//splits into letters
			String[] letters = word.split(" ");
			
			//loops through the letters
			for(String letter : letters) {
				//adds the letter to the final string
				finalString += tree.fetchLetter(tree.getRoot(), letter);
			}
			
			//adds a space after every word
			finalString += " ";
		}
		
		return finalString;
		
	}
	
	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
		Scanner input = new Scanner(codeFile);
		String finalString = "";
		
		while (input.hasNextLine()) {
			finalString += input.nextLine() + " ";
		}
		input.close();
		
		return convertToEnglish(finalString);
	}
}
