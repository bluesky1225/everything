import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class BufferInputOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(PrintStream ps = new PrintStream(new FileOutputStream("./src/log.txt"));
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream("./src/log.txt"));
		) 
		{
			//기록하기
			ps.println("Hello Buffered Stream 안녕");
			ps.flush();
			
			// 읽기
			int len = bis.available();
			byte [] b = new byte[len];
			bis.read(b);
			System.out.println(new String(b));
		}catch(IOException e) {
			System.out.println("예외:"+e.getStackTrace());
		}
	}
	
}
