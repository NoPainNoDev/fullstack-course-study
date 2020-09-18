/*=======================================================
      ���� �÷��� �����ӿ�ũ(Collection Framework) ����
=========================================================*/

// Set -> HashSet, TreeSet
// - ���� ����.
// - �ߺ��� ������� �ʴ� ����(�⺻)

/*
�� HashSet<E> Ŭ����

  java.util.HashSet<E> Ŭ������
  Set �������̽��� �����ϴ� Ŭ������
  ������ ������ �ƴ϶� ������ �������� �����ؾ� �ϴ� �ڷᱸ���̴�.
  �̷� ���� �������� �ߺ��� ������� �ʴ´�.
  ����, ����ȭ�� �������� �ʴ´�.
*/

import java.util.Set;
import java.util.HashSet;

public class Test173
{
	public static void main(String[] args)
	{	
		//Set ob = new Set();
		//Set<String> ob = new Set<String>();
		// ���� : Set�� �������̽�

		Set<String> dog = new HashSet<String>();

		// dog ��� Set �ڷᱸ���� ��� �߰�
		dog.add("��ī���ĴϿ�");
		dog.add("���޶�Ͼ�");
		dog.add("��縮Ʈ����");
		dog.add("�����ڱ�");
		dog.add("�ҵ�");

		for(String s : dog)
			System.out.print(s + " ");
		System.out.println();
		//--==>> ���޶�Ͼ� ��縮Ʈ���� �ҵ� �����ڱ� ��ī���ĴϿ�
		//-- ������ �ǹ� ���� �ڷᱸ���̱� ������
		//   ������ �Է� ���� -> �ڷᱸ���� ��� �ݳ� ����
		//   �̵��� ���� ���� ���� �����Ǿ� �ִ� ���� Ȯ��.

		// ������ ��� �߰�
		dog.add("Ǫ��");
		dog.add("��ũ���׸���");
		dog.add("��Ƽ��");
		dog.add("������");

		dog.add("��ī���ĴϿ�");
		dog.add("��ī���ĴϿ�");
		dog.add("��ī���ĴϿ�");
		dog.add("��ī���ĴϿ�");

		dog.add("�����ڱ�");
		dog.add("�����ڱ�");
		dog.add("�����ڱ�");
		dog.add("�����ڱ�");

		dog.add("������");

		dog.add("��縮Ʈ����");
		dog.add("��縮Ʈ����");
		dog.add("��縮Ʈ����");

		// �߰� �� ������ Set ���
		System.out.print("�߰� �� ������ Set : ");
		for(String s : dog)
			System.out.print(s + " ");
		System.out.println();
		//--==>>�߰� �� ������ Set : ������ ���޶�Ͼ� ��縮Ʈ���� ��ũ���׸��� Ǫ�� �ҵ� �����ڱ� ��Ƽ�� ��ī���ĴϿ�

		// �� �����Ͱ� �߰��Ǵ� ������ ������� ����� �����Ǿ� ������
		//   ���� �����Ͱ� ���� �� �ݺ� �߰��� ���(�ߺ� ������)
		//   �ϳ��� ��ȿ�� �����ͷ� �����Ǿ� �ִ� ���� Ȯ���� �� �ִ�.
		//   (�ƹ��� �߰��ص� �� ���� ��µ�)

		// �� ����, �ڷᱸ���� Ư�� �� �ߺ� �����͸� ������� �ʴ´ٰ� �ؼ� 
		//   �ߺ� �����͸� �߰��� ��� ������ �߻��ϰų� �ϴ� ���� �ƴϴ�.
	}
}