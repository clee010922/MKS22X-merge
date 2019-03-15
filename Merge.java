public class Merge {

  public static void mergesort(int[] data) {
    int[] temp = new int[data.length];
    for (int i = 0; i < data.length; i++) {
      temp[i] = data[i];
    }
    mergesort(data, temp, 0, data.length);
  }

  private static void mergesort(int[] data, int[] temp, int lo, int hi) {
    int[] copy = new int[data.length/2];
    int[] copy2 = new int[data.length - copy.length];
    if (lo < hi) {
      mergesort(data, copy, lo, copy.length-1);
      mergesort(data, copy2, );
      merge();
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
