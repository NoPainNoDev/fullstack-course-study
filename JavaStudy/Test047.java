/*=======================================================
	 ■■■ 실행 흐름의 컨트롤 (제어문) ■■■
	 - 반복문 실습
=========================================================*/

// 1부터 100까지 정수의 합을 구하되,
// 10의 배수가 될 때 마다 ... 결과를 출력하는 프로그램을 구현한다.

// 실행 예)
// 1 ~ 10 까지의 합 : xx
// 1 ~ 20 까지의 합 : xxx
// 1 ~ 30 까지의 합 : xxx
// ...
// 1 ~ 100 까지의 합 : xxxx
// 계속하려면 아무 키나 누르세요...

public class Test047
{
	public static void main(String[] args)
	{
		int num, sum;
		num = sum = 0;

		while(++num <= 100)
		{
			sum += num;
			if(num % 10 == 0)
				System.out.printf("1 ~ %3d 까지의 합 : %d\n", num, sum);
		}
	}
}