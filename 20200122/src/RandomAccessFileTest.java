import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(
				RandomAccessFile raf = new RandomAccessFile("../test.txt", "rw")
		) 
		{
			String msg = "Hello Random Access File";
			
			raf.write(msg.getBytes());
			
			raf.seek(0);
			byte[] b = new byte[5]; 
			raf.read(b);
			System.out.println(new String(b));
			
			b = new byte[5]; 
			raf.read(b);
			System.out.println(new String(b));
			
			raf.seek(0);
			b = new byte[5]; 
			raf.read(b);
			System.out.println(new String(b));
		} catch(Exception e) {
			System.out.println("¿¹¿Ü: " +e.getMessage());
		}
	}

}
