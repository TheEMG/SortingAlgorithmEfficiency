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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-----------------------------------------");
		System.out.println("SORTING ALGORITHM: SELECTION SORT");    
		for (int index =10 ; index <=10000;index*=10) {
			int [] array  = new int[index];

			generate(array,index);

			//selection sort with output
			selectionSort(array.clone(),index);
			output(index,comparisons);

			//reset comparisons count 
			comparisons = 0;


		}
		
		System.out.println("-----------------------------------------");
		System.out.println("SORTING ALGORITHM: ENHANCED BUBBLE SORT");
		for (int index =10 ; index <=10000;index*=10) {
			int [] array  = new int[index];

			generate(array,index);

			//enhanced bubble sort sort with output
			enhancedBubbleSort(array.clone(),index);
			output(index,comparisons);

			//reset comparisons count 
			comparisons = 0;


		}

		System.out.println("-----------------------------------------");
		System.out.println("SORTING ALGORITHM: INSERTION SORT");
		for (int index =10 ; index <=10000;index*=10) {
			int [] array  = new int[index];

			generate(array,index);

			//insertion sort sort with output
			insertionSort(array.clone(),index);
			output(index,comparisons);

			//reset comparisons count 
			comparisons = 0;


		}
		
		System.out.println("-----------------------------------------");
		System.out.println("SORTING ALGORITHM: MERGE SORT");
		for (int index =10 ; index <=10000;index*=10) {
			int [] array  = new int[index];

			generate(array,index);

			//merge  sort with output
			mergeSort(array.clone());
			output(index,comparisons);

			//reset comparisons count 
			comparisons = 0;


		}
		System.out.println("-----------------------------------------");


		//		int [] test = {8, 2, 5, 7, 90};
		//		mergeSort(test);
		//		output("MergeSort",5,comparisons);
	}
	//method to populate an array with randomized integers 

	public static void generate(int[]valueArray, int size) {
		//number generator is created 
		Random gen = new Random();

		//each position in an array is filled with a random 
		//integer up to the maximum integer.MAX_VALUE
		for(int i = 0; i < size; i ++) {
			valueArray[i] = gen.nextInt(Integer.MAX_VALUE);
		}
	}

	public static void output( int index , long comparisons) {
		System.out.println("Number of Values in Array: "+ index);
		System.out.println("Number of Comparisons Required: "+ comparisons);
		System.out.println();
	}

	//selection sort method 
	public static void selectionSort (int [] theArray,int n) {
		for(int i =0;i < n-1;i++) {
			int min =i;
			for(int j = i+1;j < n;j++) {
				comparisons++;                       //count basic operations
				if(theArray[j]<theArray[min]) {
					min = j;
				}//end for j


			}
			int temp = theArray[min];
			theArray[min] = theArray[i];
			theArray[i] = temp;
		}

		// end for i 
	}// end selection sort


	//insertion sort
	public static void insertionSort(int [] theArray,int n) {
		for(int i =1;i < n; i++) {
			//the current element of the array 
			int key  = theArray[i];

			//Since we are starting at i =1 in order to get the i = 0 then we would need to do 
			// i -1 
			int j = i -1;

			while(j >= 0 && theArray[j]> key) {
				comparisons ++;                    //count basic operations 
				theArray[j+1] = theArray[j];       //shift to the right 
				j --;                              // (j = j-1) decrement 
			}
			theArray[j+1] = key;                  //insert to new position
		}


	}

	//Enhanced Bubble Sort  
	public static void enhancedBubbleSort(int []theArray,int n) {
		boolean sorted  = false;
		for (int i = 0;i < n-1 && !sorted;i++ ) {
			sorted = true;
			for(int j =0; j < n-i-1;j++) {
				comparisons++;                    //count basic operations
				if(theArray[j] > theArray[j+1]) {
					int temp = theArray[j];
					theArray[j] = theArray[j+1];
					theArray[j+1] = temp;
					sorted = false;
				}
			}
		}


	}

	//mergesort 

	public static void mergeSort(int[] theArray) {

		int n = theArray.length;
		if (n > 1){
			int middle = n/2;
			int [] leftArray = new int[middle];
			//n - middle in case we have an odd number
			int [] rightArray = new int[n-middle];

			for(int i = 0;i < middle;i++) {
				leftArray[i] = theArray[i];
			}

			//start at the midpoint -> right
			for(int i = middle;i < n;i++) {
				rightArray[i-middle] = theArray[i];
			}

			//merge recursively 
			mergeSort(leftArray);
			mergeSort(rightArray);
			merge(theArray,leftArray,rightArray);
		}
	}

	public static void merge(int[]theArray, int[] leftArray,int[] rightArray) {
		int leftSize = leftArray.length;
		int rightSize = rightArray.length;
		//i for left , j for right , k for merge array
		int i=0,j=0,k = 0;

		//while we have elements on the left array and right array 
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
		}

		//for leftover elements from left and right arrays 
		while(i < leftSize) {
			comparisons++;
			theArray[k] = leftArray[i];
			i++;
			k++;
		}
		while(j< rightSize) {
			comparisons++;
			theArray[k] = rightArray[j];
			j++;
			k++;
		}
	}

}