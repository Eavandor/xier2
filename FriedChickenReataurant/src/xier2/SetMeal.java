package xier2;
import java.time.LocalDate;
public class SetMeal {
String mealName;
double mealPrice;
String friedChickenName;
Drinks drinkName;

public SetMeal(String mealName, double mealPrice, String friedChickenName, Drinks drinkName) {
	
	this.mealName = mealName;
	this.mealPrice = mealPrice;
	this.friedChickenName = friedChickenName;
	this.drinkName = drinkName;
}

public String getMealName() {
	return mealName;
}

public void setMealName(String mealName) {
	this.mealName = mealName;
}

public double getMealPrice() {
	return mealPrice;
}

public void setMealPrice(double mealPrice) {
	this.mealPrice = mealPrice;
}

public String getFriedChickenName() {
	return friedChickenName;
}

public void setFriedChickenName(String friedChickenName) {
	this.friedChickenName = friedChickenName;
}

public Drinks getDrinkName() {
	return drinkName;
}

public void setDrinkName(Drinks drinkName) {
	this.drinkName = drinkName;
}

@Override
public String toString() {
	return "�ײ�����" + mealName + ", �۸�" + mealPrice + ",ը�����ͣ�" + friedChickenName
			+ ",����" + drinkName.getName();
}


}
