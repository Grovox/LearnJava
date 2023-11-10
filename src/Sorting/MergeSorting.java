package Sorting;

import java.util.Arrays;

public class MergeSorting {
    public static void main(String[] args) {
        int[] a = { 5, 3, 12, 6, 7, 1, 4, 6, 0, 3, 1};
        mergeSortOptimal(a);
        Arrays.stream(a).forEach(val -> System.out.print(val + " "));

        // 5 3 12 6 7 1 4 6 0 3 1
        // 3 5 6 12 1 7 4 6 0 3 1
        // 3 5 6 12 1 4 6 7 0 1 3
        // 1 3 4 5 6 6 7 12 0 1 1
        // 0 1 1 1 3 4 5 6 6 7 12
        // 0 1 1 1 3 4 5 6 6 7 12

    }
    public static void mergeSortOptimal(int[] arr) {
        mergeSortOptimal(arr, 0 , arr.length - 1);
    }
    public static void mergeSortOptimal(int[] arr, int low, int high) {
        if(low >= high) return;
        int mid = (low + high) / 2;
        mergeSortOptimal(arr, low, mid);
        mergeSortOptimal(arr, mid + 1, high);
        mergeOptimal(arr, low, mid, high);
    }
    public static void mergeOptimal(int[] arr, int low, int mid, int high){
        int end1 = mid - low + 1;
        int end2 = high - mid;
        int[] leftArr =  new int[end1];
        int[] rightArr = new int[end2];

        for (int i = 0; i < leftArr.length; i++)
            leftArr[i] = arr[low + i];
        for (int i = 0; i < rightArr.length; i++)
            rightArr[i] = arr[mid + i + 1];

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = low; i <= high; i++) {
            if(leftIndex < end1 && (rightIndex >= end2 || leftArr[leftIndex] < rightArr[rightIndex])){
                arr[i] = leftArr[leftIndex];
                leftIndex++;
            } else {
                arr[i] = rightArr[rightIndex];
                rightIndex++;
            }
        }
    }

    public static int[] mergeSort(int[] arr){
        int[] tmp;
        int[] currentSrc = arr;
        int[] currentDest = new int[arr.length];

        int size = 1;
        while (size < arr.length) {
            for (int i = 0; i < arr.length; i += 2 * size){
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }

            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;

            size *= 2;

            /*Arrays.stream(currentSrc).forEach(val -> System.out.print(val + " "));
            System.out.println();*/
        }
        return currentSrc;
    }

    //функция слияния двух массивов
    public static void merge(int[] arr1, int start1, int[] arr2, int start2, int[] dest, int destStart, int size){
        int index1 = start1;
        int index2 = start2;

        int end1 = Math.min(start1 + size, arr1.length);
        int end2 = Math.min(start2 + size, arr2.length);

        int iterationCount = end1 - start1 + end2 - start2;

        for(int i = destStart; i < destStart + iterationCount; i++){
            if( index1 < end1 && (index2 >= end2 || arr1[index1] < arr2[index2])){
                dest[i] = arr1[index1];
                index1++;
            } else {
                dest[i] = arr2[index2];
                index2++;
            }
        }
    }
}
