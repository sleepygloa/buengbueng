package sample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
public class Advice {
	@Before("execution(public * test.spring.bean..*(..))")
	public void before(JoinPoint jp){
		// controller ������ request ��ü�� ȹ���Ѵ�. 
		RequestAttributes  ra = RequestContextHolder.currentRequestAttributes();
		ServletRequestAttributes sra =  (ServletRequestAttributes)ra;
		HttpServletRequest request =sra.getRequest();
		HttpSession session = request.getSession();
	}
	
	
	
	
	
	@After("execution(public * test.spring.bean..*(..))")
	public void after(){
		System.out.println("aop after");
	}
}










