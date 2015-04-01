/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staticdemo;

/**
 * This is a basic worker thread class that inherits from a thread and makes sure the worker will perform a given
 * activity in a separate thread.
 *
 * @author @author <a href="mailto:ivan.zapreev@gmail.com">Dr. Ivan S. Zapreev</a>
 */
public class WorkerThread extends Thread {
    //This is the worker's name
    private final String name;
    //The action to be performed by the worker
    private String action = null;
    //The duration of the action that is to be performed by the worker in milliseconds
    private long duration = 0;

    /**
     * The basic worker thread constructor. The name parameter will only be used in case there are enough possible
     * workers in the pool, otherwise this name will be ignored as a worker with another name  be used.
     *
     * @param name the name of the worker to be created
     */
    public WorkerThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Worker s = Worker.getWorker(name);
        s.doSomething(action, duration);
    }

    /**
     * This method will c start a new thread with an action of a given duration on an available worker
     * @param action the action name
     * @param duration the action's duration in milliseconds
     */
    public void doAction(String action, long duration) {
        this.action = action;
        this.duration = duration;
        this.start();
    }
}
