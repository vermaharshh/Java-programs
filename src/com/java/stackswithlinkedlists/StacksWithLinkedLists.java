package com.java.stackswithlinkedlists;

import javax.naming.event.ObjectChangeListener;
import java.util.Scanner;

public class StacksWithLinkedLists {
    public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
        System.out.println("Hello world");
        System.out.println("Stack implementation using Linked lists");

        NewStack stack = new NewStack();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Choose an option from the ones given below:");
            System.out.println("1) Add an item into the Stack");
            System.out.println("2) Remove an item from the Stack");
            System.out.println("3) Show the topmost item");
            System.out.println("4) Print the contents of the stack");
            System.out.println("5) Exit");
            System.out.print("=> ");
            Object choice = scanner.next();

            if (choice.equals("1")) {
                System.out.println("Enter data to be entered: ");
                Object data = scanner.next();
                stack.push(data);
                System.out.println("Data pushed");
            }
            else if (choice.equals("2")) {
                stack.pop();
                System.out.println("Data popped");
            }
            else if (choice.equals("3"))
                System.out.println("The topmost item is " + stack.topItem());
            else if (choice.equals("4")) {
                System.out.println("The contents of the stack is: ");
                stack.printStack();
            }
            else if (choice.equals("5")) {
                System.out.println("Bye!");
                System.exit(0);
            }
            else
                System.out.println("Please enter the choice from 1-4");
        }
    }
}

class ListNode {
    Object data;
    ListNode next;

    public ListNode(Object data) {
        this.data = data;
        next = null;
    }
}

class StackOverflowException extends Exception {
    public StackOverflowException() {
        System.err.println("Stack Overflow");
    }
}

class StackUnderflowException extends Exception {
    public StackUnderflowException() {
        System.err.println("Stack Underflow");
    }

}

interface StackMethods {
    void push(Object item) throws StackOverflowException;
    void pop() throws StackUnderflowException;
    Object topItem() throws StackUnderflowException;
    boolean isEmpty();
    void printStack() throws StackUnderflowException;

}

class NewStack implements StackMethods {
    public ListNode theStack;

    public NewStack() {
        theStack = null;
    }

    public void push(Object item) throws StackOverflowException {
        ListNode temp = theStack;
        theStack = new ListNode(item);
        theStack.next = temp;
    }

    public void pop() throws StackUnderflowException {
        if (theStack == null)
            throw new StackUnderflowException();
        else
            theStack = theStack.next;
    }

    public Object topItem() throws StackUnderflowException {
        if (theStack == null)
            throw new StackUnderflowException();
        else
            return theStack.data;
    }

    public boolean isEmpty() {
        return theStack == null;
    }

    public void printStack() throws StackUnderflowException {
        if (theStack == null)
            throw new StackUnderflowException();
        else {
            ListNode pointer = theStack;
            while (pointer != null) {
                System.out.println("=> " + pointer.data);
                pointer = pointer.next;
            }
        }
    }
}