/**
 * Exception class for when password does not meet digit requirement
 * @author John Vu
 */
public class NoDigitException extends RuntimeException{
	/**
	 * default constructor
	 */
	public NoDigitException() {
		super("The password must contain at least one digit");
	}
	/**
	 * constructor with custom message
	 * @param m custom message
	 */
	public NoDigitException(String m) {
		super(m);
	}
}
