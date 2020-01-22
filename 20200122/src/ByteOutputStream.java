import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class ByteOutputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(FileOutputStream fos = new FileOutputStream("./src/test.txt", true)) {
			System.out.print("메모를 입력하세요(x를 입력하면 종료) : ");
			Scanner sc = new Scanner(System.in);
			while(sc.hasNext()) {
				String memo = sc.nextLine();
				if(memo.contains("x")) break;
				fos.write(memo.getBytes());
				fos.flush();
			}
			sc.close();
		
			FileInputStream fis = new FileInputStream("./src/test.txt");
			BufferedInputStream bis = new BufferedInputStream(fis);
			int len = bis.available();
			byte [] b = new byte[len];
			bis.read(b);
			bis.close();
				
			for(int i=0; i<len; i++)
				System.out.print((char)b[i]);
			
		} catch(Exception e) {
			
		}
		
	}

}
