package Ch16;

// general : 일반적인, 보통의
// generic : 포괄적인, 총칭의

class 재료{
	
}

class 팥 extends 재료{
	private String material;
	
	팥(String material){
		this.material = material;
	}
	@Override
	public String toString() {
		return "팥 [material=" + material + "]";
	}
}
class 야채 extends 재료{
	@Override
	public String toString() {
		return "야채 []";
	}
}
class 슈크림 extends 재료{
	@Override
	public String toString() {
		return "슈크림 []";
	}
}
class 민초{
	@Override
	public String toString() {
		return "민초 []";
	}
}

class 호빵<T extends 재료>{					// 호빵의 재료를 제한 // T의 자료형을 제한
	private T material;						// 팥(<-T)의 객체(material) // 호빵의 재료
	
	호빵(T material){							// 팥의 객체를 받는 것
		this.material = material;
	}
	
	void showInfo() {
		System.out.println(material + "으로 만든 호빵!");
	}
}


public class C01GenericMain {

	public static void main(String[] args) {
		호빵<팥> ob1 = new 호빵<팥>(new 팥("단팥"));			// 자료형을 객체 생성 시점에서 지정
		ob1.showInfo();
		
		호빵<야채> ob2 = new 호빵<야채>(new 야채());
		ob2.showInfo();

		호빵<슈크림> ob3 = new 호빵<슈크림>(new 슈크림());
		ob3.showInfo();
		
//		호빵<민초> ob4 = new 호빵<민초>(new 민초());
//		ob4.showInfo();
		
	}

}
