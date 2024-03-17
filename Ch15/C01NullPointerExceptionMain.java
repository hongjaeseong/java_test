package Ch15;

// 예외처리는 프로그램의 실행 중지를 방지하는 것이 Point!

public class C01NullPointerExceptionMain {

	public static void main(String[] args) {

		try {
			String str = null;
			System.out.println(str.toString());		// 예외객체 생성
		}catch(NullPointerException e) {			// 예외객체와 연결
//			System.out.println("예외발생!" + e);
//			System.out.println(e.getCause());
//			System.out.println(e.toString());
//			System.out.println(e.getStackTrace());
			e.printStackTrace();					// 관련 이슈 찾아보기
		}
		System.out.println("HELLOWORLD");
		
		
	}

}
