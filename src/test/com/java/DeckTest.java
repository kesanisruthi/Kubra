package test.com.java;

import com.java.Deck;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DeckTest {
	
	 List<String> numbersList = new ArrayList();
	 List<String> suiteList = new ArrayList();
	 List<String> deckList = new ArrayList();
	Deck deck = new Deck();
	
	@Before
	 public void intialize() {
		numbersList.add("Ace");
		numbersList.add("2"); numbersList.add("3"); numbersList.add("4"); numbersList.add("5");
		numbersList.add("6"); numbersList.add("7");
		numbersList.add("8"); numbersList.add("9"); numbersList.add("10"); 
		numbersList.add("J"); numbersList.add("Q"); numbersList.add("K");
		suiteList.add("Heart"); suiteList.add("Clubs"); suiteList.add("Diamond");
		suiteList.add("Spades");
		
		numbersList.forEach(number -> {
			suiteList.forEach(suite -> {
				deckList.add(number+suite);
			});
		});
	}

	@Test
	public void testShuffle() {
		
		DeckTest deckTest = new DeckTest();
		List<String> shuffleList = new ArrayList();
		List<String> decks = new ArrayList<>();
		decks.addAll(deckList);
		shuffleList =  deck.shuffle(deckList);
		//assertFalse(decks.get(0).equalsIgnoreCase(shuffleList.get(0)));
		assertFalse(decks == shuffleList);
	}

	@Test
	public void testCut() {
		List<String> decks = new ArrayList<>();
		decks.addAll(deckList);
		List cutList = deck.cut(deckList, 9);
		assertFalse(decks==cutList);
	}

	@Test
	public void testTurnOver() {
		String turnOverCard = deck.turnOver(deckList);
		assertTrue(turnOverCard.equalsIgnoreCase("KSpades"));
	}

	@Test
	public void testSearch() {
		int position = deck.search(deckList, "KSpades");
		assertTrue(position == 1);
	}

	@Test
	public void testReOrder() {
		List<String> decks = new ArrayList<>();
		decks.addAll(deckList);
		List<String> ReorderList = Deck.reOrder(deckList);
		assertTrue(ReorderList.get(0).equals("AceHeart"));
	}

}
