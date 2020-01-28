import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MacroTest {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\chromedriver_win32\\chromedriver.exe");
		// 크롬 실행
		WebDriver driver = new ChromeDriver();
		/*
		driver.get("https://logins.daum.net/accounts/signinform.do?url=https%3A%2F%2Fwww.daum.net%2F");
		
		// ggangpae1 / wnddkd1969
		Scanner sc = new Scanner(System.in);
		System.out.print("다음 아이디를 입력하세요  : ");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력하세요 : ");
		String pw = sc.nextLine();
		String title = "매크로 테스트";
		String content = "글내용";
		driver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys(id);
		driver.findElement(By.xpath("//*[@id=\"inputPwd\"]")).sendKeys(pw);
		driver.findElement(By.xpath("//*[@id=\"loginBtn\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"gnbServiceList\"]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"home_top\"]/ul/li[1]/a/div/div[2]/div/div/strong")).click();
		driver.findElement(By.xpath("//*[@id=\"cafe_write_article_btn\"]/img")).click();
		driver.findElement(By.xpath("//*[@id=\"subject\"]")).sendKeys(title);
		driver.findElement(By.xpath("/html/body")).sendKeys(content);
		driver.findElement(By.xpath("//*[@id=\"board_select\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"board_select\"]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"primaryContent\"]/table/tbody/tr[2]/td[2]/div/div[2]/span[1]/a[2]/span[2]")).click();
		*/
		
		driver.get("https://logins.daum.net/accounts/signinform.do?url=http%3A%2F%2Fcafe.daum.net%2F_c21_%2Fhome%3Fgrpid%3D10bQ");
		
		// ggangpae1 / wnddkd1969
		Scanner sc = new Scanner(System.in);
		System.out.print("다음 아이디를 입력하세요  : ");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력하세요 : ");
		String pw = sc.nextLine();
		String title = "매크로 테스트";
		String content = "글내용";
		driver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys(id);
		driver.findElement(By.xpath("//*[@id=\"inputPwd\"]")).sendKeys(pw);
		driver.findElement(By.xpath("//*[@id=\"loginBtn\"]")).click();
		
		driver.switchTo().frame(driver.findElement(By.id("down")));
		
		driver.findElement(By.xpath("//*[@id=\"memoForm__memo\"]/div/table/tbody/tr[1]/td[1]/div/textarea")).click();
		driver.findElement(By.xpath("//*[@id=\"memoForm__memo\"]/div/table/tbody/tr[1]/td[1]/div/textarea")).sendKeys(title);
		driver.findElement(By.xpath("//*[@id=\"memoForm__memo\"]/div/table/tbody/tr[1]/td[2]/a[1]/span[2]")).click();
		
		
		try {
			Thread.sleep(5000);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		sc.close();
		
		
	}
}
