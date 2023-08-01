package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public BankAccount(String name, double balance, double minBalance) {
         this.name=name;
         this.balance=balance;
         this.minBalance=minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if(sum < 10){
            throw new Exception("Account Number can not be generated");
        }
        String accountNumber ="";
        while(sum > 9){
            accountNumber +='9';
            sum -=9;
        }
        accountNumber +=(sum + "");
        while(accountNumber.length() < digits){
            accountNumber +='0';
        }
        return accountNumber;
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance+=amount;

    }

    public void withdraw(double amount) throws Exception {
        if((balance-amount) >= minBalance){
    balance-= amount;
        }
        else{
            throw new Exception("Insufficient Balance");
        }
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance

    }

}