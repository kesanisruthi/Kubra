package com.java;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pinochle {

    static List<String> numbersList = new ArrayList();
    static List<String> suiteList = new ArrayList();
    static List<String> deckList = new ArrayList();

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
        deckList.addAll(deckList);
    }

    public static List formPinochle(List<String> l) {
        List<String> countList = new ArrayList<>();
        List<String> finalList = new ArrayList<>();
        List<String> pincholeCountList = new ArrayList<>();
        countList.add("Ace");countList.add("9");countList.add("10");countList.add("J");
        countList.add("Q");countList.add("K");
        countList.forEach(number -> {
            suiteList.forEach(suite -> {
                pincholeCountList.add(number+suite);
            });
        });

        /*for(int i=0; i<l.size();i++) {
            String card = l.get(i);
            if((pincholeCountList.contains(card))) {
                finalList.add(card);
            }
        }*/

        l.forEach(card -> {
            if((pincholeCountList.contains(card))) {
                finalList.add(card);
            }
        });
        return finalList;
    }
    
    public static List pincholeSort(List<String> list) {
        List<String> pincholeList = new ArrayList();
        List<String> finalList = new ArrayList<>();

        pincholeList.add("9");pincholeList.add("9");
        pincholeList.add("J");pincholeList.add("J");
        pincholeList.add("Q");pincholeList.add("Q");
        pincholeList.add("K");pincholeList.add("K");
        pincholeList.add("10");pincholeList.add("10");
        pincholeList.add("Ace");pincholeList.add("Ace");


        pincholeList.forEach(number -> {
            suiteList.forEach(suite -> {
                finalList.add(number+suite);
            });
        });
       return finalList;
    }


    public static void main(String args[]) {
        initialize();
        System.out.println("deckList = " + deckList);
        System.out.println("deckList = " + deckList.size());
        List l1 = Pinochle.formPinochle(deckList);
        System.out.println("l = " +l1);
        List pincholeOrder = Pinochle.pincholeSort(l1);
        System.out.println("pincholeOrder = " + pincholeOrder);
    }
}
