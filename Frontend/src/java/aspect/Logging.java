package aspect;

import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
public class Logging {
	@Pointcut("execution(* service.LoginService.*(..))")
	private void loginService() {}

	@Before("loginService()")
	public void log(JoinPoint jp) throws Exception {
		Logger.getLogger("LoginService").severe(jp.toString());
	}
}
