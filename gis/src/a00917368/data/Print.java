/**
 * Project: A00917368Gis
 * File: Print.java
 * Date: May 16, 2015
 * Time: 11:46:54 AM
 */

package a00917368.data;

/**
 * @author Lize Wu A00917368
 *
 */
public class Print {
	private int win;
	private int loss;
	private String gameName;
	private String gamertag;
	private String platform;
	private String result;

	/**
	 * 
	 */
	public Print() {
		super();
	}

	/**
	 * @param win
	 * @param gameName
	 * @param gamertag
	 * @param platform
	 */
	public Print(int win, int loss, String gameName, String gamertag,
			String platform) {
		super();
		setWin(win);
		setLoss(loss);
		setGameName(gameName);
		setGamertag(gamertag);
		setPlatform(platform);
		setResult(win, loss);
	}

	/**
	 * @return the loss
	 */
	public int getLoss() {
		return loss;
	}

	/**
	 * @param loss
	 *            the loss to set
	 */
	public void setLoss(int loss) {
		this.loss = loss;
	}

	/**
	 * @return the win
	 */
	public int getWin() {
		return win;
	}

	/**
	 * @param win
	 *            the win to set
	 */
	public void setWin(int win) {
		this.win = win;
	}

	/**
	 * @return the gameName
	 */
	public String getGameName() {
		return gameName;
	}

	/**
	 * @param gameName
	 *            the gameName to set
	 */
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	/**
	 * @return the gamertag
	 */
	public String getGamertag() {
		return gamertag;
	}

	/**
	 * @param gamertag
	 *            the gamertag to set
	 */
	public void setGamertag(String gamertag) {
		this.gamertag = gamertag;
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

	/**
	 * @return the Result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param platform
	 *            the platform to set
	 */
	public void setResult(int win, int loss) {
		result = String.format("%3d:%d   ", win, loss);
	}
}
