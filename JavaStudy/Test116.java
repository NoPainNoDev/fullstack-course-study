/*=======================================================
      ���� Ŭ���� ���� ����
	  - ���(Inheritance)
=========================================================*/

/*
	��	���(Inheritance)�̶�
		���� ����(����)�ϰ��� �ϴ� Ŭ������
		�̹� ����Ǿ� �ִ� �ٸ� Ŭ������ ��ɰ� �ߺ��Ǵ� ���
		�̹� ����� Ŭ������ �Ϻκ��̳� ��ü ������ ������ �� �ֵ��� �ϴ� ����� �ǹ��Ѵ�.

		��, ����� ��ü�� �� �� ���� ���� �� �ִ�
		�������� ���뼺(reusability)�� Ȯ���ϰ�
		��ü���� ���踦 ���������ν�
		��ü ������ �� �ٸ� ū Ư¡�� [������]�� ������ ��밡 �ȴ�.

		����� ���� ���α׷��� Ŭ���� ������ ���������ν�
		�ߺ��� �ڵ���� ���ۼ� �� �ʿ� ����
		�ݺ����̰� �������� �۾��� ó������ �ʱ� ������
		���α׷��� �ۼ��ϴ� �ð��� ������ �� �ְ�
		���������� �����ϰ� �� �� ������,
		���α׷��� ���̵� ª������ �ȴ�.

		����, �̹� �ۼ��� ���α׷����� �ռ� �׽�Ʈ�Ǿ��� ������
		������ ���� �� �־� ���� �ۼ����� ���α׷����� ������ �� �ִ�.


	��	�����ִ� Ŭ���� -> ����ϴ� Ŭ���� -> ���� Ŭ���� -> �θ�(����) Ŭ���� -> Super Class
		�����޴� Ŭ���� -> ��ӹ޴� Ŭ���� -> ���� Ŭ���� -> �ڽ�(�ڼ�) Ŭ���� -> Sub Class


	��	������ �� 
		�ڹٴ� ��.��.��.��. �� �������� �ʱ� ������
		�� �� �̻��� Ŭ�����κ��� ����� ���� �� ����.
		�ڹٴ� ��.��.��.��. �� ���ȴ�.

*/

// �θ� Ŭ����
class SuperTest116 
{
	// [protected] : ��ӹ޴� Ŭ����, ������ ��Ű��, Ŭ���� ���ο��� ���� ����
	protected double area;
	
	// [default] : ������ ��Ű��, Ŭ���� ���ο��� ���� ����
	// �θ� Ŭ������ ������ 
	SuperTest116()
	{
		System.out.println("Super Class...");
	}

	// [default] : ������ ��Ű��, Ŭ���� ���ο��� ���� ����
	void write(String title)
	{
		System.out.println(title + " - " + area);
	}
}


// �ڽ� Ŭ����(������ ��Ű���� �����ϴ� �ڽ� Ŭ����
public class Test116 extends SuperTest116 //, SuperTest117, SuperTest118	// �츮 �θ���� SuperTest116 �̴�~!!!
{
	// �θ� Ŭ�����κ��� ��ӹ��� ����
	/*
	protected double area;

	(�����ڴ� ��ӿ��� ���ܵȴ�.)

	// write�� default ���� ���� �������̹Ƿ�
	// ���� SuperTest116�� �ڽ� Ŭ������ Test116��
	// ������ ��Ű���� �������� �ʴ´ٸ�
	// Test116�� write�� ȣ���� �� ����.
	void write(String title)
	{
		System.out.println(title + " - " + area);
	}
	*/

	//double area = 10.1234;

	// �ڽ� Ŭ������ ������
	Test116()
	{
		// �θ� Ŭ������ ������ ȣ��
		//SuperTest116();	// -> super();
		
		//Test116();		// -> this();
		
		System.out.println("Sub Class...");

		//Super Class�� �׻� ���� ��µǾ�� �Ѵ�.
		//super();
		// --==>> ���� �߻�(������ ����)
	}

	public void circle()
	{
		int r = 10;
		area = r * r * 3.141592;
		write("��");
	}

	public void rect()
	{
		int w = 20, h = 5;
		// super�� ����ϸ� �ڽ� Ŭ���� ������ �ƴ� �θ� Ŭ���� ������ �´�.
		super.area = w * h;	
		super.write("�簢��");
	}

	public static void main(String[] args)
	{
		// Test116 Ŭ����(�ڽ� Ŭ����) ��� �ν��Ͻ� ����
		Test116 ob = new Test116();
		// --==>> Super Class...
		//		  Sub Class...

		ob.circle();
		// --==>> �� - 314.1592;

		ob.rect();
		// --==>> �簢�� - 100.0


	}
}