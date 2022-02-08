
public class NoSpecialCharacterException extends Exception{
	public String getMessage() {
		return "The password must contain at least one special character";
	}
}
