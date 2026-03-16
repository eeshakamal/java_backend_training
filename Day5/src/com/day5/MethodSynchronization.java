package com.day5;

//method synchronization is a technique used to control access to a shared resource by multiple threads. It ensures that only one thread can access the resource at a time, preventing data corruption and ensuring thread safety.
//In Java, you can achieve method synchronization using the synchronized keyword.	
class BankAccount
{
 int balance = 1000;
 synchronized void withdraw(int amount)
 {
     System.out.println(Thread.currentThread().getName() + " is withdrawing money");

     if(balance >= amount)
     {
         System.out.println("Balance before withdrawal: " + balance);
         balance = balance - amount;
         System.out.println("Balance after withdrawal: " + balance);
     }
     else
     {
         System.out.println("Insufficient balance");
     }
 }
}
class Customer extends Thread//extends Thread to create a thread for each customer
{
 BankAccount account;

 Customer(BankAccount account)
 {
     this.account = account;
 }

 public void run()
 {
     account.withdraw(500);
 }
}
public class MethodSynchronization
{
 public static void main(String args[])
 {
     BankAccount obj = new BankAccount();
     Customer c1 = new Customer(obj);
     Customer c2 = new Customer(obj);
     c1.setName("Person A");//setName is used to set the name of the thread, which can be useful for debugging and logging purposes. It allows you to identify which thread is performing a particular action when you are analyzing the output or logs of your program.
     c2.setName("Person B");
     c1.start();
     c2.start();
 }
}

