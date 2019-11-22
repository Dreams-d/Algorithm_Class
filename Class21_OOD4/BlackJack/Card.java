package Laicode.Class21_OOD4.BlackJack;

public class Card {
	private final int faceValue;//1 for A, 11 for J…. Or we can use enum here
	private final Suit suit; // enum
	public Card(int c, Suit s) {
		faceValue = c;
		suit = s;
	}
	public int value() {
		return faceValue;
	}
	public Suit suit() {
		return suit;
	}
}

