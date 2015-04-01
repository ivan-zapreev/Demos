/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 * This class uses synchronized methods for increasing and decreasing the energy values.
 * In case one runs two threads with continuous concurrent calling of these without no or
 * small delay in between, the energy levels will not stay @ zero but can significantly
 * deviate.
 * @author @author <a href="mailto:ivan.zapreev@gmail.com">Dr. Ivan S. Zapreev</a>
 */
public class SynchPerson extends Person{
    @Override
    public synchronized void eat() throws InterruptedException {
        incrementEnergy(1);
    }
    
    @Override
    public synchronized void think() throws InterruptedException {
        decrementEnergy(1);
    }
    
}
