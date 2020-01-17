import java.io.*;
import java.util.Properties;

public class PropertiesMain {
	public static void main(String[] args) {
		
		
		Properties props = new Properties();
		
		props.setProperty("name", "베르캄프");
		
		System.out.println(props.getProperty("name"));
		FileInputStream fis=null;
		File f = new File("temp.xml");
		FileReader fr = null;
		try {
			FileOutputStream fos = new FileOutputStream("./temp.xml");
			props.storeToXML(fos, "test");
			fis = new FileInputStream(f.getPath());
			fr = new FileReader(f);
			char[] temp = new char[10];
			while(temp!=null) {
				fr.read(temp);
				System.out.print(temp);
			}
			fr.close();
			fis.close();
			fos.close();
		} catch (Exception e) {
			
		} finally {
			
		}
	}
}
