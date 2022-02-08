
public class InvalidSequenceException extends Exception{
	public String getMessage() {
		return "The password cannot contain more than two of the same character in sequence.";
	}
}
