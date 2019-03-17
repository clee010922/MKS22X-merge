public class Merge {

  public static void mergesort(int[] data) {
    mergesort(data, 0, data.length);
  }

  private static void mergesort(int[] data, int lo, int hi) {
    int m = (lo+hi)/2;
    if (lo < hi) {
      mergesort(data, lo, m);
      mergesort(data, m+1, hi);
      merge(data, lo, m, hi);
    }
  }

  private static void merge(int[] data, int lo, int m, int hi) {
    int[] left = new int[m-lo+1];
    int[] right = new int[hi-m];
    for (int i = 0; i < left.length; i++) {
      left[i] = data[i];
    }
    for (int i = 0; i < right.length; i++) {
      right[i] = data[i+m];
    }
    int leftCounter = 0;
    int rightCounter = 0;
    int counter = 0;
    while(leftCounter < left.length && rightCounter < right.length) {
      if (left[leftCounter] < right[rightCounter] ||
          left[leftCounter] == right[rightCounter]) {
        data[counter] = left[leftCounter];
        leftCounter++;
      }
      else {
        data[counter] = right[rightCounter];
        rightCounter++;
      }
      counter++;
    }
    if (rightCounter < right.length) {
      for (int i = rightCounter; i < right.length; i++) {
        data[counter] = right[rightCounter];
        counter++;
      }
    }
    if (leftCounter < left.length) {
      for (int i = leftCounter; i < left.length; i++) {
        data[counter] = left[leftCounter];
        counter++;
      }
    }
  }



  /*

  is swap needed?

  public static void swap(int index1, int index2, int[] data) {
    int temp = data[index1];
    data[index1] = data[index2];
    data[index2] = temp;
  }
  */

}
