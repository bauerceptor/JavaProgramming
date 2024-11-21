package class04_lambda;

@FunctionalInterface
public interface EmailValidator {
	boolean validate(String str);
}
