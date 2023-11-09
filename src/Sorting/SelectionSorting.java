package Sorting;

import java.util.Arrays;

public class SelectionSorting {
    public static void main(String[] args) {
        int[] a = { 5, 3, 12, 6, 7, 1, 4, 6, 0, 3, 1};
        selectionSort(a);
        Arrays.stream(a).forEach(val -> System.out.print(val + " "));

        // 5 3 12 6 7 1 4 6 0 3 1
        // 0 3 12 6 7 1 4 6 5 3 1
        // 0 1 12 6 7 3 4 6 5 3 1
        // 0 1 1 6 7 3 4 6 5 3 12
        // 0 1 1 3 7 6 4 6 5 3 12
        // 0 1 1 3 3 6 4 6 5 7 12
        // 0 1 1 3 3 4 6 6 5 7 12
        // 0 1 1 3 3 4 5 6 6 7 12
        // 0 1 1 3 3 4 5 6 6 7 12
        // 0 1 1 3 3 4 5 6 6 7 12
        // 0 1 1 3 3 4 5 6 6 7 12
    }
    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            int min_index = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[min_index] > arr[j]) min_index = j;
            }
            if(min_index != i){
                int temp = arr[min_index];
                arr[min_index] = arr[i];
                arr[i] = temp;
            }
            //Arrays.stream(arr).forEach(val -> System.out.print(val + " "));
            //System.out.println();
        }

    }
}
