package utility;

public class InputOutOfRangeException extends Exception{

    public InputOutOfRangeException() {
        super("Input exceeds valid range");
    }

    public InputOutOfRangeException(String message)
    {
       super(message);
    }
}
