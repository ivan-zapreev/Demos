/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 * The action interface for calling methods on persons
 * @author @author <a href="mailto:ivan.zapreev@gmail.com">Dr. Ivan S. Zapreev</a>
 */
public interface IAction {
    /**
     * This is the action that will be performed on the person
     * @param p the person to perform the action on
     * @throws InterruptedException will be thrown in case of interruption of the thread's wait or sleep.
     */
    public void doSomething(Person p) throws InterruptedException;
}
