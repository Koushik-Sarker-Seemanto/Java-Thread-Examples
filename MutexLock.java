/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RaceCondition;

import RaceCondition.MutexLock.First;
import RaceCondition.MutexLock.Second;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author koushik
 */
public class MutexLock {
    boolean available;
    int x;
    
    public MutexLock(){
        available = true;
        x=5;
    }
    public void acquire(){
        while(!available);
        available = false;
    }
    public void release(){
        available = true;
    }
    
    class First implements Runnable{
        Thread t;
        public First(){
            t = new Thread();
            t.setName("First Thread");
            t.start();
        }

        @Override
        public void run() {
            acquire();
            x++;
            System.out.println(t.getName()+" After Update: "+x);
            release();
        }
        
    }
    class Second implements Runnable{
        Thread t;
        public Second(){
            t = new Thread();
            t.setName("Second Thread");
            t.start();
        }

        @Override
        public void run() {
            acquire();
            x--;
            System.out.println(t.getName()+" After Update: "+x);
            release();
        }
    }
    
}
class Main{
    public static void main(String[] args) {
        MutexLock lock = new MutexLock();
        First f = lock.new First();
        Second s = lock.new Second();
        
        for(int i=0;i<10;i++)
        {
            f.run();
            s.run();
        }
        try 
        {
            f.t.join();
            s.t.join();
        } 
        catch (InterruptedException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
