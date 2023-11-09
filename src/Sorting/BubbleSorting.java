package Sorting;

import java.util.Arrays;

public class BubbleSorting {
    public static void main(String[] args) {
        int[] a = { 5, 3, 12, 6, 7, 1, 4, 6, 0, 3, 1};
        bubbleSort(a);
        Arrays.stream(a).forEach(val -> System.out.print(val + " "));

        // 5 3 12 6 7 1 4 6 0 3 1
        // 3 5 6 7 1 4 6 0 3 1 12
        // 3 5 6 1 4 6 0 3 1 7 12
        // 3 5 1 4 6 0 3 1 6 7 12
        // 3 1 4 5 0 3 1 6 6 7 12
        // 1 3 4 0 3 1 5 6 6 7 12
        // 1 3 0 3 1 4 5 6 6 7 12
        // 1 0 3 1 3 4 5 6 6 7 12
        // 0 1 1 3 3 4 5 6 6 7 12
        // 0 1 1 3 3 4 5 6 6 7 12
    }
    static void bubbleSort(int[] arr){
        int length = arr.length;
        while (length != 0){
            int maxIndex = 0;
            for (int i = 1; i < length; i++){
                if(arr[i - 1] >arr[i]){
                    //System.out.println("i - " + i + " arr[i] - " + arr[i] + " arr[i - 1] - " + arr[i - 1]);
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    maxIndex = i;
                    //System.out.println("maxIndex - " + maxIndex);
                }
            }
            length = maxIndex;
            //Arrays.stream(arr).forEach(val -> System.out.print(val + " "));
            //System.out.println();

            //System.out.println("length - " + length);
        }

    }
}
