/**
 * Project: A00917368Gis
 * File: Calculator.java
 * Date: May 13, 2015
 * Time: 10:41:39 PM
 */

package a00917368.processor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import a00917368.data.Game;
import a00917368.data.Persona;
import a00917368.data.Player;
import a00917368.data.Print;
import a00917368.data.Score;
import a00917368.gis.CompareByCount;
import a00917368.gis.CompareByGame;

/**
 * @author Lize Wu A00917368
 *
 */
public class Calculator {
	private static ArrayList<Print> collect;
	private static ArrayList<Game> games;
	private static ArrayList<Player> players;
	private static ArrayList<Persona> personas;
	private static ArrayList<Score> scores;

	private static boolean total;
	private static boolean desc;
	private static boolean byGame;
	private static boolean byCount;
	private static String plat;
	private static boolean error;
	private static boolean printPlayer;
	private static int numberForEntries;

	private static Logger logger = Logger.getLogger(Calculator.class);

	public static final String SEPERATOR = "----------------------------------------------------";
	public static final String HEADER_FORMAT = "%3s:%-4s %-18s %-15s %-8s%n";
	public static final String PERSONA_FORMAT = "%s %-18s %-15s %-8s%n";
	public static final String WIN_FORMAT = "%3d:%d   ";
	public static final String FINAL_FORMAT = "%-24s %d%n";
	public static final String NUPI = "Number Picker";
	public static final String QUFI = "Quick Fingers";
	public static final String CODE = "Colour Demon";
	public static final String PLAYERHEADER_FORMAT = "%-10s %-29s %-25s %-4s %-19s %-10s%n";
	public static final String PLAYERBODY_FORMAT = "%9d  %-29s %-25s %3d  %18d %11d%n";

	/**
	 * 
	 */
	public Calculator() {
		super();
		collect = new ArrayList<Print>();
	}

	/**
	 * The report for player if there is no args
	 * 
	 * @param games
	 * @param players
	 * @param personas
	 * @param scores
	 * @return
	 */
	public static ArrayList<Print> privateWrite() {
		collect = new ArrayList<Print>();
		try{
			for (Persona persona : personas) {
				int qufiwin = 0;
				int qufiloss = 0;
				int nupiloss = 0;
				int nupiwin = 0;
				int codewin = 0;
				int codeloss = 0;
				String tag = persona.getGameTag();
				String plat = persona.getPlatform();
				for (Score score : scores) {
					if (score.getPersonaId() == persona.getId()) {
						if (score.getGameId().equalsIgnoreCase("NUPI")) {
							if (score.getWin().equalsIgnoreCase("WIN")) {
								nupiwin++;
							} else {
								nupiloss++;
							}
						} else if (score.getGameId().equalsIgnoreCase("QUFI")) {
							if (score.getWin().equalsIgnoreCase("WIN")) {
								qufiwin++;
							} else {
								qufiloss++;
							}
						} else if (score.getGameId().equalsIgnoreCase("CODE")) {
							if (score.getWin().equalsIgnoreCase("WIN")) {

								codewin++;
							} else {

								codeloss++;
							}
						}
					}
				}

				if (codeloss != 0 || codewin != 0) {
					Print print = new Print(codewin, codeloss, CODE, tag, plat);
					collect.add(print);
					numberForEntries++;
				}

				if (nupiwin != 0 || nupiloss != 0) {
					Print print = new Print(nupiwin, nupiloss, NUPI, tag, plat);
					collect.add(print);
					numberForEntries++;
				}

				if (qufiwin != 0 || qufiloss != 0) {
					Print print = new Print(qufiwin, qufiloss, QUFI, tag, plat);
					collect.add(print);
					numberForEntries++;
				}
			}

			return collect;
		}catch(NullPointerException e){
			logger.error(e.getMessage(), e);
		}
		for (Persona persona : personas) {
			int qufiwin = 0;
			int qufiloss = 0;
			int nupiloss = 0;
			int nupiwin = 0;
			int codewin = 0;
			int codeloss = 0;
			String tag = persona.getGameTag();
			String plat = persona.getPlatform();
			for (Score score : scores) {
				if (score.getPersonaId() == persona.getId()) {
					if (score.getGameId().equalsIgnoreCase("NUPI")) {
						if (score.getWin().equalsIgnoreCase("WIN")) {
							nupiwin++;
						} else {
							nupiloss++;
						}
					} else if (score.getGameId().equalsIgnoreCase("QUFI")) {
						if (score.getWin().equalsIgnoreCase("WIN")) {
							qufiwin++;
						} else {
							qufiloss++;
						}
					} else if (score.getGameId().equalsIgnoreCase("CODE")) {
						if (score.getWin().equalsIgnoreCase("WIN")) {

							codewin++;
						} else {

							codeloss++;
						}
					}
				}
			}

			if (codeloss != 0 || codewin != 0) {
				Print print = new Print(codewin, codeloss, CODE, tag, plat);
				collect.add(print);
				numberForEntries++;
			}

			if (nupiwin != 0 || nupiloss != 0) {
				Print print = new Print(nupiwin, nupiloss, NUPI, tag, plat);
				collect.add(print);
				numberForEntries++;
			}

			if (qufiwin != 0 || qufiloss != 0) {
				Print print = new Print(qufiwin, qufiloss, QUFI, tag, plat);
				collect.add(print);
				numberForEntries++;
			}
		}

		return collect;
	}

	/**
	 * print the report
	 */
	public static void write() {

		File file = new File("leaderboard_report.txt");
		PropertyConfigurator.configure("log.properties");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter writer = new FileWriter(file);
			String strH = String.format(HEADER_FORMAT, "win", "loss",
					"Game Name", "Gamertag", "Platform");
			writer.write(strH);
			writer.append(SEPERATOR + System.getProperty("line.separator"));

			for (Print print : collect) {
				String str = String.format(PERSONA_FORMAT, print.getResult(),
						print.getGameName(), print.getGamertag(),
						print.getPlatform());
				writer.append(str);

			}
			writer.append(SEPERATOR + System.getProperty("line.separator"));
			writer.flush();
			writer.close();
			printReport("leaderboard_report.txt");
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
		} catch (NullPointerException e) {
			logger.error(e.getMessage(),e);
		}
	}

	/**
	 * Get command line and know what should we do
	 * 
	 * @param args
	 */
	public static void getCommandLine(String[] args) {
		int i = 0;
		if (args != null && args.length == 1
				&& args[0].equalsIgnoreCase("players")) {
			error = false;
			printPlayer = true;
		} else {
			while ((i < args.length)
					&& (args[i].equalsIgnoreCase("total")
							|| args[i].equalsIgnoreCase("by_count")
							|| args[i].equalsIgnoreCase("desc")
							|| args[i].contains("platform=") || args[i]
								.equalsIgnoreCase("by_game"))) {
				if (args[i].equalsIgnoreCase("total")) {
					total = true;
				} else if (args[i].equalsIgnoreCase("by_game")) {
					byGame = true;
				} else if (args[i].equalsIgnoreCase("by_count")) {
					byCount = true;
				} else if (args[i].equalsIgnoreCase("desc")) {
					desc = true;
				} else if (args[i].contains("platform=")) {
					plat = args[i].substring(args[i].indexOf("=") + 1,
							args[i].length());
				}
				i++;
			}
			if (i < args.length) {
				logger.error("Unknow in put"
						+ System.getProperty("line.separator")
						+ "total        - Prints the total count of each game played"
						+ System.getProperty("line.separator")
						+ "by_game      - sorts the report by game name ascending"
						+ System.getProperty("line.separator")
						+ "by_count     - sorts the report by count name ascending"
						+ System.getProperty("line.separator")
						+ "platform=xxx - Filers the report by the platform type ascending"
						+ System.getProperty("line.separator")
						+ "desc         - Any sorted valus is sorted in a descending order");
				error = true;
			} else if (i == args.length) {
				error = false;
			}

			if (byGame == true && byCount == true) {
				error = true;
			}
		}

	}

	/**
	 * Print by the order of command line ask
	 */
	public static void printForCommandline() {
		if (!error) {
			if (!printPlayer) {
				if (plat != null) {
					ArrayList<Print> a = new ArrayList<Print>();
					for (Print print : collect) {
						if (print.getPlatform().equalsIgnoreCase(plat)) {
							a.add(print);
						}
					}
					collect.clear();
					collect.addAll(a);
				}

				if (byGame) {
					Collections.sort(collect, new CompareByGame());
				}

				if (byCount) {
					Collections.sort(collect, new CompareByCount());
				}

				if (desc) {
					Collections.reverse(collect);
				}
				if (total) {
					int nupi = 0;
					int qufi = 0;
					int code = 0;
					File file = new File("leaderboard_report.txt");
					PropertyConfigurator.configure("log.properties");
					try {
						if (!file.exists()) {
							file.createNewFile();
						}
						FileWriter writer = new FileWriter(file);
						String strH = String.format(HEADER_FORMAT, "win",
								"loss", "Game Name", "Gamertag", "Platform");
						writer.write(strH);
						writer.append(SEPERATOR
								+ System.getProperty("line.separator"));

						for (Print print : collect) {
							String str = String.format(PERSONA_FORMAT,
									print.getResult(), print.getGameName(),
									print.getGamertag(), print.getPlatform());
							writer.append(str);
						}
						writer.append(SEPERATOR
								+ System.getProperty("line.separator"));

						for (Print print : collect) {
							if (print.getGameName().equalsIgnoreCase(NUPI)) {
								nupi = nupi + print.getWin() + print.getLoss();
							} else if (print.getGameName().equalsIgnoreCase(
									QUFI)) {
								qufi = qufi + print.getWin() + print.getLoss();

							} else if (print.getGameName().equalsIgnoreCase(
									CODE)) {
								code = code + print.getWin() + print.getLoss();
							}

						}
						writer.append(String.format(FINAL_FORMAT, NUPI, nupi));
						writer.append(String.format(FINAL_FORMAT, QUFI, qufi));
						writer.append(String.format(FINAL_FORMAT, CODE, code));
						writer.append(SEPERATOR
								+ System.getProperty("line.separator"));
						writer.flush();
						writer.close();
						printReport("leaderboard_report.txt");
					} catch (IOException e) {
						logger.error(e.getMessage(),e);
					} catch (NullPointerException e) {
						logger.error(e.getMessage(),e);
					}

				} else {
					write();
				}
			} else {
				File file = new File("leaderboard_report.txt");
				PropertyConfigurator.configure("log.properties");
				try {
					if (!file.exists()) {
						file.createNewFile();
					}
					FileWriter writer = new FileWriter(file);
					writer.append(String.format(PLAYERHEADER_FORMAT,
							"Player ID", "Full name", "Email", "Age",
							"Total games played", "Total Wins"));
					writer.append(SEPERATOR + SEPERATOR
							+ System.getProperty("line.separator"));
					if (players != null) {
						Collections.reverse(players);
						for (Player player : players) {
							GregorianCalendar today = new GregorianCalendar();
							String name = player.getFirstName() + " "
									+ player.getLastName();
							int age = today.get(Calendar.YEAR)
									- player.getBirthDay().get(Calendar.YEAR);
							int win = 0;
							int gamePlayed = 0;
							for (Persona persona : personas) {
								if (persona.getPlayerId() == player.getId()) {
									for (Score score : scores) {
										if (score.getPersonaId() == persona
												.getId()) {
											gamePlayed++;
											if (score.getWin()
													.equalsIgnoreCase("WIN")) {
												win++;
											}
										}
									}
								}
							}

							writer.append(String.format(PLAYERBODY_FORMAT,
									player.getId(), name, player.getEmail(),
									age, gamePlayed, win));

						}
					}
					writer.append(SEPERATOR + SEPERATOR
							+ System.getProperty("line.separator"));
					writer.flush();
					writer.close();
					printReport("leaderboard_report.txt");
				} catch (IOException e) {
					logger.error(e.getMessage(),e);
				} catch (NullPointerException e) {
					logger.error(e.getMessage(),e);
				}
			}

		} else {
			logger.error("Some thing wrong with commandline. Try again.");

		}

	}

	public static void printReport(String fileName) {
		File file = new File(fileName);
		String str = "";
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String row = scanner.nextLine();
				str = str + System.getProperty("line.separator") + row;
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage(),e);
		} catch (NullPointerException e) {
			logger.error(e.getMessage(),e);
		}

		System.out.println(str.toString());
	}

	/**
	 * @return the games
	 */
	public ArrayList<Game> getGames() {
		return games;
	}

	/**
	 * @param games
	 *            the games to set
	 */
	public static void setGames(ArrayList<Game> games) {
		Calculator.games = games;
	}

	/**
	 * @return the players
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * @param players
	 *            the players to set
	 */
	public static void setPlayers(ArrayList<Player> players) {
		Calculator.players = players;
	}

	/**
	 * @return the personas
	 */
	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	/**
	 * @param personas
	 *            the personas to set
	 */
	public static void setPersonas(ArrayList<Persona> personas) {
		Calculator.personas = personas;
	}

	/**
	 * @return the scores
	 */
	public ArrayList<Score> getScores() {
		return scores;
	}

	/**
	 * @param scores
	 *            the scores to set
	 */
	public static void setScores(ArrayList<Score> scores) {
		Calculator.scores = scores;
	}

	/**
	 * @return the numberForEntries
	 */
	public static int getNumberForEntries() {
		return numberForEntries;
	}

}
