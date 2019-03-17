import java.util.*;

public class Merge {

  public static void mergesort(int[] data) {
    mergesort(data, 0, data.length-1);
  }

  private static void mergesort(int[] data, int lo, int hi) {
    if (lo < hi) {
      int m = (lo+hi)/2;
      int[] left = new int[m-lo+1];
      int[] right = new int[hi-m];
      for (int i = 0; i < left.length; i++) {
        left[i] = data[lo+i];
      }
      for (int i = 0; i < right.length; i++) {
        right[i] = data[m+i+1];
      }
      mergesort(left, 0, left.length-1);
      mergesort(right, 0, right.length-1);
      merge(left, right, data);
    }
  }

  private static void merge(int[] left, int[] right, int[] data) {
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
    while (leftCounter < left.length) {
      data[counter] = left[leftCounter];
      counter++;
      leftCounter++;
    }
    while (rightCounter < right.length) {
      data[counter] = right[rightCounter];
      counter++;
      rightCounter++;
    }
  }

  public static String printArray(int[] data) {
    String result = "[";
    for (int i = 0; i < data.length; i++) {
      if (i != data.length - 1)
        result += data[i] + ", ";
      else result += data[i] + "]";
    }
    return result;
  }

  /*
  public static void main(String[] args) {
    int[] data = {6, 5, 4, 3, 2, 1, 0};
    mergesort(data);
    System.out.println(printArray(data));
  }
  */


  public static void main(String[]args){
    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          Merge.mergesort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
  }


}
