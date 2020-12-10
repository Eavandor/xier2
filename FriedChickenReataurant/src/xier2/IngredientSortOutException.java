package xier2;

public class IngredientSortOutException extends RuntimeException{
private boolean beer;
private boolean juice;
public IngredientSortOutException(boolean beer,boolean juice) {
	super();
	this.beer=beer;
	this.juice=juice;
}
public IngredientSortOutException(String message, Throwable cause, boolean enableSuppression,
		boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
	// TODO Auto-generated constructor stub
}

public IngredientSortOutException(String message, Throwable cause) {
	super(message, cause);
	// TODO Auto-generated constructor stub
}

public IngredientSortOutException(String message) {
	super(message);
	// TODO Auto-generated constructor stub
}

public IngredientSortOutException(Throwable cause) {
	super(cause);
	// TODO Auto-generated constructor stub
}

	public void showDetails(){
		if(this.beer==true&&this.juice==true) {
			System.out.println("果汁和啤酒都已售完。");
		}else if(this.beer==true) {
			System.out.println("啤酒已售完。");
		}else {
			System.out.println("果汁已售完。");
		}
	}


}
