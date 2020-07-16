package earthQuakeMonitor;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Earthquake class represents a template for constructing earthquakes.
 *
 * @author Gideon Bayisa
 * @version 1.0 (2019.11.10)
 */
public class MonitoringIO {

	static Monitoring monitor = new Monitoring();
	static Scanner input = new Scanner(System.in);

	/**
	 * Main method for Console input The main method uses switch cases within a
	 * do-while loop. External methods are used to present the user console and
	 * simply the structure.
	 *
	 *
	 * @param args
	 */
	public static void main(String[] args) { // throws java.io.IOException {

		int option;
		String answer;

		do {
			// user console information is printed
			InputData();
			option = input.nextInt();
			// switch case is presented with 4 options.
			switch (option) {
			// case 1 regards user input data for observatories
			case 1:

				System.out.println("Observatory");

				int observatoryYear;
				int observatoryArea;

				String observatoryName = input.nextLine();

				while (observatoryName.isEmpty()) {
					System.out.print("Nothing was entered. Please try again: ");
					observatoryName = input.nextLine();
				}

				System.out.print("Observatory Country: ");
				String observatoryCountry = input.nextLine();

				while (observatoryCountry.isEmpty()) {
					System.out.print("Nothing was entered. Please try again: ");
					observatoryCountry = input.nextLine();
				}

				do {
					System.out.print("Observatory Year: ");
					while (!input.hasNextInt()) {
						System.out.print("Please enter a correct year! ");
						input.next();
					}
					observatoryYear = input.nextInt();
				} while (observatoryYear <= 0 || observatoryYear > 2019);

				do {
					System.out.print("Observatory Area (in km^2): ");
					while (!input.hasNextInt()) {
						System.out.print("Please enter a correct Observation area! ");
						input.next();
					}
					observatoryArea = input.nextInt();
				} while (observatoryArea <= 0 || observatoryArea > 500);

				ArrayList<Earthquake> earthquakes = new ArrayList<Earthquake>();
				Observatory newObservatory = new Observatory(observatoryName, observatoryCountry, observatoryYear,
						observatoryArea, earthquakes);
				// Observatory from user input are added into the arraylist earthquakes.
				monitor.instances.add(newObservatory);

				break;

			// case 2 regards user input for earthquakes
			case 2:

				double earthquakeMagnitude;
				double earthquakeLatitude;
				double earthquakeLongitude;
				int earthquakeYear;

				System.out.println("Earthquake");
				// earthquakes need to be assigned to an observatory
				System.out.println("Which observatory would you like to add the earthquake to?");
				try {
					int n = findObservatory(); //

					do {

						System.out.print("Earthquake Magnitude: ");
						while (!input.hasNextDouble()) {
							System.out.print("That's not a number!"); // prompt if an incorrect key is input
							input.next();
						}
						earthquakeMagnitude = input.nextDouble();
					} while (earthquakeMagnitude <= 0 || earthquakeMagnitude > 10);

					do {
						System.out.print("Earthquake Latitude: ");
						while (!input.hasNextDouble()) {
							System.out.print("That's not a number! ");
							input.next();
						}
						earthquakeLatitude = input.nextDouble();
					} while (earthquakeLatitude <= -85.05115 || earthquakeLatitude > 85);

					do {
						System.out.print("Earthquake Longitude: ");
						while (!input.hasNextDouble()) {
							System.out.print("That's not a number! ");
							input.next();
						}
						earthquakeLongitude = input.nextDouble();
					} while (earthquakeLongitude <= -180 || earthquakeLongitude > 180);

					do {
						System.out.print("Earthquake Year: ");
						while (!input.hasNextInt()) {
							System.out.print("Please enter a correct year! ");
							input.next();
						}
						earthquakeYear = input.nextInt();
					} while (earthquakeYear <= 0 || earthquakeYear > 2019);

					monitor.instances.get(n).addtolistObservatory(new Earthquake(earthquakeMagnitude,
							earthquakeLatitude, earthquakeLongitude, earthquakeYear));
					// Observatory from user input are added into the arraylist instances.

				} catch (Exception e) {
				}

				break;

			case 3:
				System.out.println("Monitoring results:");
				// Case 3 offers the user the ability to print monitoring statistics.
				try {
					Observatory maxAvgQuake = monitor.largestAverageEarthquake();
					// returns the largest average earthquake recorded.
					System.out.println("Observatory with the largest average magnitude is: " + maxAvgQuake.toString());

					Earthquake bigQuake = monitor.getLargestEarthquakeEver();
					// returns the largest earthquake ever recorded.
					System.out.println("Largest earthquake ever:" + bigQuake.toString());

					System.out.println("Get Largest Earthquake with Magnitude greater than x: "); // returns the largest
																									// earthquakes with
																									// a magnitude
																									// greater than the
																									// user given filter
																									// input.
					Double answer3 = input.nextDouble();
					ArrayList<Earthquake> greaterthan = monitor.getThresholdListEarthquakes(answer3);
					System.out.println(
							"All earthquakes with magnitude greater than a given number: " + greaterthan.toString());

					System.out.println("which option would you like to chose next?");
					// InputData();
					answer = input.next();

				} catch (Exception e) {
					System.out.println("You do not have sufficient data to monitor earthquake\n"); // exception is
																									// printed if at
																									// least one
																									// earthquake and
																									// one observatory
																									// have not been
																									// created.
				}
				break;
			case 4:
				System.out.println("Exit"); // Case 4 offers the user the ability to exit the program
				break;
			default:
				System.out.println("Not a valid input choice\n");
				// default cases is if the user does not select one of the 4 predefined options.
				break;
			}

		} while (option != 4); // as long as case 4 (exit) is not chosen, the program keeps running.
		input.close(); // scanner is not closed.
	}

	/**
	 * The method takes in the parameter name from the user input. It then uses name
	 * to find the observatory with the same name. If user input does not match an
	 * existing name, a prompt requests the user to input an observatory first.
	 * 
	 * @return locInArray index location of observatory with a given name.
	 */
	private static Integer findObservatory() {

		String name;
		Integer locInArray = null;

		System.out.println("Please enter an observatory name: ");
		name = input.next();
		if (name != null) {
			locInArray = monitor.findObservatory(name);
			if (locInArray != null) {
				System.out.println(("Observatory " + name + " is found "));
			} else {
				System.out.println("Input observatory first");
			}
		} else {
			System.out.println("Input observatory name first");
		}
		return locInArray;

	}

	/**
	 * Method to present user with 4 options on the console.
	 */
	public static void InputData() {
		System.out.println("Please enter 1 to input observatory data");
		System.out.println("Please enter 2 to input earthquake data");
		System.out.println("Please enter 3 to input to produce Monitoring results");
		System.out.println("Please enter 4 to exit");
	}

}
