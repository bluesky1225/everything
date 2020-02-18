package web0212;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		try {
			String filePath="C:\\Users\\admin\\Desktop\\2020-02-12.log";
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
			while(true) {
				String temp = br.readLine();
				if(temp==null) break;
				System.out.println(temp);
			}
			br.close();
		} catch(Exception e) {
			
		}
	}

}
