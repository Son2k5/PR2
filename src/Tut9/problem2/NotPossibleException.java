package Tut9.problem2;

public class NotPossibleException extends Exception {
    public NotPossibleException(String msg) {
        super("NotPossibleException: " + msg);
    }
}
