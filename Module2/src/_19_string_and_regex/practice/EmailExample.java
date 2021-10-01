package _19_string_and_regex.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExample {
	private static Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_REGEX =   "^[A-Za-z0-9]+[A-Za-z0-9]{5,}@[A-Za-z0-9]+(\\.[A-Za-z0-9]+){1,2}$";

	public EmailExample() {
		pattern = Pattern.compile(EMAIL_REGEX);
	}

	public boolean validate(String regex) {
		matcher = pattern.matcher(regex);
		return matcher.matches();
	}
}