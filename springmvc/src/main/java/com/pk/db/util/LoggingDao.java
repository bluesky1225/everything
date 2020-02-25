package com.pk.db.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
// AOP 클래스라는 어노테이션
@Aspect
public class LoggingDao {
		// 리턴타입과 매개변수는 변경할 수 없음
		
		@Around("execution(public * com.pk.db..*Dao.*(..))")
		public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
			// TODO Auto-generated method stub
			Calendar cal = new GregorianCalendar();
			Date date = new Date(cal.getTimeInMillis());
			System.out.println(date + " DB에 접근합니다");
			
			Object obj = null;
			
			try {
				// 원래 호출할 메소드
				obj= joinPoint.proceed();
			} catch(Throwable e) {
				e.printStackTrace();
			}
			
			return obj;
		}
}
