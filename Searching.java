
package binary_search_thread;

/**
 *
 * @author koushik
 */
public class Searching implements Runnable{
    Thread th;
    int arr[],key,size;
    public Searching(int arr[],int key,int size) 
    {
        this.size = size;
        this.arr = arr;
        this.key = key;
        th = new Thread(this);
        th.start();
    }

    @Override
    public void run() 
    {
        binarySearch();
    }
    
    public synchronized void binarySearch()
    {
        int start = 0, end = size-1,mid;
        boolean flag = false;
        while(start<=end)
        {
            mid = (start+end+1)/2;
            if(arr[mid]==key)
            {
                flag = true;
                System.out.println("Found at Index:"+mid);
                break;
            }
            else if(arr[mid]<key)
            {
                start = mid+1;
            }
            else
            {
                end = end-1;
            }
        }
        if(!flag)
        {
            System.out.println("Not Found!");
        }
    }
    
}
