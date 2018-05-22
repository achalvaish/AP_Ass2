package Exceptions;

public class NoParentException extends Exception {
    public NoParentException()
    {
        System.out.println("Invalid operation.Both parents are required for a child.");
    }
}