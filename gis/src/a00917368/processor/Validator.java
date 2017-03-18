/**
 * Project: A00917368lab4
 * File: Validator.java
 * Date: Apr 29, 2015
 * Time: 5:04:38 PM
 */

package a00917368.processor;

import java.util.regex.Pattern;

/**
 * @author Lize Wu A00917368
 *
 */
public class Validator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

	private Validator() {
	}

	/**
	 * Validate an email string.
	 * 
	 * @param email
	 *            the email string.
	 * @return true if the email address is valid, false otherwise.
	 */
	public static boolean validateEmail(final String email) {
		return pattern.matcher(email).matches();
	}

}
