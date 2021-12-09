package com.java.helloworld;

public class HelloWorld {
    public static void main(String[] args) {
        Customer john = new Customer("John", 1234);
        Account jAcct= new Account(1, 300);
        john.addAccount(jAcct);
        Account returned = john.getAccount(0);
        System.out.println("John’s account balance: " + returned.getBalance());
    }
}

class Customer {
    private String name = null;
    private int number = 0;
    private String password = null;
    private int numAccounts = 0;
    private Account[] accounts = new Account[MAX_ACCTS];
    private static final int MAX_ACCTS=5;

    Customer(String name, int number)
    {
        this.name = name;
        this.number = number;
    }

    public String getName()
    {
        return name;
    }

    public int getCustNo()
    {
        return number;
    }

    public String getPassword()
    {
        return password;
    }

    public Account getAccount(int index)
    {
        return accounts[index];
    }
    public Account[] getAccounts()
    {
        return accounts;
    }

    public boolean addAccount(Account a)
    {
        if (numAccounts< MAX_ACCTS)
        {
            accounts[numAccounts] = a;
            numAccounts++;
            return true;
        }
        else
            return false;
    }

    public void setPassword(String pw)
    {
        password = pw;
    }// other methods go here}

}

class Bank{
    public static void main(String[] args)
    {
        if (args.length< 2)
        {
            System.out.println("Usage: java Bank user bal");
            System.exit(0);
        }
        Customer cust= new Customer(args[0], 1);
        float balance = Float.parseFloat(args[1]);
        cust.addAccount(new Account(1, balance));
        System.out.println("New account created!");
        Account ret = cust.getAccount(0);
        System.out.println("Balance: " + ret.getBalance());}
}

class Account{
    private int acctNumber = 0;
    private float balance = 0.0F;

    Account(int aNumber, float bal)
    {
        acctNumber = aNumber;
        balance = bal;
    }

    public int getAcctNumber()
    {
        return acctNumber;
    }

    public boolean withdraw(float amount){
        if (balance >= amount)
        {
            balance -= amount;
            return true;
        }
        else
        return false;
    }

    public void deposit(float amount)
    {
        balance += amount;
    }

    public float getBalance()
    {
        return  balance;
    }

}


