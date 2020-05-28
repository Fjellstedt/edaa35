
import java.util.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

class Project
{
	private static void ValidityTest(Integer[] array)
	{
		for(int i = 0; i < array.length; ++i)
		{
			assert i == array[i] : "Should be the same";
		}
	}

	private static void insertionSort(Integer[] array)
	{
		for(int i = 1; i < array.length; ++i)
		{
			int pos = i;
			Integer val = array[pos];
			while(pos > 0 && val.compareTo(array[pos - 1]) < 0)
			{
				array[pos] = array[pos - 1];
				--pos;
			}
			array[pos] = val;
		}
	}

	private static void merge(Integer[] output, Integer[] left, Integer[] right)
	{
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < left.length && j < right.length)
		{
			if(left[i].compareTo(right[j]) < 0)
			{
				output[k++] = left[i++];
			}
			else
			{
				output[k++] = right[j++];
			}
		}
		assert (i == 0 || j == 0) : "One must be zero";
		while(i < left.length)
		{
			output[k++] = left[i++];
		}
		while(j < right.length)
		{
			output[k++] = right[j++];
		}
	}

	private static void mergeSort(Integer[] array)
	{
		if(array.length > 1)
		{
			int halfSize = array.length / 2;
			Integer[] left = (Integer[]) new Integer[halfSize];
			Integer[] right = (Integer[]) new Integer[array.length - halfSize];
			System.arraycopy(array, 0, left, 0, halfSize);
			System.arraycopy(array, halfSize, right, 0, array.length - halfSize);
			mergeSort(left);
			mergeSort(right);
			merge(array, left, right);
		}
	}
	
	public static void main(String args[])
	{
	try
	{
	    if(args.length == 4)
	    {
		Scanner fileR = new Scanner(new File(args[0]));
		PrintWriter fileW = new PrintWriter(new FileOutputStream(args[1], false));
		Integer amountOfTimes = Integer.parseInt(args[2]);
		String testType = args[3];
		System.out.println(testType);
		LinkedList<Integer> original = new LinkedList<Integer>();
		while(fileR.hasNext())
		{
			Integer val = fileR.nextInt();
			original.add(val);
		}

		// NOTE(pf): i for insertion...
		if(testType.equals("i"))
		{
			for(int i = 0; i < amountOfTimes; ++i)
			{
				Integer[] array = original.toArray(new Integer[original.size()]);
				long t0 = System.nanoTime();
				insertionSort(array);
				//ValidityTest(array);
				long t1 = System.nanoTime();
				fileW.println((t1 - t0));
			}
		}
		// NOTE(pf): .. and m for merge.
		else if(testType.equals("m"))
		{
			for(int i = 0; i < amountOfTimes; ++i)
			{
				Integer[] array = original.toArray(new Integer[original.size()]);
				long t0 = System.nanoTime();
				mergeSort(array);
				//ValidityTest(array);
				long t1 = System.nanoTime();
				fileW.println((t1 - t0));
			}
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
}
