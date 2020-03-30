
import java.util.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

class Labb
{
    public static void main(String args[])
    {
        try
        {
            if(args.length == 3)
            {
                LinkedList<Integer> original = new LinkedList<Integer>();
                Scanner fileR = new Scanner(new File(args[0]));
                while(fileR.hasNext())
                {
                    original.add(fileR.nextInt());
                }
                
                PrintWriter fileW = new PrintWriter(new FileOutputStream(args[1], false));
                //fileW.println("HEADER: Run: <index>, <time in ns>, <time in ns>");
                Integer amountOfTimes = Integer.parseInt(args[2]);

                for(int i = 0; i < amountOfTimes; ++i)
                {
                    float time = 0.0f;
                    LinkedList<Integer> list = new LinkedList<Integer>(original);
                    float t0 = System.nanoTime();
                    java.util.Collections.sort(list);
                    //merge(list, 0, list.size() / 2, list.size() - 1);
                    float t1 = System.nanoTime();
                    fileW.println((t1 - t0));
                }

                fileW.flush();
                fileW.close();
            }
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.toString());
        }
    }
   // Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r] 
    private static void merge(LinkedList<Integer> ll, int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        Integer L[] = new Integer [n1]; 
        Integer R[] = new Integer [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = ll.get(l + i); 
        for (int j=0; j<n2; ++j) 
            R[j] = ll.get(m + 1+ j); 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                ll.set(k, L[i]); 
                i++; 
            } 
            else
            { 
                ll.set(k, R[j]);
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            ll.set(k, L[i]); 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            ll.set(k, R[j]);
            j++; 
            k++; 
        } 
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    void sort(LinkedList<Integer> ll, int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(ll, l, m); 
            sort(ll , m+1, r); 
  
            // Merge the sorted halves 
            merge(ll, l, m, r); 
        } 
    }
}
