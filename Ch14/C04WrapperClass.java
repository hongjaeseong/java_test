package Ch14;

// Wrapper 클래스
// 자바의 기본 자료형을 객체 타입을 처리할 수 있도록 만든 클래스이다.
// 기본 자료형에 대응하는 클래스들이 모두 준비되어 있다.
// 각 Wrapper 클래스에는 해당 데이터 타입과 관련된 유용한 기능들이 제공된다.

public class C04WrapperClass {

	public static void main(String[] args) {
		// Boxing (기본자료형 -> Wrapper Class)
		Integer ob1 = new Integer(100);
		Integer ob2 = new Integer("100");
		Integer ob3 = Integer.valueOf("300");
		System.out.println(ob1 + ob2 + ob3);
				
		// UnBoxing
		int n1 = ob1.intValue();
		int n2 = ob2.intValue();
		int n3 = ob3.intValue();
		System.out.println(n1 + n2 + n3);
		
		// Auto Boxing
		Integer ob4 = 100;		// int 자료형 -> Integer 형
		int n4 = ob1 + ob2 + ob3;
		
		
	}

}
