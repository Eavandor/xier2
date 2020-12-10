package xier2;
import java.time.LocalDate;
public abstract class Drinks {
 protected String name;
 protected double cost;
 protected LocalDate productionDate;
 protected int preserveDays;
public Drinks(String name, double cost, LocalDate productionDate, int preverveDays) {
	
	this.name = name;
	this.cost = cost;
	this.productionDate = productionDate;
this.preserveDays = preverveDays;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getCost() {
	return cost;
}

public void setCost(double cost) {
	this.cost = cost;
}

public LocalDate getProductionDate() {
	return productionDate;
}

public void setProductionDate(LocalDate productionDate) {
	this.productionDate = productionDate;
}

public int getPreserveDays() {
	return preserveDays;
}

public void setPreserveDays(int preverveDays) {
	this.preserveDays = preverveDays;
}

public boolean isExpired() {
	
	int days=Math.abs((int)(this.productionDate.toEpochDay()-LocalDate.now().toEpochDay()));
	
	return days>preserveDays?true:false;
}

@Override
public String toString() {
	return "Drinks [name=" + name + ", cost=" + cost + ", productionDate=" + productionDate + ", preserveDays="
			+ preserveDays + "]";
}


}

