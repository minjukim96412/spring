// Singleton pattern (�̱��� ����)
// ��ü�� �ϳ��� ������ �ʿ䰡 ���� �� ���

public class SingletonTest {

	// 1. private static ������� ����
	private static SingletonTest obj = new SingletonTest();

	// 2. private ������ : �ܺο��� ��ü ���� �Ұ�
	private SingletonTest() {
	}

	// 3. ������� ��ü�� ��ȯ�ϴ� public �޼ҵ� ����
	public static SingletonTest getInstance() {
		return obj;
	}

}
