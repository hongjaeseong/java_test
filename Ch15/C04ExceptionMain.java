package Ch15;

public class C04ExceptionMain {

	public static void main(String[] args) {
		try {
			String str = null;
			//str.toString();					// Null 예외발생
			
			int arr[] = {10,20,30};
			arr[5] = 100;					// Bound Exception 발생
			
			Integer.parseInt("a1234");		// Parse Exception 발생
			
			Animal animal = new Dog();
			Cat yummi = (Cat) animal;		// Cast Exception 발생
		
//		}catch(NullPointerException e) {
//			System.out.println("NULL 예외발생 처리...");
//		}catch(ArrayIndexOutOfBoundsException e2) {
//			System.out.println("Arr Bounds 예외발생 처리...");
//		}catch(NumberFormatException e3) {
//			System.out.println("Number Format Exception 예외발생 처리...");
//		}catch(ClassCastException e4) {
//			System.out.println("Class Cast Exception 예외발생 처리...");
//		}
			
		}catch(Exception e) {				// Exception e : 모든 하위 예외를 받아내겠다는 의미 (UpCasting)
			System.out.println(e);
		}finally {							// finally : 예외가 발생해도 발생하지 않아도 무조건 실행
			System.out.println("무조건 실행되는 코드");
		}
		
	}

}
