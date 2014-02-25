package validators;

import bean.LoginInfo;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginInfoValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return LoginInfo.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		LoginInfo user = (LoginInfo) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "uname", "field.required", "Required field");
		ValidationUtils.rejectIfEmpty(errors, "password", "field.required", "Required field");
	}
}
