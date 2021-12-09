package com.java.helloworld;

import java.util.Vector;

public class ISA1 {
    public static void main(String[] args) {
        NewVector vector = new NewVector();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(3);
        vector.add(3);
        vector.add(4);
        vector.add(4);
        vector.traverse();
        vector.delete(3);
        System.out.println();
        vector.traverse();

    }
}

class NewVector extends Vector<Integer>
{
    private final Vector<Integer>  vector = new Vector<Integer>();


    public void traverse()
    {
        int size = vector.size();
        int count = 0;
        while(count < size)
        {
            System.out.println("index " + count + ": " + vector.elementAt(count));
            count++;
        }
        System.out.println("Size of vector: " + vector.size());
    }

    public void add(int data)
    {
        vector.add(data);
    }

    public void delete(int data)
    {
        int count = 0;

        while (count < vector.size()) {
            if (vector.elementAt(count) == data) {
                vector.removeElementAt(count);
                count--;
            }
            count++;
        }
    }
}
