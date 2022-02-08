
public class NoLowerAlphaException extends Exception{
	public String getMessage() {
		return "The password must contain at least one lowercase alphabetic character";
	}
}
