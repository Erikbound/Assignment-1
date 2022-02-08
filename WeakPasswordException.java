
public class WeakPasswordException extends Exception{
	public String getMessage() {
		return "The password is OK but weak - it contains fewer than 10 characters.";
	}
}
