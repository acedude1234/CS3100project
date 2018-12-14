/*This is the class for the array list 
 * I added elements so that we have a getElement and a setELement
 * this helps with retrieving items from the array or changing elements
 * instead of using the threanum and all that, you can use gettheatrenum
 * or if you wanted to set the number then you can use settheatrenum
 */
import java.util.*;
public class MovieList 
{
	private int theatrenum;
    private String name;  
    private String desc;
    private double rating;
    private int age;
    
    public MovieList(int theatrenum,String name,double rating, String desc)
    {  
        this.theatrenum=theatrenum;  
        this.name=name;  
        this.rating=rating;
        this.desc=desc;
    }
    public int gettheatrenum() {
    	return theatrenum;
    }
    public void settheatrenum(int theatrenum) {
    	this.theatrenum = theatrenum;
    }
    
    public String getName() 
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getNameLower()								//added to help for movies and not be case sensitive and gets rid of spaces and special characters
    {
    	return name.replaceAll("[^A-Za-z0-9]+", "").toLowerCase();
    }
    public double getrating() {
    	return rating;
    }
    public void setRating(double rating) {
    	this.rating=rating;
    }
    
    public String getdesc() {
    	return desc;
    }
    public void setdesc(String desc) {
    	this.desc=desc;
    }
    @Override
    public String toString() {
    	return "\n" + this.name + " is located in theatre number: " + this.theatrenum +"\n" +
    			"Rating: " + this.rating + "/10, or " + ((int)(this.rating*100)/10) + "%\n" +
    			"Synopsis:\n" + this.desc + "\n";
    }
}

