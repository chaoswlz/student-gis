/**
 * Project: A00917368Gis
 * File: Game.java
 * Date: May 12, 2015
 * Time: 7:53:14 PM
 */

package a00917368.data;

/**
 * @author Lize Wu A00917368
 *
 */
public class Game {
	public static final int ATTRIBUTE_COUNT = 3;
	private String id;
	private String name;
	private String producer;

	/**
	 * @param id
	 * @param name
	 * @param producer
	 */
	public Game(String id, String name, String producer) {
		super();
		setId(id);
		setName(name);
		setProducer(producer);

	}

	/**
	 * 
	 */
	public Game() {
		super();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the producer
	 */
	public String getProducer() {
		return producer;
	}

	/**
	 * @param producer
	 *            the producer to set
	 */
	public void setProducer(String producer) {
		this.producer = producer;
	}

}
