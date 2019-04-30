package Laicode.Class03_Stack_Queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Stack With min()
 * Description
 * Enhance the stack implementation to support min() operation. min() should return the current minimum value in the stack. If the stack is empty, min() should return -1.
 * pop() - remove and return the top element, if the stack is empty, return -1
 * push(int element) - push the element to top
 * top() - return the top element without remove it, if the stack is empty, return -1
 * min() - return the current min value in the stack
 *
 * try to make the elements in stack2 a descending order and store an Element in stack2 in the format of <value, size of the stack1 when this element is added to stack2>
 * Stack1|| 3 3 3 2 1 0 3 1 -7 3 1 -7 -7 -6 -8
 * Stack2|| <3,1> <2,4> <1,5> <0,6>,<-7,9>,<-8,15>
 */

class StackWithMin {
    private Deque<Integer> stack;
    private Deque<Element> minStack;
    public StackWithMin() {
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Element>();
    }

    public void push(int element) {
        stack.push(element);
        if (minStack.isEmpty() || element < minStack.peek().value) {
            minStack.push(new Element(element, stack.size()));
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        int stackTop = stack.peek();
        Element minTop = minStack.peek();
        if (stackTop == minTop.value && stack.size() == minTop.stackSize) {
            minStack.pop();
        }
        return stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public int min() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek().value;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

class Element {
    int value;
    int stackSize;
    public Element(int value, int stackSize) {
        this.value = value;
        this.stackSize = stackSize;
    }
}
