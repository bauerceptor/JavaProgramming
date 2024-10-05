package lambda_class04;

@FunctionalInterface
public interface EmailValidator {
	boolean validate(String str);
}
