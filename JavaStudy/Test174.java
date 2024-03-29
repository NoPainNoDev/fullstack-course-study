/*=======================================================
      ■■■ 컬렉션 프레임워크(Collection Framework) ■■■
=========================================================*/

// Set -> HashSet, TreeSet
// - 순서 없음.
// - 중복을 허용하지 않는 구조(기본)

/*
○ TreeSet<E> 클래스

  java.util.TreeSet<E> 클래스는
  Set 인터페이스를 상속한 SortedSet 인터페이스를 구현한 클래스로
  데이터를 추가하면 데이터들이 자동으로 오름차순 정렬이 된다.

  즉, TreeSet 클래스는 SortedSet 인터페이스를 implements 한 클래스이다.
*/

// VO   ->  Value Object
// DTO  ->  Data Transfer Object
// DAO  ->  Data Asscess Object 

// VO, DTO => 뭔가를 담아내는 오브젝트
// DAO     => 데이터베이스에 직접 접속하기 위한 오브젝트

// (Program) -> (VO, DTO) ==> DAO -> (Database)

import java.util.TreeSet;
import java.util.Iterator;
import java.util.Comparator;

class GradeDTO  // GradeVO
{
	// 주요 속성 구성
	private String hak;			//-- 학번
	private String name;		//-- 이름
	private int kor, eng, mat ; //-- 국어, 영어, 수학

	// 생성자(사용자 정의 생성자)
	GradeDTO(String hak, String name, int kor, int eng, int mat)
	{
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	// 생성자(사용자 정의 생성자 -> 매개변수 없는 생성자)
	//-- 매개변수가 존재하는 생성자를 사용자 정의 생상자로 구성하였기 때문에
	//   default 생성자가 자동으로 삽입되지 않는 상황이므로
	//   추가로 정의한 생성자
	GradeDTO()
	{
		
	}

	// getter / setter 구성
	String getHak(){ return hak; }
	String getName(){ return name; }
	int getKor(){ return kor; }
	int getEng(){ return eng; }
	int getMat(){ return mat; }

	int getTot()
	{
		return kor + eng + mat;
	}

	void setHak(String hak){ this.hak = hak; }
	void setName(String name){ this.name = name; }
	void setKor(int kor){ this.kor = kor; }
	void setEng(int eng){ this.eng = eng; }
	void setmat(int mat){ this.mat = mat;}
}

// TreeSet은 원소가 오름차순으로 기본 정렬이 되어야 하기 때문에
// GradeDTO 클래스를 어떠한 기준으로 정렬할 것인지를 
// 비교가 가능하게 사용자가 직접 설정해줘야 한다.
class MyComparator<T> implements Comparator<T>
{
	// TreeSet에 있는 compare를 재정의
	@Override
	public int compare(T o1, T o2)
	{
		GradeDTO s1 = (GradeDTO)o1;
		GradeDTO s2 = (GradeDTO)o2;

		// 총점 기준(오름차순)
		//return s1.getTot() - s2.getTot();

		// 총점 기준(내림차순)
		//return s2.getTot() - s1.getTot();

		// 학번 기준(오름차순)
		//return Integer.parseInt(s1.getHak()) - 
			 //Integer.parseInt(s2.getHak());
		
		// my code
		//return s1.getHak().compareTo(s2.getHak());

		// 학번 기준(내림차순)
		//return Integer.parseInt(s2.getHak()) - 
			 //Integer.parseInt(s1.getHak());

		// 이름 기준(오름차순)
		//return s1.getName().compareTo(s2.getName());
		//--==>> 학번: 2020831, 이름: 백해진, 국어: 98, 영어: 78, 수학: 88, 총점: 264
		//		 학번: 2020835, 이름: 안혜지, 국어: 96, 영어: 31, 수학: 90, 총점: 217
		//		 학번: 2020824, 이름: 이준구, 국어: 91, 영어: 81, 수학: 71, 총점: 243
		//		 학번: 2000883, 이름: 주재완, 국어: 90, 영어: 80, 수학: 70, 총점: 240
		//		 학번: 2020816, 이름: 허수민, 국어: 98, 영어: 78, 수학: 88, 총점: 264

		// 이름 기준(내림차순)
		return s2.getName().compareTo(s1.getName());
		//--==>> 학번: 2020816, 이름: 허수민, 국어: 98, 영어: 78, 수학: 88, 총점: 264
		//		 학번: 2000883, 이름: 주재완, 국어: 90, 영어: 80, 수학: 70, 총점: 240
		//		 학번: 2020824, 이름: 이준구, 국어: 91, 영어: 81, 수학: 71, 총점: 243
		//		 학번: 2020835, 이름: 안혜지, 국어: 96, 영어: 31, 수학: 90, 총점: 217
		//		 학번: 2020831, 이름: 백해진, 국어: 98, 영어: 78, 수학: 88, 총점: 264
	}
}

public class Test174
{
	public static void main(String[] args)
	{
		// TreeSet 자료구조
		TreeSet<String> set = new TreeSet<String>();

		// TreeSet 자료구조 set 에 요소 추가 -> add();
		set.add("원피스");
		set.add("나루토");
		set.add("강철의연금술사");
		set.add("진격의거인");
		set.add("귀멸의칼날");
		set.add("이웃집토토로");
		set.add("하이큐");
		set.add("슈가슈가룬");
		set.add("아따맘마");

		// set 요소 전체 출력 -> Iterator 활용
		Iterator<String> it = set.iterator();
		while(it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();
		//--==>> 강철의연금술사 귀멸의칼날 나루토 슈가슈가룬 아따맘마 원피스 이웃집토토로 진격의거인 하이큐
		
		// TreeSet 자료구조 인스턴스 생성
		TreeSet<GradeDTO> set2 = new TreeSet<GradeDTO>(new MyComparator<GradeDTO>());

		//GradeDTO dto1 = new GradeDTO("2000883", "주재완", 90, 80, 70);

		set2.add(new GradeDTO("2000883", "주재완", 90, 80, 70));
		set2.add(new GradeDTO("2020824", "이준구", 91, 81, 71));
		set2.add(new GradeDTO("2020831", "백해진", 98, 78, 88));
		set2.add(new GradeDTO("2020816", "허수민", 98, 78, 88));
		set2.add(new GradeDTO("2020835", "안혜지", 96, 31, 90));

		// Iterator를 활용한 set 요소 전체 출력
		/*
		Iterator<GradeDTO> it2 = set2.iterator();
		while(it2.hasNext())
			System.out.print(it2.next() + " ");
		System.out.println();
		*/
		
		for(GradeDTO g : set2)
		{
			System.out.printf("학번: %s, 이름: %s, 국어: %2d, 영어: %2d, 수학: %2d, 총점: %3d\n", 
				g.getHak(), g.getName(), g.getKor(), g.getEng(), g.getMat(), g.getTot());
		}
		//--==>> 학번: 2020835, 이름: 안혜지, 국어: 96, 영어: 31, 수학: 90, 총점: 217
		//		 학번: 2000883, 이름: 주재완, 국어: 90, 영어: 80, 수학: 70, 총점: 240
		//		 학번: 2020824, 이름: 이준구, 국어: 91, 영어: 81, 수학: 71, 총점: 243
		//		 학번: 2020831, 이름: 백해진, 국어: 98, 영어: 78, 수학: 88, 총점: 264

	}	
}