/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 * The class for running the actions on person class in a loop from a different thread.
 * @author @author <a href="mailto:ivan.zapreev@gmail.com">Dr. Ivan S. Zapreev</a>
 */
public class ActionRunner extends Thread {
    public final String ActionName;
    private final IAction action;
    private final Person person;
    private final long delay;
    
    /**
     * The basic constructor accepting all of the necessary things
     * @param actionName The action name used for logging
     * @param action The action itself
     * @param person The person to apply the action to
     * @param delay the delay for between repeating the action.
     */
    public ActionRunner(String actionName, IAction action, Person person, long delay){
        this.ActionName = actionName;
        this.action = action;
        this.person = person;
        this.delay = delay;
    }
    
    @Override
    @SuppressWarnings("SleepWhileInLoop")
    public void run(){
        try{
            while(!Thread.interrupted()){
                action.doSomething(person);
                //Yes we do want to sleep here as with
                //that I want to be able to simulate different
                //performance and concurrency issues.
                sleep(delay);
            }
        }catch(InterruptedException e){
            System.out.println("Interrupted action: " + ActionName);
        }finally{
            System.out.println("The " + ActionName + " thread is stopped!");
        }
    }
    
}
