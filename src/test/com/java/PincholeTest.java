package test.com.java;

import com.java.Deck;
import com.java.Pinochle;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PincholeTest {
	
	 List<String> numbersList = new ArrayList();
	 List<String> suiteList = new ArrayList();
	 List<String> deckList = new ArrayList();
	Pinochle pinochle = new Pinochle();
	
	@Before
	 public void intialize() {
		numbersList.add("Ace");
		numbersList.add("2"); numbersList.add("3"); numbersList.add("4"); numbersList.add("5");
		numbersList.add("6"); numbersList.add("7");
		numbersList.add("8"); numbersList.add("9"); numbersList.add("10");
		numbersList.add("J"); numbersList.add("Q"); numbersList.add("K");
		suiteList.add("Heart"); suiteList.add("Clubs"); suiteList.add("Diamond");suiteList.add("Spades");

		numbersList.forEach(number -> {
			suiteList.forEach(suite -> {
				deckList.add(number+suite);
			});
		});
		deckList.addAll(deckList);
	}

	@Test
	public void testFormPinochle() {
		
		PincholeTest deckTest = new PincholeTest();
		List<String> pincholeList = new ArrayList();
		List<String> decks = new ArrayList<>();
		decks.addAll(deckList);
		pincholeList =  pinochle.formPinochle(deckList);
		//assertFalse(decks.get(0).equalsIgnoreCase(shuffleList.get(0)));
		assertFalse(decks == pincholeList);
		assertFalse(pincholeList.contains("3Spades"));
	}

	@Test
	public void testPincholeSort() {
		List<String> decks = new ArrayList<>();
		decks.addAll(deckList);
		List pincholeList = pinochle.pincholeSort(deckList);
		assertFalse(decks==pincholeList);
		assertFalse(pincholeList.contains("3Spades"));
	}

}
