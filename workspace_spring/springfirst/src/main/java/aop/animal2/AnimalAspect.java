package aop.animal2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AnimalAspect { // 공통적으로 해야할 일을 작성함
	// @Pointcut과 @Before/After/Around 중 하나 필수!
	@Pointcut("execution (public String aop.animal2.*.lunch())")
	public void a() {}
	@Around("a()")
	public void around(ProceedingJoinPoint p) {
		// p.getTarget(); // aop.animal1.Dog@16진수 의 형태로 출력됨...
		System.out.println("오늘은 뭐 먹을거에요");
		try {
			String target = p.getTarget().toString(); // p.getTarget() 이 애초에 Object 이므로..
			String[] names = target.split("@")[0].split("\\."); // @ 기준으로 자르고 앞에것([0]) 뒤에것([1])이 각각 배열에 담김
			String classname = names[names.length - 1];
			Object o = p.proceed();
			System.out.println(classname + "-" + o + " 먹었군요.");
		// Dog - 사료 먹었군요.
		}catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
