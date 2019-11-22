package Laicode.Class21_OOD4.BlackJack;

import java.util.ArrayList;
import java.util.List;

public class BlackJackGameAutomator {
	private Deck deck;
	private BlackJackHand[] hands;
	private static final int HIT_UNTIL = 16;

	public BlackJackGameAutomator(int numPlayers) {
		hands = new BlackJackHand[numPlayers];
		for (int i = 0; i < numPlayers; i++) {
			hands[i] = new BlackJackHand();
		}
	}

	void initializeDeck() {
		deck = new Deck();
		deck.shuffle();
	}

	boolean dealInitial() {
		for (BlackJackHand hand: hands) {
			Card[] cards = deck.dealHand(2);
			if (cards == null) return false;
			hand.addCards(cards);
		}
		return true;
	}

	List<Integer> getBlackJacks() {
		List<Integer> winners = new ArrayList<>();
		for (int i = 0; i < hands.length; i++) {
			if (hands[i].isBlackJack()) {
				winners.add(i);
			}
		}
		return winners;
	}

	boolean playHand(BlackJackHand hand) {
		while (hand.score() < HIT_UNTIL) {
			Card card = deck.dealCard();
			if (card == null) return false;
			hand.addCards(new Card[]{card});
		}
		return true;
	}

	boolean playAllHands() {
		for (BlackJackHand hand: hands) {
			if (!playHand(hand)) return false;
		}
		return true;
	}

	List<Integer> getWinners() {
		List<Integer> winners = new ArrayList<>();
		int winnerScore = 0;
		for (int i = 0; i < hands.length; i++) {
			if (!hands[i].busted()) {
				int curScore = hands[i].score();
				if ( curScore > winnerScore) {
					winners.clear();
					winners.add(i);
					winnerScore = curScore;
				} else if (curScore == winnerScore) {
					winners.add(i);
				}
			}
		}
		return winners;
	}

	void printHandsAndScores() {
		for (int i = 0; i < hands.length; i++) {
			System.out.println("Hand " + i + " (" + hands[i].score() + "): ");
			System.out.println();
		}
	}

	public void simulate() {
		initializeDeck();
		boolean success = dealInitial();
		if (!success) {
			System.out.println("Error. Out of cards. ");
		}

		System.out.println("---------initial----------");
		printHandsAndScores();
		List<Integer> blackjacks = getBlackJacks();
		if (blackjacks.size() > 0) {
			System.out.print("BlackJack at ");
			for (int i: blackjacks) {
				System.out.print(i + " ");
			}
			System.out.println("done.");
		} else {
			success = playAllHands();
			if (!success) {
				System.out.println("Error. Out of cards. ");
			}
			System.out.println("\n---------Complete Game----------");
			printHandsAndScores();
			List<Integer> winners = getWinners();
			if (winners.size() > 0) {
				System.out.print("Winners ");
				for (int i : winners) {
					System.out.print(i + " ");
				}
				System.out.println();
			} else {
				System.out.println("Draw. All players have busted.");
			}
		}
	}

	public static void main(String[] args) {
		BlackJackGameAutomator automator = new BlackJackGameAutomator(5);
		automator.simulate();
	}
}

