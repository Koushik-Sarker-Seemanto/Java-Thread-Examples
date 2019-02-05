
package binary_search_thread;

import java.util.Arrays;

/**
 *
 * @author koushik
 */
public class Sorting implements Runnable{
    int arr[];
    Thread t;
    public Sorting(int arr[]) 
    {
        this.arr = arr;
        t = new Thread(this);
        t.start();
    }
    
    synchronized void Sort_Array()
    {
        Arrays.sort(arr);
    }
    
    @Override
    public void run() {
        Sort_Array();
    }    
}
