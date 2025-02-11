/**
 * Exception class for when the passwords do not match
 * @author John Vu
 */
public class UnmatchedException extends RuntimeException{
	/**
	 * default constructor
	 */
	public UnmatchedException() {
		super("Passwords do not match");
	}
	/**
	 * constructor with custom message
	 * @param m customer message
	 */
	public UnmatchedException(String m) {
		super(m);
	}
}
