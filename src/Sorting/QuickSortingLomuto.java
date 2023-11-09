package Sorting;

import java.util.Arrays;

public class QuickSortingLomuto {
    public static void main(String[] args) {
        int[] a = { 5, 3, 12, 6, 7, 1, 4, 6, 0, 3, 1};
        quicksortLomuto(a, 0, a.length - 1);
        Arrays.stream(a).forEach(val -> System.out.print(val + " "));

        // 5 3 12 6 7 1 4 6 0 3 1
        // 1 0 1 6 7 5 4 6 3 3 12
        // 0 1 1 6 7 5 4 6 3 3 12
        // 0 1 1 6 7 5 4 6 3 3 12
        // 0 1 1 6 7 5 4 6 3 3 12
        // 0 1 1 3 3 5 4 6 6 7 12
        // 0 1 1 3 3 5 4 6 6 7 12
        // 0 1 1 3 3 5 4 6 6 7 12
        // 0 1 1 3 3 5 4 6 6 7 12
        // 0 1 1 3 3 5 4 6 6 7 12
        // 0 1 1 3 3 4 5 6 6 7 12
        // 0 1 1 3 3 4 5 6 6 7 12
        // 0 1 1 3 3 4 5 6 6 7 12
    }
    public static void quicksortLomuto(int[] arr, int start, int end){
        if(start >= end) return;
        int rightStart = partitionLomuto(arr, start, end);
        // Arrays.stream(arr).forEach(val -> System.out.print(val + " "));
        // System.out.println();
        quicksortLomuto(arr, start, rightStart - 1);
        quicksortLomuto(arr, rightStart, end);
    }
    public static int partitionLomuto(int[] arr, int start, int end){
        int left = start;
        for (int current = start; current < end; current++){
            if(arr[current] <= arr[end]){
                int temp = arr[left];
                arr[left] = arr[current];
                arr[current] = temp;
                left++;
            }
        }
        int temp = arr[left];
        arr[left] = arr[end];
        arr[end] = temp;
        return left;
    }
}
