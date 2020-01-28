import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HanMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				// 네이버
				// 필요한 HTML 다운로드
				String keyword=null;
				String html = null;
				int pagenum = 0;
				try {
					keyword = URLEncoder.encode("박문석", "utf-8");
					
					// 다운로드 받을 URL 생성
					// URL에 한글이 있다면 URLEncoder.encode 이용해서 인코딩 필요
					String addr = "http://search.hani.co.kr/Search?command=query&keyword="+keyword+"&media=news&submedia=&sort=d&period=all&datefrom=2000.01.01&dateto=2020.01.28&pageseq=0";
					URL url = new URL(addr);	
					
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
					System.out.println(html);
					System.out.println("html 출력");
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
					System.out.println("DOM : "+document);
					// span 태그 가져오기
					Elements total = document.getElementsByClass("total");
					//Elements span = document.select("#PM_ID_serviceNavi > li:nth-child(9) > a");
					// 가져온 데이터를 순회하면서 출력
					int cnt = 0;
					for(int i=0; i<total.size(); i++) {
						Element element = total.get(i);
						String[] temp = element.text().split(" ");
						cnt = Integer.parseInt(temp[0]);
						System.out.println("전체 기사수 : "+cnt);
					}
					
					
					
					if(cnt%10>0) {
						pagenum = cnt/10+1;
					} else {
						pagenum = cnt/10;
					}
					
					
					
				}catch(Exception e) {
					System.out.println("파싱 예외 : " + e.getMessage());
					e.printStackTrace();
				}
				
				
				String htmlPerPage = "";
				
				
				
				for (int i=0; i<pagenum; i++) { // 페이지별로 기사 목록 가져오기
					
					List<String> list = new ArrayList<String>();
					
					// 예외 발생시 특정 페이지의 데이터를 읽지 못하더라도 다음 페이지부터는 데이터를 읽을 수 있도록 반복문안에 예외처리문장 삽입
					try {
						System.out.println("i : "+i +" pagenum : "+pagenum);
						keyword = URLEncoder.encode("박문석", "utf-8");
						String addr = "http://search.hani.co.kr/Search?command=query&keyword="+keyword+"&media=news&submedia=&sort=d&period=all&datefrom=2000.01.01&dateto=2020.01.28&pageseq="+i;
						URL url = new URL(addr);
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
						
						htmlPerPage = sb.toString();
						
						Document documentPerPage = Jsoup.parse(htmlPerPage);
						
						Elements links = documentPerPage.select("dl > dt > a");
						
						for(int j=0; j<links.size(); j++) {	// 한 페이지 기사 목록의 링크만 모아서 리스트에 저장
							Element element = links.get(j);
							list.add(element.attr("href"));
							System.out.println(element.attr("href"));
						}
						
						htmlPerPage = "";
					} catch(Exception e) {
						System.out.println("링크 수집 실패 : "+e.getMessage());
						e.printStackTrace();
					}
					
					try {
						for(String addr:list) {	// 리스트에 저장한 기사 링크(url)로 연결하여 기사 내용 가져오기
							try {
								URL url = new URL(addr);
								HttpURLConnection con = (HttpURLConnection) url.openConnection();
								con.setUseCaches(false);
								con.setConnectTimeout(10000);
								
								StringBuilder sb = new StringBuilder();
								BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
								
								while(true) {
									String line = br.readLine();
									
									if(line == null) {
										break;
									}
									
									sb.append(line+"\n");
								}
								
								String html2 = sb.toString();
								br.close();
								con.disconnect();
								System.out.println(html2);								
								
								Document document = Jsoup.parse(html2);
								Elements articles = document.getElementsByClass("title");
								
								for(int j=0; j<articles.size(); j++) {
								
									PrintWriter pw = new PrintWriter(new FileOutputStream("../박문석.txt", true));
									// 두번째 인수로 true를 넣어야 append 모드가 되어 기존 파일이 있을시 덮어쓰지 않고 이어쓴다.
									pw.println(articles.get(j).text());
									pw.flush();
									
									
									pw.close();
								}
								// 실제 여러개의 페이지에서 스크래핑 할때는 딜레이를 주는 것이 좋습니다.
								// 그렇지 않으면 메모리 부족인지 프로그램이 죽을때가 있다고 함.
								// Thread.sleep(1000);
								
								
							} catch(Exception e) {
								
							}
						}
					} catch(Exception e) {
						
					}
				}
	}

}
