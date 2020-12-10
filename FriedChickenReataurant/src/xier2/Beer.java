package xier2;
import java.time.LocalDate;
public class Beer extends Drinks{
protected float alcoholLevel;

public Beer(String name, double cost, LocalDate productionDate,float alcoholLevel) {
	super(name, cost,productionDate, 30);
	this.alcoholLevel = alcoholLevel;
	
}








}
