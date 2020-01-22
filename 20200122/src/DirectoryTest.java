import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;

public class DirectoryTest {
	public static void main(String[] args) {
		// 절대경로를 이용해서 파일 인스턴스 생성
		File f = new File("./log.txt");
		
		// 파일의 존재여부 확인 - 서버&클라이언트 화경에서 클라이언트에 파일 존재여부를 확인해서 다운로드
		boolean isExists = f.exists();
		System.out.println("존재여부 : "+isExists);
		
		// 파일의 마지막 수정시간 확인 - 업데이트 할때 이 시간이 서로 다르면 다운로드
		long modify = f.lastModified();
		System.out.println("존재여부 : "+modify);
		// 수정시간을 우리가 사용하는 시간으로 변경
		Date date = new Date(modify);
		System.out.println("마지막 수정시간 : "+date);
		
		
		// 파일의 크기 확인 - 업데이트 할때도 사용할수 있고 다운로드 여부를 판정하는데도 이용
		long size = f.length();
		System.out.println("크기 : "+size);
		// 파일의 크기를 알려줘서 다운로드 여부를 판단하도록 하는 경우가 있습니다.
		
		Path src = Paths.get("./log.txt");
		Path dest = Paths.get("./src/log.txt");
		
		try {
			Files.copy(src, dest);
		} catch(IOException e) {}
		
		
	}
}
