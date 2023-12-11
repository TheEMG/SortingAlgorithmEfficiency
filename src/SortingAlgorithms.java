/*Eric Gutierrez 
 * COSC 2336.001 
 * Programming Assignment IV: Program will generate increasingly larger sequences of unsigned 
 * integers(stored in an array), sorts each sequence into ascending order (counting the number of 
 * comparisons necessary to complete the sort), prints the number of comparisons required for each 
 * sequenced sorted. 
 */
import java.util.Random;

public class SortingAlgorithms {
	private static long comparisons = 0;

	/**
 * Main method to demonstrate various sorting algorithms.
 * This method generates sequences of unsigned integers of varying sizes,
 * sorts them using different algorithms, and prints out the number of comparisons
 * required for each sort. It demonstrates Selection Sort, Enhanced Bubble Sort,
 * Insertion Sort, Merge Sort, CombSort, and QuickSort.
 */
	public static void main(String[] args) {
		
		System.out.println("-----------------------------------------");
		System.out.println("SORTING ALGORITHM: SELECTION SORT");   
		//Loop thorugh different sizes for the sorting arrays  
		for (int index =10 ; index <=10000;index*=10) {
			int [] array  = new int[index];

			// Generate an array with 'index' number of random integers
			generate(array,index);

			//Clone array and Ouput the results along with its comparisons 
			selectionSort(array.clone(),index);
			output(index,comparisons);

			//reset comparisons count 
			comparisons = 0;


		}
		
		System.out.println("-----------------------------------------");
		System.out.println("SORTING ALGORITHM: ENHANCED BUBBLE SORT");
		//Loop thorugh different sizes for the sorting arrays 
		for (int index =10 ; index <=10000;index*=10) {
			int [] array  = new int[index];

			// Generate an array with 'index' number of random integers
			generate(array,index);


			//Clone array and Ouput the results along with its comparisons 
			enhancedBubbleSort(array.clone(),index);
			output(index,comparisons);

			//reset comparisons count 
			comparisons = 0;


		}

		System.out.println("-----------------------------------------");
		System.out.println("SORTING ALGORITHM: INSERTION SORT");
		//Loop thorugh different sizes for the sorting arrays
		for (int index =10 ; index <=10000;index*=10) {
			int [] array  = new int[index];

			// Generate an array with 'index' number of random integers
			generate(array,index);
		
			//Clone array and Ouput the results along with its comparisons 
			insertionSort(array.clone(),index);
			output(index,comparisons);

			//reset comparisons count 
			comparisons = 0;


		}
		
		System.out.println("-----------------------------------------");
		System.out.println("SORTING ALGORITHM: MERGE SORT");
		//Loop thorugh different sizes for the sorting arrays
		for (int index =10 ; index <=10000;index*=10) {
			int [] array  = new int[index];

			// Generate an array with 'index' number of random integers
			generate(array,index);

			//Clone array and Ouput the results along with its comparisons 
			mergeSort(array.clone());
			output(index,comparisons);

			//reset comparisons count 
			comparisons = 0;


		}

		System.out.println("-----------------------------------------");
		System.out.println("SORTING ALGORITHM: COMBSORT");
		//Loop thorugh different sizes for the sorting arrays
		for (int index =10 ; index <=10000;index*=10) {
			int [] array  = new int[index];

			// Generate an array with 'index' number of random integers
			generate(array,index);
			
			//Clone array and Ouput the results along with its comparisons 
			combSort(array.clone(),index);
			output(index,comparisons);

			//reset comparisons count 
			comparisons = 0;

		}

		
		System.out.println("-----------------------------------------");
		System.out.println("SORTING ALGORITHM: QUICKSORT");
		//Loop thorugh different sizes for the sorting arrays
		for (int index =10 ; index <=10000;index*=10) {
			int [] array  = new int[index];

			// Generate an array with 'index' number of random integers
			generate(array,index);

			
			//Clone array and Ouput the results along with its comparisons 
			quicksort(array.clone(),0,array.length -1 );
			output(index,comparisons);

			//reset comparisons count 
			comparisons = 0;


		}
		
	}
	
/**
 * Populates the given array with random integers.
 * Each element of the array is filled with a random integer,
 * up to the maximum value allowed by the integer type (Integer.MAX_VALUE).
 *
 * @param valueArray The array to be populated with random integers.
 * @param size       The size of the array to be populated.
 */

	public static void generate(int[]valueArray, int size) {
		//number generator is created 
		Random gen = new Random();

		//each position in an array is filled with a random 
		//integer up to the maximum integer.MAX_VALUE
		for(int i = 0; i < size; i ++) {
			valueArray[i] = gen.nextInt(Integer.MAX_VALUE);
		}
	}

	/**
 * Prints out the results of the sorting operation.
 * This method displays the size of the array that was sorted and the number of comparisons
 * required to sort the array using the chosen sorting algorithm.
 *
 * @param index The size of the array that was sorted.
 * @param comparisons The number of comparisons made during the sorting process.
 */

	public static void output( int index , long comparisons) {
		System.out.println("Number of Values in Array: "+ index);
		System.out.println("Number of Comparisons Required: "+ comparisons);
		System.out.println();
	}

	/**
 * Implements the Selection Sort algorithm to sort an array in ascending order.
 * The method works by repeatedly finding the minimum element from the unsorted part of the array
 * and moving it to the beginning. This process is continued until the entire array is sorted.
 * It also counts the number of comparisons made during the sorting process.
 *
 * @param theArray The array to be sorted.
 * @param n The number of elements in the array.
 */
	public static void selectionSort (int [] theArray,int n) {
		for(int i =0;i < n-1;i++) {
			int min =i;
			for(int j = i+1;j < n;j++) {
				//count basic operations
				comparisons++;                       
				if(theArray[j]<theArray[min]) {
					min = j;
				}//end inner loop
			}
			//Swapping the found minimum element with the first elemennt
			int temp = theArray[min];
			theArray[min] = theArray[i];
			theArray[i] = temp;
		} //End outer loop
	}// End Selection Sort 


	/**
 * Implements the Insertion Sort algorithm to sort an array in ascending order.
 * The method iteratively builds a sorted portion of the array, inserting each new element
 * into its correct position within the sorted part. This process continues until the entire
 * array is sorted. The algorithm is efficient for small data sets and more efficient than 
 * most simple quadratic (O(n^2)) algorithms, such as Selection Sort or Bubble Sort.
 * It also counts the number of comparisons made during the sorting process.
 *
 * @param theArray The array to be sorted.
 * @param n The number of elements in the array.
 */
	public static void insertionSort(int [] theArray,int n) {
		for(int i =1;i < n; i++) {
			int key  = theArray[i];
			int j = i -1;

			//Move elements of theArray[0..i-1], that are greater than key 
			//to one position ahead of their current position
			while(j >= 0 && theArray[j]> key) {
				//count basic operation 
				comparisons ++;                   
				theArray[j+1] = theArray[j];        
				j --;                              
			} //End of While loop
			theArray[j+1] = key;                 
		} //End of For loop 
	}

/**
 * Implements an enhanced version of the Bubble Sort algorithm to sort an array in ascending order.
 * This optimized version introduces a flag that monitors whether any swaps have been made in the
 * current pass. If no swaps occur, the algorithm concludes that the array is already sorted and
 * terminates early, improving efficiency in cases where the array is already or almost sorted.
 * The method also counts the number of comparisons made during the sorting process.
 *
 * @param theArray The array to be sorted.
 * @param n The number of elements in the array.
 */
	public static void enhancedBubbleSort(int []theArray,int n) {
		//Initialize flag 
		boolean sorted  = false;
		for (int i = 0;i < n-1 && !sorted;i++ ) {
			sorted = true;
			for(int j =0; j < n-i-1;j++) {
				//Count basic operation
				comparisons++;                   
				if(theArray[j] > theArray[j+1]) {
					//Swap Elements
					int temp = theArray[j];
					theArray[j] = theArray[j+1];
					theArray[j+1] = temp;

					//Indicates array is not yet sorted 
					sorted = false;
				}
			}//End inner loop
		}//End outer loop 
	}

/**
 * Implements the Merge Sort algorithm to sort an array in ascending order.
 * This method sorts an array by dividing it into two halves, recursively sorting each half,
 * and then merging the sorted halves. It is an efficient, stable, and comparison-based sorting algorithm.
 * 
 * The method first checks if the array length is greater than one (a condition to proceed with sorting).
 * It then divides the array into two halves - left and right. The division is done such that in the case
 * of an odd number of elements, the right half contains one more element than the left.
 * 
 * After dividing, it recursively sorts the left and right halves and then calls the 'merge' method
 * to combine these sorted halves into a single sorted array.
 *
 * @param theArray The array to be sorted.
 */
	public static void mergeSort(int[] theArray) {

		int n = theArray.length;
		if (n > 1){
			int middle = n/2;
			int [] leftArray = new int[middle];
			//n - middle in case we have an odd number
			int [] rightArray = new int[n-middle];

			//Copying the first half of theArray to leftArray
			for(int i = 0;i < middle;i++) {
				leftArray[i] = theArray[i];
			}

			//Copying the second half of theArray to rightArray
			for(int i = middle;i < n;i++) {
				rightArray[i-middle] = theArray[i];
			}

			//Recursively sorting the two halves 
			mergeSort(leftArray);
			mergeSort(rightArray);

			//Merging the sorted halves 
			merge(theArray,leftArray,rightArray);
		}
	}

/**
 * Merges two sorted subarrays into a single sorted array.
 * This method is a part of the Merge Sort algorithm and is used to combine two sorted halves
 * of an array into a single sorted array. It takes two sorted subarrays (leftArray and rightArray) 
 * and merges them into theArray in sorted order.
 *
 * The method iterates over both subarrays, comparing their elements and placing the smaller element
 * into theArray. This process continues until all elements from both subarrays have been placed into theArray.
 *
 * If there are leftover elements in either subarray after the main merging loop, 
 * these elements are also copied into theArray. This ensures that theArray is a completely merged and sorted array.
 *
 * The method also counts the number of comparisons made during the merging process.
 *
 * @param theArray The array into which the merged output is placed.
 * @param leftArray The first sorted subarray.
 * @param rightArray The second sorted subarray.
 */
	public static void merge(int[]theArray, int[] leftArray,int[] rightArray) {
		int leftSize = leftArray.length;
		int rightSize = rightArray.length;
		//i for left , j for right , k for merge array
		int i=0,j=0,k = 0;

		//Merge Elements from leftArray and rightArray into theArray
		while(i < leftSize && j < rightSize) {
			comparisons++;
			if(leftArray[i] <= rightArray[j]) {
				theArray[k] = leftArray[i];
				i++;
			}
			else {
				theArray[k] = rightArray[j];
				j++;
			}
			k++;
		} //End While

		//Copy any remaining elements from leftArray into theArray 
		while(i < leftSize) {
			comparisons++;
			theArray[k] = leftArray[i];
			i++;
			k++;
		} //End While

		//Copy any remaining elements from rightArray into theArray 
		while(j< rightSize) {
			comparisons++;
			theArray[k] = rightArray[j];
			j++;
			k++;
		}//End While
	}

	/**
 * Implements the Comb Sort algorithm to sort an array in ascending order.
 * Comb Sort is an improvement over the Bubble Sort algorithm, introducing a gap variable
 * to optimize the comparison and swap process. The gap starts out as the length of the array
 * and is reduced by a factor of 1.3 with each iteration until it becomes 1.
 * 
 * The algorithm works by comparing and potentially swapping elements that are 'gap' indices apart.
 * The gap reduction continues until the gap is 1 and no swaps are needed, indicating the array is sorted.
 *
 * @param theArray The array to be sorted.
 * @param n The number of elements in the array.
 */
	public static void combSort(int []theArray , int n ) {
		//local variables 
		int gap = n;
		boolean swapped = true ;
		while(swapped || gap > 1 ) {
			//Reduce the gap 
			gap = Math.max((int)(gap/1.3),1);
			
			//Reset swap flag
			swapped = false;
			
			//or I <- 1, 2, ..., Tally – Gap
			for (int i = 1; i < n - gap; i++) {
				
				//Element to compare with 
				int j = i + gap;

				//comparisons count 
				comparisons++;
				
				//Swap if the elements are not in order 
				if (theArray[i] > theArray[j]) {
					swap(theArray,i,j);
					//Indicates a swap has occured
					swapped = true;
				}//end If
			}//End For 
		}//End While
	}

/**
 * Implements the QuickSort algorithm to sort an array in ascending order.
 * QuickSort is a divide and conquer algorithm. It works by selecting a 'pivot' element
 * from the array and partitioning the other elements into two sub-arrays, according to whether
 * they are less than or greater than the pivot. The sub-arrays are then sorted recursively.
 * 
 * This method performs the recursive QuickSort algorithm.
 *
 * @param theArray The array to be sorted.
 * @param l The starting index of the portion of the array to be sorted.
 * @param r The ending index of the portion of the array to be sorted.
 */
	public static void quicksort(int[] theArray, int l, int r) {
		if (l < r) {
			  //Partitioning the array 
				int s = partition(theArray, l, r);
				
				//Sorting the left sub-array
				quicksort(theArray, l, s - 1); 

				//Sorting the right sub-array
				quicksort(theArray, s + 1, r);
		}
}

/**
 * The partition method for the QuickSort algorithm.
 * This method takes the first element as pivot, places the pivot element at its correct
 * position in the sorted array, and places all smaller (than pivot) to left of pivot and all
 * greater elements to the right of pivot.
 *
 * @param theArray The array to be partitioned.
 * @param l The starting index for the partition.
 * @param r The ending index for the partition.
 * @return The index of the pivot element after partitioning.
 */
private static int partition(int[] theArray, int l, int r) {
		//Pivot Element 
		int p = theArray[l]; 

		//Start from the element next to the pivot 
		int i = l + 1; 
		int j = r;
		while (true) {
				// Find the first element greater than or equal to the pivot 
				while (i < r && theArray[i] < p) {
					comparisons++; // Count the comparison
						i++;
				}
				// Find the first element smaller than or equal to the pivot 
				while (j > l && theArray[j] > p) {
					comparisons++; // Count the comparison
						j--;
				}
				// If pointer have crossed, partitioning is done 
				if (i >= j) {
						break;
				}
				// Swap elements at i and j
				swap(theArray, i, j);
		}
		// Place pivot in its correct position 
		swap(theArray, l, j);
		return j; // Return the index of the pivot element
}

/**
 * Swaps two elements in an array.
 * This method is a utility function used in various sorting algorithms to swap the positions 
 * of two elements in the array. The swap is performed in-place, meaning that no additional
 * storage is used apart from a temporary variable to facilitate the swap.
 *
 * @param theArray The array in which the elements are to be swapped.
 * @param value1 The index of the first element to be swapped.
 * @param value2 The index of the second element to be swapped.
 */
	public static void swap(int []theArray,int value1, int value2 ) {
		//Temporary storage for the value at index value1
		int temp =  theArray[value1];
		
		//Swap Elements
		theArray[value1] = theArray[value2];
		theArray[value2] = temp;
	}//end swap 


}
