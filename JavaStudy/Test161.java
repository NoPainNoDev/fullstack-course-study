/*=======================================================
      ■■■ 컬렉션 프레임워크(Collection Framework) ■■■
=========================================================*/

/*
○ 큐(Queue)

  큐(Queue)는 FIFO(First Input First Output) 구조로
  먼저 입력된 자료를 먼저 출력하며
  Queue 인터페이스를 구현한 클래스는 큐와 관련된 다양한 기능을 제공한다.

  ※ Queue 인터페이스 인스턴스를 생성하기 위해서는 
    new 연산자를 이용하여 Queue 인터페이스를 구현한(implements)
	클래스의 생성자를 호출한다.

	ex) Queue ob = new LinkedList();

○ 주요 메소드
  
  - E element()
    큐의 head 요소를 반환하며 삭제하지 않는다.

  - boolean offer(E o)
    지정된 요소를 큐에 삽입한다.
  
  - E peek()
    큐의 head 요소를 반환하고 삭제하지 않으며
	큐 자료구조가 empty 인 경우 null을 반환한다.

  - E poll()
    큐의 head 요소를 반환하고 삭제하며
	큐 자료구조가 empty 인 경우 null 을 반환한다.

  - E remove()
    큐의 head 요소를 반환하고 삭제한다.
*/

import java.util.Queue;
import java.util.LinkedList;

public class Test161
{
	public static void main(String[] args)
	{
		// Queue 자료구조 생성
		//Queue myQueue = new Queue();
		//--==>> 오류
		// 제네릭을 안정해줌
		// Queue는 인터페이스이기 때문에 자체를 인스턴스 생성 할 수 없음

		Queue<Object> myQueue = new LinkedList<Object>();

		// 데이터 준비
		String str1 = "이준구";
		String str2 = "이진주";
		String str3 = "정의진";
		String str4 = "조영욱";

		// myQueue 라는 Queue 자료구조에 데이터 추가
		myQueue.offer(str1);
		myQueue.offer(str2);
		myQueue.offer(str3);
		myQueue.offer(str4);
		
		// Queue 자료구조에서 요소를 제거하지 않고 head 요소 반환
		System.out.println("값1 : " + (String)myQueue.element());
		System.out.println("값2 : " + (String)myQueue.element());
		//--==>> 값1 : 이준구
		//		 값2 : 이준구

		System.out.println();

		String val;

		// 1
		// peek()
		//-- 큐의 head 요소 반환. 제거 안함.
		//   큐가 empty 일 경우. null 반환.
		
		/*
		while(myQueue.peek() != null)
		{
			// poll()
			//-- 큐의 head 요소 반환. 제거함.
			//   큐가 empty 일 경우. null 반환.
			val = (String)myQueue.poll();
			System.out.println("요소 : " + val);
		}
		*/
		//--==>> 요소 : 이준구
		//		 요소 : 이진주
		//		 요소 : 정의진
		//		 요소 : 조영욱

		// ( X )
		/*
		while(myQueue.poll() != null)
		{
			// poll()
			//-- 큐의 head 요소 반환. 제거함.
			//   큐가 empty 일 경우. null 반환.
			val = (String)myQueue.poll();
			System.out.println("요소 : " + val);
		}
		*/
		//--==>> 요소 : 이진주
		//		 요소 : 조영욱


		// 2
		/*
		while(true)
		{
			val = (String)myQueue.poll();

			if(val == null)
				break;
			else
				System.out.println("요소 : " + val);
		}
		System.out.println();
		*/
		//--==>> 요소 : 이준구
		//		 요소 : 이진주
		//		 요소 : 정의진
		//		 요소 : 조영욱


		// 3
		while(!myQueue.isEmpty())
		{
			val =(String)myQueue.poll();
			System.out.println("요소 : " + val);
		}
		System.out.println();
		//--==>> 요소 : 이준구
		//		 요소 : 이진주
		//		 요소 : 정의진
		//		 요소 : 조영욱
	}
}