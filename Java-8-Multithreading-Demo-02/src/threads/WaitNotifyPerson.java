/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 * This is an example class with synchronized eat and think methods that allows
 * to keep the levels between the specified values even if we concurrently call
 * on eat and think from two different threads.
 * @author @author <a href="mailto:ivan.zapreev@gmail.com">Dr. Ivan S. Zapreev</a>
 */
public class WaitNotifyPerson extends Person{
    private final int maxEnergyLevel;
    private final int minEnergyLevel;
    
    /**
     * Accepts the minimum and maximum allowed energy levels for the person
     * @param maxEnergyLevel
     * @param minEnergyLevel 
     */
    public WaitNotifyPerson(final int maxEnergyLevel, final int minEnergyLevel) {
        super(minEnergyLevel);
        this.maxEnergyLevel = maxEnergyLevel;
        this.minEnergyLevel = minEnergyLevel;
    }
    
    @Override
    public void eat() throws InterruptedException {
        synchronized(this) {
            //Do not let eat too much
            while(getEnergy() >= maxEnergyLevel) {
                wait();
            }
            incrementEnergy(1);
            //Notify the thinking thread that there is energy to think.
            notify();
        }
    }
    
    @Override
    public void think() throws InterruptedException{
        synchronized(this) {
            //Do not think if you are drained.
            while(getEnergy() <= minEnergyLevel){
                wait();
            }
            decrementEnergy(1);
            //Notify the eating thread in case of pending eat actions
            notify();
        }
    }
    
}
