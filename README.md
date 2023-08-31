# SortingAlgorithmEfficiency
 Program will generate increasingly larger sequences of unsigned 
 integers(stored in an array), sorts each sequence into ascending order (counting the number of 
  comparisons necessary to complete the sort), prints the number of comparisons required for each 
  sequenced sorted. In doing so we will see which sorting algorithm is more efficient 

## What have I learned 
- Merge sort is more efficient than the other algorithm mentioned. This is because merge sort is a divide-and-conquer algorithm.
  - Merge sort also has time complexity of O(n log n) which makes it efficient for large data.
- Selection sort was less efficient compared to other sorting algorithm. This is because it does the same comparisons regardless of initial ordering
  - Time complexity of O(n^2) , thus making it less efficient for large data.
 
- Enhanced Bubble Sort compares adjacent elements and swaps them if they are in the wrong position. If no swaps were made during a pass, it means that the array is sorted(meaning it can terminate early.)
  - Time complexity of O(n^2) which can be inefficient depending on the intial order of the data.

 - Insertion Sort builds the sorted array one element at a time, placing the each element in its correct position within the sorted array
   - Time complexity of O(n^2) , can be slighlty better than Enhanced Bubble Sort , Selection Sort if the data is nearly sorted
