/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staticdemo;

/**
 * This is a demo programm for the first year old students to show the concurrent execution of multiple threads with
 * synchronization blocks.
 *
 * @author @author <a href="mailto:ivan.zapreev@gmail.com">Dr. Ivan S. Zapreev</a>
 */
public class StaticDemo {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Create a number of worker threads, these threads will use a number of workers and run actions on them
        //Please note that the number of workers available in the system is defined by the Worker singleton class.
        WorkerThread s1 = new WorkerThread("A");
        WorkerThread s2 = new WorkerThread("B");
        WorkerThread s3 = new WorkerThread("C");
        WorkerThread s4 = new WorkerThread("D");

        //Run the parallel actions on the number of workers from the four created threads.
        s1.doAction("play", 300);
        s2.doAction("walk", 300);
        s3.doAction("sleep", 100);
        s4.doAction("think", 400);
    }   
}
