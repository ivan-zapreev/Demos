/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 * This is a fully unsynchronized class for a person, concurrent calling for
 * eat and think methods can cause a large deviation from zero energy levels
 * @author @author <a href="mailto:ivan.zapreev@gmail.com">Dr. Ivan S. Zapreev</a>
 */
public class UnsynchPerson extends Person{
    @Override
    public void eat() throws InterruptedException {
        incrementEnergy(1);
    }
    
    @Override
    public void think() throws InterruptedException {
        decrementEnergy(1);
    }
    
}
