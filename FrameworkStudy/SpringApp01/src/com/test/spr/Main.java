// Main.java
// - 클래스
// - main() 메소드가 포함된 테스트 클래스

package com.test.spr;

public class Main
{
	public static void main(String[] args)
	{
		// 스프링이 처리하고 관리하게 될 영역 ------------------------------------------
		
		// RecordImpl1(Record) 객체 생성 과정
		//-- RecordView 입장에서의 의존 객체(dependency)
		Record rec1 = new RecordImpl1();
		
		// RecordImpl2(Record) 객체 생성 과정
		//-- RecordView 입장에서의 의존 객체(dependency)
		Record rec2 = new RecordImpl2();
		
		// RecordViewImpl1(RecordView) 객체 생성 과정
		//-- Record 객체(의존 객체) 필요
		RecordView view1 = new RecordViewImpl1();
		
		// RecordViewImpl2(RecordView) 객체 생성 과정
		//-- Record 객체(의존 객체) 필요
		RecordView view2 = new RecordViewImpl2();
		
		// 의존 객체 주입(Injection)
		//-- 의존 객체 주입 방법을 사용하게 되면
		//   느슨한 결합을 구성할 수 있게 되고
		//   한 쪽의 변동 상황이 다른 한 쪽에 영향을 덜 줄 수 있게 된다.
		view2.setRecord(rec2);	//-- setter injection
								//   (setter 를 통한 주입)
		
		// ------------------------------------------ 스프링이 처리하고 관리하게 될 영역
		
		view2.input();
		view2.output();
	}
}
