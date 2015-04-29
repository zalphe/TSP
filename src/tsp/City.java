/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

/**
 *
 * @author zalphe
 */
public class City {
    double x = 0;
    double y = 0;
    private String id;
    
    // Constructs a randomly placed city
    public City(){
        this.x = (double)(Math.random()*200);
        this.y = (double)(Math.random()*200);
    }
    
    // Constructs a city at chosen x, y location
    public City(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    // Sets city's x coordinate
    public void setX(double x){
        this.x = x;        
    }
    
    // Sets city's y coordinate
    public void setY(double y){
        this.y = y;        
    }
    
    // Gets city's x coordinate
    public double getX(){
        return this.x;
    }
    
    // Gets city's y coordinate
    public double getY(){
        return this.y;
    }
    
    // Gets the distance to given city
    public double distanceTo(City city){
        double xDistance = Math.abs(getX() - city.getX());
        double yDistance = Math.abs(getY() - city.getY());
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );        
        
        return distance;
    }
    
    @Override 
    public String toString(){
        return getX()+", "+getY();
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
}
