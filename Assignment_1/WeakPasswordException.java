/**
 * Exception class for when password is weak
 * @author John Vu
 */
public class WeakPasswordException extends RuntimeException{
	/**
	 * default constructor
	 */
	public WeakPasswordException() {
		super("The password is OK but weak - it contains fewer than 10 characters");
	}
	/**
	 * constructor with custom message
	 * @param m custom message
	 */
	public WeakPasswordException(String m) {
		super(m);
	}
}
