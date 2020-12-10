package xier2;

import java.util.LinkedList;
import java.time.LocalDate;

public class Test1 {

	public static void main(String[] args) throws OverdraftBalanceException, IngredientSortOutException {

		LinkedList<Beer> beerList = new LinkedList<Beer>();
		LinkedList<Juice> juiceList = new LinkedList<Juice>();

		West2FriedChickenRestauran w1 = new West2FriedChickenRestauran(10000, beerList, juiceList);

		System.out.println("************************测试批量进货：*****************************");

		w1.purchaseThings(new Beer("啤酒", 3, LocalDate.now(), (float) 0.05), 20, 60); // 进货20瓶啤酒，花费60元
		w1.purchaseThings(new Juice("果汁", 3, LocalDate.parse("1982-10-10")), 10, 30); // 进货10瓶过期啤酒，花费30元
		w1.purchaseThings(new Juice("果汁", 3, LocalDate.now()), 10, 30); // 进货10瓶未过期啤酒，花费30元。
		System.out.println();

		System.out.println("************************测试完毕*****************************");
		System.out.println();
		System.out.println();
		SetMeal meal1 = new SetMeal("套餐1", 20.5, "大份炸鸡",
				new Beer("啤酒", 3, LocalDate.parse("2020-11-19"), (float) 0.05));
		SetMeal meal2 = new SetMeal("套餐2", 15.5, "中份炸鸡",
				new Beer("啤酒", 3, LocalDate.parse("2020-11-19"), (float) 0.05));

		SetMeal meal3 = new SetMeal("套餐3", 10.5, "小份炸鸡", new Juice("果汁", 3, LocalDate.parse("2020-11-19")));
		SetMeal meal4 = new SetMeal("套餐4", 12.5, "炸鸡腿", new Juice("果汁", 3, LocalDate.parse("2020-11-19")));
		SetMeal meal5 = new SetMeal("套餐5", 17.5, "小份炸鸡", new Juice("果汁", 3, LocalDate.parse("2020-11-19")));
		SetMeal meal6 = new SetMeal("套餐6", 30.5, "炸鸡全家桶",
				new Beer("啤酒", 3, LocalDate.parse("2020-11-19"), (float) 0.05));

		System.out.println("************************测试套餐1,2是否可正常出售*****************************");
		if (beerList.get(0).isExpired()) { // 若套餐中的果汁过期，则移除过期果汁，并印出相应信息。
			System.out.println("啤酒已过期！");
			w1.beerList.remove(0);
		} else { // 若套餐中果汁未过期，则出售套餐1。
			w1.sellMeals(meal1);
		}

		if (beerList.get(0).isExpired()) { // 若套餐中的果汁过期，则移除过期果汁，并印出相应信息。
			System.out.println("啤酒已过期！");
			w1.beerList.remove(0);
		} else { // 若套餐中果汁未过期，则出售套餐2。
			w1.sellMeals(meal2);
		}

		System.out.println("************************测试完毕*****************************");

		System.out.println();
		System.out.println();
		System.out.println("************************测试购买过期套餐与未过期套餐*****************************");
		for (int t = 1; t <= 20; t++) {
			w1.sellMeals(meal3);
		}
		System.out.println();
		System.out.println("************************测试完毕*****************************");
		System.out.println();
		System.out.println();

		
//	      w1.purchaseThings(new Beer("啤酒", 3, LocalDate.now(), (float) 0.05),20000,60000);   
		
		// 进货20000瓶啤酒，花费60000元，但是没这么多钱,可以解除注释运行试试看，结果会抛出OverdraftBalanceException
		// 这一自定义异常。可以取消上面那行的注释试试看哦！

		
//		for(int t=1;t<=22;t++) {
//			w1.sellMeals(meal3);
//		}
		
//测试饮料卖完的情况，抛出IngredientSortOutException，可以取消注释试试看哦！

	}

}
