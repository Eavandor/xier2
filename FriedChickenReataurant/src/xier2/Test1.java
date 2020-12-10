package xier2;

import java.util.LinkedList;
import java.time.LocalDate;

public class Test1 {

	public static void main(String[] args) throws OverdraftBalanceException, IngredientSortOutException {

		LinkedList<Beer> beerList = new LinkedList<Beer>();
		LinkedList<Juice> juiceList = new LinkedList<Juice>();

		West2FriedChickenRestauran w1 = new West2FriedChickenRestauran(10000, beerList, juiceList);

		System.out.println("************************��������������*****************************");

		w1.purchaseThings(new Beer("ơ��", 3, LocalDate.now(), (float) 0.05), 20, 60); // ����20ƿơ�ƣ�����60Ԫ
		w1.purchaseThings(new Juice("��֭", 3, LocalDate.parse("1982-10-10")), 10, 30); // ����10ƿ����ơ�ƣ�����30Ԫ
		w1.purchaseThings(new Juice("��֭", 3, LocalDate.now()), 10, 30); // ����10ƿδ����ơ�ƣ�����30Ԫ��
		System.out.println();

		System.out.println("************************�������*****************************");
		System.out.println();
		System.out.println();
		SetMeal meal1 = new SetMeal("�ײ�1", 20.5, "���ը��",
				new Beer("ơ��", 3, LocalDate.parse("2020-11-19"), (float) 0.05));
		SetMeal meal2 = new SetMeal("�ײ�2", 15.5, "�з�ը��",
				new Beer("ơ��", 3, LocalDate.parse("2020-11-19"), (float) 0.05));

		SetMeal meal3 = new SetMeal("�ײ�3", 10.5, "С��ը��", new Juice("��֭", 3, LocalDate.parse("2020-11-19")));
		SetMeal meal4 = new SetMeal("�ײ�4", 12.5, "ը����", new Juice("��֭", 3, LocalDate.parse("2020-11-19")));
		SetMeal meal5 = new SetMeal("�ײ�5", 17.5, "С��ը��", new Juice("��֭", 3, LocalDate.parse("2020-11-19")));
		SetMeal meal6 = new SetMeal("�ײ�6", 30.5, "ը��ȫ��Ͱ",
				new Beer("ơ��", 3, LocalDate.parse("2020-11-19"), (float) 0.05));

		System.out.println("************************�����ײ�1,2�Ƿ����������*****************************");
		if (beerList.get(0).isExpired()) { // ���ײ��еĹ�֭���ڣ����Ƴ����ڹ�֭����ӡ����Ӧ��Ϣ��
			System.out.println("ơ���ѹ��ڣ�");
			w1.beerList.remove(0);
		} else { // ���ײ��й�֭δ���ڣ�������ײ�1��
			w1.sellMeals(meal1);
		}

		if (beerList.get(0).isExpired()) { // ���ײ��еĹ�֭���ڣ����Ƴ����ڹ�֭����ӡ����Ӧ��Ϣ��
			System.out.println("ơ���ѹ��ڣ�");
			w1.beerList.remove(0);
		} else { // ���ײ��й�֭δ���ڣ�������ײ�2��
			w1.sellMeals(meal2);
		}

		System.out.println("************************�������*****************************");

		System.out.println();
		System.out.println();
		System.out.println("************************���Թ�������ײ���δ�����ײ�*****************************");
		for (int t = 1; t <= 20; t++) {
			w1.sellMeals(meal3);
		}
		System.out.println();
		System.out.println("************************�������*****************************");
		System.out.println();
		System.out.println();

		
//	      w1.purchaseThings(new Beer("ơ��", 3, LocalDate.now(), (float) 0.05),20000,60000);   
		
		// ����20000ƿơ�ƣ�����60000Ԫ������û��ô��Ǯ,���Խ��ע���������Կ���������׳�OverdraftBalanceException
		// ��һ�Զ����쳣������ȡ���������е�ע�����Կ�Ŷ��

		
//		for(int t=1;t<=22;t++) {
//			w1.sellMeals(meal3);
//		}
		
//�������������������׳�IngredientSortOutException������ȡ��ע�����Կ�Ŷ��

	}

}
