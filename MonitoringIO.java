 

import java.util.*;


/**	
Define a class MonitoringIO, with a main method which does the following:
	• Presents the user with a menu (printed to the console) offeatures:
	o enter observatory data;
	o enter earthquake data;
	o provide monitoring statistics on largest average earthquake, largest
	earthquake ever and all earthquakes with magnitude greater than a given
	number; or
	o exit
	• Takes user input from the console to choose one of the menu features
	• Allows the user to input, via the console, the details of observatories and
	earthquakes
	• After executing one of the features, returns the user to the menu to choose another
	option

*/	

public class MonitoringIO {
    
   private Scanner reader;	
    //reader = new Scanner(System.in);
    
  
   
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
   Monitoring monitor = new Monitoring();
	Scanner scan = new Scanner(System.in);

	
	// Getting observatoryName input
	System.out.print("Enter Observatory Name: ");
	String observatoryName = scan.nextLine();
	//System.out.println("String entered = " + observatoryName);
	
	
	// Getting observatoryCountry input
	System.out.print("Enter Observatory Country: ");
	String observatoryCountry = scan.nextLine();
	//System.out.println("String entered = " + observatoryCountry);
	
	// Getting observatoryArea input
	System.out.print("Enter Observatory Area: ");
	String observatoryArea = scan.nextLine();
	//System.out.println("String entered = " + observatoryArea);
	
	
	// Getting observatoryString input
	System.out.print("Enter Observatory Year: ");
	int observatoryYear = scan.nextInt();
	//System.out.println("int entered = " + observatoryYear);
	
	
	
	//Getting Earthquake 
	System.out.print("Enter Earthquake Magnitude ");
	double earthquakeMagnitude = scan.nextDouble();
	//System.out.println("String entered = " + earthquakeMagnitude);
	
	
	// Getting observatoryCountry input
	System.out.print("Enter Earthquake Latitude: ");
	double earthquakeLatitude = scan.nextDouble();
	//System.out.println("String entered = " + earthquakeLatitude);
	
	// Getting observatoryArea input
	System.out.print("Enter Earthquake Longitude: ");
	double earthquakeLongitude = scan.nextDouble();
	//System.out.println("String entered = " + earthquakeLongitude);
	
	
	// Getting observatoryString input
	System.out.print("Enter Earthquake Year: ");
	int earthquakeYear = scan.nextInt();
	//System.out.println("int entered = " + earthquakeYear);
	

	
	
	
	//provide monitoring statistics on the largest average earthquake
	System.out.print("Get Largest Average Earthquake : ");
	Observatory maxAvgQuake = monitor.largestAvgMag();
	
	 System.out.print(maxAvgQuake.getMaximumEarthquake()); //?
	
	 
	 
	//provide monitoring statistics on the largest ever earthquake
	 
	System.out.print("Get Largest Earthquake Ever: ");
	Earthquake bigQuake = monitor.largestMagRecorded();
	
	 System.out.print(bigQuake.getMagnitude());
	
	
	 
	 
	 
	 
//provide monitoring statistics on all earthquake with a magnitude greater than a given number.. OR
	
	 System.out.print("Get Largest Earthquake with Magnitude greater than x : ");
		double x = 0.0;
		
		System.out.print("Enter Value for x: ");
		double x1 = scan.nextDouble();
	 
	ArrayList<Earthquake> listQuake = monitor.getListOfAllEarthquakes(earthquakeMagnitude); 
	//Observatory listQuake =  
		earthquakeMagnitude = x1;
		if (earthquakeMagnitude > x1) {	
		   x1 = earthquakeMagnitude;
		   
		   System.out.print(listQuake);		   
				   
				   
		//ArrayList<Earthquake> eventList = new ArrayList<Earthquake>();
		 
		//for (i=0; i<events.size(); i++) {
		
		}
	 
	 
	 
	 
	
	//exit
	
	scan.close();
	
	

	
	}

}
