/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RaceCondition;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author koushik
 */
class RaceConditionTest implements Runnable{

    private int c;
    @Override
    public void run() {
        synchronized(this){
            this.incriment();
            System.out.println("After Increment: "+Thread.currentThread().getName()+" "+getValue());
            this.decrement();
            System.out.println("After Decrement: "+Thread.currentThread().getName()+" "+getValue());
        }
       
    }
    public int getValue(){
        return c;
    }
    public void incriment(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            
        }
        c++;
    }
    public void decrement(){
        c--;
    }
    
}
public class RaceCondition{
    public static void main(String[] args) {
       RaceConditionTest condition = new RaceConditionTest();
       Thread t1 = new Thread(condition,"Thread-1");
       Thread t2 = new Thread(condition,"Thread-2");
       Thread t3 = new Thread(condition,"Thread-3");
       t1.start();
       t2.start();
       t3.start();
    }
    
}
