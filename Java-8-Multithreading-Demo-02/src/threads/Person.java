/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 * The person class which has energy levels in it and can eat and think
 * @author @author <a href="mailto:ivan.zapreev@gmail.com">Dr. Ivan S. Zapreev</a>
 */
public abstract class Person {
    //The energy levels
    private int energy = 0;
    
    protected Person(){
    }
    
    /**
     * This constructor allows to set the initial energy level
     * @param energy the initial energy level
     */
    protected Person(final int energy){
        this.energy = energy;
    }
    
    /**
     * A non-synchronized energy increment method
     * @param increment the non-negative value to add to the energy level
     */
    protected final void incrementEnergy(final int increment){
        energy = energy + increment;
    }

    /**
     * A non-synchronized energy decrement method
     * @param decrement the non-negative value to subtract from the energy level
     */
    protected final void decrementEnergy(final int decrement){
        energy = energy - decrement;
    }
    
    /**
     * Allows to read the current energy level
     * @return the current energy level
     */
    protected final int getEnergy(){
        return energy;
    }
    
    /**
     * The abstract eat method to be implemented
     * @throws InterruptedException will be thrown if we wait or sleep within the method.
     */
    public abstract void eat() throws InterruptedException;
    
    /**
     * The abstract think method to be implemented
     * @throws InterruptedException will be thrown if we wait or sleep within the method.
     */
    public abstract void think() throws InterruptedException;
    
    /**
     * This is a synchronized probing method
     */
    public final synchronized void probe(){
        System.out.println("Energy level: " + energy);
    }
}
