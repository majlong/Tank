package com.mjl.test;

/**
 * @Auther: mjl
 * @Date: 2020/6/24 - 10:04
 * @Description: com.mjl.test
 * @version: 1.0
 */
public class MySorter {

    public static void Sort(int arr[]){

        for (int i = 0; i <arr.length ; i++) {
            int minPos = i;

            for (int j = i+1; j <arr.length ; j++) {
                minPos = arr[j]<arr[minPos]? j : minPos;
            }
            swap(arr,i,minPos);
        }
    }

    private static void swap(int[] arr, int i, int minPos) {
        int temp = arr[i];
         arr[i] = arr[minPos];
         arr[minPos] = temp;

    }
}
