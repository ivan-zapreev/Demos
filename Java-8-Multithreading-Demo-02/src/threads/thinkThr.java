/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.Scanner;

/**
 * This example application shows how you work with threads
 * @author @author <a href="mailto:ivan.zapreev@gmail.com">Dr. Ivan S. Zapreev</a>
 */
public class thinkThr {
    
    //Define the main actions to be used in the examples
    private final static IAction eatAction = (Person p) -> {p.eat();};
    private final static IAction thinkAction = (Person p) -> {p.think();};
    private final static IAction probeAction = (Person p) -> {p.probe();};

    /**
     * This method is used for creating a thread that does monitoring of the application
     * @param eatThr the eating thread
     * @param thinkThr the thinking thread
     * @param probeTh the probing thread
     * @return returns the monitor thread
     */
    private static Thread createMponitoreThread(final Thread eatThr, final Thread thinkThr, final Thread probeTh){
        //The stopping thread, waits for an enter on
        //the command line and stops the threads.
        return new Thread(){
            private final Scanner scanner = new Scanner(System.in);
            private boolean hasMoreWork = true;
            @Override
            @SuppressWarnings("SleepWhileInLoop")
            public void run(){
                System.out.println("The monitore thread is started!");
                //First start the threads
                eatThr.start();
                thinkThr.start();
                probeTh.start();
                //Then wait for the sygnal to end the threads
                try{
                    while(!Thread.interrupted() && hasMoreWork) {
                        //Yes, we sleep as we are not concerned with performance
                        //And yes, using magic constants is bad ;)
                        sleep(300);
                        //In case some one presses enter on the command line
                        //the application is to be stopped, the work is done.
                        if( scanner.hasNextLine() ) {
                            hasMoreWork = false;
                        }
                    }
                }catch(InterruptedException e){
                    //Do nothing
                }finally{
                    System.out.println("Stopping all the threads");
                    eatThr.interrupt();
                    thinkThr.interrupt();
                    probeTh.interrupt();
                }
                System.out.println("The monitore thread is stopped!");
            }
        };
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Just define the person and thread variables that we wil need in examples
        Person manUnSynch;
        Thread controlThr;
        
        //1. Keep one of the person class instantiations uncommented
        //1. Keep one of the example class instantiations uncommented
        //3. Run the program and observe the output

        /***************************************/
        /*************** PERSONS ***************/
        /***************************************/
        
        //Person 1.0: A fully non-synchronized person
        //manUnSynch = new UnsynchPerson();
        
        //Person 2.0: A synchronized person
        //manUnSynch = new SynchPerson();
        
        //Person 3.0: A synchronized person with wait and notify allowing for [0-1] energy levels
        //manUnSynch = new WaitNotifyPerson(1,0);
        
        //Person 3.0: A synchronized person with wait and notify allowing for [5-100] energy levels
        manUnSynch = new WaitNotifyPerson(100,5);

        /***************************************/
        /*************** EXAMPLES **************/
        /***************************************/
        
        //Example 0.1: Do actions @ different moments in time.
        //Depending on how the Person class methods are synchronized or not
        //it can give different effects.
        //Create the fully unsynchronized Peron class and run it in threads
        //controlThr = createMponitoreThread(new ActionRunner("Eat", eatAction, manUnSynch, 298),
        //                                          new ActionRunner("Think", thinkAction, manUnSynch, 300),
        //                                          new ActionRunner("Probe", probeAction, manUnSynch, 100));
               
        //Example 0.2: Do actions simultaneously but not often
        //Depending on how the Person class methods are synchronized or not
        //it can give different effects. Typically, if the person's methods
        //are synchronized then one will see that the energy levels are @ 0
        //controlThr = createMponitoreThread(new ActionRunner("Eat", eatAction, manUnSynch, 100),
        //                                          new ActionRunner("Think", thinkAction, manUnSynch, 100),
        //                                          new ActionRunner("Probe", probeAction, manUnSynch, 100));

        //Example 0.3: Do actions simultaneously but not often
        //Depending on how the Person class methods are synchronized or not
        //it can give different effects. Typically, if the person's methods
        //are synchronized then one will see that the energy levels still
        //can deviate a lot from zerro. Only if the use wait and notify the
        //energy values will be within the proper limits.
        controlThr = createMponitoreThread(new ActionRunner("Eat", eatAction, manUnSynch, 0),
                                                  new ActionRunner("Think", thinkAction, manUnSynch, 0),
                                                  new ActionRunner("Probe", probeAction, manUnSynch, 100));
        
        //Start the threads
        controlThr.start();
    }
    
}
