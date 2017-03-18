/**
 * Project: A00917368Gis
 * File: Reader.java
 * Date: May 13, 2015
 * Time: 12:45:18 PM
 */

package a00917368.processor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import java.util.Scanner;

import org.apache.log4j.Logger;

import a00917368.data.Game;
import a00917368.data.Persona;
import a00917368.data.Player;
import a00917368.data.Score;
import a00917368.exception.ApplicationException;
import a00917368.gis.CompareByGamertag;

/**
 * @author Lize Wu A00917368
 *
 */
public class Reader {
	public static ArrayList<Persona> personas;
	public static ArrayList<Game> games;
	public static ArrayList<Player> players;
	public static ArrayList<Score> scores;
	public static final String RECORD_DELIMITER = ":";
	public static final String FIELD_DELIMITER = "\\|";
	private static Logger logger = Logger.getLogger(Reader.class);
	private static int numberForPersona;
	private static int numberForScores;

	/**
	 * Read from file
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String readFromFile(String fileName) {
		File file = new File(fileName);
		logger.debug("reading from " + file.getAbsolutePath());
		String str = "";
		try {
			Scanner scanner = new Scanner(file);
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				String row = scanner.nextLine();
				str = row + ":" + str;
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage(),e);
		} catch (NullPointerException e) {
			logger.error(e.getMessage(),e);
		}

		return str.toString();
	}

	/**
	 * Read the player input data.
	 * 
	 * @param data
	 *            The input data.
	 * @return An arraylist of players.
	 * @throws ApplicationException
	 */
	public static ArrayList<Player> readPlayer(String data)
			throws ApplicationException {
		String[] rows = data.split(RECORD_DELIMITER);
		players = new ArrayList<Player>();
		for (int i = 0; i < rows.length; i++) {
			String row = rows[i];
			String[] elements = row.split(FIELD_DELIMITER);
			if (elements.length != Player.ATTRIBUTE_COUNT) {
				throw new ApplicationException(String.format(
						"Expected %d but got %d: %s", Player.ATTRIBUTE_COUNT,
						elements.length, Arrays.toString(elements)));
			}
			Player player = new Player();
			int index = 0;
			player.setId(Integer.parseInt(elements[index++]));
			player.setFirstName(elements[index++]);
			player.setLastName(elements[index++]);
			String email = elements[index++];
			if (!Validator.validateEmail(email)) {
				throw new ApplicationException(String.format(
						"Invalid email: %s", email));
			}
			player.setEmail(email);

			String yyyymmdd = elements[index];
			try {
				player.setBirthDay(Integer.parseInt(yyyymmdd.substring(0, 4)),
						Integer.parseInt(yyyymmdd.substring(4, 6)) - 1,
						Integer.parseInt(yyyymmdd.substring(6, 8)));
			} catch (NumberFormatException e) {
				logger.error("Invalid date element:" + yyyymmdd,e);
			}

			players.add(player);

		}

		return players;
	}

	/**
	 * Read the score input data.
	 * 
	 * @param data
	 *            The input data.
	 * @return An arraylist of players.
	 * @throws ApplicationException
	 */
	public static ArrayList<Score> readScore(String data)
			throws ApplicationException {
		String[] rows = data.split(RECORD_DELIMITER);
		scores = new ArrayList<Score>();
		for (int i = 0; i < rows.length; i++) {
			String row = rows[i];
			String[] elements = row.split(FIELD_DELIMITER);
			if (elements.length != Score.ATTRIBUTE_COUNT) {
				throw new ApplicationException(String.format(
						"Expected %d but got %d: %s", Score.ATTRIBUTE_COUNT,
						elements.length, Arrays.toString(elements)));
			}
			Score score = new Score();
			int index = 0;
			score.setPersonaId(Integer.parseInt(elements[index++]));
			score.setGameId(elements[index++]);
			score.setWin(elements[index]);

			scores.add(score);

		}
		numberForScores = scores.size();
		return scores;
	}

	/**
	 * Read the score input data.
	 * 
	 * @param data
	 *            The input data.
	 * @return An arraylist of players.
	 * @throws ApplicationException
	 */
	public static ArrayList<Game> readGame(String data)
			throws ApplicationException {
		String[] rows = data.split(RECORD_DELIMITER);
		games = new ArrayList<Game>();
		for (int i = 0; i < rows.length; i++) {
			String row = rows[i];
			String[] elements = row.split(FIELD_DELIMITER);
			if (elements.length != Game.ATTRIBUTE_COUNT) {
				throw new ApplicationException(String.format(
						"Expected %d but got %d: %s", Game.ATTRIBUTE_COUNT,
						elements.length, Arrays.toString(elements)));
			}
			Game game = new Game();
			int index = 0;
			game.setId(elements[index++]);
			game.setName(elements[index++]);
			game.setProducer(elements[index]);

			games.add(game);

		}

		return games;
	}

	/**
	 * Read the score input data.
	 * 
	 * @param data
	 *            The input data.
	 * @return An arraylist of players.
	 * @throws ApplicationException
	 */
	public static ArrayList<Persona> readPersona(String data)
			throws ApplicationException {
		String[] rows = data.split(RECORD_DELIMITER);
		personas = new ArrayList<Persona>();
		for (int i = 0; i < rows.length; i++) {
			String row = rows[i];
			String[] elements = row.split(FIELD_DELIMITER);
			if (elements.length != Persona.ATTRIBUTE_COUNT) {
				throw new ApplicationException(String.format(
						"Expected %d but got %d: %s", Persona.ATTRIBUTE_COUNT,
						elements.length, Arrays.toString(elements)));
			}
			Persona persona = new Persona();
			int index = 0;
			persona.setId(Integer.parseInt(elements[index++]));
			persona.setPlayerId(Integer.parseInt(elements[index++]));
			persona.setGameTag(elements[index++]);
			persona.setPlatform(elements[index]);

			personas.add(persona);
			numberForPersona = personas.size();

		}
		Collections.sort(personas, new CompareByGamertag());
		numberForPersona = personas.size();
		return personas;
	}

	/**
	 * @return the numberForPersona
	 */
	public static int getNumberForPersona() {
		return numberForPersona;
	}

	/**
	 * @return the numberForScores
	 */
	public static int getNumberForScores() {
		return numberForScores;
	}

}
