package com.java.stackswitharrays;

import java.util.Scanner;

public class StacksWithArrays {
    public static void main(String[] args) throws StackOverflowException, StackUnderflowException {

        Scanner scanner = new Scanner(System.in);
        NewStack stack = new NewStack();

        System.out.println("Implementation of stack using arrays");

        while (true) {
        System.out.println("Choose an option below: ");
        System.out.println("1) Add an Item to the Stack");
        System.out.println("2) Pop the item from the Stack");
        System.out.println("3) Show the topmost item");
        System.out.println("4) Printing the stack");
        System.out.println("5) Exit");
        System.out.print("=> ");
        int choice = scanner.nextInt();


        if (choice == 1) {
            System.out.print("\nEnter the number you want to push: ");
            int item = scanner.nextInt();
            stack.push(item);
        }
        else if (choice == 2) {
            stack.pop();
            System.out.println("\nItem popped");
        }
        else if (choice == 3) {
            System.out.println("Topmost item of the stack: " + stack.topItem());
        }
        else if (choice == 4) {
            System.out.println("The elements of the stack are: ");
            stack.printStack();
        }
        else if (choice == 5) {
            System.out.println("bye");
            System.exit(0);
        }
        else {
            System.out.println("Please enter the numbers given above only");
        }

        }
    }
}

class StackUnderflowException extends Exception {
    public StackUnderflowException() {
        System.err.println("Stack underflow");
    }
}

class StackOverflowException extends Exception {
    public StackOverflowException() {
        System.err.println("Stack Overflow");
    }
}


interface StackMethods {
    public abstract void  pop() throws StackUnderflowException;
    public abstract void push(Object item) throws StackOverflowException;
    public abstract boolean isEmpty();
    public abstract boolean isFull();
    public abstract Object topItem() throws StackUnderflowException;
    public abstract void printStack() throws StackUnderflowException;
}

class NewStack implements StackMethods {

    public Object theStack[];
    private final int MAXSIZE = 5;
    private int nextPos;

    public NewStack() {
        theStack = new Object[MAXSIZE];
        nextPos = 0;
    }

    public boolean isEmpty() {
        return nextPos == 0;
    }

    public boolean isFull() {
        return nextPos < MAXSIZE;
    }

    public void push(Object item) throws StackOverflowException {
        if (nextPos < MAXSIZE) {
            theStack[nextPos] = item;
            nextPos++;
        }
        else {
            throw new StackOverflowException();
        }
    }

    public void pop() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }
        else {
            nextPos--;
        }
    }

    public Object topItem() throws StackUnderflowException {
        if (nextPos > 0)
            return theStack[nextPos - 1];
        else
            throw new StackUnderflowException();
    }

    public void printStack() throws StackUnderflowException {
        if (nextPos != 0) {
            //System.out.println(nextPos);
            for (int i = nextPos; i > 0; i--) {
                //System.out.println(i);
                System.out.println("|    " + theStack[i-1] + "    |");
                System.out.println("|__________|");
            }
        }
        else {
            throw new StackUnderflowException();
        }
    }
}