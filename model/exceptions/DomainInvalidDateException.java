package model.exceptions;

public class DomainInvalidDateException extends Exception{
    private static final long serialVersionUID = 1L;

    public DomainInvalidDateException(String message){
        super(message);
    }
}
