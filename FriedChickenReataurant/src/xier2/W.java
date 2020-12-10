package xier2;
import java.time.LocalDate;

public class W {

	public static void main(String[] args) {
	LocalDate day1=LocalDate.parse("2020-12-01");
	LocalDate day2=LocalDate.now();
	W w1=new W();
	w1.isExpired(day1, 4);


	}
public void isExpired(LocalDate day,int preserveDays) {
		
		int days=Math.abs((int)(day.toEpochDay()-LocalDate.now().toEpochDay()));
		System.out.println(days>preserveDays?true:false);
		
	}
}
