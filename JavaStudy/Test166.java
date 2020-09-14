/*=======================================================
      ���� �÷��� �����ӿ�ũ(Collection Framework) ����
=========================================================*/

// �˻� �� ����

import java.util.Vector;

public class Test166
{
	// ���� ���ڿ� �迭 ���� �� �ʱ�ȭ
	private static final String[] colors
		= {"����", "���", "�ʷ�", "�Ķ�", "����", "����"};

	public static void main(String[] args)
	{
		// ���� �ڷᱸ�� ����
		Vector<String> v = new Vector<String>();

		// ���� �ڷᱸ�� v�� colors �����͸� ��ҷ� �߰�
		for(String color : colors)
			v.add(color);

		// ���� �ڷᱸ�� v�� ��ü ��� ���
		System.out.print("��ü ��� ��� : ");
		for(String str : v)
			System.out.print(str + " ");
		System.out.println();
		//--==>> ��ü ��� ��� : ���� ��� �ʷ� �Ķ� ���� ����

		// ��ȫ ���� ã��
		String s1 = "��ȫ";
		int i = v.indexOf(s1);
		System.out.println(s1 + " -> index ��ġ : " + i);
		System.out.println();
		//--==>> ��ȫ -> index ��ġ : -1
		
		// ��� ���� ã��
		String s2 = "���";
		i = v.indexOf(s1);
		System.out.println(s2 + " -> index ��ġ : " + i);
		System.out.println();
		//--==>> ��� -> index ��ġ : 1

		// [v.contains(s)]
		// ���� �ڷᱸ�� v �� ã�����ϴ� s �� ���ԵǾ� �ִٸ�...
		// -> index ��ġ Ȯ��
		if(v.contains(s2))
		{
			// [v.indexOf(s)]
			// ���� �ڷᱸ�� v ���� s �� �ε��� ��ġ ��ȯ
			i = v.indexOf(s2);
			System.out.println(s2 + " -> index ��ġ : " + i);

			// �켱 ���� �ڵ带 ���� ã��...
			// ã������ �����ض�~!!!
			v.remove(i);
		}

		// ã�Ƽ� ������ �� ��ü ��� ���
		System.out.print("���� �� ��ü ��� ��� : ");
		for(String str : v)
			System.out.print(str + " ");
		System.out.println();
		//--==>> ���� �� ��ü ��� ��� : ���� �ʷ� �Ķ� ���� ����

		// �߰� �׽�Ʈ(���ǻ���)
		System.out.println(colors);
		//--==>> [Ljava.lang.String;@69930714

		System.out.println(v);
		//--==>> [����, �ʷ�, �Ķ�, ����, ����]

		// �� Ȯ�ο� ���� �����ʹ�
		//   ���� ���(������)�� �ƴϱ� ������
		//   �̸� Ȱ���Ͽ� ������ �����ϰ� ó���ؼ��� �ȵȴ�.
		//   check~!!!
	}
}