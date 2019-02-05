
package stack;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author koushik
 */
public class StackThread {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int arr[] = new int[100];
        int index = -1;
        while(true)
        {
            System.out.println("Enter option:");
            System.out.println("Push    [press 1]");
            System.out.println("Pop     [press 2]");
            System.out.println("Display [press 3]");
            System.out.println("Exit    [press 4]");
            int option = s.nextInt();
            if(option == 4)
                break;
            else if(option == 1)
            {
                index++;
                int num = s.nextInt();
                Push add = new Push(arr, num, index);
                try {
                    add.t.join();
                } catch (InterruptedException ex) {
                    
                }
                Display show = new Display(arr, index);
                try {
                    show.t.join();
                } catch (InterruptedException ex) {
                    
                }
            }
            else if(option == 2)
            {
                Pop delete = new Pop(index);
                
                try {
                    delete.t.join();
                } catch (InterruptedException ex) {
                    
                }
                if(delete.popValue()==-1)
                {
                    index=-1;
                    System.out.println("stack Underflow");
                }
                else
                {
                    System.out.println("poped: "+arr[delete.popValue()]);
                    index--;
                }
                
                Display show = new Display(arr, index);
                try {
                    show.t.join();
                } catch (InterruptedException ex) {
                    
                }
            }
            else  if (option == 3)
            {
                Display show = new Display(arr, index);
                try {
                    show.t.join();
                } catch (InterruptedException ex) {
                    
                }
            }
        }
    }
}
class Push implements Runnable{
    int num,index,arr[];
    Thread t;

    public Push(int arr[],int num,int index) {
        this.num=num;
        this.index=index;
        this.arr=arr;
        t = new Thread(this);
        t.start();
    }
    
    @Override
    public void run() {
        pushValue();
    }
    
    public void pushValue()
    {
        arr[index]=num;
        System.out.println("Pushed!");
    }
    
}
class Pop implements Runnable{
    int index;
    Thread t;

    public Pop(int index) {
        this.index = index;
        t = new Thread(this);
        t.start();
    }
    
    @Override
    public void run() {
        popValue();
    }
    public synchronized int popValue()
    {
        if(index<0)
        {
            return -1;
        }
        else
        {
            return index;
        }
    }
}
class Display implements Runnable{
    int arr[],index;
    Thread t;
    public Display(int arr[],int index) {
        this.arr=arr;
        this.index=index;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        showStack();
    }
    public synchronized void showStack()
    {
        System.out.print("Stack:  ");
        for(int i=0;i<=index;i++)
        {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }
    
}