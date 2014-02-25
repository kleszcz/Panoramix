package aspect;

import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;

@Aspect
public class Logging {
	@Pointcut("execution(* service.LoginService.*(..))")
	private void allServices() {}

	@Before("allServices()")
	public void log(JoinPoint jp) throws Exception {
		System.out.println(jp.getSignature());
	}
}
