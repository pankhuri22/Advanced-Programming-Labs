//Pankhuri Kasliwal
//2016253



import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Recurse extends RecursiveAction 
{
	 public final int n,k;
	 private int r;
	 private Recurse(int i, int j)
	 {
		 this.n = i;
		 this.k = j;
	}
	 
	 public void compute() 
	 {
		 if (n == 0 || k == 0 || n == k) 
		 {
			 r = 1;	
			 return ;
				
		 }
		    Recurse left = getInstance(n - 1, k - 1);
			Recurse right = getInstance(n - 1, k);
			left.fork();
			right.compute();
			left.join();
			r = left.r + right.r;
			}
	 
			private static Map<String, Recurse> instances = new HashMap<String, Recurse>();
			
			public static Recurse getInstance(int x, int y)
		    {
		        String key = x + ", " + y;
		        if (!instances.containsKey(key)) {
		            instances.put(key, new Recurse(x, y));
		        }
		        return instances.get(key);
		    }

	 

	public static void main(String[] args) 	{
		Scanner input = new Scanner(System.in);
        System.out.print("Enter n = ");
        int n=input.nextInt();
        System.out.print("Enter k = ");
        int k=input.nextInt();
		ForkJoinPool pool1 = new ForkJoinPool(1);
		
		ForkJoinPool pool2 = new ForkJoinPool(2);
		ForkJoinPool pool3 = new ForkJoinPool(3);


	    Recurse task = new Recurse(n, k);
	    long startTime1 = System.currentTimeMillis();
	    	 //   long startTime2 = System.currentTimeMillis();

	  pool1.invoke(task);
	  //pool2.invoke(task);
	  //  pool3.invoke(task);

	    int r = task.r;
	    System.out.println(r);
	    long endTime 1  = System.currentTimeMillis();
     //   long endTime2   = System.currentTimeMillis();
	    long totalTime1 = endTime1 - startTime1;
	    	    //long totalTime2 = endTime2 - startTime2;

	    System.out.println(totalTime1);  

	   // int ratio1 = totalTime2 / totalTime1; 


	}

}


