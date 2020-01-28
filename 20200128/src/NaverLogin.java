import java.util.Scanner;

import javax.swing.text.Document;

import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NaverLogin {

	public static void main(String[] args) {
		// 크롬드라이버의 위치를 프로퍼티에 추가
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\chromedriver_win32\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				
				driver.get("https://nid.naver.com/nidlogin.login?mode=form&url=https%3A%2F%2Fwww.naver.com");
				
				Scanner sc = new Scanner(System.in);
				System.out.print("네이버 아이디를 입력하세요  : ");
				String id = sc.nextLine();
				System.out.print("비밀번호를 입력하세요 : ");
				String pw = sc.nextLine();
				
				driver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys(id);
				driver.findElement(By.xpath("//*[@id=\"pw\"]")).sendKeys(pw);
				driver.findElement(By.xpath("//*[@id=\"log.login\"]")).click();
				
				String html = driver.getPageSource();
				Document document = (Document) Jsoup.parse(html);
				/*
				try {
					Thread.sleep(5000);
				} catch(Exception e) {
					e.printStackTrace();
				}
				*/
				
				
				sc.close();
	}

}
