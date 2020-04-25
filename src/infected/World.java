package infected;

import java.util.ArrayList;

interface OnWorldListener {
	void update();
}

public class World {

	private OnWorldListener mListener; // listener field
	
	   // setting the listener
	 public void registerEventListener(OnWorldListener mListener) 
	 { 
	     this.mListener = mListener; 
	 } 
	  // An Asynchronous task 
	 public void createThread() 
	 { 
	 // An Async task always executes in new thread 
	     new Thread(new Runnable() { 
	     public void run() 
	     {
	          // perform any operation 
	    	 System.out.println("Performing operation in Asynchronous Task"); 
	    	 // check if listener is registered. 
	    	 if (mListener != null) { 
	    		 // invoke the callback method of class A 
	    		 mListener.update(); 
	    	 } 
	     } 
	     }).start(); 
	 } 
	 
	private int day;
	private ArrayList<Country> countries;
	private Virus virus;
	public World(ArrayList<Country> countries, Virus virus) {
		this.countries = countries;
		this.virus = virus;
		this.day = 0;
	}
	
	public ArrayList<Country> getCountries() {
		return countries;
	}
	
	public Virus getVirus() {
		return virus;
	}
	
	public void setVirus(Virus virus) {
		this.virus = virus;
	}
	
	public int getDay() {
		return day;
	}
	

}
