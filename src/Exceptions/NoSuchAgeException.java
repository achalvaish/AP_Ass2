package Exceptions;

public class NoSuchAgeException extends Exception {

    public NoSuchAgeException()
    {
        System.out.println("Invalid age. Please enter an age between 0-150.");
    }
}
