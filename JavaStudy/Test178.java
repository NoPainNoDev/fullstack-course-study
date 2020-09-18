/*=======================================================
      ���� �ڹ��� �⺻ �����(I/O) ����
=========================================================*/

// OutputStream �ǽ�

import java.io.OutputStream;
import java.io.IOException;

public class Test178
{
	public static void main(String[] args) throws IOException
	{
		// System.in	: �ڹ��� ǥ�� �Է� ��Ʈ��
		// System.out	: �ڹ��� ǥ�� ��� ��Ʈ��
		// System.in, out �� ��ü�� ��ü�̴�!
		OutputStream out = System.out;

		// �迭 ����
		byte[] ch = new byte[3];
		ch[0] = 65;		// A
		ch[1] = 97;		// a
		ch[2] = 122;	// z

		out.write(ch);	//-- ������ ������ ������(����)�� ��Ʈ���� ���

		out.flush();    //-- ��ϵ� ��Ʈ���� ��������(�о��) ����� ����.
						//   ������ Buffer�� Ȱ������ �ʰ� �ִ� ��Ȳ�̱� ������
						//   ������ ������ �ڵ�
						//   (Buffered �Ǿ� �ִ� ��Ʈ��(stream)�� ��� ���� �Ұ�)

		out.close();	//-- ��� ��Ʈ��(���ٱ�)�� ���� ���ҽ� �ݳ�.
						//   (out ��Ʈ����(����������) �ᰡ���� ��Ȳ)

		System.out.println("�������� �ŷڸ� ���� �ִ� ����...");
		//-- [out.close()]�� �ۼ��� ���� ��µ��� �ʴ� ����
		//   ��µǴ� ��Ʈ��(���ٱ�)�� �ݾұ� ������...
	}
}