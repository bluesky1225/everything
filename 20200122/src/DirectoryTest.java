import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;

public class DirectoryTest {
	public static void main(String[] args) {
		// �����θ� �̿��ؼ� ���� �ν��Ͻ� ����
		File f = new File("./log.txt");
		
		// ������ ���翩�� Ȯ�� - ����&Ŭ���̾�Ʈ ȭ�濡�� Ŭ���̾�Ʈ�� ���� ���翩�θ� Ȯ���ؼ� �ٿ�ε�
		boolean isExists = f.exists();
		System.out.println("���翩�� : "+isExists);
		
		// ������ ������ �����ð� Ȯ�� - ������Ʈ �Ҷ� �� �ð��� ���� �ٸ��� �ٿ�ε�
		long modify = f.lastModified();
		System.out.println("���翩�� : "+modify);
		// �����ð��� �츮�� ����ϴ� �ð����� ����
		Date date = new Date(modify);
		System.out.println("������ �����ð� : "+date);
		
		
		// ������ ũ�� Ȯ�� - ������Ʈ �Ҷ��� ����Ҽ� �ְ� �ٿ�ε� ���θ� �����ϴµ��� �̿�
		long size = f.length();
		System.out.println("ũ�� : "+size);
		// ������ ũ�⸦ �˷��༭ �ٿ�ε� ���θ� �Ǵ��ϵ��� �ϴ� ��찡 �ֽ��ϴ�.
		
		Path src = Paths.get("./log.txt");
		Path dest = Paths.get("./src/log.txt");
		
		try {
			Files.copy(src, dest);
		} catch(IOException e) {}
		
		
	}
}
