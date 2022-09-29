package sort;

import java.util.Arrays;

/**
 * Write a description of class Merge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Merge
{
  
  /**
   * Returns the sorted array
   */
  public static int[] sort(int[] arr) {

    int N = arr.length;

    //if the array is of length 1, it is already sorted
    if (N < 2) { return arr; }

    int m = N/2;

    // Split the array into two halves
    int[] l = new int[m];
    int[] r = new int[N-m];

    // Create the left and right arrays
    System.arraycopy(arr, 0, l, 0, m);
    System.arraycopy(arr, m, r, 0, N - m);

    // Sort the left and right arrays via recursion
    // Which leads to the ends of the arrays.
    sort(l);
    sort(r);

    // Merge the left and right arrays
    merge(arr, l, r);

    return arr;

  }
  public static void merge(int[] arr, int[] l, int[] r)
  {
    int i = 0, j = 0, k = 0;

    // i is the index of the left array
    // j is the index of the right array
    // k is the index of the merged array

    while (i < l.length && j < r.length)
    {
      // If the left array is smaller than the right array
      // Add the left array to the merged array
      if (l[i] <= r[j])
      {
        arr[k] = l[i];
        i++;

      }
      // If the right array is smaller than the left array
      //Add the right array to the merged array
      else
      {
        arr[k] = r[j];
        j++;

      }
      k++;

    }
    // Copy the remaining elements of the left array
    if (i < l.length)
    {
      System.arraycopy(l, i, arr, k, l.length - i);
    }
    // Copy the remaining elements of the right array
    else
    {
      System.arraycopy(r, j, arr, k, r.length - j);
    }

  }
  
  public static void main(String[] args) {
    int[] arr = {53,85,93,25,39,27,42,5,24,45,33,51,5,80,4,7,91,
      31,66,71,32,19,79,58,61,82,89,63,7,4,50,10,48,24,75,19,22,
      73,54,51,25,33,20,52,79,97,70,54,63,49};    
    
    // Test the sort
    testSort(sort(arr));
  }
  
  public static void testSort(int[] arr) {
    for (int i=0; i<arr.length-1; i++) {
      if (arr[i] > arr[i+1]) {
        System.out.println("FAIL at index "+i);
        System.out.println(Arrays.toString(arr));
        return;
      }
    }
    System.out.println("SUCCESS!");
    System.out.println(Arrays.toString(arr));
  }

}
