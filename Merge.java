public class Merge {

  public static void mergesort(int[] data) {
    int[] temp = new int[data.length];
    for (int i = 0; i < data.length; i++) {
      temp[i] = data[i];
    }
    mergesort(data, temp, 0, data.length);
  }

  private static void mergesort(int[] data, int lo, int hi) {
    int m = (lo+hi)/2;
    if (lo < hi) {
      mergesort(data, lo, m;);
      mergesort(data, m+1, hi);
      merge(data, lo, hi);
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
