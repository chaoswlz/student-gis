/**
 * Project: A00917368Gis
 * File: Scores.java
 * Date: May 12, 2015
 * Time: 8:03:08 PM
 */

package a00917368.data;

/**
 * @author Lize Wu A00917368
 *
 */
public class Score {
	public static final int ATTRIBUTE_COUNT = 3;
	private int personaId;
	private String gameId;
	private String win;

	/**
	 * 
	 */
	public Score() {
		super();
	}

	/**
	 * @param personaId
	 * @param gameId
	 * @param win
	 */
	public Score(int personaId, String gameId, String win) {
		super();
		setPersonaId(personaId);
		setGameId(gameId);
		setWin(win);
	}

	/**
	 * @return the personaId
	 */
	public int getPersonaId() {
		return personaId;
	}

	/**
	 * @param personaId
	 *            the personaId to set
	 */
	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}

	/**
	 * @return the gameId
	 */
	public String getGameId() {
		return gameId;
	}

	/**
	 * @param gameId
	 *            the gameId to set
	 */
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	/**
	 * @return the win
	 */
	public String getWin() {
		return win;
	}

	/**
	 * @param win
	 *            the win to set
	 */
	public void setWin(String win) {
		this.win = win;
	}

}
