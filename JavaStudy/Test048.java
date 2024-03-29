/*=======================================================
	 ■■■ 실행 흐름의 컨트롤 (제어문) ■■■
	 - 반복문 실습
=========================================================*/

// 1/2 + 2/3 + 3/4 + 4/5 + ... + 9/10 의 연산 결과를
// 출력하는 프로그램을 구현한다.

// 실행 예)
// 연산 결과 : xxx			(<- 실수 기반 연산 결과)
// 계속하려면 아무 키나 누르세요.


//	1		2		3		4		...		9
//  |		|		|		|				|
//  n		|		|		|				|		-> n은 1 ~ 9 까지 1씩 증가
//  |		|		|		|				|		 -> n/(n+1)
//	1/2 	2/3 	3/4 	4/5     ... 	9/10
//	  |		  |		  |		  |				  |
//	  n		  |		  |		  |				  |		-> n은 2 ~ 10 까지 1씩 증가
//	  |		  |		  |		  |				  |		 -> (n-1)/n
//	  2		  3		  4		  5		...		  10

public class Test048
{
	public static void main(String[] args)
	{
		// 주요 변수 선언 및 초기화
		int n = 0;				// -- 1부터 1씩 증가하게 될 변수
		double sum = 0;			// -- 누적합을 담을 변수 (나눗셈 연산 결과 실수 형태)

		// 연산 및 처리(반복문 구성)
		while(n < 9)
		{
			// 증감식 구성
			// --최종적으로 반복문의 조건을 무너뜨리는 열쇠가 되는 구문
			n++;		// 1  2  3  4  5  6  7  8  9

			sum += (double)n/(n+1);
			// --	정수 기반 나눗셈 연산은 몫을 반환하기 때문에
			//		실수 기반 연산이 수행될 수 있도록 처리하기 위해서
			//		나눗셈 연산자를 중심으로 피연산자 중 하나를
			//		실수 형태로 만들어 준 상황.
		}
		System.out.printf("연산 결과 : %f		(<- 실수 기반 연산 결과)\n", sum);

		/*
		int num = 1;
		double sum = 0.0;

		while(num < 10)
		{
			sum += num/(double)++num;
		}

		System.out.printf("연산 결과 : %f		(<- 실수 기반 연산 결과)\n", sum);
		*/
	}
}

/*
연산 결과 : 7.071032            (<- 실수 기반 연산 결과)
계속하려면 아무 키나 누르십시오 . . .
*/