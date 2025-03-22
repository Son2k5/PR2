package Tut9.problem3;

public class NotPossibleException extends Exception {
    public NotPossibleException(String msg) {
        super("NotPossibleException: " + msg);
    }
}
