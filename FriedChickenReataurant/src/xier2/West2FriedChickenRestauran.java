package xier2;

import java.util.LinkedList;
import java.util.Iterator;
import java.time.LocalDate;

public class West2FriedChickenRestauran implements FriedChickenRestaurant {
	public float moneyYouHave;
	public LinkedList<Beer> beerList; // ʹ��LinkedList,��Ϊ���ArrayList��LinkedList
										// ��ɾ�죬��ѯ����ArrayList��ɾ������ѯ�졣�˴�Ƶ����ɾ����ʹ��LinkedList��
	public LinkedList<Juice> juiceList;
	public static LinkedList<SetMeal> mealList = new LinkedList<SetMeal>() ;
//	{
//		{ // ʹ����������ײ��б���г�ʼ����
//
//			mealList.add(
//					new SetMeal("�ײ�1", 20.5, "���ը��", new Beer("ơ��", 3, LocalDate.parse("2020-12-19"), (float) 0.05)));
//			mealList.add(
//					new SetMeal("�ײ�2", 15.5, "�з�ը��", new Beer("ơ��", 3, LocalDate.parse("2020-12-19"), (float) 0.05)));
//			mealList.add( new SetMeal("�ײ�3", 10.5, "С��ը��", new Juice("��֭", 3, LocalDate.parse("2020-12-19"))));
//			mealList.add( new SetMeal("�ײ�4", 12.5, "ը����", new Juice("��֭", 3, LocalDate.parse("2020-12-19"))));
//			mealList.add( new SetMeal("�ײ�5", 17.5, "С��ը��", new Juice("��֭", 3, LocalDate.parse("2020-10-19"))));
//			mealList.add(
//					new SetMeal("�ײ�6", 30.5, "ը��ȫ��Ͱ", new Beer("ơ��", 3, LocalDate.parse("2020-12-19"), (float) 0.05)));
//
//		}
//	};

	public West2FriedChickenRestauran(float moneyYouHave, LinkedList<Beer> beerList, LinkedList<Juice> juiceList) {
		super();
		this.moneyYouHave = moneyYouHave;
		this.beerList = beerList;
		this.juiceList = juiceList;
		mealList.add(
				new SetMeal("�ײ�1", 20.5, "���ը��", new Beer("ơ��", 3, LocalDate.parse("2020-12-19"), (float) 0.05)));
		mealList.add(
				new SetMeal("�ײ�2", 15.5, "�з�ը��", new Beer("ơ��", 3, LocalDate.parse("2020-12-19"), (float) 0.05)));
		mealList.add( new SetMeal("�ײ�3", 10.5, "С��ը��", new Juice("��֭", 3, LocalDate.parse("2020-12-19"))));
		mealList.add( new SetMeal("�ײ�4", 12.5, "ը����", new Juice("��֭", 3, LocalDate.parse("2020-12-19"))));
		mealList.add( new SetMeal("�ײ�5", 17.5, "С��ը��", new Juice("��֭", 3, LocalDate.parse("2020-10-19"))));
		mealList.add(
				new SetMeal("�ײ�6", 30.5, "ը��ȫ��Ͱ", new Beer("ơ��", 3, LocalDate.parse("2020-12-19"), (float) 0.05)));
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
			throw new IngredientSortOutException("ơ�������꣡");
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
			throw new IngredientSortOutException("��֭�����꣡");
		}
	}

	public void sellMeals(SetMeal sm) throws IngredientSortOutException {
		String drinkType="";
		if(sm.getDrinkName() instanceof Beer) {
			drinkType="ơ��";
		}else {
			drinkType="��֭";
		}
		try {
		if((sm.getDrinkName() instanceof Beer)&&beerList.get(0).isExpired()||(sm.getDrinkName() instanceof Juice)&&juiceList.get(0).isExpired()) {
			
			if(sm.getDrinkName() instanceof Beer) {               //���ײ�����������Ϊơ�ƣ����Ƴ�ơ���еĵ�һ����
				beerList.remove(0);
				System.out.println("ơ���ѹ���");
			}else {
				juiceList.remove(0);    
				System.out.println("��֭�ѹ���");                    //�����Ƴ���֭�еĵ�һ����
			}
		}else {
		String mealN = sm.getMealName();

		switch (mealN) {
		case "�ײ�1":
			moneyYouHave +=20.5;
			if (beerList.isEmpty()) {
				throw new IngredientSortOutException("ơ�������ꡣ");
			} else {
				beerList.remove(0);
				System.out.println("�ɹ����� ");
				System.out.println(	sm.toString());
			}
			break;
		case "�ײ�2":
			moneyYouHave += 15.5;
			if (beerList.isEmpty()) {
				throw new IngredientSortOutException("ơ�������ꡣ");
			} else {
				beerList.remove(0);
				System.out.println("�ɹ����� ");
				System.out.println(	sm.toString());
			}
			break;
		case "�ײ�3":
			moneyYouHave +=  10.5;
			if (juiceList.isEmpty()) {
				throw new IngredientSortOutException("��֭�����ꡣ");
			} else {
				juiceList.remove(0);
				System.out.println("�ɹ����� ");
				System.out.println(	sm.toString());
			}
			break;
		case "�ײ�4":
			moneyYouHave += 12.5;
			if (juiceList.isEmpty()) {
				throw new IngredientSortOutException("��֭�����ꡣ");
			} else {
				juiceList.remove(0);
				System.out.println("�ɹ����� ");
				System.out.println(	sm.toString());
			}
			break;
		case "�ײ�5":
			moneyYouHave +=  17.5;
			if (juiceList.isEmpty()) {
				throw new IngredientSortOutException("��֭�����ꡣ");
			} else {
				juiceList.remove(0);
				System.out.println("�ɹ����� ");
				System.out.println(	sm.toString());
			}
			break;
		case "�ײ�6":
			moneyYouHave +=  30.5;
			if (beerList.isEmpty()) {
				throw new IngredientSortOutException("ơ�������ꡣ");
			} else {
				beerList.remove(0);
				System.out.println("�ɹ����� ");
			System.out.println(	sm.toString());
			}
			break;
		}
		
		}
}catch(Exception e) {
			throw new IngredientSortOutException(drinkType+"�����ꡣ");
		}

	}


	

	
	public void purchaseThings(Drinks d, int num, int costMoneyInTotal) throws OverdraftBalanceException {
		if (d instanceof Beer) {
			if (costMoneyInTotal > moneyYouHave) {
				throw new OverdraftBalanceException("����Ҫ" + (costMoneyInTotal - moneyYouHave) + "Ԫ��֧�����");
			} else {
				for (int i = 0; i < num; i++) {
					beerList.add(new Beer("ơ��", 3,d.getProductionDate(), (float) 0.05));
				}
				moneyYouHave -= costMoneyInTotal;
				System.out.println("�ɹ�����" + num + "ƿơ��");
			}
		} else {
			if (costMoneyInTotal > moneyYouHave) {
				throw new OverdraftBalanceException("����Ҫ" + (costMoneyInTotal - moneyYouHave) + "Ԫ��֧�����");
			} else {
				for (int i = 0; i < num; i++) {
					juiceList.add(new Juice("��֭", 3, d.getProductionDate()));
				}
				moneyYouHave -= costMoneyInTotal;
				System.out.println("�ɹ�����" + num + "ƿ��֭");
			}
		}
	}
}
