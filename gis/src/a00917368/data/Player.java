/**
 * Project: A00917368Gis
 * File: Players.java
 * Date: May 12, 2015
 * Time: 8:02:41 PM
 */

package a00917368.data;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Lize Wu A00917368
 *
 */
public class Player {
	public static final int ATTRIBUTE_COUNT = 5;
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private GregorianCalendar birthday;

	/**
	 * 
	 */
	public Player() {
		super();

	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the birthDate
	 */
	public GregorianCalendar getBirthDay() {
		return birthday;
	}

	/**
	 * Set the birthdate
	 * 
	 * @param year
	 *            the year, includes the century, ex. 1967
	 * @param month
	 *            the month - must be 0-based
	 * @param day
	 *            the day of the month - 1-based
	 */
	public void setBirthDay(int year, int month, int day) {
		birthday = new GregorianCalendar();
		birthday.set(Calendar.YEAR, year);
		birthday.set(Calendar.MONTH, month);
		birthday.set(Calendar.DAY_OF_MONTH, day);
	}

}
