package com.java.helloworld;

public class dataStructures {
    public static void main(String[] args) {
        List newList = new List();
        newList.add(1);
        newList.add(2);
        newList.add(3);
        newList.add(4);
        newList.traverse();
    }
}



class ListNode
{
    int data;
    ListNode next;

    ListNode(int data)
    {
        this.data = data;
        this.next = null;
    }

}

class List
{
    ListNode head;
    List()
    {
        head = null;
    }

    public void traverse()
    {
        ListNode current = head;
        int count = 0;

        if (head == null)
        {
            System.out.println("No elements in the list!");
        }

        while (current != null)
        {
            System.out.println((count+1) + " position: " + current.data);
            current = current.next;
            count++;
        }
    }

    public void add(int data)
    {
        ListNode newNode = new ListNode(data);
        ListNode current = head;

        if (head == null)
        {
            newNode.next = head;
            head = newNode;
        }
        else
        {
            while(current.next != null)
            {
                current = current.next;
            }
            current.next = newNode;
            newNode = null;

        }


        //newNode.next = head;
        //head = newNode;
    }
}