/**
 * Write a description of class Earthquake here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

public class Earthquake
{   // An Arraylist for storing the event of earthquakes
            // state & instance variables -
    private String event;  // The name of the earthquake event
    private double magnitude; // the registered magnitude of the event
    private double latitude;  // the latitude location of the event
    private double longitude; // longitude location of the event
    private int year;  // year of the event
   
   
   
    public Earthquake(double magnitude, double latitude, double longitude, int year) {
        this.magnitude = magnitude;
        this.latitude = latitude;
        this.longitude = longitude;
        this.year = year;
    }
   
   
   
    public void setMagnitude(double magnitude) { //local variable
         if(magnitude > 0.0 && magnitude <= 10.0) {  
        this.magnitude = magnitude;
    }
        }
   
    public void setLatitude(double latitude) { //local variable
        if(latitude >= -85.05115  && latitude <= 85.0) {  
        this.latitude = latitude;
    }  
        }
   
    public void setLongitude(double longitude) { //local variable
           if(longitude >= -180.0  && longitude <= 180) {  
        this.longitude = longitude;
    }
        }  
   
    public void setYear(int year) { //local variable
          if(year >= 0  && year <= 2019) {  
        this.year = year;
    }
    }
     
   
    public double getMagnitude() {
        return this.magnitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public int getYear() {
        return this.year;
    }    
   
   
       
}