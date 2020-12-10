package xier2;
import java.time.LocalDate;
public class OverdraftBalanceException extends RuntimeException{
private float moneyYouHave;
private float cost;
public OverdraftBalanceException() {
	super();
	// TODO Auto-generated constructor stub
}
public OverdraftBalanceException(String message, Throwable cause, boolean enableSuppression,
		boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
	// TODO Auto-generated constructor stub
}
public OverdraftBalanceException(String message, Throwable cause) {
	super(message, cause);
	// TODO Auto-generated constructor stub
}
public OverdraftBalanceException(String message) {
	super(message);
	// TODO Auto-generated constructor stub
}
public OverdraftBalanceException(Throwable cause) {
	super(cause);
	// TODO Auto-generated constructor stub
}


}
