/**
 * Project: A00917368Gis
 * File: Persona.java
 * Date: May 12, 2015
 * Time: 8:03:56 PM
 */

package a00917368.data;

/**
 * @author Lize Wu A00917368
 *
 */
public class Persona {
	public static final int ATTRIBUTE_COUNT = 4;
	private int id;
	private int playerId;
	private String gameTag;
	private String platform;

	/**
	 * 
	 */
	public Persona() {
		super();

	}

	/**
	 * @param id
	 * @param playerId
	 * @param gameTag
	 * @param platform
	 */
	public Persona(int id, int playerId, String gameTag, String platform) {
		super();

		setId(id);
		setPlayerId(playerId);
		setGameTag(gameTag);
		setPlatform(platform);

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
	 * @return the playerId
	 */
	public int getPlayerId() {
		return playerId;
	}

	/**
	 * @param playerId
	 *            the playerId to set
	 */
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	/**
	 * @return the gameTag
	 */
	public String getGameTag() {
		return gameTag;
	}

	/**
	 * @param gameTag
	 *            the gameTag to set
	 */
	public void setGameTag(String gameTag) {
		this.gameTag = gameTag;
	}

	/**
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * @param platform
	 *            the platform to set
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}

}
