/**
 * Exception class for when password does not meet length requirement
 * @author John Vu
 */
public class LengthException extends RuntimeException {
	/**
	 * default constructor
	 */
	public LengthException() {
		super("The password must be at least 6 characters long");
	}
	/**
	 * constructor with custom message
	 * @param m custom message
	 */
	public LengthException(String m) {
		super(m);
	}
}


