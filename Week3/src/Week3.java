import java.util.Arrays;
import java.util.Random;

public class Week3 {
	/* Specification 
	 * Brand: Custom Built
	 * CPU: AMD Ryzen 5 1600 Ram: 16gb
	 * 
	 * Conjecture:
	 * After studying the 2 algorithms my conjecture was that the binary search will be faster in most cases than linear search. 
	 * We can come to that conclusion by looking at the Big O Notation of both. If we look at the best 
	 * case scenario for both, we get a Big O of O(1). This means that both will have equal performance if the 
	 * value the algorithm is looking for is the first value steps thru. However, the 
	 * algorithm for worst case scenario is O(n) for linear search while binary search is O(log n). This means that the 
	 * algorithm will grow linearly for linear search and logarithmic for binary depending on n.
	 * We can assume that more iteration will need to take place for linear since N is greater than log n.
	 * Also in the average case, binary will have a growth of O(log n) which will still be less than the linear O(n/2). 
	 * Therefore in all cases other than best case scenario, binary search will need less iterations to search a sorted data set and
	 * be faster overall. 
	 * 
	 * Conclusion: As it turns out my conjecture was correct. The iteration count of the binary search was less than the linear search.
	 * Due to the greatly reduced amount of iterations, I believe that the binary search would take less time to search for a value. 
	 */
	public static void main(String[] args) {
		//SearchValue
		int searchValue = 25000;
		int[][] iterationValues = new int[2][5];
		//Comparison Code, controls for array and assigns iterations to container.
		for(int y = 0; y < 5; y++) {
			//create array
			int elements = 100 * (int)Math.pow(10, y);
			int[] intArray = createRandomArray(elements);
			
			//linear Search
			iterationValues[0][y] = linearSearch(intArray, searchValue);
			
			//Binary Search
			iterationValues[1][y] = binarySearch(intArray, searchValue);
		}
		
		//print out results by type of search
		for(int x = 0; x < 2; x++) {
			if(x == 0) {
				System.out.println("LinearSeach:");
			}
			else {
				System.out.println("BinarySearch:");
			}
			for(int y = 0; y < iterationValues[x].length; y++) {
				System.out.printf("%d in elements: %d comparisons%n", 100 * (int)Math.pow(10, y), iterationValues[x][y]);
			}
		}
	}

	
	//Creates integer array with random values. Will create 
	static int[] createRandomArray(int arraySize) {
		@SuppressWarnings("unused")
		int memoryConsumption = (4 * arraySize) + 24 + 8; // memory calculation for int array. int takes 4 bytes
		int min = 10000;
		int max = 99999;
		int numElements = arraySize;
		Random rand = new Random();
		int dataArray[] = new int[numElements];
		for (int i = 0; i < dataArray.length; i++)
		{
		    dataArray[i] = (rand.nextInt((max - min) + 1) + min);
		}
		
		return dataArray;
	}
	
	/* Will search for a values inside of an Array by using a linear search algorithm. Will return
	 * the number of iterations the method took to find value. If value doesn't exists, method will return
	 * the amount of iterations the method took to determine that values was not within the array.  
	 */
	static int linearSearch(int[] searchArray, int seekValue) {
		int iteration = 0;
			for (int i = 0; i < searchArray.length ; i++) {
				iteration++;
				if(searchArray[i] == seekValue) {
				return iteration; 
				}
			}
			return iteration;
	}
	
	
	/* Will search for a values inside of an Array by using a binary search algorithm. Will return
	 * the number of iterations the method took to find value. If value doesn't exists, method will return
	 * the amount of iterations the method took to determine that values was not within the array. Will sort the
	 * array.
	 */
	static int binarySearch(int[] searchArray, int seekValue) {
		Arrays.sort(searchArray);//sort array
		int iteration = 0; 
		int low = 0;
		int high = searchArray.length -1;
		while (low <= high) {
			iteration ++;
			int mid = low + (high - low) / 2;
			if(searchArray[mid] == seekValue) {
				return iteration;
			}
			if(searchArray[mid] < seekValue) {
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}
		return iteration;
	}
	
}
