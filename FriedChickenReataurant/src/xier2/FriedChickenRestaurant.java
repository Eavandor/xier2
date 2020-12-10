package xier2;
import java.time.LocalDate;
public interface FriedChickenRestaurant {
	

	
void sellMeals(SetMeal sm) throws IngredientSortOutException;





void purchaseThings(Drinks d,int num,int costMoneyInTotal)throws OverdraftBalanceException ;



}
