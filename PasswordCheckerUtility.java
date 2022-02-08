import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {
	
	public PasswordCheckerUtility() {
		
	}
	
	public static boolean isValidPassword(String password) throws
	LengthException, NoUpperAlphaException, NoLowerAlphaException,
    NoDigitException, NoSpecialCharacterException, InvalidSequenceException{
		boolean result = true;
				//Check Length
			if (!isValidLength​(password)) {
				result = false;
				throw new LengthException();
			}
				//Check Upper/Lower Alpha
			if (!hasUpperAlpha(password)) {
				result = false;
				throw new NoUpperAlphaException();
			}
			if (!hasLowerAlpha(password)) {
				result = false;
				throw new NoLowerAlphaException();
			}
				//Check for Digit
			if (!hasDigit(password)) {
				result = false;
				throw new NoDigitException();
			}
				//Check for Special Char
			if (!hasSpecialChar(password)) {
				result = false;
				throw new NoSpecialCharacterException();
			}
				//Check for Invalid Sequence
			if (!NoSameCharInSequence(password)) {
				result = false;
				throw new InvalidSequenceException();
			}
		return result;
	}
	
	public static boolean isValidLength​(String password) throws LengthException{
		boolean result = false;
		try{
			if (password.length() < 6){
				throw new LengthException();
			}
			else result = true;
		}
		catch(LengthException e){
			e.getMessage();
		}
		
		return result;
	}
	
	public static boolean isWeakPassword(String password) throws WeakPasswordException {
		boolean result = false;
			result = !hasBetweenSixAndNineChars(password);
			if (!result) throw new WeakPasswordException();
		
		return result;
	}
	
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> password) {
		ArrayList<String> list = password;
		String temp = "";
		String error = "";
		
		for (int i = 0; i < password.size()-1; i++) {
			temp = password.get(i);
			try {
				isValidPassword(temp);
			} catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException
					| NoSpecialCharacterException | InvalidSequenceException e) {
				error = e.getMessage();
			}
			
			list.set(i, temp + " " + error);
			error = "";
		}
		
		return list;
	}
	
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		try {
			if (!password.contentEquals(passwordConfirm)) {
				throw new UnmatchedException();
			}
		}
		catch (UnmatchedException e) {
			e.getMessage();
		}
	}
	
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		boolean result = false;
		if (password.contentEquals(passwordConfirm)) {
			result = true;
		}
		return result;
	}
	
	public static boolean hasBetweenSixAndNineChars(String password) {
		boolean result = false;
		if ((password.length() > 6) && (password.length() < 9)){
			result = true;
		}
		return result;
	}
	
	public static boolean hasDigit(String password) throws NoDigitException{
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher matcher = pattern.matcher(password);
			boolean result = !matcher.matches();
		try {
			if (!result) throw new NoDigitException();
		}
		catch (NoDigitException e) {
			e.getMessage();
		}
		return result;
	}
	
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
		boolean result = false;
		char val;
		try {
			for(int i = 0; i < password.length(); i++){
				val = password.charAt(i);
				if (Character.isLowerCase(val)){
					result = true;
					break;
				}
			}
			if (!result) throw new NoLowerAlphaException();
		}
		catch(NoLowerAlphaException e) {
			e.getMessage();
		}
		
		return result;
	}
	
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
		boolean result = false;
		char val;
		try {
			for(int i = 0; i < password.length(); i++){
				val = password.charAt(i);
				if (Character.isUpperCase(val)){
					result = true;
					break;
				}
			}
			if (!result) throw new NoUpperAlphaException();
		}
		catch(NoUpperAlphaException e) {
			e.getMessage();
		}
		return result;
	}
	
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
			Pattern pattern = Pattern.compile("[!@#&()–[{}]:;',?/*~$^+=<>]*");
			Matcher matcher = pattern.matcher(password);
			boolean result = !matcher.matches();
		try {
			if (!result) throw new NoSpecialCharacterException();
		}
		catch (NoSpecialCharacterException e) {
			e.getMessage();
		}
		return result;
	}
	
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException{
		boolean result = true;
		char current, prev;

		try {
			for (int i = 1; i < password.length() - 1; i++) {
				current = password.charAt(i);
				prev = password.charAt(i-1);
				if (current == prev) {
					throw new InvalidSequenceException();
				}
			}
		}
		catch(InvalidSequenceException e) {
			result = false;
			e.getMessage();
		}
		
		return result;
		
	}
}
