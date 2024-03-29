package Ch99;					// 패키지명 : Ch99

import java.util.Scanner;		// Scanner 클래스 호출		
// java import란?
// 다른 패키지 안의 클래스를 사용하기 위해서는 클래스 이름 앞에 패키지를 붙여야 한다.
// 하지만, 다른 패키지에 속한 클래스의 이름 앞에 매번 패키지 이름을 붙이는 것은 번거로운 작업이다.
// 파일의 앞머리에 'import'를 붙여 패키지를 매번 입력하는 작업을 생략할 수 있다.
// 따라서 다른 패키지 안의 클래스르 사용할 때 클래스 이름만 적어주면 된다.
// 클래스 라이브러리의 패키지?
// java에서는 여러 유용한 클래스 라이브러리를 패키지 형태로 제공하고 있다.

public class test_star {		// 클래스명 : test_star

	public static void main(String[] args) {	// 메인메서드 영역 : 자바 가상 머신(JVM)이 프로그램을 시작하기 위해 호출하는 메서드 

// 높이 입력 별찍기 
// 높이 : n
//      *
//     ***
//    *****
//   *******
//  *********
// ***********
// 구조 분석
// i(행)		j(공백)			k(별)
// 0		0 ~ 4(n-2)-i	0 ~ 0(i*2)
// 1		0 ~ 3(n-2)-i	0 ~ 2(i*2)
// 2		0 ~ 2(n-2)-i	0 ~ 4(i*2)
// 3		0 ~ 1(n-2)-i	0 ~ 6(i*2)
// 4		0 ~ 0(n-2)-i	0 ~ 8(i*2)
// 5		0 ~ x(n-2)-i	0 ~ 10(i*2)
// ...		...				...
// n-1			
// --------------------------------------
// i=0		j=0				k=0
// i<n		j<=(n-2)-i		k<=i*2
// i++		j++				k++
		
		Scanner sc = new Scanner(System.in);	// Scanner 객체 생성 
												// System.in : 사용자로부터 입력을 받기 위한 입력 스트림.
		int n = sc.nextInt();			// int 형 입력 및 리턴 -> 변수 n에 대입
										// Scanner의 입력 메소드 : nextInt()
		sc.close();						// Scanner 닫아줌
		
		int i = 0;						// 변수 선언 및 초기화(탈출용 변수)
		int j;							// 변수 선언
		int k;							// 변수 선언
		
		while(i<n) {					// 행 반복을 위한 while문 (탈출 조건식은 상단 구조분석 참고)
			// 공백
			j = 0;						// 변수 초기화(탈출용 변수)
			while(j<=(n-2)-i) {			// 공백 반복을 위한 while문 (탈출 조건식은 상단 구조분석 참고)
				System.out.print(" ");	// 공백 찍기
				j++;					// 탈출용 증감연산
			}
			// 별
			k = 0;						// 변수 초기화(탈출용 변수)
			while(k<=i*2) {				// 별 반복을 위한 while문 (탈출 조건식은 상단 구조분석 참고)
				System.out.print("*");	// 별 찍기
				k++;					// 탈출용 증감연산
			}
			
			System.out.println();		// 한 행을 기준으로 개행
			i++;						// 탈출용 증감연산
		}
		
		
	
	}

}
