package tw.da.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Component("logAdvice")
@Aspect
public class LogAdvice {
  @Pointcut(value = "execution(* tw.da.model.HouseService.select*(..))")
	public void pointcut1() {
		
	}
	@Before(value = "pointcut1()")
	 public void logBefore(JoinPoint point) {
		 System.out.println("before: at" + point.getTarget().getClass());
		 System.out.println("calling mthond" + point.getSignature().getName());
		 System.out.println("Using" + point.getArgs()[0]);
		 System.out.println("before: going into joinpoit : metohd");
	 }
  @Around(value = "pointcut1()")
   public Object logAround(ProceedingJoinPoint pPoint) throws Throwable {
	   System.out.println("Around at "+pPoint.getTarget().getClass());
	   System.out.println("calling mthond "+pPoint.getSignature().getName());
	   System.out.println("Using" + pPoint.getArgs()[0]);
	   Object rs = pPoint.proceed();
	   System.out.println("Around result" + rs);
	   return rs;
   }
   
  @AfterReturning(pointcut="pointcut1()",returning = "result")
   public void logAfter(JoinPoint  point,Object result) {
	   System.out.println("After:Joinpoint is finished");
	   System.out.println("After result:"+result);
   }
   @AfterThrowing(pointcut ="pointcut1()",throwing = "e" )
   public void logThrow(JoinPoint point, Throwable e) {
   	System.out.println("e:" + e);
   }
}
