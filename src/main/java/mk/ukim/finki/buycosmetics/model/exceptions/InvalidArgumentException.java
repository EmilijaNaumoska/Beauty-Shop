package mk.ukim.finki.buycosmetics.model.exceptions;

public class InvalidArgumentException extends RuntimeException{
    public InvalidArgumentException() {
        super("Enter valid arguments!");
    }
}
