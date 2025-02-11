
/**
 * Exception class for when the password meets the sequence requirement
 * @author John Vu
 */
public class InvalidSequenceException extends RuntimeException{
	/**
	 * default constructor
	 */
	public InvalidSequenceException() {
		super("The password cannot contain more than two of the same characters in sequence");
	}
	/**
	 * constructor with custom message
	 * @param m custom message
	 */
	public InvalidSequenceException(String m) {
		super(m);
	}
}
