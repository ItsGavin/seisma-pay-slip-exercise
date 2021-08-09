package utility;

/**
 * Custom exception for out of range inputs as defined in project spec:
 * 1. Non positive salary numbers
 * 2. Superannuation rate not between 0.0 and 0.50
 */
public class InputOutOfRangeException extends Exception{

    public InputOutOfRangeException() {
        super("Input exceeds valid range");
    }

    public InputOutOfRangeException(String message)
    {
       super(message);
    }
}
