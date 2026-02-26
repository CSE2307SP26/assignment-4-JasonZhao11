package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SpellCheckerTest {

	@Test
	void wordCount() {
		//construct object to be tested
		SpellChecker checker = new SpellChecker();

		//Call the method being tested
		int words = checker.getNumberOfWords();

		//use assertions to verify results
		assertEquals(0, words);
	}

	@Test
	void incrementByOne(){
		SpellChecker checker = new SpellChecker();

		int words1 = checker.getNumberOfWords();
		checker.addWord("hi");
		int words2 = checker.getNumberOfWords();
		int diff = words2 - words1;
		assertEquals(1, diff);
	}

	@Test
	void addSameWord(){
		SpellChecker checker = new SpellChecker();
		checker.addWord("hello");
		int words1 = checker.getNumberOfWords();
		checker.addWord("hello");
		int words2 = checker.getNumberOfWords();
		int diff = words2 - words1;
		assertEquals(0, diff);
	}

	@Test
	void checkCorrect(){
		SpellChecker checker = new SpellChecker();
		String[] dictionary = ["hello", "world"];
		checker.setDictionary(dictionary);
		boolean results = checker.checkSpelling("hello");
		assertTrue(results);
	}

	@Test
	void checkIncorrect(){
		SpellChecker checker = new SpellChecker();
		String[] dictionary = ["hello", "world"];
		checker.setDictionary(dictionary);
		boolean results = checker.checkSpelling("asdwdedsasd");
		assertFalse(results);
	}

	@Test
	void checkCaseInsensitive(){
		SpellChecker checker = new SpellChecker();
		String[] dictionary = ["hello", "world"];
		checker.setDictionary(dictionary);
		boolean results = checker.checkSpelling("hELlo");
		assertTrue(results);
	}

	@Test
	void checkRecommend(){
		SpellChecker checker = new SpellChecker();
		String[] dictionary = ["hello", "world", "bank"];
		checker.setDictionary(dictionary);
		String rec = checker.recommend("bamk");
		assertEquals("bank", rec);
	}

	@Test
	void checkRecommendCorrect(){
		SpellChecker checker = new SpellChecker();
		String[] dictionary = ["hello", "world", "bank"];
		checker.setDictionary(dictionary);
		String rec = checker.recommend("bank");
		assertEquals("bank", rec);
	}

	@Test
	//if a email form exist, spell checker ignores the email address spelling and returns true 
	void checkEmail(){
		SpellChecker checker = new SpellChecker();
		String[] dictionary = ["hello", "world", "bank"];
		checker.setDictionary(dictionary);
		Boolean result = checker.checkSpelling("a@gmail.com");
		assertTrue(result);
	}

	@Test
	//can check a list of words in a sentence and if all are spelled correct return true
	void checkLisfOfWorkds(){
		SpellChecker checker = new SpellChecker();
		String[] dictionary = ["hello", "world", "bank"];
		checker.setDictionary(dictionary);
		Boolean result = checker.checkSpellingForSentence("hello world");
		assertTrue(result);
	}

}
