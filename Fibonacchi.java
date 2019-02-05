
package fibonacchi;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author koushik
 */
public class Fibonacchi implements Runnable{
    int num,res=0;
    Thread th;
    public Fibonacchi(int num) {
        this.num = num;
        th = new Thread(this);
        th.start();
    }
    
    @Override
    public void run() {
        fibo();
        
    }
    public synchronized void fibo()
    {
        res=0;
        int i=0,j=1;
        if(num>0)
            System.out.print("0 1 ");
        else if(num==0)
            System.out.println("0 ");
        while(true)
        {
            
            res = i+j;
            if(res>=num)
            {
                break;
            }
            System.out.print(i+j+" ");
            i=j;
            j=res;
        }
        System.out.println();
        
    }
    
    
}

class Input implements Runnable{
    int num;
    Thread t;
    Scanner s = new Scanner(System.in);
    public Input() {
        t =new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        takeInput();
    }
    public synchronized int takeInput()
    {
        num = s.nextInt();
        return num;
    }
    
}

class Main {
    public static void main(String[] args) {
        while(true)
        {
            System.out.println("Enter Number:");
            int n = 0;
            Input inp = new  Input();
            try {

                inp.t.join();
                n=inp.num;
            } catch (InterruptedException ex) {

            }
            Fibonacchi fib = new Fibonacchi(n);
            try {
                fib.th.join();
            } catch (InterruptedException ex) {

            }
            if(n==0)
                break;
        }
    }
}