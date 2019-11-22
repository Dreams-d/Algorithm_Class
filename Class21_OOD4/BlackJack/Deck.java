package Laicode.Class21_OOD4.BlackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
	private static final Random random = new Random();
	private final List<Card> cards = new ArrayList<>();//or Card[]
	private int dealtIndex = 0; //挡板

	public Deck() {
		for (int i = 1; i <= 13; i++) {
			for (Suit suit: Suit.values()) {
				cards.add(new Card(i,suit));}
		}
	}

	public void shuffle() {
//任选两张牌交换位置
		for (int i = 0; i < cards.size() - 1; i++) {
			int j = random.nextInt(cards.size() - i) + i; //[i, card.size())
			Card card1 = cards.get(i);
			Card card2 = cards.get(j);
			cards.set(i, card2);
			cards.set(j, card1);
		}
	}

	public int remainingCards() {
		return cards.size() - dealtIndex;
	}
	//发几张牌
	public Card[] dealHand(int number) {
		if (remainingCards() < number) {
			return null;
		}
		Card[] res = new Card[number];
		for (int i = 0; i < number; i++) {
			res[i] = dealCard();
		}
		return res;
	}

	public Card dealCard() {
		return remainingCards() == 0 ? null : cards.get(dealtIndex++);
	}
}


