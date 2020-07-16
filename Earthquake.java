package earthQuakeMonitor;

/**
 * The Earthquake class represents a template for constructing earthquakes.
 *
 * @author Gideon Bayisa
 * @version 1.0 (2019.11.10)
 */

public class Earthquake {

	private double magnitude; // the registered magnitude of the event
	private double latitude; // the latitude location of the event
	private double longitude; // longitude location of the event
	private int year; // year of the event

	/**
	 *
	 * @param magnitude Value assigned to the magnitude of the earthquake.
	 * @param latitude  Value assigned to the latitude position of the earthquake.
	 * @param longitude Value assigned to the longitude position of the earthquake.
	 * @param year      Value assigned to the year of the earthquake event.
	 */
	public Earthquake(double magnitude, double latitude, double longitude, int year) {
		this.magnitude = magnitude;
		this.latitude = latitude;
		this.longitude = longitude;
		this.year = year;
	}

	/**
	 *
	 * @param magnitude Sets the value of the earthquake magnitude.
	 */
	public void setMagnitude(double magnitude) { // local variable
		if (magnitude > 0.0 && magnitude <= 10.0) {
			this.magnitude = magnitude;
		}
	}

	/**
	 *
	 * @param latitude Sets the value of the earthquake latitude.
	 */
	public void setLatitude(double latitude) { // local variable
		if (latitude >= -85.05115 && latitude <= 85.0) {
			this.latitude = latitude;
		}
	}

	/**
	 *
	 * @param longitude Sets the value of the earthquake Longitude.
	 */
	public void setLongitude(double longitude) { // local variable
		if (longitude >= -180.0 && longitude <= 180) {
			this.longitude = longitude;
		}
	}

	/**
	 *
	 * @param year Sets the value of the earthquake year.
	 */
	public void setYear(int year) { // local variable
		if (year >= 0 && year <= 2019) {
			this.year = year;
		}
	}

	/**
	 *
	 * @return magnitude Method to return the magnitude value.
	 */
	public double getMagnitude() {
		return this.magnitude;
	}

	/**
	 *
	 * @return latitude Method to return the latitude value.
	 */
	public double getLatitude() {
		return this.latitude;
	}

	/**
	 *
	 * @return longitude Method to return the Longitude value.
	 */
	public double getLongitude() {
		return this.longitude;
	}

	/**
	 *
	 * @return year Method to returns the year of the earthquake.
	 */
	public int getYear() {
		return this.year;
	}

	/**
	 * @return String Returns a string format of earthquake values.
	 */
	@Override
	public String toString() {
		return String.format("\nMagnitude: %2f; Latitude: %2f; Longitude: %2f; Year: %d;", magnitude, latitude,
				longitude, year);
	}

}
