import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;



/**
 * Write a description of class Monitoring here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Monitoring
{ // creating instances of monitoring class
    // instance variables - replace the example below with your own
   
    private ArrayList<Observatory> instances = new ArrayList<Observatory>();
             
    Earthquake valdivia = new Earthquake(9.5, -39.813889, -73.245833, 1960); //american observatory
    Earthquake princeWilliam = new Earthquake(9.2, 60.615, -147.168056, 1964); //american observatory
    Earthquake sumatra = new Earthquake(9.2, 0, 102, 2004); //Asian Observatory
    Earthquake tohoku = new Earthquake(9.1, 38.9, 140.683333, 2011); //Asian Observatory
   
    //String name, String country, int year, String area
    Observatory america = new Observatory("Berkeley Observatory", "United States", 1955, "4000 sq.km" );
    Observatory asia = new Observatory("Seoul Observatory", "South Korea", 1977, "4000 sq.km" );
   
    /**
     * Constructor for objects of class Monitoring
     */
    public Monitoring()
    {
        america.addToList(valdivia);
        america.addToList(princeWilliam);
        asia.addToList(sumatra);
        asia.addToList(tohoku);
    }
   
   
    public void addToList(Observatory newObservatory){
        instances.add(america);
        instances.add(asia);
    }    
   
    public ArrayList<Observatory> getInstances(){
     return instances;  
    }
     //monitoring --> observatory
    //public List<Obsevatory> instances.<Earthquake> events = GFreeze.getInstance().getFrozen();
     //public Observatory();

   
   
    // how to collect the largest average magnitude from the observatory
    public Observatory largestAvgMag() {
        double maxAvg = 0.0;
        double avg;
        int maxObs = 0;
       
        for(int i=0; i<instances.size();i++) {
            avg = instances.get(i).getAvgMag();
            if(avg > maxAvg) {
            maxAvg = avg;
            maxObs = i;
            }
        }
        return instances.get(maxObs);
            //double magnitude = earthquake.getMagnitude();
    // if (magnitude > filter) {
    // results.add(earthquake);        
        }
       
   
   
    //return type earthquake not double
   
    public Earthquake largestMagRecorded() {
        Earthquake earthquake;
        Earthquake maxQuake = null;
        double maxMag = 0.0;
        double mag = 0.0;
        //int maxObs = 0;
        for(int i=0; i<instances.size(); i++) {
         Observatory observatory = instances.get(i);
         Earthquake reading = observatory.getMaximumEarthquake();//
        if(mag > maxMag) {
          maxMag = mag;
          maxQuake = reading;
   
          //earthquake = instances.get(i).getMaximumEarthquake();
         
                //instances.get(i).events.get(i).getMagnitude();
           
           //  public double getMaximumMagnitude() {
           //    double maximum = 0.0;
           // for(int i=0; i<events.size();i++){
                             
           //  Earthquake earthquake = events.get(i);
           //  double magnitude = earthquake.getMagnitude();
           //   if(magnitude > maximum) {
           //   maximum = magnitude;            
           
            }
       
            //return Observatory.getMaximumEarthquake();
       
        //Store largest earthquake object
        //For each earthquake in the list, compare to current largest
        //If bigger, replace, else carry on
               
        }
       
        return maxQuake;
        // Earthquake earthquake = events.get(i);
         //double magnitude = earthquake.getMagnitude();
         //if(magnitude > maximum) {
           //  maximum = magnitude;
       
   }

   
   public ArrayList<Earthquake> getListOfAllEarthquakes(double filter) {
       ArrayList<Observatory> instances = new ArrayList<Observatory>();
       ArrayList<Earthquake> ledger = new ArrayList<Earthquake>();
       double mag = 0.0;
       for(int i=0; i<instances.size();i++){
         Observatory observatory = instances.get(i);
         
         //ledger.add(observatory.getListOfAllEarthquakes(filter));
         //ArrayList<Earthquake> currentQuake = 
        for(int j =0; i<observatory.getListOfAllEarthquakes(filter).size();i++){
         //if (observatory.magnitude > filter) {
          Earthquake earthquake = getListOfAllEarthquakes(filter).get(i);   
          ledger.add(earthquake);
        // }
         // System.out.println(events.get(i));  
          // add.america and .asia to separate the two observatories
      }  
       
 
    }
   
      return ledger;
  }

   
   
}   
   

   