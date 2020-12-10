package xier2;

import java.util.LinkedList;
import java.util.Iterator;
import java.time.LocalDate;

public class West2FriedChickenRestauran implements FriedChickenRestaurant {
	public float moneyYouHave;
	public LinkedList<Beer> beerList; // 使用LinkedList,因为相比ArrayList，LinkedList
										// 增删快，查询慢；ArrayList增删慢，查询快。此处频繁增删，故使用LinkedList。
	public LinkedList<Juice> juiceList;
	public static LinkedList<SetMeal> mealList = new LinkedList<SetMeal>() ;
//	{
//		{ // 使用匿名类对套餐列表进行初始化。
//
//			mealList.add(
//					new SetMeal("套餐1", 20.5, "大份炸鸡", new Beer("啤酒", 3, LocalDate.parse("2020-12-19"), (float) 0.05)));
//			mealList.add(
//					new SetMeal("套餐2", 15.5, "中份炸鸡", new Beer("啤酒", 3, LocalDate.parse("2020-12-19"), (float) 0.05)));
//			mealList.add( new SetMeal("套餐3", 10.5, "小份炸鸡", new Juice("果汁", 3, LocalDate.parse("2020-12-19"))));
//			mealList.add( new SetMeal("套餐4", 12.5, "炸鸡腿", new Juice("果汁", 3, LocalDate.parse("2020-12-19"))));
//			mealList.add( new SetMeal("套餐5", 17.5, "小份炸鸡", new Juice("果汁", 3, LocalDate.parse("2020-10-19"))));
//			mealList.add(
//					new SetMeal("套餐6", 30.5, "炸鸡全家桶", new Beer("啤酒", 3, LocalDate.parse("2020-12-19"), (float) 0.05)));
//
//		}
//	};

	public West2FriedChickenRestauran(float moneyYouHave, LinkedList<Beer> beerList, LinkedList<Juice> juiceList) {
		super();
		this.moneyYouHave = moneyYouHave;
		this.beerList = beerList;
		this.juiceList = juiceList;
		mealList.add(
				new SetMeal("套餐1", 20.5, "大份炸鸡", new Beer("啤酒", 3, LocalDate.parse("2020-12-19"), (float) 0.05)));
		mealList.add(
				new SetMeal("套餐2", 15.5, "中份炸鸡", new Beer("啤酒", 3, LocalDate.parse("2020-12-19"), (float) 0.05)));
		mealList.add( new SetMeal("套餐3", 10.5, "小份炸鸡", new Juice("果汁", 3, LocalDate.parse("2020-12-19"))));
		mealList.add( new SetMeal("套餐4", 12.5, "炸鸡腿", new Juice("果汁", 3, LocalDate.parse("2020-12-19"))));
		mealList.add( new SetMeal("套餐5", 17.5, "小份炸鸡", new Juice("果汁", 3, LocalDate.parse("2020-10-19"))));
		mealList.add(
				new SetMeal("套餐6", 30.5, "炸鸡全家桶", new Beer("啤酒", 3, LocalDate.parse("2020-12-19"), (float) 0.05)));
	}

	public void use(Beer beer1) throws IngredientSortOutException {
		Iterator<Beer> i1 = beerList.iterator();
		boolean flag = false;
		while (i1.hasNext()) {
			Beer b = (Beer) i1.next();
			
			if (b.getName() == beer1.getName()) {
				flag = true;
				beerList.remove(b);
				break;
			}
		}
		if (flag == false) {
			throw new IngredientSortOutException("啤酒已卖完！");
		}
		
	}

	public void use(Juice juice1) throws IngredientSortOutException {
		Iterator<Juice> i2 = juiceList.iterator();
		boolean flag = false;
		while (i2.hasNext()) {
			Juice j = (Juice) i2.next();
			
			if (j.getName() == juice1.getName()) {
				flag = true;
				juiceList.remove(j);
				break;
			}
		}
		
		if (flag == false) {
			throw new IngredientSortOutException("果汁已卖完！");
		}
	}

	public void sellMeals(SetMeal sm) throws IngredientSortOutException {
		String drinkType="";
		if(sm.getDrinkName() instanceof Beer) {
			drinkType="啤酒";
		}else {
			drinkType="果汁";
		}
		try {
		if((sm.getDrinkName() instanceof Beer)&&beerList.get(0).isExpired()||(sm.getDrinkName() instanceof Juice)&&juiceList.get(0).isExpired()) {
			
			if(sm.getDrinkName() instanceof Beer) {               //若套餐中饮料类型为啤酒，则移除啤酒中的第一个。
				beerList.remove(0);
				System.out.println("啤酒已过期");
			}else {
				juiceList.remove(0);    
				System.out.println("果汁已过期");                    //否则移除果汁中的第一个。
			}
		}else {
		String mealN = sm.getMealName();

		switch (mealN) {
		case "套餐1":
			moneyYouHave +=20.5;
			if (beerList.isEmpty()) {
				throw new IngredientSortOutException("啤酒已卖完。");
			} else {
				beerList.remove(0);
				System.out.println("成功购买： ");
				System.out.println(	sm.toString());
			}
			break;
		case "套餐2":
			moneyYouHave += 15.5;
			if (beerList.isEmpty()) {
				throw new IngredientSortOutException("啤酒已卖完。");
			} else {
				beerList.remove(0);
				System.out.println("成功购买： ");
				System.out.println(	sm.toString());
			}
			break;
		case "套餐3":
			moneyYouHave +=  10.5;
			if (juiceList.isEmpty()) {
				throw new IngredientSortOutException("果汁已卖完。");
			} else {
				juiceList.remove(0);
				System.out.println("成功购买： ");
				System.out.println(	sm.toString());
			}
			break;
		case "套餐4":
			moneyYouHave += 12.5;
			if (juiceList.isEmpty()) {
				throw new IngredientSortOutException("果汁已卖完。");
			} else {
				juiceList.remove(0);
				System.out.println("成功购买： ");
				System.out.println(	sm.toString());
			}
			break;
		case "套餐5":
			moneyYouHave +=  17.5;
			if (juiceList.isEmpty()) {
				throw new IngredientSortOutException("果汁已卖完。");
			} else {
				juiceList.remove(0);
				System.out.println("成功购买： ");
				System.out.println(	sm.toString());
			}
			break;
		case "套餐6":
			moneyYouHave +=  30.5;
			if (beerList.isEmpty()) {
				throw new IngredientSortOutException("啤酒已卖完。");
			} else {
				beerList.remove(0);
				System.out.println("成功购买： ");
			System.out.println(	sm.toString());
			}
			break;
		}
		
		}
}catch(Exception e) {
			throw new IngredientSortOutException(drinkType+"已卖完。");
		}

	}


	

	
	public void purchaseThings(Drinks d, int num, int costMoneyInTotal) throws OverdraftBalanceException {
		if (d instanceof Beer) {
			if (costMoneyInTotal > moneyYouHave) {
				throw new OverdraftBalanceException("还需要" + (costMoneyInTotal - moneyYouHave) + "元来支付货款。");
			} else {
				for (int i = 0; i < num; i++) {
					beerList.add(new Beer("啤酒", 3,d.getProductionDate(), (float) 0.05));
				}
				moneyYouHave -= costMoneyInTotal;
				System.out.println("成功购买" + num + "瓶啤酒");
			}
		} else {
			if (costMoneyInTotal > moneyYouHave) {
				throw new OverdraftBalanceException("还需要" + (costMoneyInTotal - moneyYouHave) + "元来支付货款。");
			} else {
				for (int i = 0; i < num; i++) {
					juiceList.add(new Juice("果汁", 3, d.getProductionDate()));
				}
				moneyYouHave -= costMoneyInTotal;
				System.out.println("成功购买" + num + "瓶果汁");
			}
		}
	}
}
