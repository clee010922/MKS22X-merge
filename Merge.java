import java.util.*;

public class Merge {

  public static void mergesort(int[] data) {
    mergesort(data, 0, data.length-1); //wrapper function
  }

  private static void mergesort(int[] data, int lo, int hi) {
    if (lo < hi) {
      if (hi-lo <= 10) {
        insertionsort(data, lo, hi);
      }
      else {
        int m = (lo+hi)/2; //the index of the middle value when the array is split into halves
        int[] left = new int[m-lo+1]; //left half of the splitted array
        int[] right = new int[hi-m]; //right half of the splitted array
        for (int i = 0; i < left.length; i++) {
          left[i] = data[lo+i]; //copying over values to the left half array
        }
        for (int i = 0; i < right.length; i++) {
          right[i] = data[m+i+1]; //copying over values to the right half array
        }
        mergesort(left, 0, left.length-1); //recursive call to left half array
        mergesort(right, 0, right.length-1); //recursive call to right half array
        merge(left, right, data);
      }
    }
  }

  private static void merge(int[] left, int[] right, int[] data) {
    int leftCounter = 0; //keeps track of index of the left array
    int rightCounter = 0; //keeps track of index of the right array
    int counter = 0; //keeps track of index of the original array
    while(leftCounter < left.length && rightCounter < right.length) {//when both left and right arrays still have values
      if (left[leftCounter] < right[rightCounter] ||
          left[leftCounter] == right[rightCounter]) { //if value of left array is greater or equal to the value of right array
        data[counter] = left[leftCounter]; //copy that value so that it is the first value of the original array
        leftCounter++; //increment left array index
      }
      else { //if right array value is greater
        data[counter] = right[rightCounter]; //copy over
        rightCounter++; //increment right array index
      }
      counter++; //increment the index of the original array
    }
    while (leftCounter < left.length) { //when there are values left over in left array
      data[counter] = left[leftCounter]; //copy over
      counter++; //increment index of original array
      leftCounter++; //increment index of left array
    }
    while (rightCounter < right.length) { //when there are values left over in right array
      data[counter] = right[rightCounter]; //copy over
      counter++; //increment index of original array
      rightCounter++; //increment index of right array
    }
  }

  //method that prints the array. used for debugging.
  public static String printArray(int[] data) {
    String result = "[";
    for (int i = 0; i < data.length; i++) {
      if (i != data.length - 1)
        result += data[i] + ", ";
      else result += data[i] + "]";
    }
    return result;
  }

  public static void insertionsort(int[] data, int lo, int hi) {
    int temp = 0;
    for (int i = lo+1; i < hi+1; i++) {
      temp = data[i];
      while (i > lo && temp < data[i-1]) {
        data[i] = data[i-1];
        i--;
      }
      data[i] = temp;
    }
  }

  /*
  public static void main(String[] args) {
    int[] data = {6, 5, 4, 3, 2, 1, 0};
    mergesort(data);
    System.out.println(printArray(data));
  }
  */

  //mr.K's driver for quicksort, but changed it to mergesort
  public static void main(String[]args){
    System.out.println("Size\t\tMax Value\tmerge/builtin ratio ");
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
