package earthQuakeMonitor;

import java.util.ArrayList;

/**
* The Earthquake class represents a template for constructing earthquakes.
*
* @author Gideon Bayisa
* @version 1.0 (2019.11.10)
*/

/**
 * Constructor for objects of class Monitoring
 */
public class Monitoring {
	// creating instances of monitoring class
	ArrayList<Observatory> instances = new ArrayList<Observatory>();

	/**
	 *
	 * @return An arraylist of observatories.
	 */
	public ArrayList<Observatory> getInstances() {
		return instances;
	}

	/**
	 * This method is responsible of finding an observatory in the arraylist of
	 * observatory instances based on the parameter name It returns the index of the
	 * observatory with a given name, within the arraylist.
	 * 
	 * @param name indicates the parameter name of the observatory.
	 * @return index Index within the arraylist.
	 */
	public Integer findObservatory(String name) {

		Integer index = null;
		for (int i = 0; i < instances.size(); i++) {
			if (instances.get(i).getName().equals(name)) {
				index = i;
				break;
			}
		}
		return index;
	}

//The observatory with the largest average earthquake magnitude
	/**
	 * Method to find the observatory with the largest average earthquake magnitude.
	 *
	 * Cycles through the arraylist of observatories and uses the getAvgMag() method
	 * to get the largest average Magnitude from the arraylist of earthquakes .
	 *
	 * @return instances.get(maxObs) the details corresponding to the observatory
	 *         with the largest average earthquake within the arraylist of
	 *         observatories.
	 */
	public Observatory largestAverageEarthquake() {
		double maxAvg = 0.0;
		double avg;
		int maxObs = 0;

		for (int i = 0; i < instances.size(); i++) {
			avg = instances.get(i).getAvgMag();
			if (avg > maxAvg) {
				maxAvg = avg;
				maxObs = i;
			}
		}

		return instances.get(maxObs);
	}

	/**
	 * Method to find the observatory with the largest earthquake ever recorded.
	 *
	 * Cycles through the arraylist of observatories and uses the
	 * getMaximumMagnitude() method to get the earthquake with the largest Magnitude
	 * from the arraylist of earthquakes.
	 *
	 * Compares the magnitude value of current earthquake to the maximum magnitude
	 * currently found and continually cycles through the arraylist of earthquakes
	 * and setting a new maximum value every time a larger earthquake event is
	 * found.
	 *
	 * Then assigns that value to the earthquake event.
	 *
	 * @return maxQuake Earthquake event with the largest value found from the
	 *         arraylist of observatories.
	 */

	// The largest magnitude earthquake ever recorded.
	public Earthquake getLargestEarthquakeEver() {
		Earthquake maxQuake = null;
		double maxMag = 0.0;
		double mag = 0.0;

		/**
		 * Store the largest earthquake object. For each earthquake in the list, compare
		 * to current largest. If bigger, replace, else carry on
		 */

		for (int i = 0; i < instances.size(); i++) {
			Observatory observatory = instances.get(i);
			Earthquake reading = observatory.getMaximumEarthquake();
			mag = instances.get(i).getMaximumMagnitude();
			if (mag > maxMag) {
				maxMag = mag;
				maxQuake = reading;
			}
		}
		return maxQuake;
	}

	/**
	 * Method to list of all earthquakes recorded at the observatory with a
	 * magnitude greater than a given number. Creating a filter that stores
	 * earthquake with values higher than a certain value.
	 *
	 * @param filter Value assigned to the cutoff point for earthquakes under a
	 *               given magnitude.
	 * @return ledger Arraylist of earthquakes with a magnitude greater than a given
	 *         number.
	 */

	// A list of all earthquakes recorded with magnitude greater than a given number
	public ArrayList<Earthquake> getThresholdListEarthquakes(double filter) {

		// Initialize values
		ArrayList<Earthquake> ledger = new ArrayList<Earthquake>();

		for (int i = 0; i < instances.size(); i++) { // instance.size is number of observatories
			Observatory observatory = instances.get(i);
			for (int j = 0; j < observatory.getListOfAllEarthquakes(filter).size(); j++) {
				// number of earthquakes within observatory, which are larger than filter
				Earthquake earthquake = observatory.getListOfAllEarthquakes(filter).get(j);
				ledger.add(earthquake);
			}
		}
		return ledger;
	}

}
