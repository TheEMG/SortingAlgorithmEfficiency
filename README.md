# SortingAlgorithmEfficiency
 Program will generate increasingly larger sequences of unsigned 
 integers(stored in an array), sorts each sequence into ascending order (counting the number of 
  comparisons necessary to complete the sort), prints the number of comparisons required for each 
  sequenced sorted. In doing so we will see which sorting algorithm is more efficient 

## What have I learned 
- **Merge sort** is more efficient than the other algorithm mentioned. This is because merge sort is a divide-and-conquer algorithm.
  - Merge sort also has time complexity of O(n log n) which makes it efficient for large data.
- **Selection sort** was less efficient compared to other sorting algorithm. This is because it does the same comparisons regardless of initial ordering
  - Time complexity of O(n^2) , thus making it less efficient for large data.
 
- **Enhanced Bubble Sort** compares adjacent elements and swaps them if they are in the wrong position. If no swaps were made during a pass, it means that the array is sorted(meaning it can terminate early.)
  - Time complexity of O(n^2) which can be inefficient depending on the intial order of the data.

 - **Insertion Sort** builds the sorted array one element at a time, placing the each element in its correct position within the sorted array
   - Time complexity of O(n^2) , can be slighlty better than Enhanced Bubble Sort , Selection Sort if the data is nearly sorted
   
- **CombSort** is an improvement on Bubble Sort, where the comparison and swap operation uses a gap to optimize the sorting process. The gap starts at a large size and shrinks by a factor of 1.3 with each iteration until it becomes 1. It is more efficient than traditional Bubble Sort, especially for larger datasets.
  - Time complexity averages to O(n^2/2^p), where p is the number of increments, but it's often faster for partially sorted arrays.
- **QuickSort** is a divide-and-conquer algorithm that selects a pivot element and partitions the other elements into two sub-arrays, according to whether they are less than or greater than the pivot. It is generally faster than other O(n log n) algorithms due to its in-place partitioning and low overhead.
  - Average time complexity of O(n log n), but in the worst case, it can degrade to O(n^2).
