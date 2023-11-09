package Sorting;

import java.util.Arrays;

public class InsertionSorting {
    public static void main(String[] args) {
        int[] a = { 5, 3, 12, 6, 7, 1, 4, 6, 0, 3, 1};
        insertionSort(a);
        Arrays.stream(a).forEach(val -> System.out.print(val + " "));

        // 5 3 12 6 7 1 4 6 0 3 1
        // 3 5 12 6 7 1 4 6 0 3 1
        // 3 5 12 6 7 1 4 6 0 3 1
        // 3 5 6 12 7 1 4 6 0 3 1
        // 3 5 6 7 12 1 4 6 0 3 1
        // 1 3 5 6 7 12 4 6 0 3 1
        // 1 3 4 5 6 7 12 6 0 3 1
        // 1 3 4 5 6 6 7 12 0 3 1
        // 0 1 3 4 5 6 6 7 12 3 1
        // 0 1 3 3 4 5 6 6 7 12 1
        // 0 1 1 3 3 4 5 6 6 7 12
    }
    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int sorted = i - 1;
            while (sorted > -1 && arr[sorted] > arr[sorted + 1]){
                int temp = arr[sorted];
                arr[sorted] = arr[sorted + 1];
                arr[sorted + 1] = temp;
                sorted--;
            }
            //Arrays.stream(arr).forEach(val -> System.out.print(val + " "));
            //System.out.println();
        }
    }
}
