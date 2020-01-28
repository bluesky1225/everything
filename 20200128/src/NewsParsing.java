import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NewsParsing {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 네이버
		// 필요한 HTML 다운로드
		
		String searchWord = null; //검색어
		int pageCnt = 0; // 페이지수
		String html = null;
		try {
			// 다운로드 받을 URL 생성
			// URL에 한글이 있다면 URLEncoder.encode 이용해서 인코딩 필요
			
			System.out.print("검색어를 입력하세요 : ");
			Scanner sc = new Scanner(System.in);
			searchWord = sc.nextLine();
			
			String addr = "http://search.hani.co.kr/Search?command=query&keyword="+searchWord+"&media=news&submedia=&sort=d&period=all&datefrom=2000.01.01&dateto=2020.01.28&pageseq="+pageCnt;
			URL url = new URL(addr);
			
			System.out.println("url 객체의 클래스명은 "+url.getClass().getName());
			System.out.println("URL 클래스의 본명은 "+URL.class);
			
			// 연결
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setConnectTimeout(30000);
			con.setUseCaches(false);
			
			// 데이터를 다운로드
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			while(true) {
				String line = br.readLine();
				if(line == null) break;
				sb.append(line + "\n");
			}
			
			// 사용한 스트림 정리
			br.close();
			con.disconnect();
			
			// 데이터 확인
			html = sb.toString();
			//System.out.println(html);
			//System.out.println("html 출력");
		}catch(Exception e) {
			System.out.println("다운로드 예외 : " + e.getMessage());
			e.printStackTrace();
		}
		
		if(html == null) {
			System.out.println("다운로드 받은 문자열이 없습니다.");
			return;
		}
		
		//  HTML 파싱을 해서 원하는 자료구조 만들기
	
		try {
			// 문자열을 메모리에 DOM(Document Object Model)으로 펼치기
			Document document = Jsoup.parse(html);
			//System.out.println("DOM : "+document);
			//System.out.println("DOM 출력... html 변수와 내용이 같다. 파싱할 수 있는 상태로 만듦.");
			Elements a = document.getElementsByTag("a");
			//Elements span = document.select("#PM_ID_serviceNavi > li:nth-child(9) > a");
			// 가져온 데이터를 순회하면서 출력
			
			String[] news_urls = new String[a.size()];
			
			for(int i=0; i<a.size(); i++) {
				Element element = a.get(i);
				//System.out.println(element.text());
				news_urls[i] = element.attr("href");
				//System.out.println(news_urls[i]);
			}
			BufferedReader br2=null;
			HttpURLConnection con2=null;
			PrintWriter pw=null;
			for(String news_url:news_urls) {
				if(!news_url.contains("www")) continue;
				System.out.println(news_url);
				URL url_news = new URL(news_url);
				con2 = (HttpURLConnection)url_news.openConnection();
				con2.setConnectTimeout(30000);
				con2.setUseCaches(false);
				StringBuilder sb2 = new StringBuilder();
				br2 = new BufferedReader(new InputStreamReader(con2.getInputStream()));
				
				while(true) {
					String line2 = br2.readLine();
					if(line2 == null) break;
					sb2.append(line2 + "\n");
				}
				String html2 = sb2.toString();
				
				Document document2 = Jsoup.parse(html2);
				Elements body = document2.getElementsByTag("body");
				//Elements span = document.select("#PM_ID_serviceNavi > li:nth-child(9) > a");
				// 가져온 데이터를 순회하면서 출력
				pw = new PrintWriter(new File("../news.txt"));
				String news = "";
				for(int i=0; i<body.size(); i++) {
					Element element = body.get(i);
					news = news + element.text() + "\n";
					//System.out.println(element.text());
					
				}
				pw.write(news);
				System.out.println("ㅇㅇ");
				// 사용한 스트림 정리
				pw.close();
				br2.close();
				con2.disconnect();
			}
			
		}catch(Exception e) {
			System.out.println("파싱 예외 : " + e.getMessage());
			e.printStackTrace();
		}
	
	
	}
}
