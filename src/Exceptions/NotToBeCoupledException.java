package Exceptions;

public class NotToBeCoupledException extends Exception {
    public NotToBeCoupledException()
    {
        System.out.println("Cannot form connection. One or more of the users is underage to become an adult");
    }
}
