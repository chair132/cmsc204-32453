/**
 * Exception class for when password does not meet lowercase requirement
 * @author John Vu
 */
public class NoLowerAlphaException extends RuntimeException{
	/**
	 * default constructor
	 */
	public NoLowerAlphaException() {
		super("The password must contain at least one lowercase alphabetic character");
	}
	/**
	 * constructor with custom message
	 * @param m custom message
	 */
	public NoLowerAlphaException(String m) {
		super(m);
	}
}
