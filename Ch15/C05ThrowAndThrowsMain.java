package Ch15;

// Throw  : 예외를 강제적으로 발생시키는 용도
// Throws : 특정한 예외 클래스의 예외처리 시점을 던져주기 위한 용도. 중앙관리를 위해 사용됨.

public class C05ThrowAndThrowsMain {

	public static void Ex1() throws NullPointerException{				// 예외처리시점: 특정한 예외 클래스를 메서드 호출시점으로 던져주기
//		try {
//			throw new NullPointerException("Ex1에서 발생시킨 NULL");		// 예외발생
			throw new ClassCastException("Ex1에서 발생시킨 NULL");
//		}catch(Exception e) {
//			System.out.println(e);
//		}
	}
	
	public static void main(String[] args) {
		System.out.println("실행코드1");
		System.out.println("실행코드2");
		try {
			Ex1();										// 예외처리시점을 메서드 호출 시점으로 넘기기
		}catch(Exception e) {
			System.out.println("Exception 처리");
		}
		
		System.out.println("실행코드3");

	}

}
