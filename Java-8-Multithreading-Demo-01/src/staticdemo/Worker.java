/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staticdemo;

/**
 * This is a singleton Worker factory class combined with the Worker class.
 * The first purpose of this class is a Worker's pool and a factory issuing
 * these workers.
 * The second purpose of the class is an implementation of a worker class
 * that repeatedly perform some requested actions.
 *
 * @author @author <a href="mailto:ivan.zapreev@gmail.com">Dr. Ivan S. Zapreev</a>
 */
class Worker {
    //The allowed number of workers in the system
    public static final int NUM_OF_WORKERS = 2;
    //The pool array storing the workers present in the system
    private static final Worker[] instances = new Worker[NUM_OF_WORKERS];
    //The index that defines the last issued worker
    private static int turn = 0;

    //The name of the current worker
    private final String name;

    /**
     * The basic worker construction
     *
     * @param name the worker's name, should not be null
     */
    private Worker(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + ": " + name;
    }

    /**
     * This is a synchronized action method that allows to perform an action of a certain duration on the given worker object.
     *
     * @param action the action name
     * @param duration the action's duration in milliseconds
     */
    public synchronized void doSomething(String action, long duration) {
        System.out.println("[" + this + "] Begin doing: " + action);
        try {
            Thread.sleep(duration);
            System.out.println("[" + this + "] End doing: " + action);
        } catch (InterruptedException e) {
            System.out.println("[" + this + "] Interrupted doing: " + action);
        }
    }

    /**
     * The factory method of the class that returns either a new worker if there is
     * space left in the pool, or an existing worker, if there is no more space in the pool.
     *
     * @param name the name of the new worker
     * @return a worker class instance
     */
    public static Worker getWorker(String name) {
        Worker inst = null;
        synchronized (instances) {
            System.out.println("Begin: Asking for: " + name);
            final int index = turn % NUM_OF_WORKERS;
            inst = instances[index];

            if (inst == null) {
                inst = new Worker(name);
                System.out.println("A new Worker Instance [" + inst + "]!");
                instances[index] = inst;
            } else {
                System.out.println("An existing Worker Instance [" + inst + "!");
            }

            turn++;
            System.out.println("End: Asking for: " + name);
        }
        return inst;
    }

}
