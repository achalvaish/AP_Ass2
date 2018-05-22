package Exceptions;

public class NotToBeColleaguesException extends Exception {

    public NotToBeColleaguesException()
    {
        System.out.println("Invalid operation. Children cannot have colleagues");
    }
}
