package Sorting;

import java.util.Arrays;

public class QuickSorting {
    public static void main(String[] args) {
        int[] a = { 5, 3, 12, 6, 7, 1, 4, 6, 0, 3, 1};
        quicksort(a, 0, a.length - 1);
        Arrays.stream(a).forEach(val -> System.out.print(val + " "));

        // 5 3 12 6 7 1 4 6 0 3 1
        // 1 0 1 6 7 12 4 6 3 3 5
        // 0 1 1 6 7 12 4 6 3 3 5
        // 0 1 1 6 7 12 4 6 3 3 5
        // 0 1 1 3 3 4 12 6 7 6 5
        // 0 1 1 3 3 4 12 6 7 6 5
        // 0 1 1 3 3 4 12 6 7 6 5
        // 0 1 1 3 3 4 5 6 6 7 12
        // 0 1 1 3 3 4 5 6 6 7 12
        // 0 1 1 3 3 4 5 6 6 7 12
        // 0 1 1 3 3 4 5 6 6 7 12
        // 0 1 1 3 3 4 5 6 6 7 12
    }
    public static void quicksort(int[] arr, int start, int end){
        if(start >= end) return;
        int rightStart = partition(arr, start, end);
        // Arrays.stream(arr).forEach(val -> System.out.print(val + " "));
        // System.out.println();
        quicksort(arr, start, rightStart - 1);
        quicksort(arr, rightStart, end);
    }
    public static int partition(int[] arr, int left, int right){
        int pivot = arr[(left + right) / 2];
        while (left <= right) {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;
            if(left <= right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
}
