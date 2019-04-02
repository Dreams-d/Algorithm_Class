package Laicode.Class3_Stack_Queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Deque By Three Stack
 * How to use multiple Stacks to implement a deque
 * Deque:左右都可以进出
 * Observer	Left  xxxxxxxx12345678xxxxxxxx Right
 * 4APIS		Left.add()						  Right.add()
 * Left.remove()					  Right.remove()
 *
 * Stack1: left hand side
 * Stack2: right hand side
 * Stack3: buffer(half elements)
 *
 * time of push = O(1)
 * amortized time of pop() = O(1)
 */

public class DequeByThreeStack {
	Deque<Integer> stack1;
	Deque<Integer> stack2;
	Deque<Integer> tmpStack;
	
	public DequeByThreeStack() {
		stack1 = new LinkedList<Integer>();
		stack2 = new LinkedList<Integer>();
		tmpStack = new LinkedList<Integer>();
	}

	public void leftAdd(int value) {
		stack1.push(value);
	}

	public void rightAdd(int value) {
		stack2.push(value);
	}

	public int leftRemove() {
		shuffle(stack2, stack1);
		if (!stack1.isEmpty()) {
			return stack1.pop();
		} 
		return -1;
	}

	public int rightRemove() {
		shuffle(stack1, stack2);
		if (!stack2.isEmpty()) {
			return stack2.pop();
		}
		return -1;
	}

	public int size() {
		return stack1.size() + stack2.size();
	}

	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}

	private void shuffle(Deque<Integer> stack1, Deque<Integer> stack2) {
		if (!stack1.isEmpty() && stack2.isEmpty()) {
			int size = stack1.size();
			for (int i = 0; i < size / 2; i++) {
				tmpStack.push(stack1.pop());
			}
			
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			
			while (!tmpStack.isEmpty()) {
				stack1.push(tmpStack.pop());
			}
		}
	}
}
