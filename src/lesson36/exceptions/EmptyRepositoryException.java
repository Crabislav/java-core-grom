package lesson36.exceptions;

public class EmptyRepositoryException extends Exception {
    public EmptyRepositoryException(String message) {
        super(message);
    }
}
