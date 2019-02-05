
package binary_search_thread;

import java.util.Scanner;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author koushik
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter the Size of Array:");
        int size = s.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the Array elements:");
        for(int i=0;i<size;i++)
        {
            arr[i]=s.nextInt();
        }
        Sorting sort_array = new Sorting(arr);
        try {
            sort_array.t.join();
        } catch (InterruptedException ex) {
            
        }
        
        System.out.println("Enter the Number of Query:");
        int q = s.nextInt();
        for(int i=0;i<q;i++)
        {
            System.out.println("Enter Query Element:");
            int key = s.nextInt();
            Searching search = new Searching(arr,key,size);
            try {
                search.th.join();
            } catch (InterruptedException ex) {
                
            }
        }
    }
}
