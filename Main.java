import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.util.Collections.swap;

public class Main {

    private static final String [] suits = {"DIAMONDS", "HEARTS", "CLUBS", "SPADES"};
    private static final String [] ranks = {"TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN",
                              "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING", "ACE"};



    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();

        generateDeck(deck);
        System.out.println(deck.size() + " cards in the deck.");

        shuffle(deck);
        System.out.println("\n\nShuffled Deck:\n");
        printDeck(deck);

        sortSuitRank(deck);
        System.out.println("\n\nSorted by Suit and Rank:\n");
        printDeck(deck);

        shuffle(deck);
        sortRank(deck);
        System.out.println("\n\nSorted by Rank:\n");
        printDeck(deck);
    }

    // Generates a new deck, ordered by suit, then rank
    static void generateDeck(List<Card> deck) {
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    static void printDeck(List<Card> deck) {
        for (Card card : deck) {
            System.out.println(card.getRank() + " of " + card.getSuit());
        }
    }

    static void shuffle(List<Card> deck) {
        Random rand = new Random();
        for (int i = deck.size() - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            swap(deck, i, index);
        }
    }

    // The generateDeck already assigns the deck in this order, but I wanted to make it find and sort the cards
    static void sortSuitRank(List<Card> deck) {
        deck.sort((card1, card2) -> {
            int suitComparison = Integer.compare(Arrays.asList(suits).indexOf(card1.getSuit()), Arrays.asList(suits).indexOf(card2.getSuit()));
            if (suitComparison != 0) {
                return suitComparison;
            }
            return Integer.compare(Arrays.asList(ranks).indexOf(card1.getRank()), Arrays.asList(ranks).indexOf(card2.getRank()));
        });
    }

    // Sorts by rank, does not compare the suit
    static void sortRank(List<Card> deck) {
        deck.sort((card1, card2) -> {
            return Integer.compare(Arrays.asList(ranks).indexOf(card1.getRank()), Arrays.asList(ranks).indexOf(card2.getRank()));
        });
    }
}

class Card {
    String suit;
    String rank;

    Card (String s, String r) {
        suit = s;
        rank = r;
    }

    String getSuit() {
        return suit;
    }

    String getRank() {
        return rank;
    }
}
