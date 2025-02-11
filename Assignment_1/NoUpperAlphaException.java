/**
 * Exception class for when password does not meet uppercase requirement
 * @author John Vu
 */
public class NoUpperAlphaException extends RuntimeException{
	/**
	 * default constructor
	 */
	public NoUpperAlphaException() {
		super("The password must contain at least one uppercase alphabetic character");
	}
	/**
	 * constructor with custom message
	 * @param m custom message
	 */
	public NoUpperAlphaException(String m) {
		super(m);
	}
}
