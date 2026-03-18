package bookmystay.exception;

/**
 * Use Case 9: Error Handling & Validation
 *
 * Custom exception representing invalid booking scenarios.
 * Makes error handling clearer and safer.
 *
 * @author Harshal
 * @version 9.0
 */
public class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}
