import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/**
 * Write a description of class Earthquake here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Observatory {
    // state & instance variables - replace the example below with your own
    private String name;
    private String country;
    private int year;
    private String area;
    //list of earthquakes goes here (array, arraylist etcc..)
    private static ArrayList<Earthquake> events = new ArrayList<Earthquake>();
   
    //private List<Earthquake> list;
    //public List<Earthquake> getList(){
    //  return list;        
    //}    
   
    //observatory thisObs myobsList.get(i).
    /**
     * Constructor for objects of class Earthquake
     */
   
       //public Observatory()
   
       // name = "";
       // country = "";
       // year = 0;
       // area = "";
        //earthquakes go here
       
   
   
   
        public Observatory(String name, String country, int year, String area) {
        this.name = name;
        this.country = country;
        this.year = year;
        this.area = area;
       
            Earthquake valdivia = new Earthquake(9.5, -39.813889, -73.245833, 1960); //american observatory
            Earthquake princeWilliam = new Earthquake(9.2, 60.615, -147.168056, 1964); //american observatory
            Earthquake sumatra = new Earthquake(9.2, 0, 102, 2004); //Asian Observatory
            Earthquake tohoku = new Earthquake(9.1, 38.9, 140.683333, 2011); //Asian Observatory
   
            events.add(valdivia);
            events.add(princeWilliam);
            events.add(sumatra);
            events.add(tohoku);
       
        // for(Earthquake event: events) {
        // this.events.add(event);
         // }
       
      }
   
   
   
    // setters for observatories
   
   
    public void setName(String name){
        this.name = name;
    }    
       
    public void setCountry(String name){
        this.country = country;
    }
   
    public void setYear(int year){
        this.year = year;
    }
   
    public void setArea(String area) {
    if(year >= 0  && year <= 2019)
        this.area = area;    
    }    
   
   
   
   
   
    // getters for observatories
   
     public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getYear() {
        return year;
    }

    public String getArea() {
        return area;
    }    
   
    public void addToList(Earthquake newEarthquake){
        events.add(newEarthquake);
    }    
   
    public ArrayList<Earthquake> getEvents(){
     return events;  
    }
   
   
 
    public double getMaximumMagnitude() {
        double maximum = 0.0;
        Earthquake maxQuake;
       
        for(int i=0; i<events.size();i++){
             
        Earthquake earthquake = events.get(i);
        double magnitude = earthquake.getMagnitude();
        if(magnitude > maximum) {
            maximum = magnitude;
            maxQuake = earthquake;
            //System.out.println(events.get(i));
             }
       }
        return maximum;
    }  
   
   // getting the maximum earthquake (with the maximum magnitude of earthquake)
    public Earthquake getMaximumEarthquake() {
        double maximum = 0.0;
        Earthquake maxQuake = null;
       
        for(int i=0; i<events.size();i++){
             
        Earthquake earthquake = events.get(i);
        double magnitude = earthquake.getMagnitude();
         if(magnitude > maximum) {
            maximum = magnitude;
            maxQuake = earthquake;
         
             }
       }
        return maxQuake;
    }  
       
    
   
   
   
    //think about using big decimal
     public double getAvgMag() {      
         double total = 0.0;
         for(int i=0; i<events.size();i++){
        // calculating total first
         Earthquake earthquake = events.get(i);
         double magnitude = earthquake.getMagnitude();
         //calculating average next
         total += magnitude;
       
        }
       
         return total/events.size();
         
     }
     
    // think about using big decimal
    //creating a filter to store earthquake values higher than a certain value (x)
   
   
   public ArrayList<Earthquake> getListOfAllEarthquakes(double filter) {
       ArrayList<Earthquake> results = new ArrayList<Earthquake>();
       for(int i=0; i<events.size();i++){
         Earthquake earthquake = events.get(i);
         double magnitude = earthquake.getMagnitude();
         if (magnitude > filter) {
             results.add(earthquake);
         }
         // System.out.println(events.get(i));  
          // add.america and .asia to separate the two observatories
      }  
        return results;
 
    }
  //also try void print(int... values) {
     //  Sysystem.out.println(Arrays.toString(values));
   
   

 
 
}