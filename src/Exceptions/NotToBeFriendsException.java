package Exceptions;

public class NotToBeFriendsException extends Exception {
    public NotToBeFriendsException()
    {
        System.out.println("Users do not satisfy requirements to form connections.");
    }
}
