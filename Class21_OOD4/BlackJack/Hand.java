package Laicode.Class21_OOD4.BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {
	protected final List<Card> cards = new ArrayList<>();

	public int score() {
		int score = 0;
		for (Card card : cards) {
			score += card.value(); //所有手牌加起来
			//其他方法: 给abstract methods，其他游戏里具体implemente
		}
		return score;
	}

	public void addCards(Card[] c) {
		Collections.addAll(cards, c);
	}

	public int size() {
		return cards.size();
	}
}

class BlackJackHand extends Hand {
	@Override
	public int score() {
		List<Integer> scores = possibleScores();
		//initial state
		if (scores.size() == 0) {
			return 0;
		}
		int maxUnder = Integer.MIN_VALUE; // max score <= 21
		int minOver = Integer.MAX_VALUE; // min score > 21
		for (int score : scores) {
			if (score > 21 && score < minOver) {
				minOver = score;
			} else if (score <= 21 && score > maxUnder) {
				maxUnder = score;
			}
		}
		//如果没有比21小的，就返回min over
		return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
	}

	private List<Integer> possibleScores() {
		List<Integer> scores = new ArrayList<>();
		for (Card card : cards) {
			updateScores(card, scores);
		}
		return scores;
	}

	private void updateScores(Card card, List<Integer> scores) {
		final int[] toAdd = getScores(card);
		if (scores.isEmpty()) {
			for (int score : toAdd) {
				scores.add(score);
			}
		} else {
			final int length = scores.size();
			for (int i = 0; i < length; i++) {
				int oldScore = scores.get(i);
				scores.set(i, oldScore + toAdd[0]);
				if (toAdd.length > 1) {
					scores.add(oldScore + toAdd[1]);
				}
			}
		}
	}

	private int[] getScores(Card card) {
		if (card.value() > 1) {
			return new int[]{Math.min(card.value(), 10)};
		} else {
			return new int[]{1, 11};
		}
	}

	public boolean busted() {
		return score() > 21;
	}

	public boolean isBlackJack() {
		if (cards.size() != 2) return false;
		//两张牌，一张Ace，一张花脸
		Card first = cards.get(0);
		Card second = cards.get(1);
		return isAce(first) && isFaceCard(second) ||
				isAce(second) && isFaceCard(first);
	}

	private boolean isAce(Card c) {
		return c.value() == 1;
	}

	private boolean isFaceCard(Card c) {
		return c.value() >= 11 && c.value() <= 13;
	}
}

