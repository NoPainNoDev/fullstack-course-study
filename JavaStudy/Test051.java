/*=======================================================
	 ■■■ 실행 흐름의 컨트롤 (제어문) ■■■
	 - 반복문 실습
=========================================================*/

// 사용자로부터 임의의 두 정수를 입력받아
// 작은 수 부터 큰 수 까지의 합을 구하여
// 결과를 출력하는 프로그램을 구현한다.

// 실행 예)
// 첫 번째 정수 입력 : 10
// 두 번째 정수 입력 : 20
// >> 10 ~ 20 까지의 합 : xxxx
// 계속하려면 아무 키나 누르세요...

// 첫 번째 정수 입력 : 10
// 두 번째 정수 입력 : 2
// >> 2 ~ 10 까지의 합 : 54
// 계속하려면 아무 키나 누르세요...

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test051
{
	public static void main(String[] args) throws IOException
	{
		// teacher's code

		// 주요 변수 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n;				// -- 루프 변수로 활용할 변수
		int su1, su2;		// -- 첫 번째, 두 번째 입력값
		int result = 0;		// -- 누적합

		// 값을 입력 받음
		System.out.print("첫 번째 정수 입력 : ");
		su1 = Integer.parseInt(br.readLine());

		System.out.print("두 번째 정수 입력 : ");
		su2 = Integer.parseInt(br.readLine());

		// 입력받은 두 수의 크기 비교 및 자리 바꿈
		// 즉, su1이 su2보다 큰 경우 두 수의 자리를 바꿀 수 있도록 처리
		if(su1 > su2)
		{
			// 자리 바꿈
			su1 = su1 ^ su2;
			su2 = su1 ^ su2;
			su1 = su1 ^ su2;
		}

		// 반복 연산 수행
		// 반복 연산을 수행하기 전에
		// 작은 수를 따로 저장하여 루프 변수로 활용한다.
		// (이유는... 결과를 출력해 주는 과정에서 작은 수가 필요한데...
		//  직접 이 수를 증가시켜 나갈 경우 ... 최종 결과 출력이 불가능하기 때문에...)
		n = su1;

		while(n <= su2)
		{
			result += n;
			n++;
		}
	
		System.out.printf(">> %d ~ %d 까지의 합 : %d\n", su1, su2, result);


		// my code
		
		/*
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		int min, max;
		
		System.out.print("첫 번째 정수 입력 : ");
		min = Integer.parseInt(br.readLine());

		System.out.print("두 번째 정수 입력 : ");
		max = Integer.parseInt(br.readLine());

		if(min > max)
		{
			min = min ^ max;
			max = min ^ max;
			min = min ^ max;
		}
			
		
		// 1
		int num = min, sum = 0;
		
		while(num <= max)
		{
			sum += num;
			++num;
		}
		
		System.out.printf(">> %d ~ %d 까지의 합 : %d\n", min, max, sum);
		/*
		// 2 
		int numMin = min, numMax = max, sum = 0;
		while(numMin < numMax)
		{
			sum += (numMin++) + (numMax--);
		}

		System.out.printf(">> %d ~ %d 까지의 합 : %d\n", min, max, sum);
		*/

		/*
		//3
		int num = min + max, sum = 0;
		int count = (max - min + 1);
		sum = num * (count / 2) + (count % 2 == 0 ? 0 : num / 2);

		System.out.printf(">> %d ~ %d 까지의 합 : %d\n", min, max, sum);
		*/		
	}
}