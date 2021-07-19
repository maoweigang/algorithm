package MyPractice.sort;

import MyPractice.heap.Heap;
import Utils.ArraysUtils;

public class RadixSort {
    public static void main(String[] args) {
        int rumTimes = 10000;
        int[] test={930,117,809,506,383,577};
        Heap.sort(test);

        for (int i = 0; i < rumTimes; i++) {
            int[] testNums = ArraysUtils.getRandomArray(20, 9999);
            int[] testNums2 = ArraysUtils.copy(testNums);
            System.out.println("================origin===================");
            ArraysUtils.print(testNums);
            ArraysUtils.print(testNums2);
            radixSort(testNums,4);
            SelectSort.selectSort(testNums2);

            System.out.println("==============sort=====================");
            ArraysUtils.print(testNums);

            for (int t = 0; t < testNums.length - 1; t++) {
                if (testNums2[t] != testNums[t]) {
                    System.out.println("error");
                    return;
                }
            }
            System.out.println("=============end======================");
        }
    }

    public static void radixSort(int[] nums,int maxlength){

    }
    }

