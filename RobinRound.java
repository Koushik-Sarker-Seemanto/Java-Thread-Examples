/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RoundRobin;

import java.util.Scanner;

/**
 *
 * @author koushik
 */
public class RobinRound {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the Number of process:");
        int n = s.nextInt();
        int arr[] = new int[n];
        int bt[] = new int[n];
        int wait[] = new int[n];
        int tat[] = new int[n];
        int sum=0;
        System.out.println("Enter Burst times:");
        for(int i=0;i<n;i++)
        {
            bt[i]=s.nextInt();
            arr[i]=bt[i];
            wait[i]=0;
        }
        System.out.println("Enter Quantum time:");
        int q = s.nextInt();
        do
        {
            for(int i=0;i<n;i++)
            {
                if(bt[i]>=q)
                {
                    bt[i]=bt[i]-q;
                    for(int j=0;j<n;j++)
                    {
                        if(i!=j && bt[j]!=0)
                        {
                            wait[j]=wait[j]+q;
                        }
                    }
                }
                else
                {
                    for(int j=0;j<n;j++)
                    {
                        if(i!=j && bt[j]!=0)
                            wait[j]=wait[j]+bt[i];
                    }
                    bt[i]=0;
                }
            }
            sum = 0;
            for(int k=0;k<n;k++)
            {
                sum = sum + bt[k];
            }
        }
        while(sum!=0);
        
        for(int i=0;i<n;i++)
        {
            tat[i] = arr[i]+wait[i];
        }
        System.out.println("Process No\tBrust\tWaiting\tTat");
        for(int i=0;i<n;i++)
        {
            System.out.println("Process: "+(i+1)+"\t"+arr[i]+"\t"+wait[i]+"\t"+tat[i]);
        }
    }
}
