package org.kniit.lab9.task16;

import java.util.ArrayList;
import java.util.List;

enum Suit {
    SPADES("ПИКИ"),
    HEARTS("ЧЕРВИ"),
    DIAMONDS("БУБНЫ"),
    CLUBS("ТРЕФЫ");

    private final String russianName; 

    Suit(String russianName) {
        this.russianName = russianName;
    }

    public String getRussianName() {
        return russianName;
    }
}


enum Rank {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("ВАЛЕТ"),
    QUEEN("ДАМА"),
    KING("КОРОЛЬ"),
    ACE("ТУЗ");

private final String russianName; 

    Rank(String russianName) {
        this.russianName = russianName;
    }

    public String getRussianName() {
        return russianName;
    }
}

class Card {
    private final Rank rank;
    private final Suit suit;
    
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
    public Rank getRank() {
        return rank;
    }
    
    public Suit getSuit() {
        return suit;
    }
    
    @Override
    public String toString() {
        return rank.getRussianName() + " " + suit.getRussianName();
    }
}


public class Deck {
    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(rank, suit)); 
            }
        }

        System.out.println("\nКолода из 52 карт:");
        for (int i = 0; i < deck.size(); i++) {
            System.out.println(i + 1 + ". " + deck.get(i));
        }
    }
}
