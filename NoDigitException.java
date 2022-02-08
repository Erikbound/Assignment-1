
public class NoDigitException extends Exception{
	public String getMessage() {
		return "The password must contain at least one digit";
	}
}
