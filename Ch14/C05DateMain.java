package Ch14;

import java.util.Calendar;
import java.util.Date;

// 날짜 관련 클래스


public class C05DateMain {

	public static void main(String[] args) {
		
		Date d1 = new Date();
		System.out.println("------------");
		System.out.println(d1);
		System.out.println("------------");
		System.out.println(d1.getYear());
		System.out.println("------------");
		System.out.println(d1.getMonth()+1);		// 0 : 1월
		System.out.println("------------");			// 0~6(일~토)
		System.out.println(d1.getDay());
		System.out.println("------------");
		System.out.println(d1.getHours());
		System.out.println("------------");
		System.out.println(d1.getMinutes());
		System.out.println("------------");
		System.out.println(d1.getSeconds());
		System.out.println("------------");
		System.out.println(d1.getTime());			// TimeStamp 값
		
		Calendar cal = Calendar.getInstance();		// SingleTon pattern
		System.out.println("------Calendar------");
		System.out.println(cal);
		System.out.println("------------");
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println("------------");
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println("------------");
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("------------");
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));		// 요일
																// 1~7(일~토) Ex. 수요일 : 4
		System.out.println("------------");
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("------------");
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println("------------");
		System.out.println(cal.get(Calendar.SECOND));
		
		

	}

}
