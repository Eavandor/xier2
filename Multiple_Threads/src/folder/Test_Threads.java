package folder;
import java.util.Scanner;
public class Test_Threads {
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		int targ = sc.nextInt();
		sc.close();

		String target = "" + targ;
		Thread t[] = new Thread[1000];
		for (int i = 0; i < t.length; i++) {

			t[i] = new Thread(new Thread_To_Sum(1000000 * i, 1000000 * i + 999999, target, i));

			t[i].start();

		}

		try {
			Thread t4 = new Thread(new Thread_To_Sum(1, 10, "", 9) { // ��t4�߳���ʹ����������дrun(),��ʵ�ֲ�ͬ���ܡ���
				public void run() {
					while (true) {
						if (isFinished(t) == false) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {

							}
						} else {

							long s[] = Thread_To_Sum.sums;
							long c2 = 0;
							for (long g : s) {
								c2 += g;
							}
							System.out.println(c2);
							break;
						}
					}

				}
			}, "t4");
			t4.setPriority(1); //��t4����ܽ����ǰ�������̵߳ķ����̣߳����ִ�С�
			t4.start();
			
		} catch (Exception e) {

		}
	}

}
