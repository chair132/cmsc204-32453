import java.util.ArrayList;

/**
 * Implements a variety of functions determining whether a password is valid and/or weak or not.
 * @author John Vu
 */
public class PasswordCheckerUtility {
	
	/**
	 * Compares the equality of two passwords 
	 * @param password string to be checked
	 * @param passwordConfirm string to be checked against password for equality
	 * @throws UnmatchedException thrown if the passwords do not match
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		if (!password.equals(passwordConfirm)) {
			throw new UnmatchedException();
		}
	}
	
	/**
	 * Compares the equality of two passwords 
	 * @param password string to be checked
	 * @param passwordConfirm string to be checked against password for equality
	 * @return true if the passwords match, false if otherwise 
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		return (password.equals(passwordConfirm));
	}
	
	/**
	 * This method will accept an ArrayList of passwords as the parameter and return an ArrayList with the status of any invalid passwords (weak passwords are not considered invalid).
	 * @param passwords an ArrayList of passwords to be checked
	 * @return an ArrayList of all invalid passwords
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		ArrayList<String> invalidPws = new ArrayList<>();
		
		for(int i = 0; i < passwords.size();i++) {
			try {
				isValidPassword(passwords.get(i));
			} catch (RuntimeException e){
				invalidPws.add(passwords.get(i) + " " + e.getMessage());
			}
			
		}
		return invalidPws;
	}
	
	/**
	 * Checks if the password contains 6 to 9 characters
	 * @param password password to be checked
	 * @return true if password is between six and nine characters, false otherwise
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		return (password.length() >=6 && password.length() <=9);
	}
	
	/**
	 * Checks the password digit requirement 
	 * @param password string to be checked
	 * @return true if password meets the digit requirement
	 * @throws NoDigitException thrown if password does not meet digit requirement
	 */
	public static boolean hasDigit(String password) throws NoDigitException{
		for(int i = 0; i < password.length(); i++) {
			if(Character.isDigit(password.charAt(i))) {
				return true;
			}
		}
		throw new NoDigitException();
	}
	
	/**
	 * Checks the password lowercase requirement
	 * @param password string to be checked
	 * @return true if password meets lowercase requirement
	 * @throws NoLowerAlphaException thrown if lowercase requirement not met
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
		for(int i = 0; i < password.length(); i++) {
			if(Character.isLowerCase(password.charAt(i))) {
				return true;
			}
		}
		throw new NoLowerAlphaException();
	}
	/**
	 * Checks the password special character requirement
	 * @param password string to be checked
	 * @return true if password meets special character requirement
	 * @throws NoSpecialCharacterException thrown if special character requirement not met
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
		for(int i = 0; i < password.length(); i++) {
			if(!Character.isLetterOrDigit(password.charAt(i)) && !Character.isWhitespace(password.charAt(i))) {
				return true;
			}
		}
		throw new NoSpecialCharacterException();
	}
	/**
	 * Checks the password uppercase requirement
	 * @param password string to be checked
	 * @return true if password meets uppercase requirement
	 * @throws NoUpperAlphaException thrown if uppercase requirement not met
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
		for(int i = 0; i < password.length(); i++) {
			if(Character.isUpperCase(password.charAt(i))) {
				return true;
			}
		}
		throw new NoUpperAlphaException();
	}
	/**
	 * Checks the password length requirement
	 * @param password string to be checked
	 * @return true if password meets length requirement
	 * @throws LengthException thrown if length requirement not met
	 */
	public static boolean isValidLength(String password) throws LengthException{
		
		if(!(password.length() >=6)) {
			throw new LengthException();
		}
		return true;
	}
	/**
	 * Checks the validity of the password (follows all the rules)
	 * @param password string to be checked
	 * @return true if valid password (follows all the rules), false if invalid password
	 * @throws LengthException thrown if length requirement not met
	 * @throws NoUpperAlphaException thrown if uppercase requirement not met
	 * @throws NoLowerAlphaException thrown if lowercase requirement not met
	 * @throws NoDigitException thrown if digit requirement not met
	 * @throws NoSpecialCharacterException thrown if special character requirement not met
	 * @throws InvalidSequenceException thrown if sequence requirement is met
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException{
		return isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasDigit(password) && hasSpecialChar(password) && !noSameCharInSequence(password);
	}
	
	/**
	 * Checks if the password is valid and the length is NOT between six and nine characters (inclusive) 
	 * @param password string to be checked
	 * @return false if the password is valid the length is NOT between six and nine characters (inclusive)
	 * @throws WeakPasswordException thrown if length of password is between six and nine characters (inclusive), ALTHOUGH the password may be VALID.
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException{
		if(isValidPassword(password) && !hasBetweenSixAndNineChars(password)) {
			return false;
		}
		throw new WeakPasswordException();
	}
	/**
	 * Checks the password sequence requirement
	 * @param password string to be checked
	 * @return false if password does not meet sequence requirement
	 * @throws InvalidSequenceException thrown password meets sequence requirement
	 */
	public static boolean noSameCharInSequence(String password) throws InvalidSequenceException {
		for(int i = 0; i < password.length() - 2; i++) {
			if(password.charAt(i) == password.charAt(i+1) && password.charAt(i) == password.charAt(i+2)) {
				throw new InvalidSequenceException();
			}
		}
		return false;
	}
	
	
	
	
}
