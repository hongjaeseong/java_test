package Ch02;

public class C02음수 {

	public static void main(String[] args) {
//		컴퓨터(CPU)는 구조상 덧셈처리를 할 수 있다.(o)
//		컴퓨터(CPU)는 구조상 뺄셈처리를 할 수 있다.(x)
//		컴퓨터로 뺄셈결과를 확인 할 수 있다(o).
//		보수개념 도입 뺄셈요청시 
//
//		7-3 = 4	(3 + 7 = 10)
//		7+7 = 4	(증가하는 자리 버림)
//
//		77-32 =  45
//		77+68 =  45
//		------------
//
//		 00000101 = 5
//		 11111010 	(5에 대한 1의보수)
//		        1	(1bit)
//		+11111011 = -5	(5에 대한 2의보수)	// 가장 왼쪽 비트는 부호 비트(부호는 지원하는 공간인 경우에만 해당됨+)
//		 --------------
//		 00000000 = 0
//
//		------------
//		00000000 = 0
//		00000001 = 1
//		00000010 = 2
//		00000011 = 3
//		..
//		01111111 = 127
//		10000000 = -128 
//		10000001 = -128+1
//		10000010 = -128+2
//		10000011 = -128+3
//		..
//		11111111 = -128+127 = -1
//		00000001 = 1


		//문제
		//음수값임을 고려하여 풉니다
		//10 진수 	-> 2진수
		//111 		-> 01101111
		//-111 		-> 10010001
		//96		-> 01100000
		//-96		-> 10100000
		//31 		-> 00011111
		//-31		-> 11100001
		
		//2진수		-> 10진수
		//10101111 	-> -128 + 32 + 15
		//00110101	-> 32+16+4+1
		//11001100	-> -128+64+8+4
		//10101010	-> -128+32+8+2
		
		
		
		 
		  
		}

}
