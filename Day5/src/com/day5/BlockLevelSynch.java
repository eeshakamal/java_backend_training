package com.day5;

class TicketBooking
{
    int seats = 1;
    void bookTicket(String name)
    {
        System.out.println(name + " is trying to book ticket");
        // Block level synchronization is a technique used to control access to a specific block of code within a method, rather than synchronizing the entire method. This allows for more fine-grained control over which parts of the code are synchronized, potentially improving performance by allowing multiple threads to execute non-critical sections of the code concurrently.
        synchronized(this)
        {
            if(seats > 0)
            {
                System.out.println(name + " successfully booked the ticket");
                seats--;
            }
            else
            {
                System.out.println("Sorry ticket not available for " + name);
            }
        }
    }
}
class Custome extends Thread //extends Thread to create a thread for each customer
{
    TicketBooking tb;
    String name;
    Custome(TicketBooking tb, String name)
    {
        this.tb = tb;
        this.name = name;
    }
    public void run()
    {
        tb.bookTicket(name);
    }
}
public class BlockLevelSynch
{
    public static void main(String args[])
    {
        TicketBooking obj = new TicketBooking();

        Custome c1 = new Custome(obj,"Customer 1");
        Custome c2 = new Custome(obj,"Customer 2");

        c1.start();
        c2.start();
    }
}


