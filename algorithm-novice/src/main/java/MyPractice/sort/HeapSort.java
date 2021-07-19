package MyPractice.sort;

import MyPractice.heap.Heap;
import Utils.ArraysUtils;

public class HeapSort {
    public static void main(String[] args) {
        int rumTimes = 10000;
        int[] test={930,117,809,506,383,577};
        Heap.sort(test);

        for (int i = 0; i < rumTimes; i++) {
            int[] testNums = ArraysUtils.getRandomArray(20, 1002);
            int[] testNums2 = ArraysUtils.copy(testNums);
            System.out.println("================origin===================");
            ArraysUtils.print(testNums);
            ArraysUtils.print(testNums2);
            Heap.sort(testNums);
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
}
