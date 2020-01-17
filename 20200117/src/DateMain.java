import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateMain {

	public static void main(String[] args) {
		Date date = new Date(120, 0, 17);
		System.out.println(date);
		
		Calendar c = Calendar.getInstance();
		
		System.out.println(c.get(Calendar.YEAR)+ "년\t"+(c.get(Calendar.MONTH) + 1) + "월\n");
		
		int[] months = {0, 31, 29, 31, 30, 31, 31, 30, 31, 30, 31};
		System.out.println(months[2]);// 2월
		// 프로그래밍의 편리성을 위해서 첫번째 위치에 의미없는 값을 삽입하여 인덱스와 데이터의 위치를 맞추는 경우가 있음
		
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 a h시 mm분");
		System.out.println(sdf.format(today));
	}
}
