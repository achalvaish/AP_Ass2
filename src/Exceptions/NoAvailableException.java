package Exceptions;

public class NoAvailableException extends Exception{
    public NoAvailableException()
    {
        System.out.println("Cannot form connection. One or more of the users are already part of a couple");
    }
}
