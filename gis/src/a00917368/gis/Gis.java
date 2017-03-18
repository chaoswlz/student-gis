/**
 * Project: A00917368Gis
 * File: Gis.java
 * Date: May 12, 2015
 * Time: 8:10:56 PM
 */

package a00917368.gis;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import a00917368.data.Game;
import a00917368.data.Persona;
import a00917368.data.Player;
import a00917368.data.Score;
import a00917368.exception.ApplicationException;
import a00917368.processor.Calculator;
import a00917368.processor.Reader;

/**
 * @author Lize Wu A00917368
 *
 */
public class Gis {
	private static Logger logger = Logger.getLogger(Gis.class);
	private String game;
	private String player;
	private String persona;
	private String score;
	private static ArrayList<Game> games;
	private static ArrayList<Player> players;
	private static ArrayList<Persona> personas;
	private static ArrayList<Score> scores;
	final static DateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PropertyConfigurator.configure("log.properties");
		GregorianCalendar begin = new GregorianCalendar();
		logger.info(dateFormat.format(begin.getTime()));
		logger.info("Created Gis");
		String strPlayer = null;
		String strGame = null;
		String strScore = null;
		String strPersona = null;
		strPlayer = Reader.readFromFile("players.dat");
		if (strPlayer.isEmpty() || strPlayer == null) {
			logger.error("Input data is missing. Expecting player data.");
			System.exit(-1);
		}

		strGame = Reader.readFromFile("games.dat");
		if (strGame.isEmpty() || strGame == null) {
			logger.error("Input data is missing. Expecting game data.");
			System.exit(-1);
		}
		strScore = Reader.readFromFile("scores.dat");
		if (strScore.isEmpty() || strScore == null) {
			logger.error("Input data is missing. Expecting score data.");
			System.exit(-1);
		}
		strPersona = Reader.readFromFile("personas.dat");
		if (strPersona.isEmpty() || strPersona == null) {
			logger.error("Input data is missing. Expecting persona data.");
			System.exit(-1);
		}
		new Gis(strPlayer, strGame, strScore, strPersona).start();
		if (args == null || args.length == 0) {
			logger.debug("Added " + Reader.getNumberForScores() + " Scores to "
					+ Reader.getNumberForPersona() + " personas");
			Calculator.setGames(games);
			Calculator.setPersonas(personas);
			Calculator.setPlayers(players);
			Calculator.setScores(scores);
			Calculator.privateWrite();
			logger.debug("Leaderboard has " + Calculator.getNumberForEntries()
					+ " entries");
			Calculator.write();
		} else {
			Calculator.setGames(games);
			Calculator.setPersonas(personas);
			Calculator.setPlayers(players);
			Calculator.setScores(scores);
			Calculator.privateWrite();
			Calculator.getCommandLine(args);
			Calculator.printForCommandline();
		}
		GregorianCalendar end = new GregorianCalendar();
		logger.info(dateFormat.format(end.getTime()));
	}

	public Gis(String player, String game, String score, String persona) {
		this.player = player;
		this.game = game;
		this.score = score;
		this.persona = persona;
	}

	/**
	 * Populate the players and print them out.
	 */
	private void start() {
		try {
			loadPlayers();
		} catch (ApplicationException e) {
			logger.error(e.getMessage(),e);
		}
	}

	/**
	 * 
	 * @throws ApplicationException
	 */
	private void loadPlayers() throws ApplicationException {
		players = Reader.readPlayer(player);
		scores = Reader.readScore(score);
		games = Reader.readGame(game);
		personas = Reader.readPersona(persona);

	}

}
