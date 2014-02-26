package aspect;

import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import java.util.logging.Logger;

@Aspect
public class Logging {
	@Pointcut("execution(* service.LoginService.*(..))")
	private void loginService() {}

	@Pointcut("execution(* service.LoginService.authenticate(..))")
	private void auth() {}

	@Pointcut("execution(* service.LoginService.addUser(..))")
	private void reg() {}

	@Before("loginService()")
	public void logEverything(JoinPoint jp) throws Exception {
		Logger.getLogger("LoginService").severe(jp.toString());
	}

	@After("auth()")
	public void logAuth(JoinPoint jp) throws Exception {
		Logger.getLogger("LoginService").severe("authentication for " + jp.getArgs()[0].toString());
	}

	@After("reg()")
	public void logReg(JoinPoint jp) throws Exception {
		Logger.getLogger("LoginService").severe("registration of " + jp.getArgs()[0].toString());
	}
}
