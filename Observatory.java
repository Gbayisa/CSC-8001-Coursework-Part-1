package earthQuakeMonitor;

import java.util.ArrayList;

/**
 * The Earthquake class represents a template for constructing earthquakes.
 *
 * @author Gideon Bayisa
 * @version 1.0 (2019.11.10)
 */
public class Observatory {
	// State & instance variables
	private String name;
	private String country;
	private int year;
	private int area;

	ArrayList<Earthquake> earthquakes = new ArrayList<Earthquake>();

	/**
	 *
	 * @param name        Value assigned to the name of the observatory.
	 * @param country     Value assigned to the country where observatory is
	 *                    located.
	 * @param year        Value assigned to the year the observatory started
	 *                    monitoring earthquakes.
	 * @param area        Values assigned to the area that the observatory monitors.
	 * @param earthquakes Holds an arraylist of earthquake events within the
	 *                    observatory.
	 */
	public Observatory(String name, String country, int year, int area, ArrayList<Earthquake> earthquakes) {
		this.name = name;
		this.country = country;
		this.year = year;
		this.area = area;
		this.earthquakes = earthquakes;
	}

	/**
	 *
	 * @param newEarthquake Adds an earthquake to the arraylist of earthquakes.
	 */
	public void addtolistObservatory(Earthquake newEarthquake) {
		earthquakes.add(newEarthquake);
	}

	/**
	 * Method to find the The largest magnitude earthquake recorded by the
	 * observatory.
	 *
	 * Gets the earthquake with the largest magnitude value. Compares the magnitude
	 * value of current earthquake by cycling through the arraylist of earthquakes
	 * and setting a new maximum value every time a larger earthquake is compared to
	 * the previous one.
	 *
	 * @return maximum Returns the value for the earthquake with the largest
	 *         Magnitude.
	 *
	 */
	public double getMaximumMagnitude() {
		double maximum = 0.0;

		for (int i = 0; i < earthquakes.size(); i++) {
			Earthquake earthquake = earthquakes.get(i);
			double magnitude = earthquake.getMagnitude();
			if (magnitude > maximum) {
				maximum = magnitude;
			}
		}

		return maximum;
	}

	/**
	 * Method to find the earthquake event with the largest magnitude value.
	 *
	 * Compares the magnitude value of current earthquake by cycling through the
	 * arraylist of earthquakes and setting a new maximum value every time a larger
	 * earthquake is compared to the previous one.
	 *
	 * Then assigns that value to the earthquake event.
	 *
	 * @return maxObsQuake The observatory that has the earthquake with the largest
	 *         magnitude.
	 */
	public Earthquake getMaximumEarthquake() {
		double maximum = 0.0;
		Earthquake maxObsQuake = new Earthquake(0.1, -39.813889, -73.245833, 1960); // ??????

		for (int i = 0; i < earthquakes.size(); i++) {
			Earthquake earthquake = earthquakes.get(i);
			double magnitude = earthquake.getMagnitude();

			if (magnitude > maximum) {
				maximum = magnitude;
				maxObsQuake = earthquake;
			}
		}
		return maxObsQuake;
	}

	/**
	 * Method to find The average earthquake magnitude recorded at the observatory
	 * Cycles through the arraylist of earthquakes within the observatory. Uses
	 * getMagnitude() to get the earthquake with the maximum magnitude. Then adds
	 * assignment operator magnitude to total value.
	 *
	 * @return total / earthquakes.size() The average magnitude value of earthquakes
	 *         at the observatory.
	 */

	public double getAvgMag() {
		double total = 0.0;

		for (int i = 0; i < earthquakes.size(); i++) {
			// calculating total first
			Earthquake earthquake = earthquakes.get(i);
			double magnitude = earthquake.getMagnitude();
			// calculating average next
			total += magnitude;
		}

		return total / earthquakes.size();

	}

	/**
	 * Method to list of all earthquakes recorded at the observatory with a
	 * magnitude greater than a given number. Creating a arraylist that stores
	 * earthquake with values higher than a certain value.
	 *
	 * @param filter Value assigned to the cutoff point for earthquakes under a
	 *               given magnitude.
	 * @return results list of earthquakes within the observatory with a value
	 *         greater then the filter input.
	 */

	// creating a filter to store earthquake values higher than a certain value (x)
	public ArrayList<Earthquake> getListOfAllEarthquakes(double filter) {
		ArrayList<Earthquake> results = new ArrayList<Earthquake>();
		for (int i = 0; i < earthquakes.size(); i++) {
			Earthquake earthquake = earthquakes.get(i);
			double magnitude = earthquake.getMagnitude();
			if (magnitude > filter) {
				results.add(earthquake);
			}
		}
		return results;

	}

	/**
	 *
	 * @param name Method to set the name of the observatory.
	 */
	public void setName(String name) {
		this.name = name;
	}

	public void setCountry(String name) {
		this.country = country;
	}

	/**
	 * Year is limited to an input between 0 and 2019.
	 *
	 * @param year Method to set the year that observatory began monitoring.
	 */
	public void setYear(int year) {
		if (year >= 0 && year <= 2019) {
			this.year = year;
		}
	}

	/**
	 *
	 * @param area Method to set the area of observation for earthquakes.
	 */
	public void setArea(int area) {
		this.area = area;
	}

//getters for observatories
	/**
	 *
	 * @return name Method to get the name of the Observatory
	 */
	public String getName() {
		return name;
	}

	/**
	 *
	 * @return country Method to get the country where the observatory is located.
	 */
	public String getCountry() {
		return country;
	}

	/**
	 *
	 * @return year Method to get the Year the Observatory began monitoring
	 *         earthquakes.
	 */
	public int getYear() {
		return year;
	}

	/**
	 *
	 * @return Method to get the area of observation for earthquakes.
	 */
	public int getArea() {
		return area;
	}

	/**
	 * @return String Returns a string format of observatories, with values for
	 *         name, country, year, area and arraylist of earthquakes.
	 */
	@Override
	public String toString() {
		return String.format(
				"\nObservatory name: %s; Country: %s; Year of Construction: %d; Observation Area %d; Earthquakes %s ",
				name, country, year, area, earthquakes);
	}

	public Observatory getObservatory() {
		Observatory observatory = new Observatory(name, country, year, area, earthquakes);
		return observatory;
	}
}
