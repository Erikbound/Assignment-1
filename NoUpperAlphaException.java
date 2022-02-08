
public class NoUpperAlphaException extends Exception{
	public String getMessage() {
		return "The password must contain at least one uppercase alphabetic character";
	}
}
