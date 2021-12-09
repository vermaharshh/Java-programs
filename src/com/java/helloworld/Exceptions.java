package com.java.helloworld;

public class Exceptions {
    public static void main(String[] args) {
        Student stud1, stud2;
        stud1 = new Student("Amogh", "A1", "ECE");
        stud2 = new Student("Avni", "A1", "CS");
        stud1.display();
        stud2.display();

        int a=0;
        int b=0;
        try {
            System.out.println(a / b);
        }
        catch (ArithmeticException e)
        {
            System.err.println("Division by zero!");
        }
        finally {
            System.out.println("No division by zero error!");
        }
        System.out.println("I can go ahead!");

    }
}

class Student
{
  private final String name;
  private final String Class;
  private final String branch;

  Student(String name, String Class, String branch)
  {
      this.name = name;
      this.Class = Class;
      this.branch = branch;
  }

  public void display()
  {
      System.out.print("Name: " + name + "\nClass: " + Class + "\nBranch: " + branch + "\n");
  }

};


