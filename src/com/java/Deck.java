package com.java;


import java.util.*;

public class Deck {
	static List<String> numbersList = new ArrayList();
	static List<String> suiteList = new ArrayList();
	static List<String> deckList = new ArrayList();
	public static void main(String[] args) {
		Deck.initialize();
		System.out.println("Before Playing Cards"+ deckList);
		Deck deck = new Deck();
			List shuffledlist = deck.shuffle(deckList);
			//List l1 = deck.shuffle(shuffledlist);
			System.out.println("New shuffled list "+shuffledlist);
			List listCut = Deck.cut(deckList, 7);
			System.out.println("Cut List"+listCut);
			List dealList = Deck.deal(deckList);
			System.out.println("Deal List"+dealList);
			String firstCard = Deck.turnOver(deckList);
			System.out.println("Turn over card "+firstCard);
			int position = Deck.search(deckList, "2Heart");
			System.out.println("Seraching dec "+position);
			List reoderedList = Deck.reOrder(dealList);
			System.out.println("Reordered List is "+reoderedList);

			Set s1= new HashSet();
			Employee e1 = new Employee(10,"02/03/1987","xyz");
		Employee e2 = new Employee(10,"02/03/1987","xyz");
			s1.add(e1);
			s1.add(e2);
			s1.add(1);
			s1.add(1);
		System.out.println("s1.size() = " + s1.size());
	}
	
	public static void initialize() {
		
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
	}

	private static List deal(List list) {
		list.remove(list.size()-1);
		return list;
	}

	public List shuffle(List<String> list){
		Random random = new Random();
		String next = "";
		int step = 0;
		for(int i=0;i<list.size();i++) {
			int randomIndex = random.nextInt(list.size());
			String found = list.get(randomIndex);
			for(step = 4; step>=0; i--) {
				if(randomIndex >= step) {
					if(randomIndex- step >= list.size()) {
						continue;
					}
					else {
						next = list.get(randomIndex-step);
						list.remove(randomIndex);
						list.add(randomIndex, next);
						list.remove(randomIndex-step);
						list.add(randomIndex-step , found);
						break;
					}
				} else {
					if(step - randomIndex <= 0) {
						continue;
					}
					else {
						next = list.get(step - randomIndex);
						list.remove(randomIndex);
						list.add(randomIndex, next);
						list.remove(step - randomIndex);
						list.add(step - randomIndex , found);
						break;
					}
				}
				
			}
			//if(randomIndex+1 == list.size()) {
				// next = list.get(randomIndex -2 );
			//} else {
				// next = list.get(randomIndex+1);
			//}
			//String temp = found;
			//found = next;
			//next = temp;
			//list.remove(randomIndex);
			//list.add(randomIndex, found);
			
			//if(!(randomIndex+1 == list.size())) {
				//list.remove(randomIndex+1);
				//list.add(randomIndex+1, next);
			//}
			//else {
				//list.remove(randomIndex-2);
				//list.add(randomIndex-2, next);
			//}
		}
		return list;
	}
	//Assuming 0th element is top half 
	public static List cut(List list, int cardNumber){
		List topList = list.subList(cardNumber, list.size());
		List bottomList = list.subList(0, cardNumber);
		List finalList = new ArrayList();
		finalList.addAll(topList);
		finalList.addAll(bottomList);
		return finalList;
		
	}
	//Assuming last element of the list is top element
	public static String turnOver(List list){
		return (String) list.get(list.size()-1);
	}
	//Assuming 0th element is the bottom of the card
	public static int search(List list, String card) {
		return (list.size()-(list.indexOf(card)));
	}
	
	//Assuming 0th element of list is the top of the card
	public static List reOrder(List<String> list) {
		List heartSuite = new ArrayList<>();
		List clubSuite = new ArrayList<>();
		List diamondSuite = new ArrayList<>();
		List spadeSuite = new ArrayList<>();
		list.forEach(card -> {
			if(card.contains("Heart")) {
				if(card.startsWith("A")) {
					heartSuite.add(0,"Ace");
				} else if (card.startsWith("J")){
					heartSuite.add(heartSuite.size()-3, "J");
				}
				else if (card.startsWith("Q")){
					heartSuite.add(heartSuite.size()-2, "Q");
				}
				else if (card.startsWith("K")){
					heartSuite.add(heartSuite.size()-1, "K");
				}
				else if (card.startsWith("10")){
					heartSuite.add(card.substring(0, 2));
				}
				else {
					heartSuite.add(card.substring(0, 1));
				}
			}
			else if(card.contains("Diamond")) {
				if(card.startsWith("A")) {
					diamondSuite.add(0, "Ace");
				} else if (card.startsWith("J")){
					diamondSuite.add(diamondSuite.size()-3, "J");
				}
				else if (card.startsWith("Q")){
					diamondSuite.add(diamondSuite.size()-2, "Q");
				}
				else if (card.startsWith("K")){
					diamondSuite.add(diamondSuite.size()-1, "K");
				} 
				else if (card.startsWith("10")){
					diamondSuite.add(card.substring(0, 2));
				}
				else {
					diamondSuite.add(card.substring(0, 1));
				}
			}
			else if(card.contains("Spades")) {
				if(card.startsWith("A")) {
					spadeSuite.add(0, "Ace");
				} else if (card.startsWith("J")){
					spadeSuite.add(spadeSuite.size()-3, "J");
				}
				else if (card.startsWith("Q")){
					spadeSuite.add(spadeSuite.size()-2, "Q");
				}
				else if (card.startsWith("K")){
					spadeSuite.add(spadeSuite.size()-1,"K");
				} 
				else if (card.startsWith("10")){
					spadeSuite.add(card.substring(0, 2));
				}
				else {
					spadeSuite.add(card.substring(0, 1));
				}
				
			}
			else if(card.contains("Clubs")) {
				if(card.startsWith("A")) {
					clubSuite.add(0, "Ace");
				} 
				else if (card.startsWith("J")){
					clubSuite.add(clubSuite.size()-3,"J");
				}
				else if (card.startsWith("Q")){
					clubSuite.add(clubSuite.size()-2,"Q");
				}
				else if (card.startsWith("K")){
					clubSuite.add(clubSuite.size()-1,"K");
				} 
				else if (card.startsWith("10")){
					clubSuite.add(card.substring(0, 2));
				}
				else {
					clubSuite.add(card.substring(0, 1));
				}
			}
		});
		Collections.sort(heartSuite);
		Collections.sort(clubSuite);
		Collections.sort(spadeSuite);
		Collections.sort(diamondSuite);	
		sorting(heartSuite);
		sorting(clubSuite);
		sorting(spadeSuite);
		Collections.reverse(spadeSuite);
		sorting(diamondSuite);
		Collections.reverse(diamondSuite);
		List newOrderedList = new ArrayList();
		heartSuite.forEach(hearts -> {
			hearts = hearts +"Heart";
			newOrderedList.add(hearts);
		});
		clubSuite.forEach(clubs -> {
			clubs = clubs +"Clubs";
			newOrderedList.add(clubs);
		});
		diamondSuite.forEach(diamonds -> {
			diamonds = diamonds +"Diamonds";
			newOrderedList.add(diamonds);
		});
		spadeSuite.forEach(spades -> {
			spades = spades +"Spades";
			newOrderedList.add(spades);
		});
		return newOrderedList;
		
	}
	
	public static void sorting(List<String> l) {
		for (int index = 0; index<l.size(); index++){
			if(l.get(index).equalsIgnoreCase("Ace")) {
				l.remove(index);
				l.add(0, "Ace");
			} 
			else if(l.get(index).equalsIgnoreCase("10")) {
				String lastElement = l.get(l.size()-1);
				if(l.contains("9")) {
					int index9 = l.indexOf("9");
					l.remove(index);
					l.add(index9+1,"10");
				} else if(l.contains("J")) {
					int indexJ = l.indexOf("J");
					l.remove(index);
					l.add(indexJ-1,"10");
				}
				else if(l.contains("Q")) {
					int indexQ = l.indexOf("Q");
					l.remove(index);
					l.add(indexQ-1,"10");
				}
				else if(l.contains("K")) {
					int indexK = l.indexOf("K");
					l.remove(index);
					l.add(indexK-1,"10");
				}
			}
			else if(l.get(index).equalsIgnoreCase("K")) {
				if(index != l.size()-1) {
					int kPosition = index;
					int qPosition = index+1;
					l.remove(kPosition);
					l.add(kPosition, "Q");
					l.remove(qPosition);
					l.add(qPosition, "K");
				}
			}
			
		}
	}


}
