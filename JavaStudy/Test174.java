/*=======================================================
      ���� �÷��� �����ӿ�ũ(Collection Framework) ����
=========================================================*/

// Set -> HashSet, TreeSet
// - ���� ����.
// - �ߺ��� ������� �ʴ� ����(�⺻)

/*
�� TreeSet<E> Ŭ����

  java.util.TreeSet<E> Ŭ������
  Set �������̽��� ����� SortedSet �������̽��� ������ Ŭ������
  �����͸� �߰��ϸ� �����͵��� �ڵ����� �������� ������ �ȴ�.

  ��, TreeSet Ŭ������ SortedSet �������̽��� implements �� Ŭ�����̴�.
*/

// VO   ->  Value Object
// DTO  ->  Data Transfer Object
// DAO  ->  Data Asscess Object 

// VO, DTO => ������ ��Ƴ��� ������Ʈ
// DAO     => �����ͺ��̽��� ���� �����ϱ� ���� ������Ʈ

// (Program) -> (VO, DTO) ==> DAO -> (Database)

import java.util.TreeSet;
import java.util.Iterator;
import java.util.Comparator;

class GradeDTO  // GradeVO
{
	// �ֿ� �Ӽ� ����
	private String hak;			//-- �й�
	private String name;		//-- �̸�
	private int kor, eng, mat ; //-- ����, ����, ����

	// ������(����� ���� ������)
	GradeDTO(String hak, String name, int kor, int eng, int mat)
	{
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	// ������(����� ���� ������ -> �Ű����� ���� ������)
	//-- �Ű������� �����ϴ� �����ڸ� ����� ���� �����ڷ� �����Ͽ��� ������
	//   default �����ڰ� �ڵ����� ���Ե��� �ʴ� ��Ȳ�̹Ƿ�
	//   �߰��� ������ ������
	GradeDTO()
	{
		
	}

	// getter / setter ����
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

// TreeSet�� ���Ұ� ������������ �⺻ ������ �Ǿ�� �ϱ� ������
// GradeDTO Ŭ������ ��� �������� ������ �������� 
// �񱳰� �����ϰ� ����ڰ� ���� ��������� �Ѵ�.
class MyComparator<T> implements Comparator<T>
{
	// TreeSet�� �ִ� compare�� ������
	@Override
	public int compare(T o1, T o2)
	{
		GradeDTO s1 = (GradeDTO)o1;
		GradeDTO s2 = (GradeDTO)o2;

		// ���� ����(��������)
		//return s1.getTot() - s2.getTot();

		// ���� ����(��������)
		//return s2.getTot() - s1.getTot();

		// �й� ����(��������)
		//return Integer.parseInt(s1.getHak()) - 
			 //Integer.parseInt(s2.getHak());
		
		// my code
		//return s1.getHak().compareTo(s2.getHak());

		// �й� ����(��������)
		//return Integer.parseInt(s2.getHak()) - 
			 //Integer.parseInt(s1.getHak());

		// �̸� ����(��������)
		//return s1.getName().compareTo(s2.getName());
		//--==>> �й�: 2020831, �̸�: ������, ����: 98, ����: 78, ����: 88, ����: 264
		//		 �й�: 2020835, �̸�: ������, ����: 96, ����: 31, ����: 90, ����: 217
		//		 �й�: 2020824, �̸�: ���ر�, ����: 91, ����: 81, ����: 71, ����: 243
		//		 �й�: 2000883, �̸�: �����, ����: 90, ����: 80, ����: 70, ����: 240
		//		 �й�: 2020816, �̸�: �����, ����: 98, ����: 78, ����: 88, ����: 264

		// �̸� ����(��������)
		return s2.getName().compareTo(s1.getName());
		//--==>> �й�: 2020816, �̸�: �����, ����: 98, ����: 78, ����: 88, ����: 264
		//		 �й�: 2000883, �̸�: �����, ����: 90, ����: 80, ����: 70, ����: 240
		//		 �й�: 2020824, �̸�: ���ر�, ����: 91, ����: 81, ����: 71, ����: 243
		//		 �й�: 2020835, �̸�: ������, ����: 96, ����: 31, ����: 90, ����: 217
		//		 �й�: 2020831, �̸�: ������, ����: 98, ����: 78, ����: 88, ����: 264
	}
}

public class Test174
{
	public static void main(String[] args)
	{
		// TreeSet �ڷᱸ��
		TreeSet<String> set = new TreeSet<String>();

		// TreeSet �ڷᱸ�� set �� ��� �߰� -> add();
		set.add("���ǽ�");
		set.add("������");
		set.add("��ö�ǿ��ݼ���");
		set.add("�����ǰ���");
		set.add("�͸���Į��");
		set.add("�̿��������");
		set.add("����ť");
		set.add("����������");
		set.add("�Ƶ�����");

		// set ��� ��ü ��� -> Iterator Ȱ��
		Iterator<String> it = set.iterator();
		while(it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();
		//--==>> ��ö�ǿ��ݼ��� �͸���Į�� ������ ���������� �Ƶ����� ���ǽ� �̿�������� �����ǰ��� ����ť
		
		// TreeSet �ڷᱸ�� �ν��Ͻ� ����
		TreeSet<GradeDTO> set2 = new TreeSet<GradeDTO>(new MyComparator<GradeDTO>());

		//GradeDTO dto1 = new GradeDTO("2000883", "�����", 90, 80, 70);

		set2.add(new GradeDTO("2000883", "�����", 90, 80, 70));
		set2.add(new GradeDTO("2020824", "���ر�", 91, 81, 71));
		set2.add(new GradeDTO("2020831", "������", 98, 78, 88));
		set2.add(new GradeDTO("2020816", "�����", 98, 78, 88));
		set2.add(new GradeDTO("2020835", "������", 96, 31, 90));

		// Iterator�� Ȱ���� set ��� ��ü ���
		/*
		Iterator<GradeDTO> it2 = set2.iterator();
		while(it2.hasNext())
			System.out.print(it2.next() + " ");
		System.out.println();
		*/
		
		for(GradeDTO g : set2)
		{
			System.out.printf("�й�: %s, �̸�: %s, ����: %2d, ����: %2d, ����: %2d, ����: %3d\n", 
				g.getHak(), g.getName(), g.getKor(), g.getEng(), g.getMat(), g.getTot());
		}
		//--==>> �й�: 2020835, �̸�: ������, ����: 96, ����: 31, ����: 90, ����: 217
		//		 �й�: 2000883, �̸�: �����, ����: 90, ����: 80, ����: 70, ����: 240
		//		 �й�: 2020824, �̸�: ���ر�, ����: 91, ����: 81, ����: 71, ����: 243
		//		 �й�: 2020831, �̸�: ������, ����: 98, ����: 78, ����: 88, ����: 264

	}	
}