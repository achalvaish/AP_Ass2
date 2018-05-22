package Exceptions;

public class TooYoungException extends Exception{

    public TooYoungException() {
        System.out.println("The user does not meet the age requirements for forming connections");
    }
}
