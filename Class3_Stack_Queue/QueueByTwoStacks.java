package Laicode.Class3_Stack_Queue;

import java.util.LinkedList;

/**
 * Queue By Two Stacks
 * Description
 * Java: Implement a queue by using two stacks. The queue should provide size(), isEmpty(), offer(), poll() and peek() operations. When the queue is empty, poll() and peek() should return null.
 *
 * Assumptions
 * The elements in the queue are all Integers.
 * size() should return the number of elements buffered in the queue.
 * isEmpty() should return true if there is no element buffered in the queue, false otherwise.
 *
 * time of offer() = O(1)
 * amortized time of poll() = O(1)
 */

public class QueueByTwoStacks {
	private LinkedList<Integer> in;//基础加强班是用Deque来写的
	private LinkedList<Integer> out;
	
	public QueueByTwoStacks() {
		in = new LinkedList<Integer>();
		out = new LinkedList<Integer>();
	}

	public Integer poll() {
		//if out stack is empty, need to move the elements from the 
		//in stack to the out stack.
		shuffle();
		if (out.isEmpty()) {
			return null;
		} else {
			return out.pollFirst();
		}
	}	

	public void offer(int value) {
		in.offerFirst(value);//always push into the stack
	}

	public Integer peek() {
		shuffle();
		if (out.isEmpty()) {
			return null;
		} else {
			return out.peekFirst();
		}
	}	

	public int size() {
		return in.size() + out.size();
	}

	public boolean isEmpty() {
		return in.isEmpty() && out.isEmpty();
	} 

	//when out stack is empty, shuffle elements from in stack to out stack
	private void shuffle() {
		if (out.isEmpty()) {
			while (!in.isEmpty()) {
				out.offerFirst(in.pollFirst());
			}
		}
	}
}
