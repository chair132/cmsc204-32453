/**
 * Exception class for when password does not meet special character requirement
 * @author John Vu
 */
public class NoSpecialCharacterException extends RuntimeException{
	/**
	 * default constructor
	 */
	public NoSpecialCharacterException() {
		super("The password must contain at least one special character");
	}
	/**
	 * constructor with custom message
	 * @param m custom message
	 */
	public NoSpecialCharacterException(String m) {
		super(m);
	}
}
