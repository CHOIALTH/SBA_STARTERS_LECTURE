package aop2;

import java.sql.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class Common {
	@Pointcut("execution (* aop2.*.*(..))")
	public void pc(){
		/*aop 실제 동작시 타겟메소드 자동 포함*/
	}
	
	long start = 0;
	
	// @Before("pc()")
	public void a() {
		start = System.currentTimeMillis();
		System.out.println("===> a메서드는 핵심관심 이전에 호출 : "  
		+ new Date(start));
	}
	
	// @After("pc()")
	public void b() {
		System.out.println("===> b메서드는 핵심관심 이후에 호출 : " 
		+ (System.currentTimeMillis() - start) + " 소요시간(1/1000초)"); 
	}
	@Around("pc()")
	public void c(ProceedingJoinPoint joinpoint) {
		// 메서드 실행 이전 + 실행 이후 모두 실행할 메서드 c
		try {
		System.out.println("===> c메서드는 핵심관심 이전에 호출 : "); 
		System.out.println("타겟클래스객체 = " + 	joinpoint.getTarget());
		System.out.println("타겟메소드 = " + 	joinpoint.toLongString());
		Object [] args = joinpoint.getArgs();
		for(Object o : args) {
			System.out.println("매개변수 = " + o);
		}
		Object returnVal = joinpoint.proceed();
		if(returnVal != null) {
			System.out.println("리턴값 = " + returnVal);			
		}
		System.out.println("===> c메서드는 핵심관심 이후에 호출 : "); 
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}
	// void a end
}
/*
 * aop1패키지 모든 클래스 모든 메서드 실행 이전 a 메서드 실행 구성 - spring xml/@ 
 * in xml : 
 * 	<bean id="common" class="aop1.Common" />
 * 	<aop:config> 
 * 		<aop:pointcut expression="( * aop1.*.*(..))">
 *		<aop:aspect id="aopaspect" ref="common" /> 			
 * 		<aop:before method="a" pointcut-ref="pc"/>
 * 	</aop:config>
 * */
